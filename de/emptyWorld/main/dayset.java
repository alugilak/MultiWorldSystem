package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class dayset implements CommandExecutor
{
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public dayset( leerWelt instance)
  {

    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String warplist, String[] args)
  {for(Player p: Bukkit.getServer().getOnlinePlayers()) {    
  if (cmd.getName().equalsIgnoreCase("day"))
  {
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwsday")))
    {
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ((String)this.settings.getpermData().get("mwsday")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return false;
    }
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set 0 ");
    
    sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("setday")));
    
    return true;
  }
  if (cmd.getName().equalsIgnoreCase("night"))
  {
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwsnight")))
    {
    	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ((String)this.settings.getpermData().get("mwsnight")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return false;
    }
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set 13000 ");
    
    sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("setnight")));
    
    return true;
  }}
return true;}}