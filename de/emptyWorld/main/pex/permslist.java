package de.emptyWorld.main.pex;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class permslist implements CommandExecutor
{ ConsoleCommandSender console = Bukkit.getConsoleSender();

	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  FileConfiguration cpdata ;
	  
	  
	  leerWelt plugin;

  
  public permslist(leerWelt instance)
  {

    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
  {

    Player p = (Player)sender; 
   
    
    if (cmd.getName().equalsIgnoreCase("permsl"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgroup")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwscplayerworld")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;}
      p.sendMessage(ChatColor.GREEN + "§7List of all §6MultiWorldSystem created worlds§7:");
      for(String msg : this.settings.getcpData().getStringList("permissions")) {
          p.sendMessage(msg);
      } }     
    

	return false;
} {
	
	}}        
        