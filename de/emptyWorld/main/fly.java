package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  leerWelt plugin;
	  World world;  
  public fly( leerWelt instance)
  {

    plugin = instance;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
	  Player p = (Player)sender;
if (cmd.getName().equalsIgnoreCase("f")) {
	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsfly")))
	    {
	  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsfly")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      return false;}
	    if(args.length == 0){
	        if (p.getAllowFlight() == (true)){
	            p.setAllowFlight(false);
	            sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("flyoffText")) + p.getName());
	            return true;
	        } 
	        else {
	        	p.setAllowFlight(true);
	            sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("flyonText")) + p.getName());
	            return true;}}       
	        else {
	        	if (args.length < 2);{	        	
	        	if (p.getAllowFlight() == (true)){
		            p.setAllowFlight(false);  
		            sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" +  p.getName() + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("flyoffText")) + p.getName());		            
	        	return true;}
	        else {
	        	p.setAllowFlight(true);
	        	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" +  p.getName() + " "  + ChatColor.BLUE + ((String)this.settings.getsysoData().get("flyonText")) + p.getName());
	        return true;}}}}  
			return false;}}
 

