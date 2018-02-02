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

public class groupset implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public groupset( leerWelt instance)
  {

    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String warplist, String[] args)
  {Player p = (Player)sender;

  
  
  if (cmd.getName().equalsIgnoreCase("gset"))
	{
  	if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgroup"))) {
  		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgroup")) + " " + ((String)this.settings.getsysoData().get("permError")));
  	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
  	        return false;
} else {
	
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group1") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group2") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group2") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group1")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group3") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group3") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group4") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group4") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group3")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group5") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group5") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group4")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group6") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group6") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group5")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group7") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group7") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group6")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group8") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group8") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group7")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group9") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group9") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group8")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group10") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group10") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group9")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group11") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group11") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group10")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group12") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group12") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group11")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group13") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group13") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group12")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group14") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group14") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group13")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group15") + " "  + ((String)this.settings.getsysoData().get("Cmd2")))));
  	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String)this.settings.getsysoData().get("Cmd1") + " " + ((String)this.settings.getsysoData().get("Group15") + " "  + ((String)this.settings.getsysoData().get("Cmd3")) + " " + ((String)this.settings.getsysoData().get("Group2")))));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("CmdMessage1")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group1")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group3")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group4")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group5")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group6")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group7")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group8")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group9")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group10")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group11")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group12")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group13")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group14")));
  	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("Group15")));
  return true;	
	}}
return true;}}