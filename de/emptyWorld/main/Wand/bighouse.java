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

public class bighouse implements CommandExecutor{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public bighouse( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    Player p = (Player)sender;
		    if (cmd.getName().equalsIgnoreCase("house2"))
		    {
		      if (!sender.hasPermission((String) this.settings.getpermData().get("mwshouse2")))
		      {
		    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouse2")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
		        return false;
		      }else {
		    	  if (args.length <= 3) {	
					  
		    		  p.sendMessage(ChatColor.GREEN + "/house2 <BlockID> <DataValue> <WindowsID> <WindowsDataValue> ");	
				  }
				  if (args.length >= 4) {
		    	  int sid = Integer.parseInt(args[0]);
					int tid = Integer.parseInt(args[1]);
					int wind1 = Integer.parseInt(args[2]);
					int wind2 = Integer.parseInt(args[3]);
		    	  int x = (int)p.getLocation().getX();
		          int y = (int)p.getLocation().getY();
		          int z = (int)p.getLocation().getZ();
		          
		          p.getWorld().getBlockAt(x, y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x, y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 4, y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x, 1 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 1 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 1 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 1 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 4, 1 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 1 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 1 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 1 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 1 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 1 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 1 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 1 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 1 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 1 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 1 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 1 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 1 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x, 2 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x, 2 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 2 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 2 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 4, 2 + y, 3 + z).setTypeIdAndData(wind1, (byte) wind2, true);
		          p.getWorld().getBlockAt(x - 5, 2 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 2 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 2 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 8, 2 + y, z - 1).setTypeIdAndData(wind1, (byte) wind2, true);
		          p.getWorld().getBlockAt(x - 8, 2 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 2 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 2 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 2 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 2 + y, z - 5).setTypeIdAndData(wind1, (byte) wind2, true);
		          p.getWorld().getBlockAt(x - 3, 2 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 2 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 2 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x, 3 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x, 3 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 3 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 3 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 4, 3 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 3 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 3 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 3 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 8, 3 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 3 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 3 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 3 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 3 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 3 + y, z - 5).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 3 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 3 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 1, 4 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 4 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 4 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 4 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 4 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 4 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 4 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 4 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 4 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 4 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 4 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 4 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 4 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 4 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 4 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 4 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 1, 5 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 5 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 5 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 5 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 5 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 5 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 5 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 5 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 7, 5 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 5 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 5 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 5 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 5 + y, z - 4).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 2, 5 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 5 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 5 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 2, 6 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 6 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 6 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 6 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 6 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 2, 6 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 6 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 6 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 6 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 6 + y, z - 2).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 2, 6 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 3, 6 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 6 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 6 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 6, 6 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 3, 6 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 6 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 6 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 3, 6 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 4, 6 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 5, 6 + y, z - 3).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x, 2 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x, 3 + y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
		          
		          p.getWorld().getBlockAt(x - 2, y, 1 + z).setTypeId(54);
		          p.getWorld().getBlockAt(x - 2, y, z - 3).setTypeId(145);
		          p.getWorld().getBlockAt(x - 6, y, 1 + z).setTypeId(116);
		          p.getWorld().getBlockAt(x - 6, y, z - 3).setTypeId(58);
		          
		          p.getWorld().getBlockAt(x - 7, y, z).setTypeIdAndData(355, (byte) 0, true);
		          
		          p.getWorld().getBlockAt(x - 7, y, z - 2).setTypeId(61);	
		          p.getWorld().getBlockAt(x - 1, 4 + y, z).setTypeIdAndData(sid, (byte) tid, true);
		          p.getWorld().getBlockAt(x - 1, 5 + y, z).setTypeIdAndData(wind1, (byte) wind2, true);
		      return true;
		      }}}
			return false;}}
		      