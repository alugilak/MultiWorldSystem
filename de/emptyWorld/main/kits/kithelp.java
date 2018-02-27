package de.emptyWorld.main.kits;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class kithelp implements CommandExecutor
{
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public kithelp( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player)sender;
  if (commandLabel.equalsIgnoreCase("mwskit")) {
	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
      {
		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
		  p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
		  return false ;}
	if (args.length == 0) {	
		  p.sendMessage(ChatColor.GREEN +  "*************************" + ChatColor.GOLD + "MWS-Kits" + ChatColor.GREEN + "***************************");
		  p.sendMessage(ChatColor.AQUA+ "Put all Items for a kit in your Inventory.No other Items!");
		  p.sendMessage(ChatColor.AQUA+ "Now Use /createkit <KitName> to save the kit!");
		  p.sendMessage(ChatColor.AQUA+ "Now Use /getkit <KitName> or /getkit <KitName> <Playername> to give the kit!");
		  p.sendMessage(ChatColor.AQUA+ "Now Use /removekit <KitName> to delete the kit from configfile!");
		  p.sendMessage(ChatColor.AQUA+ "Now Use /listkit to list all kits from the configfile");
		  p.sendMessage(ChatColor.GREEN +  "************************************************************");
	    return true;}}
return false;}}