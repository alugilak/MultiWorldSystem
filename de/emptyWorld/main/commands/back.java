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

public class back implements CommandExecutor
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
	  
	
  public back( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;	    
	    if (cmd.getName().equalsIgnoreCase("back"))
	    {
	      if (!sender.hasPermission((String) this.settings.getpermData().get("mwsback")))
	      {
	    	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsback")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;}	      
          String world = this.settings.getData().getString("death." + p.getName() + ".world");
          double x = this.settings.getData().getDouble("death." + p.getName() + ".x");
          double y = this.settings.getData().getDouble("death." + p.getName() + ".y");
          double z = this.settings.getData().getDouble("death." + p.getName() + ".z");          
          Location loc = new Location(org.bukkit.Bukkit.getWorld(world), x, y, z);
          p.teleport(loc);
	      this.settings.getData().set("death." +  p.getName(), null);
	      this.settings.saveData();
	            p.sendMessage(ChatColor.GOLD + "Teleporting...");
	        } else {
	            p.sendMessage(ChatColor.RED + "No /back location was found!");
	        }
		return false;
	}

}