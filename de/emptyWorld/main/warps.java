package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.leerWelt;


public class warps implements CommandExecutor
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
	  
	
  public warps( leerWelt instance)
  {

    plugin = instance;
  }  


public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("sspawn"))
    {
      if (!sender.hasPermission((String) this.settings.getpermData().get("mwsspawns")))
      {
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsspawns")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }else {
      this.settings.getData().set("spawn.world", p.getLocation().getWorld().getName());
      this.settings.getData().set("spawn.x", Double.valueOf(p.getLocation().getX()));
      this.settings.getData().set("spawn.y", Double.valueOf(p.getLocation().getY()));
      this.settings.getData().set("spawn.z", Double.valueOf(p.getLocation().getZ()));
      this.settings.saveData();
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Spawnset")));
      return true;
    }}

    if (cmd.getName().equalsIgnoreCase("w"))    
    if (p.hasPermission((String) this.settings.getpermData().get("mwswarpuse"))) {
      if (args.length == 1) {
        if (this.settings.getData().getString("warps." + args[0]) != null)
        {
          String world = this.settings.getData().getString("warps." + args[0] + ".world");
          double x = this.settings.getData().getDouble("warps." + args[0] + ".x");
          double y = this.settings.getData().getDouble("warps." + args[0] + ".y");
          double z = this.settings.getData().getDouble("warps." + args[0] + ".z");          
          Location loc = new Location(org.bukkit.Bukkit.getWorld(world), x, y, z);
          p.teleport(loc);
          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.AQUA.toString() + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BOLD + " »" + ChatColor.YELLOW + ((String)this.settings.getsysoData().get("warpwelcome")) + "==>" + ChatColor.BLUE + args[0]);
          return true;
        } else {
          p.sendMessage("§7Warp §e" + args[0] + " §7not found!");        
      }} else p.sendMessage("§c/warp <NAME>");
    }    
    if (cmd.getName().equalsIgnoreCase("spawn")) {
	            	     if (!(this.settings.getData().get("spawn.world") != null))
	            	      {
	            	          p.sendMessage(ChatColor.RED + "SetSpawn Error:");
	            	          p.sendMessage("SPAWN IS NOT SET!!!");
	            	          p.sendMessage("If you are Administrator, you can set spawn using /spawn.");
	            	          return false;
	            	        }
	            	        else
	            	        {
	            	        	World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
	            	            double x = settings.getData().getDouble("spawn.x");
	            	            double y = settings.getData().getDouble("spawn.y");
	            	            double z = settings.getData().getDouble("spawn.z");
	            	            p.teleport(new Location(w, x, y, z));
	            	            return true;
	            	        }
	            	      }
	              

    
	return false;}}



    

    

