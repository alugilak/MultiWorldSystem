package de.emptyWorld.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class HelpCommand implements CommandExecutor {
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
public HelpCommand( leerWelt instance)
{

plugin = instance;
}
 

  public boolean onCommand( CommandSender sender, Command cmd, String commandLabel, String[] args )
  {for(Player p: Bukkit.getServer().getOnlinePlayers())
  	  if (!(sender instanceof Player))
  		if ((sender.hasPermission(plugin.getConfig().getString("Guipermission"))))
  		  if (cmd.getName().equalsIgnoreCase("mwscommands"))
  		    {    	  		 
  		  PluginDescriptionFile pla = plugin.getDescription();
  		   
  		p.sendMessage( pla.getVersion() + " " + pla.getCommands());
  	  
              return true;
          }
  sender.sendMessage("no permissions!" + plugin.getConfig().getString("Guipermission"));
return false;}}
