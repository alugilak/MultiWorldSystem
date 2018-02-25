package de.emptyWorld.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class blocks implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  FileConfiguration blockdata;
	  World world;
	  
	  leerWelt plugin;  
	  
	  
public blocks( leerWelt instance)
{

plugin = instance;
}

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	  Player p = (Player)sender;
if (commandLabel.equalsIgnoreCase("build")) {
	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
  {	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return false ;}
if (args.length <= 7) {		
// No, this is not a diamond hoe
Location o = p.getLocation().getBlock().getLocation();

//Sphere radius
int r = Integer.parseInt(args[0]);
int x1 = Integer.parseInt(args[1]);
int y1 = Integer.parseInt(args[2]);
int z1 = Integer.parseInt(args[3]);
int d = Integer.parseInt(args[4]);
int id = Integer.parseInt(args[5]);
int sid = Integer.parseInt(args[6]);


//Grab cuboid around the origin point
for(int x = (x1 * -x1); x <= x1; x++) {
 for(int y = (y1 * -y1); y <= y1; y++) {          {
	 for(int z = (z1 * -z1); z <= z1; z++) {
         // Grab block
         Location b = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);

         // Is this block within the radius of the origin point?

         if(b.distance(o) > r)
             continue; // Outside radius

         if(b.distance((o)) < r - d)
             continue; // Inside radius - 1

         // It's within the radius. Do stuff
         b.getBlock().setTypeId(id);
         b.getBlock().setData((byte)sid);
     }
 }
}}}
}
	return true;}}
