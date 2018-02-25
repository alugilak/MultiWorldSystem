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

public class house4 implements CommandExecutor{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public house4( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    Player p = (Player)sender;
		   
		      if (cmd.getName().equalsIgnoreCase("house4"))
			    {
			      if (!sender.hasPermission((String) this.settings.getpermData().get("mwshouse4")))
			      {
			    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouse4")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
			        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
			        return false;
			      }else {
			    	  if (args.length <= 3) {	
						  
							p.sendMessage(ChatColor.GREEN + "/house4 <BlockID> <DataValue> <poleBlockID> <poleDataValue>");	
					  }
					  if (args.length >= 4) {
						  int sid = Integer.parseInt(args[0]);
							int tid = Integer.parseInt(args[1]);
							int pol1 = Integer.parseInt(args[2]);
							int pol2 = Integer.parseInt(args[3]);
					  
	  int x = (int)p.getLocation().getX();
      int y = (int)p.getLocation().getY();
      int z = (int)p.getLocation().getZ();
      
      p.getWorld().getBlockAt(x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, y, z - 1).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 1 + y, z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 2 + y, 1 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 3 + y, 2 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 4 + y, 3 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, y, 7 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 1 + y, 6 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 2 + y, 5 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(1 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(2 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(3 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(4 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(5 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      p.getWorld().getBlockAt(6 + x, 3 + y, 4 + z).setTypeIdAndData(sid, (byte) tid, true);
      
      p.getWorld().getBlockAt(3 + x, y, 3 + z).setTypeIdAndData(pol1, (byte) pol2, true);
      p.getWorld().getBlockAt(3 + x, 1 + y, 3 + z).setTypeIdAndData(pol1, (byte) pol2, true);
      p.getWorld().getBlockAt(3 + x, 2 + y, 3 + z).setTypeIdAndData(pol1, (byte) pol2, true);
      p.getWorld().getBlockAt(3 + x, 3 + y, 3 + z).setTypeIdAndData(pol1, (byte) pol2, true);
      
      p.getWorld().getBlockAt(1 + x, y, 1 + z).setTypeId(58);
      p.getWorld().getBlockAt(1 + x, y, 5 + z).setTypeId(58);
      
      p.getWorld().getBlockAt(2 + x, y, 6 + z).setTypeId(61);
      p.getWorld().getBlockAt(3 + x, y, 6 + z).setTypeId(61);
      p.getWorld().getBlockAt(4 + x, y, 6 + z).setTypeId(61);
      p.getWorld().getBlockAt(2 + x, y, z).setTypeId(61);
      p.getWorld().getBlockAt(3 + x, y, z).setTypeId(61);
      p.getWorld().getBlockAt(4 + x, y, z).setTypeId(61);
 return true; }}}
			return false;}}