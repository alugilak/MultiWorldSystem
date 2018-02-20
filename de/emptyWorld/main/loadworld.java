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

public class loadworld implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	
  leerWelt plugin;
  World world;
  
  public loadworld(leerWelt instance)
  {

    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	    Player player = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("wload")) {
	      if (player.hasPermission((String)this.settings.getpermData().get("mwsloadworld"))) {
	        try {
	          LoadWorld(args[0], player);          
	        } catch (Exception e) {     		
	          player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("mwErrorWName")));
	        }
	      } else {
	        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("permError")));
	      }
	    }
	    return false;
	  }
	  
	  public boolean LoadWorld(String name, Player player) {
	    File fileNew = new File(name);    
	    if (fileNew.exists())
	    {
	        this.settings.getData().set("warps." + name + ".world", name);
	        this.settings.getData().set("warps." + name + ".x" , 0);
	        this.settings.getData().set("warps." + name + ".y" , 165);
	        this.settings.getData().set("warps." + name + ".z" , 0 );
	        this.settings.saveData(); 
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv" + " " + "import" + " " + name + " " + "normal");
	        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv" + " " + "confirm"); 
	      player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("worldtwcatch")));
	      World world = org.bukkit.Bukkit.getServer().createWorld(new org.bukkit.WorldCreator(name));
	      player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("loadWorlds")) + world.getName());
	      player.getPlayer().teleport(world.getSpawnLocation());
	      return true;
	    }        
	    player.sendMessage(ChatColor.RED + fileNew.getName() + ((String)this.settings.getsysoData().get("mwErrorWName")));
	    return true;
	  }
	}
	
