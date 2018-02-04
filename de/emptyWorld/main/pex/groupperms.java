package de.emptyWorld.main.pex;

import java.util.ArrayList;
import java.util.List;

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

public class groupperms implements CommandExecutor
{ ConsoleCommandSender console = Bukkit.getConsoleSender();
List<String> wl = new ArrayList<String>();
List<String> wll = new ArrayList<String>();
List<String> wlu = new ArrayList<String>();
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
  
  public groupperms(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {

    Player p = (Player)sender; 
   
    
    if (cmd.getName().equalsIgnoreCase("pg+"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgroup")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgroup")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      } StringBuilder str = new StringBuilder();
	   for (int i = 0; i < args.length; i++) {
	        str.append(args[i] + " ");
    }	if (args.length <= 1) {	
		  p.sendMessage("Use /pg+ <permission> <groupname> ");
		  	return false;}
  if (args.length == 2);{      
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex group" + " " + args[1] + " " + "add" + " " + args[0]);}
  p.sendMessage("Group" + " " + args[1] + " " + "permission" + " " + args[0] + " " + "set");
  return true;}
    if (cmd.getName().equalsIgnoreCase("pg-"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgroup")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgroup")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      } StringBuilder str = new StringBuilder();
	   for (int i = 0; i < args.length; i++) {
	        str.append(args[i] + " ");
    }	if (args.length <= 1) {	
		  p.sendMessage("Use /pg- <permission> <groupname>");
		  	return false;}
  if (args.length == 2);{      
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex group" + " " + args[1] + " " + "remove" + " " + args[0]);}
  p.sendMessage("Group" + " " + args[1] + " " + "permission" + " " + args[0] + " " + "removed");
  return true;}
    
	return false;}}