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

public class dome implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  
	  
	  public dome( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	  Player p = (Player)sender;
if (commandLabel.equalsIgnoreCase("dome")) {
	  if (!sender.hasPermission(this.settings.getmobData().getString("build")))
{	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getmobData().getString("PluginName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getmobData().getString("build") + " " + this.settings.getmobData().getString("permError"));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return true ;}
	  if (args.length <= 3) {	
		  p.sendMessage(ChatColor.GOLD + "please use /<dome> <Radius> <innerRadius> <BlockID> <DataValue>!");
	  }
	  if (args.length == 4) {	
		Location o = p.getLocation().getBlock().getLocation();
		Location n = p.getLocation().getBlock().getLocation();
		int r = Integer.parseInt(args[0]);
		int x1 = Integer.parseInt(args[0]);
		int y1 = Integer.parseInt(args[0]);
		int z1 = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int id = Integer.parseInt(args[2]);
		int sid = Integer.parseInt(args[3]);
		for(int x = (x1 * -x1); x <= x1; x++) {
			 for(int y = (y1 * -y1); y <= y1; y++) {          {
				 for(int z = (z1 * -z1); z <= z1; z++) {
			         Location b = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);
			         if(b.distance(o) > r)
			             continue; 
			         if(b.distance((o)) < r - d)
			             continue; 			      
			         b.getBlock().setTypeId(id);
			         b.getBlock().setData((byte)sid);
			     }
			 }
			}}}
			}
				return true;}}
