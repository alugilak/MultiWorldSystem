package de.emptyWorld.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class playerWorlds implements CommandExecutor
{ ConsoleCommandSender console = Bukkit.getConsoleSender();
List<String> wl = new ArrayList<String>();
List<String> wll = new ArrayList<String>();
List<String> wlu = new ArrayList<String>();
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  
	  leerWelt plugin;
	  World world;
  
  public playerWorlds(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {

    Player p = (Player)sender; 
   
    
    if (cmd.getName().equalsIgnoreCase("cpworld"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwscplayerworld")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwscplayerworld")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 0)

      {
	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));   	  
      WorldCreator b = new WorldCreator(p.getName());
      b.type(WorldType.NORMAL);
      b.generateStructures(true);      
      this.world = b.createWorld();
      this.settings.getwData().set("worlds." + p.getName() + ".type", "NORMAL");
      this.settings.getwData().set("worlds." + p.getName() + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + p.getName() + ".pvp", "true");
      this.settings.getwData().set("worlds." + p.getName() + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + p.getName() + ".seed", "");
      this.settings.getwData().set("worlds." + p.getName() + ".generate-structures", "true");
      this.settings.getwData().set("worlds." + p.getName() + ".spawn-animals", "true");
      this.settings.getwData().set("worlds." + p.getName() + ".spawn-monsters", "true");
      this.settings.savewData();      
      wll.add(p.getName());	
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + p.getName() + ".world", p.getName());
      this.settings.getData().set("warps." + p.getName() + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + p.getName() + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + p.getName() + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();      
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region define" + " " + p.getName() + " " + "g:members" + " " +  p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region flag __global__ -w" + " " + p.getName() + " " + "build deny");   
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region addowner __global__" + " " + "-w" + " " + p.getName() + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region flag __global__ build -w" + " " + p.getName() + " " + "-g members" + " " + " allow");      
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "worldguard.region.redefine.own.*" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "worldguard.region.addmember.*" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "worldguard.region.removemember.*" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.gm1.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.gm0.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.home.set" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.home.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.warp.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.warp.set" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.heal.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.repair.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.sign.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.sign.set" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.sign.del" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.inv.clear" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.night.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.day.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.chatcolor.set" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + p.getName() + " " + "add" + " " + "mws.world.pladdmem" + " " + p.getName());
      
      
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + "World & folder" + " " + p.getName() + " " + "create");
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + p.getName());
      return true;
    }
    if (args.length == 1)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("keinen Namen eingeben!")));
  	  
  	return false;
    }}
    
    if (cmd.getName().equalsIgnoreCase("owbuilder+"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsplworldaddMemb")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsplworldaddMemb")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }if (args.length == 1)
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + args[0] + " " + "add" + " " + "mws.gm0.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + args[0] + " " + "add" + " " + "mws.gm1.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region addmember __global__" + " " + "-w" + " " + p.getName() + " " + args[0]);
      
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("owbuilder-"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsplworldaddMemb")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsplworldaddMemb")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }if (args.length == 1)
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + args[0] + " " + "remove" + " " + "mws.gm0.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + " " + args[0] + " " + "remove" + " " + "mws.gm1.use" + " " + p.getName());
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region removemember __global__" + " " + "-w" + " " + p.getName() + " " + args[0]);
      
      return true;
    }
	return false;}}
