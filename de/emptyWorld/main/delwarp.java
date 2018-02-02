package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class delwarp implements CommandExecutor
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
	  
	
  public delwarp( leerWelt instance)
  {

    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;
  
	    if (cmd.getName().equalsIgnoreCase("dwarp"))
	    {
	    	 if (!sender.hasPermission((String) this.settings.getpermData().get("mwswarpdel")))    		      
	    		      {
	    		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + plugin.getConfig().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + plugin.getConfig().getString("warpdelPermission") + " " + ChatColor.GREEN + plugin.getConfig().getString("permissionErrorText"));
	    		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    		        return false;
	    		      }    	 
	      if (args.length == 0)
	    	 
	      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + plugin.getConfig().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.RED + plugin.getConfig().getString("WarpNameError"));
	        return false;
	      }
	      if (this.settings.getData().getConfigurationSection("warps." + args[0]) == null)
	      {
	        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + plugin.getConfig().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + "The warp " + ChatColor.GOLD + args[0] + ChatColor.GREEN + " does not exist!");
	        return false;
	      }
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + plugin.getConfig().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + plugin.getConfig().getString("WarpDelfinsh ") + ChatColor.GOLD + args[0] + ChatColor.GREEN + "!");
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      this.settings.getData().set("warps." + args[0], null);
	      this.settings.saveData();
	      
	      
	      return true;
	    }
		return false;}}