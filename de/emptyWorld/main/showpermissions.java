package de.emptyWorld.main;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class showpermissions implements CommandExecutor
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
	  
	
  public showpermissions( leerWelt instance)
  {

    plugin = instance;
  }  
  
      

  public boolean onCommand(CommandSender sender, Command cmd,String label,  String[] args)  
  { if ((cmd.getName().equalsIgnoreCase("permlist"))){
	    if ((sender instanceof Player)) {
	      Player p = (Player)sender;
	      if (p.hasPermission((String) this.settings.getpermData().get("mwswarpl"))) {
	        if (args.length == 0) {
	        	
	          int i = 0;
	          p.sendMessage( "§7List of all §6permissions§7:");
	          for(String msg : this.settings.getData().getStringList("List"))	          
	          for (String key : this.settings.getpData().getKeys(true)) {
	            if (!key.contains("List.")) {
	              i++;
	              p.sendMessage( "§7" + i + ". §6'" + ". §6'" + key);
	              
	              p.sendMessage(msg + i + key);
	            }
	          }
	          
	          i = 0;
	        } else {
	          p.sendMessage( "§c/permlist");
	        } } else p.sendMessage("noperm");
	    } else { System.out.println("Not for Console!"); }
	    return false;
	  }
return false;
	}}