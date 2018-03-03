package de.emptyWorld.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.loadworld;

public class snow implements CommandExecutor
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
	  loadworld loader;
		loadworld worldLoader;
	  leerWelt plugin;   
  public snow( leerWelt instance)
  {
    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {Player p = (Player)sender;
  if (cmd.getName().equalsIgnoreCase("blocks")||cmd.getName().equalsIgnoreCase("bankopen"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsbanking")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsbanking")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      } 
      if (args.length <= 3) {
      Location o = p.getLocation().getBlock().getLocation();

    //Sphere radius
    int r = Integer.parseInt(args[0]);
    int x1 = (r);
    int y1 = (0);
    int z1 = (r);    
    int id = Integer.parseInt(args[1]);
    int sid = Integer.parseInt(args[2]);


    //Grab cuboid around the origin point
    for(int x = (x1 * -x1); x <= x1; x++) {
     for(int y = (y1 * -y1); y <= y1; y++) {          
    	 for(int z = (z1 * -z1); z <= z1; z++) {
             // Grab block
             Location b = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);

             // Is this block within the radius of the origin point?

             if(b.distance(o) > r)
                 continue; // Outside radius


             // It's within the radius. Do stuff
             b.getBlock().setTypeId(id);
             b.getBlock().setData((byte)sid);
         return true;}
     }
    }

  }}
  if (args.length >= 4) {
	  if (args[0].equalsIgnoreCase("q")) {
	  Location o = p.getLocation().getBlock().getLocation();
	  int r = Integer.parseInt(args[1]);		
		int id = Integer.parseInt(args[2]);
		int sid = Integer.parseInt(args[3]);
	  for (int x = 0; x < r; x++) {
	      for (int z = 0; z < r; z++) {
	          for (int y = 0; y <= r; y++) {
	        	  if (x == 0 || y == 0 || z == 0 || x == r * r || y == 0 || z == r * r) {
	        		  Location loc = new Location(o.getWorld(), o.getBlockX() + x, o.getBlockY() + y, o.getBlockZ() + z);		        		  
		         loc.getBlock().setTypeId(id);
		         loc.getBlock().setData((byte)sid);			        
		     	return true;
		     }
		 }
		}}}		
		}

    	return false;}}
