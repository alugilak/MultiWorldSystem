package de.emptyWorld.main.Wand;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class house implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public house( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		{Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("househelp"))
		{
		if (!(player.hasPermission(this.settings.getpermData().getString("mwshouseHelp"))))       
	    {
				player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouseHelp")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
				return false;
				}
					player.sendMessage(ChatColor.GREEN + "/househelp -shows this page.");					
					player.sendMessage(ChatColor.GREEN + "/house2 <BlockID> <DataValue> <WindowsID> <WindowsDataValue> -makes a house.");
					player.sendMessage(ChatColor.GREEN + "/house3 <BlockID> <DataValue> <roofBlockID> <roofDataValue> <groundBlockID> <groundDataValue> <windowBlockID> <windowsDataValue> -makes a house.");
					player.sendMessage(ChatColor.GREEN + "/house4 <BlockID> <DataValue> <poleBlockID> <poleDataValue> -makes a house.");
				return true;}
		return false;
		
		}
			
			
	}