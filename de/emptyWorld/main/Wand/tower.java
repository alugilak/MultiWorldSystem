package de.emptyWorld.main.Wand;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class tower implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  
	  
	  public tower( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	  Player p = (Player)sender;
if (commandLabel.equalsIgnoreCase("tower")) {
	  if (!sender.hasPermission(this.settings.getmobData().getString("build")))
{	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getmobData().getString("PluginName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getmobData().getString("build") + " " + this.settings.getmobData().getString("permError"));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return true ;}
	  if (args.length <= 2) {	
		  p.sendMessage(ChatColor.GOLD + "please use /crazybuild for help. You must use alle commands!");
	  }
	  if (args.length == 3) {
		  Location o = p.getLocation().getBlock().getLocation();
		  int r = Integer.parseInt(args[0]);		
			int id = Integer.parseInt(args[1]);
			int sid = Integer.parseInt(args[2]);
		  for (int x = 0; x < r; x++) {
		      for (int z = 0; z < r; z++) {
		          for (int y = 0; y <= r; y++) {
		        	  if (x == 1 || y == 1 || z == 1 || x == r  -2 || y == r -2 || z == r - 2) {
		        		  Location loc = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);		        		  
			         loc.getBlock().setTypeId(id);
			         loc.getBlock().setData((byte)sid);
			     }
			 }
			}}}	}		
				return true;}}   



