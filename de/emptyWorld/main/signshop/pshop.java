package de.emptyWorld.main.signshop;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
public class pshop implements CommandExecutor
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
	  
	
public pshop( leerWelt instance)
{

  plugin = instance;
}  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (!(sender instanceof Player)) {
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("mwspossave")));
	      return true;
	    }
	    
	    Player p = (Player)sender;
	    
	    if (cmd.getName().equalsIgnoreCase("mwssetshoptp")) {
	      if ((p.hasPermission(((String) this.settings.getpermData().get("mwsshop"))) || (p.hasPermission(((String) this.settings.getpermData().get("mwsshoptp")))))) {
	        Location l = p.getLocation();
	        
	        World w = l.getWorld();
	        double x = l.getX();
	        double y = l.getY();
	        double z = l.getZ();
	        float yaw = l.getYaw();
	        float pitch = l.getPitch();
	        
	        this.settings.getsData().set(p.getName() + ".world", w.getName());
	        this.settings.getsData().set(p.getName() + ".x", Double.valueOf(x));
	        this.settings.getsData().set(p.getName() + ".y", Double.valueOf(y));
	        this.settings.getsData().set(p.getName() + ".z", Double.valueOf(z));
	        this.settings.getsData().set(p.getName() + ".yaw", Float.valueOf(yaw));
	        this.settings.getsData().set(p.getName() + ".pitch", Float.valueOf(pitch));
	        this.settings.savesData();
	        
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("shopseterror1")));
	      }
	      else {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', ((String) this.settings.getpermData().get("mwsshop"))));
	      }
	    }
	    
	    if (cmd.getName().equalsIgnoreCase("mwsshoptp")) {
	      if (args.length < 1) {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("shopuse")));
	        return true;
	      }
	      
	      if (this.settings.getsData().getString(args[0] + ".world") == null) {
	        String message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("shopplno").replaceAll("%player%", p.getName()));
	        p.sendMessage(message);
	        
	        return true;
	      }
	      
	      World w = org.bukkit.Bukkit.getServer().getWorld(this.settings.getsData().getString(args[0] + ".world"));
	      double x = this.settings.getsData().getDouble(args[0] + ".x");
	      double y = this.settings.getsData().getDouble(args[0] + ".y");
	      double z = this.settings.getsData().getDouble(args[0] + ".z");
	      float yaw = this.settings.getsData().getInt(args[0] + ".yaw");
	      float pitch = this.settings.getsData().getInt(args[0] + ".pitch");
	      
	      Location l = new Location(w, x, y, z, yaw, pitch);
	      
	      p.teleport(l);
	    }
	    
	    if (cmd.getName().equalsIgnoreCase("mwsdelshoptp")) {
	      if (args.length < 1) {
	        if (this.settings.getsData().getString(p.getName() + ".world") == null) {
	          String message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("shopplno").replaceAll("%player%", p.getName()));
	          p.sendMessage(message);
	          
	          return true;
	        }
	        
	        this.settings.getsData().set(p.getName() + ".world", null);
	        this.settings.getsData().set(p.getName() + ".x", null);
	        this.settings.getsData().set(p.getName() + ".y", null);
	        this.settings.getsData().set(p.getName() + ".z", null);
	        this.settings.getsData().set(p.getName() + ".yaw", null);
	        this.settings.getsData().set(p.getName() + ".pitch", null);
	        this.settings.savesData();
	        
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("sshopremoved")));
	        
	        return true;
	      }
	      
	      if ((p.hasPermission(((String) this.settings.getpermData().getString("mwsshoptpadmin")))) || (p.hasPermission(((String) this.settings.getpermData().getString("mwsshoptpdel"))))) {
	        if (this.settings.getsData().getString(args[0] + ".world") == null) {
	          String message = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("shopplno").replaceAll("%player%", p.getName()));
	          p.sendMessage(message);	          
	          return true;
	        }
	        
	        this.settings.getsData().set(args[0] + ".world", null);
	        this.settings.getsData().set(args[0] + ".x", null);
	        this.settings.getsData().set(args[0] + ".y", null);
	        this.settings.getsData().set(args[0] + ".z", null);
	        this.settings.getsData().set(args[0] + ".yaw", null);
	        this.settings.getsData().set(args[0] + ".pitch", null);
	        this.settings.savesData();
	        
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("sshopremoved")));
	      }
	      else {
	        p.sendMessage(ChatColor.translateAlternateColorCodes('&', ((String)this.settings.getsysoData().get("permError"))));
	      }
	    }
		return false;}}
	    
	   
	        
	    
