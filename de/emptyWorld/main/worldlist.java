package de.emptyWorld.main;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;




public class worldlist implements CommandExecutor
{
	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public worldlist( leerWelt instance)
  {

    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (p.hasPermission((String) this.settings.getpermData().get("mwsallworlds"))) {
    	  
        if (args.length == 0) {
        	
          int i = 0;
          p.sendMessage(org.bukkit.ChatColor.GREEN + "§7List of all §6MultiWorldSystem created worlds§7:");
          for (String key : this.settings.getwData().getKeys(true)) {
            if (!key.contains(".worlds.")) {
              i++;
              p.sendMessage(org.bukkit.ChatColor.AQUA +"§7" + i + ". §6'" + key + "'");
            }
          }
          
          i = 0;
        } else {
          p.sendMessage("§c/wlistall");
        } } else p.sendMessage("noperm");
    } else { System.out.println("Not for Console!"); }
    return false;
  }
}