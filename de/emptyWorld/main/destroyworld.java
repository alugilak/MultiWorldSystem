package de.emptyWorld.main;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.leerWelt;

public class destroyworld implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  loadworld wordLoader;
	  leerWelt plugin;
	  World world;
  
  public destroyworld(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("wdelete")) {
        if (!player.hasPermission((String)this.settings.getpermData().get("mwsworldunl"))) {
      	  player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("permError")));
        return false;}
      try {
        player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("worlddelete ")) + args[0]);
        this.settings.getData().set("warps." + args[0] , null);
        this.settings.saveData();        
        this.settings.getwData().set("worlds." + args[0], null);
        this.settings.savewData();
        DestroyWorld(args[0], player);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv remove" + " " + args[0]);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm" + " " + args[0]);
        
      } catch (Exception e) {
        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("worlddeleteError")) + args[0]);
        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("worlddeleteErrorIs")) + e);
      }
    }
    return false;
  }
  
  public boolean deleteWorld(File path) {
    if (path.exists()) {
      File[] files = path.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (files[i].isDirectory()) {
          deleteWorld(files[i]);
        } else {
          files[i].delete();
        }
      }

    	  
    }
    return path.delete();
  }
  


  public void DestroyWorld(String name, Player player)
  {
    World worldSelected = Bukkit.getWorld(name);
    
    for (Player p : Bukkit.getOnlinePlayers()) {
      if (p.getWorld() == worldSelected) {
        player.sendMessage(ChatColor.BLUE + ((String)this.settings.getsysoData().get("worldplayerremove")) + worldSelected.getName() + ((String)this.settings.getsysoData().get("worlddelePlayertp")));
        
        World Default = (World)Bukkit.getWorlds().get(0);
        if (Default != null) {
          p.getPlayer().teleport(Default.getSpawnLocation());
        } else {
          p.kickPlayer((String)this.settings.getsysoData().get("worldnoexist"));
        }
      }
    }
    
    if (worldSelected != null) {
      Bukkit.unloadWorld(worldSelected, false);
      File deleteFolder = worldSelected.getWorldFolder();
      deleteWorld(deleteFolder);
      player.sendMessage(ChatColor.GREEN + worldSelected.getName() + ((String)this.settings.getsysoData().get("worlddeleted")));
    } else {
      try {
        wordLoader = new loadworld(null);
        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("worldnotload")));
        player.sendMessage(ChatColor.BLUE + ((String)this.settings.getsysoData().get("worldloadtry")));
        boolean loadedworld = wordLoader.LoadWorld(name, player);
        if (loadedworld)
        {
          DestroyWorld(name, player);
        } else {
          player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("worldloadError")));
        }
        return;
      } catch (Exception e) {
        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("worlddeleteErrorIs")) + e);
      }
    }
  }
}
