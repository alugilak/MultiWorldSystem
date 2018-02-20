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

public class posload implements CommandExecutor
{
	public static final String warpsName = null;
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public posload( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;	    
	    if (cmd.getName().equalsIgnoreCase("posload"))
	    {
	      if (!sender.hasPermission((String) this.settings.getpermData().get("mwspossave"))) {	    	  
	    	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwspossave")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;}	
	      if (args.length == 0)
	    	  
    	  {	      
      if (this.settings.getData().getConfigurationSection("save." + p.getName()) == null)
      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwsNoposload")));
	        return false;}
	      String world = this.settings.getData().getString("save." + p.getName() + ".world");
	      double x = this.settings.getData().getDouble("save." + p.getName() + ".x");
          double y = this.settings.getData().getDouble("save." + p.getName() + ".y");
          double z = this.settings.getData().getDouble("save." + p.getName() + ".z"); 
	      String save = this.settings.getData().getString("save." + p.getName() + ".world");
	      String check = save + x + y + z;
    	  if ( this.settings.getData().contains(check));
          Location loc = new Location(org.bukkit.Bukkit.getWorld(world), x, y, z);
          p.teleport(loc);
	      this.settings.getData().set("save." +  p.getName(), null);
	      this.settings.saveData();
	            p.sendMessage(((String)this.settings.getsysoData().get("mwsposload")));
				return true;
	        } else  {
	        	 p.sendMessage(((String)this.settings.getsysoData().get("mwsNoposload")));return false;
		    }
	        
	}
		return false;

}}