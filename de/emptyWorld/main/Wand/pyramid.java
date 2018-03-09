package de.emptyWorld.main.Wand;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class pyramid  implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  
	  
	  public pyramid( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  

	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {	
		  Player p = (Player)sender;
	if (commandLabel.equalsIgnoreCase("pyramid")) {
		  if (!sender.hasPermission(this.settings.getmobData().getString("build")))
	{	    	        
	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getmobData().getString("PluginName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getmobData().getString("build") + " " + this.settings.getmobData().getString("permError"));
	p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
	return true  ;}
		  if (args.length <= 2) {	
			  p.sendMessage(ChatColor.GOLD + " You must use alle commands!");
		  }
		  if (args.length == 3) {
			  Block block = p.getTargetBlock(null, 100);
			  Location o = block.getLocation();
			  Location l = p.getLocation().getBlock().getLocation();
			  int size = Integer.parseInt(args[0]);
				int sid = Integer.parseInt(args[2]);
				int id = Integer.parseInt(args[1]);
				
		  
			  boolean affected = true;

		        int height = Integer.parseInt(args[0]);

		        for (int y = 0; y <= height; ++y) {
		            size--;
		            for (int x = 0; x <= size; ++x) {
		                for (int z = 0; z <= size; ++z) {	                	 
		                    if ((z <= size && x <= size) || z == size || x == size) {
		                    	Location loc = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);
		                    	 loc.getBlock().setTypeId(id);
		    			         loc.getBlock().setData((byte)sid);{
		    			        	
		    			         }
		                        }
		                    }
		                }
		        }

		        return affected;
		}}
		        
	return false;}}

		     
