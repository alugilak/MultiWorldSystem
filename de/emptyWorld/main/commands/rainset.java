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
import net.md_5.bungee.api.ChatColor;

public class rainset implements CommandExecutor {
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
public rainset( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	{  		
		Player p = (Player) sender;  	
		if (cmd.getName().equalsIgnoreCase("rainset"))
			if (!sender.hasPermission((String) this.settings.getpermData().get("mwsrain")))    		      
		      {
		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsrain")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permissionErrorText")));
		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
		        return false;
		      }   if (args.length == 1)	
	 if (args[0].equals("on"))
	 {		    		
		 plugin.getConfig().set("rain", false);
		 plugin.saveConfig();
		 plugin.reload();
		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("rainFalse")));
		 return true;}		 
	 if (args[0].equals("off"))
		 if (args.length == 1);{ 	    			 
			 plugin.getConfig().set("rain", true);
  		 plugin.saveConfig();
  		 plugin.reload();
  		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("rainTrue")));
  		 return true;}}}}