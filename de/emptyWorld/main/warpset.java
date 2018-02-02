package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



public class warpset implements CommandExecutor
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
	  
	
  public warpset( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("swarp"))
	    {
	      if (!sender.hasPermission((String) this.settings.getpermData().get("mwswarps")))
	      { 
	    	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsspawns")) + " " + ChatColor.GREEN + plugin.getConfig().getString("permissionErrorText"));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;
	      }
	      if (args.length == 1) {
	    
	          this.settings.getData().set("warps." + args[0] + ".world", p.getLocation().getWorld().getName());
	          this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(p.getLocation().getX()));
	          this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(p.getLocation().getY()));
	          this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(p.getLocation().getZ()));
	          this.settings.saveData();
	          p.sendMessage("§7Warp §e" + args[0] + " §7has been set!");
	          return true;}
	      if (args.length == 0) {
	          p.sendMessage("§c/setwarp <NAME>");	       	
	          return false;
	         
	  }}
		return false;
		}{
		 }}
  
  