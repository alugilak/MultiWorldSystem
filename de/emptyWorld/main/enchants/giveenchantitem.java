package de.emptyWorld.main.enchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class giveenchantitem implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  FileConfiguration blockdata;
	  World world;
	  
	  leerWelt plugin;  
	  
	  
public giveenchantitem( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	Player p = (Player)sender;	
	      if (commandLabel.equalsIgnoreCase("enchantitem")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	          {
	    		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	    		  p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
	    		  return false ;}
	    	  if (args.length == 0) {	
	  	    	 p.sendMessage("Use /enchantitem <Displayname> and/ore <Playername>");
	  	    		return false;}
	      if (args.length == 1) {
    		  ItemStack Item = new ItemStack (this.settings.getblockData().getItemStack("Item." + args[0] + ".ID"));
   	    	p.getInventory().setItem(8, Item); }
	      if (args.length == 2) {
	    	ItemStack Item = new ItemStack (this.settings.getblockData().getItemStack("Item." + args[0] + ".ID"));
	    	Player target = Bukkit.getServer().getPlayer(args[1]);
	    	target.getInventory().setItem(8, Item);
		return true;}
		return true;}
		return true;}}
		
		
	
		
