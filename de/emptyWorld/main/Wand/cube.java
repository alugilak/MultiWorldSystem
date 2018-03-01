package de.emptyWorld.main.Wand;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class cube implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  
	  
	  public cube( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	  Player p = (Player)sender;
if (commandLabel.equalsIgnoreCase("cube")) {
	  if (!sender.hasPermission(this.settings.getmobData().getString("build")))
{	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getmobData().getString("PluginName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getmobData().getString("build") + " " + this.settings.getmobData().getString("permError"));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return false ;}
	  if (args.length <= 2) {	
		  p.sendMessage(ChatColor.GOLD + "please use /cube radius block ");
	  }
	  if (args.length >= 3) {
		  Location o = p.getLocation().getBlock().getLocation();
		  int r = Integer.parseInt(args[0]);		
			int id = Integer.parseInt(args[1]);
			int sid = Integer.parseInt(args[2]);
		  for (int x = 0; x < r; x++) {
		      for (int z = 0; z < r; z++) {
		          for (int y = 0; y <= r; y++) {
		        	  if (x == 0 || y == 0 || z == 0 || x == r  -1 || y == r || z == r -1) {
		        		  Location loc = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);		        		  
			         loc.getBlock().setTypeId(id);
			         loc.getBlock().setData((byte)sid);			        
			     
			     }
			 }
			}}}		
				return true;}
return false;

}   }



