package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class homes implements CommandExecutor
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
	
	  leerWelt plugin;   
  public homes( leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;	
	    if (cmd.getName().equalsIgnoreCase("shome"))
	    {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwshomes")))
	      {
	    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwshomes")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;
	      }
	      if (args.length == 0)	
	    
	    	  this.settings.getData().set("home." +  p.getName() + ".world", p.getLocation().getWorld().getName());

	      this.settings.getData().set("home." + p.getName() + ".x", Double.valueOf(p.getLocation().getX()));
	      this.settings.getData().set("home." + p.getName() + ".y", Double.valueOf(p.getLocation().getY()));
	      this.settings.getData().set("home." + p.getName() + ".z", Double.valueOf(p.getLocation().getZ()));
	      this.settings.saveData();
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("homecreated")) + " " + ChatColor.GOLD + p.getName());
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("home"))
	    {
	      if (args.length == 0)
	    	  
	    	  {	      
	      if (this.settings.getData().getConfigurationSection("home." + p.getName()) == null)
	      {
		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("theHome")) + ChatColor.GOLD + p.getName() + ChatColor.GREEN + ((String)this.settings.getsysoData().get("notExist")));
		        return false;}
		        	
	          World w = Bukkit.getServer().getWorld(this.settings.getData().getString("home." +  p.getName() + ".world"));
		      double x = this.settings.getData().getDouble("home." + p.getName() + ".x");
		      double y = this.settings.getData().getDouble("home." + p.getName() + ".y");
		      double z = this.settings.getData().getDouble("home." + p.getName() + ".z");
		      p.teleport(new Location(w, x, y, z));
		      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("teleportTrue")) + " " + ChatColor.GOLD + p.getName() + " " + ChatColor.GREEN + "!");
		      p.getWorld().playEffect(p.getLocation(), Effect.PORTAL_TRAVEL, 50);
		      return true; }
	        
	    
	      
	      if (this.settings.getData().getConfigurationSection("home." + args[0] ) == null)
	    	 
	      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("theHome")) + " " + ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("notExist")));
	        return false;
	      }
	      
	      World w = Bukkit.getServer().getWorld(this.settings.getData().getString("home." + args[0] + ".world"));
	      double x = this.settings.getData().getDouble("home." + args[0] + ".x");
	      double y = this.settings.getData().getDouble("home." + args[0] + ".y");
	      double z = this.settings.getData().getDouble("home." + args[0] + ".z");
	      p.teleport(new Location(w, x, y, z));
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("teleportTrue")) + " " + ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + "!");
	      p.getWorld().playEffect(p.getLocation(), Effect.PORTAL_TRAVEL, 50);
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("dhome"))
	    {
	    	 if (!sender.hasPermission((String)this.settings.getpermData().get("mwshomedel")))    		      
	    		      {
	    		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwshomedel")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	    		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    		        return false;
	    		      }    	 
	      if (args.length == 0)
	      {
	    sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("homedelfine ")) + " " + ChatColor.GOLD + p.getName()+ " " + ChatColor.GREEN + "!");
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);	      
	      this.settings.getData().set("home." +  p.getName(), null);
	      this.settings.saveData();	        
	        return true;	   
	      }
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("homedelfine ")) + " " + ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + "!");
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      this.settings.getData().set("home." + args[0], null);
	      this.settings.saveData();
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("tophome"))
	    {
	      if (args.length == 0)
	      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + "Please choose a home! for your home use /home");
	        return false;
	      }
	      if (this.settings.getData().getConfigurationSection("home." + args[0]) != null)
	      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("theHome")) + " " + ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("notExist")));
	        return false;
	      }
	      World w = Bukkit.getServer().getWorld(this.settings.getData().getString("home." + args[0]));
	      double x = this.settings.getData().getDouble("home." + args[0] + ".x");
	      double y = this.settings.getData().getDouble("home." + args[0] + ".y");
	      double z = this.settings.getData().getDouble("home." + args[0] + ".z");
	      p.teleport(new Location(w, x, y, z));
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("teleportTrue")) + ChatColor.GOLD + args[0] + ChatColor.GREEN + "!");
	      p.getWorld().playEffect(p.getLocation(), Effect.PORTAL_TRAVEL, 50);
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("hub"))	   { 
	    	
	    	 if (!(this.settings.getData().get("hub.world") != null))
   	      {
   	          p.sendMessage(ChatColor.RED + "SetHUB Error:");
   	          p.sendMessage("HUB IS NOT SET!!!");
   	          p.sendMessage("If you are Administrator, you can set HUB using /shub.");
   	          return false;
   	        }
   	        else
   	        {   
	            World w = Bukkit.getServer().getWorld(this.settings.getData().getString("hub.world"));
	            double x = this.settings.getData().getDouble("hub.x");
	            double y = this.settings.getData().getDouble("hub.y");
	            double z = this.settings.getData().getDouble("hub.z");
	            p.teleport(new Location(w, x, y, z));
	            p.sendMessage(ChatColor.GOLD.toString() + ChatColor.GOLD.toString() +  ChatColor.BOLD + " »" + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Hubwelcome")));
	            p.getWorld().playEffect(p.getLocation(), Effect.PORTAL_TRAVEL, 50);	              
	             return true ; }}
		return false;}}
	    

	