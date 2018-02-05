package de.emptyWorld.main.commands;

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

public class possave implements CommandExecutor
{
	public static final String warpsName = null;
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
	  
	
  public possave( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player p = (Player)sender;	    
	    if (cmd.getName().equalsIgnoreCase("possave"))
	    {
	      if (!sender.hasPermission((String) this.settings.getpermData().get("mwspossave")))
	      {
	    	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwspossave")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;}	 
	      this.settings.getData().set("save." + p.getName() + ".world", p.getLocation().getWorld().getName());
	      this.settings.getData().set("save." + p.getName() + ".x", Double.valueOf(p.getLocation().getX()));
	      this.settings.getData().set("save." + p.getName() + ".y", Double.valueOf(p.getLocation().getY()));
	      this.settings.getData().set("save." + p.getName() + ".z", Double.valueOf(p.getLocation().getZ()));
	      this.settings.saveData();
	      p.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwspossave")));
	    } else {
            p.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("mwsNopossave")));
        }
	return false;
}}