package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class teleportxyz implements CommandExecutor {
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
	  
	
  public teleportxyz( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;  

if (cmd.getName().equalsIgnoreCase("xyz")) {
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwstpxyz"))) {
    	
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwstpxyz")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return false;
    }

	Player player = Bukkit.getServer().getPlayer(sender.getName());
    Location ploc = p.getLocation();
    Chunk chunk = p.getWorld().getChunkAt(ploc);
    Bukkit.getWorld(player.getWorld().getName()).loadChunk(chunk);
    
    {
    	
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);
      int z = Integer.parseInt(args[2]);
      ploc = new Location(p.getWorld(), x, y, z);{
      p.teleport(ploc);
      return true;
    }}}{
return false;}}}