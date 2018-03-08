package de.emptyWorld.main;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.mob.MobListener;



public class reload implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	File blockConfigFile;
	  File mobConfigFile;
	  leerWelt plugin;
  World world;
  
  public reload(leerWelt instance)
  {
    plugin = instance;
  }
  
 
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
{
	  if (cmd.getName().equalsIgnoreCase("mwsr")) {		  
		  plugin.reloadConfig();
		  this.settings.reloadData();
		  this.settings.reloaddeData();
		  this.settings.reloadenData();
		  this.settings.reloadwData();
		  this.settings.reloadpData();
		  this.settings.reloadpermData();
		  this.settings.reloadsysoData();
		  this.settings.reloadbData();
		  this.settings.reloadb2Data();
		  this.settings.reloadmobData();
		  this.settings.reloadblockData();
		  this.settings.reloadmoblootData();
		  
		  
		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("SysConfigReload")));
		return true;}	  
	  sender.sendMessage("Fehler");}
return false;}}
