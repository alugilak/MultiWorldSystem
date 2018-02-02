package de.emptyWorld.main;

import de.emptyWorld.main.leerWelt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class world implements CommandExecutor
{ loadworld loader;
	loadworld worldLoader;
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
  
  public world(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player)sender;
    if (player.hasPermission((String)this.settings.getpermData().get("worldtp"))) {
      if (cmd.getName().equalsIgnoreCase("wtp")) {
        try {
          TeleportWorld(args[0], player);
        } catch (Exception e) {
          player.sendMessage((String)this.settings.getsysoData().get("woldexistErr"));
        }
      }
    } else {
      player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("permError")));
    }
    return false;
  }
  
  public boolean TeleportWorld(String WorldName, Player player)
  {
    World world = Bukkit.getWorld(WorldName);
    if (world != null) {
      player.getPlayer().teleport(world.getSpawnLocation());
      player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("worldtptrue")) + world.getName());
      return true;
    }
    
      player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("woldexistErr")));
      loader = new loadworld(plugin);
      if (!loader.LoadWorld(WorldName, player))
    	  return false;
      {
        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("woldexistErr")));
        {
        player.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("worldtpload")));
        player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("worldtwcatch")));
        TeleportWorld(WorldName, player);
        return false;
      }
    }
  
  }
}
