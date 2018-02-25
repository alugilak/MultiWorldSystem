package de.emptyWorld.main.Wand;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class house3 implements CommandExecutor{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public house3( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    Player p = (Player)sender;
		   
		      if (cmd.getName().equalsIgnoreCase("house3"))
			    {
			      if (!sender.hasPermission((String) this.settings.getpermData().get("mwshouse3")))
			      {
			    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouse3")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
			        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
			        return false;
			      }else {
			    	  if (args.length <= 6) {	
						  
							p.sendMessage(ChatColor.GREEN + "/house3 <BlockID> <DataValue> <roofBlockID> <roofDataValue> <groundBlockID> <groundDataValue> <windowBlockID> <windowsDataValue>");	
					  }
					  if (args.length >= 7) {
			    		  int sid = Integer.parseInt(args[0]);
							int tid = Integer.parseInt(args[1]);
							int roof1 = Integer.parseInt(args[2]);
							int roof2 = Integer.parseInt(args[3]);
							int gr1 = Integer.parseInt(args[4]);
							int gr2 = Integer.parseInt(args[5]);
							int wind1 = Integer.parseInt(args[6]);
							int wind2 = Integer.parseInt(args[7]);
			    	  int x = (int)p.getLocation().getX();
			          int y = (int)p.getLocation().getY();
			          int z = (int)p.getLocation().getZ();

			          p.getWorld().getBlockAt(x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          

			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, y - 1, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          

			          p.getWorld().getBlockAt(1 + x, y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 2 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(1 + x, 3 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(1 + x, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          

			          p.getWorld().getBlockAt(x, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 1, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 2, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 3, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 4, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 5, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x - 6, y - 1, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y - 1, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          

			          p.getWorld().getBlockAt(x - 6, y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y, 2 + z).setTypeId(0);
			          p.getWorld().getBlockAt(x - 6, y, 3 + z).setTypeId(0);
			          p.getWorld().getBlockAt(x - 6, y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x - 6, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 2 + z).setTypeId(0);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 3 + z).setTypeId(0);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 1 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x - 6, 2 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x - 6, 3 + y, z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
			          p.getWorld().getBlockAt(x - 6, 3 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 2, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 3, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, 1 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, 1 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x - 2, 4 + y, 1 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          
			          p.getWorld().getBlockAt(x - 3, 4 + y, 1 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, 1 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, 1 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, 2 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, 2 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x - 2, 4 + y, 2 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          
			          p.getWorld().getBlockAt(x - 3, 4 + y, 2 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, 2 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, 2 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, 3 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, 3 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x - 2, 4 + y, 3 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          
			          p.getWorld().getBlockAt(x - 3, 4 + y, 3 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, 3 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, 3 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, 4 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, 4 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 2, 4 + y, 4 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          p.getWorld().getBlockAt(x - 3, 4 + y, 4 + z).setTypeIdAndData(wind1, (byte) wind2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, 4 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, 4 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 1, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 2, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 3, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 4, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          p.getWorld().getBlockAt(x - 5, 4 + y, 5 + z).setTypeIdAndData(roof1, (byte) roof2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 1 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 2 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 3 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 4 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 1, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 2, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 3, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 4, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          p.getWorld().getBlockAt(x - 5, y - 1, 5 + z).setTypeIdAndData(gr1, (byte) gr2, true);
			          
			          p.getWorld().getBlockAt(x - 5, y, z).setTypeId(58);
			          p.getWorld().getBlockAt(x - 5, y, 5 + z).setTypeId(58);
			          
			          p.getWorld().getBlockAt(x, y, z).setTypeId(54);
			          p.getWorld().getBlockAt(x - 1, y, z).setTypeId(54);
			          
			          p.getWorld().getBlockAt(x, y, 5 + z).setTypeId(54);
			          p.getWorld().getBlockAt(x - 1, y, 5 + z).setTypeId(54);
			          
			          p.getWorld().getBlockAt(x - 2, y, z).setTypeId(61);
			          
			          p.getWorld().getBlockAt(x - 3, y, z).setTypeId(145);
			          
			          p.getWorld().getBlockAt(x - 3, y, 5 + z).setTypeId(25);
			          
			      return true;}}}
			return false;}}
			
		    