package de.emptyWorld.main.Gamerules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class FireTick implements CommandExecutor
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
	  ConsoleCommandSender console = Bukkit.getConsoleSender();
	
  public FireTick( leerWelt instance)
  {
	   
    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;
	  String world = args[0];
	  if (args.length == 0) {		 
			p.sendMessage(ChatColor.GREEN + "/dft <worldname> <on>  or <off> to handle FireTick  ");	
	  }
	    	 if (!sender.hasPermission((String) this.settings.getpermData().get("FireTick")))    		      
	    		      {
	    		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("FireTick")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	    		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    		        return false;
	    		      }
				    	  if (cmd.getName().equalsIgnoreCase("dft")) { 				    		  			    			  
				    			  if (args[1].equals("off")){
				    				  Bukkit.dispatchCommand(p, "wtp" + " "+  world);
				    		    		 plugin.getConfig().set("doFireTick", false);
				    		    		 plugin.saveConfig();
				    		    		 plugin.reloadConfig();
				    		    		 String what =  plugin.getConfig().getString("doFireTick");
				    		    		 Bukkit.getWorld(world).setGameRuleValue("doFireTick", what);
				    		    		 Bukkit.dispatchCommand(console, "gamerule" + " "+  "doFireTick" + " " + what);
				    		    		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + plugin.getConfig().getString("doFireTickText") + " "+ ChatColor.GREEN + world + " " + ChatColor.BLUE + "to " + ChatColor.AQUA + what);
				    		    		 return true;}
				    		      	 if (args[1].equals("on")) {
				    		      		Bukkit.dispatchCommand(p, "wtp" + " "+  world);				    		      	 
				    		    		 plugin.getConfig().set("doFireTick", true);
				    		    		 plugin.saveConfig();
				    		    		 plugin.reloadConfig();
				    		    		 String what =  plugin.getConfig().getString("doFireTick");
				    		    		 Bukkit.getWorld(world).setGameRuleValue("doFireTick", what);
				    		    		 Bukkit.dispatchCommand(console, "gamerule" + " "+  "doFireTick" + " " + what);				    		    		 
				    		    		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + plugin.getConfig().getString("doFireTickText") + " "+ ChatColor.GREEN + world + " " + ChatColor.BLUE + "to " + ChatColor.AQUA + what);
				    		    		 return true;}}
	return false;}}
	    	 
									
						  
