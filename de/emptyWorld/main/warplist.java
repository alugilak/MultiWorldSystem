package de.emptyWorld.main;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



public class warplist implements CommandExecutor
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
	  
	
  public warplist( leerWelt instance)
  {

    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String warplist, String[] args)
  {
    if ((sender instanceof Player)) {
      Player p = (Player)sender;
      if (p.hasPermission((String) this.settings.getpermData().get("mwswarpl"))) {
        if (args.length == 0) {
        	
          int i = 0;
          p.sendMessage( "§7List of all §6warps§7:");
          for (String key : this.settings.getData().getKeys(true)) {
            if (!key.contains(".warps.")) {
              i++;
              p.sendMessage( "§7" + i + ". §6'" + key + "'");
            }
          }
          
          i = 0;
        } else {
          p.sendMessage( "§c/warplist");
        } } else p.sendMessage("noperm");
    } else { System.out.println("Not for Console!"); }
    return false;
  }
}