package de.emptyWorld.main.Wand;

import java.util.ArrayList;
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

public class wand implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  
	  leerWelt plugin;  

	   
public wand( leerWelt instance)
{

  plugin = instance;
}


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {  
	  Player p = (Player)sender;	
if (commandLabel.equalsIgnoreCase("fill")) {
	  if (!sender.hasPermission(this.settings.getmobData().getString("build"))){	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getmobData().getString("PluginName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getmobData().getString("build") + " " + this.settings.getmobData().getString("permError"));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return false;}
	  Location loc1 = new Location(p.getWorld(), this.settings.getmobData().getDouble("loc1.x"), this.settings.getmobData().getDouble("loc1.y"), this.settings.getmobData().getDouble("loc1.z"));
	  Location loc2	= new Location(p.getWorld(), this.settings.getmobData().getDouble("loc1.x"), this.settings.getmobData().getDouble("loc1.y"), this.settings.getmobData().getDouble("loc1.z"));
	  Location o = p.getLocation().getBlock().getLocation();
    ArrayList<Block> blocks = new ArrayList<Block>();
    int x1 = this.settings.getmobData().getInt("loc1.x");
    int y1 = this.settings.getmobData().getInt("loc1.y");
    int z1 = this.settings.getmobData().getInt("loc1.z");
    int x2 = this.settings.getmobData().getInt("loc2.x");
    int y2 = this.settings.getmobData().getInt("loc2.y");
    int z2 = this.settings.getmobData().getInt("loc2.z");
    int xMin, yMin, zMin;
    int xMax, yMax, zMax;
    int x, y, z;
    if(x1 > x2){
        xMin = x2;
        xMax = x1;
    }else{
        xMin = x1;
        xMax = x2;
    }
    if(y1 > y2){
        yMin = y2;
        yMax = y1;
    }else{
        yMin = y1;
        yMax = y2;
    }
    if(z1 > z2){
        zMin = z2;
        zMax = z1;
    }else{
        zMin = z1;
        zMax = z2;
    }
    int id = Integer.parseInt(args[0]);
    int sid = Integer.parseInt(args[1]);
    for(x = xMin; x <= xMax; x ++){
        for(y = yMin; y <= yMax; y ++){
            for(z = zMin; z <= zMax; z ++){
                Block b = new Location(p.getWorld(), x, y, z).getBlock();
                b.setTypeId(id);
                b.setData((byte)sid);
            }
        }
    }
return true;}
return false;}}






		
