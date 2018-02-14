package de.emptyWorld.main.commands;

import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;


public class stormset implements CommandExecutor {
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
public stormset( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	{  		
		Player p = (Player) sender;  	
		  if (cmd.getName().equalsIgnoreCase("stormset"))
			if (!sender.hasPermission((String) this.settings.getpermData().get("mwsstorm")))    		      
		      {
		        sender.sendMessage(org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + " >" + org.bukkit.ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsstorm")) + " " + org.bukkit.ChatColor.GREEN + ((String) this.settings.getsysoData().get("permissionErrorText")));
		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
		        return false;
		      }   if (args.length == 1)	
	 if (args[0].equals("on"))
	 {		    		
		 plugin.getConfig().set("thunder", false);
		 plugin.saveConfig();
		 plugin.reload();
		 sender.sendMessage(org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + " >" + org.bukkit.ChatColor.BLUE + ((String) this.settings.getsysoData().get("thunderFalse")));
		 return true;}		 
	 if (args[0].equals("off"))
		 if (args.length == 1);{ 	    			 
			 plugin.getConfig().set("thunder", true);
  		 plugin.saveConfig();
  		 plugin.reload();
  		 sender.sendMessage(org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + org.bukkit.ChatColor.GOLD.toString() + org.bukkit.ChatColor.BOLD + " >" + org.bukkit.ChatColor.BLUE + ((String) this.settings.getsysoData().get("thunderTrue")));
  		 return true;
	 }}}}