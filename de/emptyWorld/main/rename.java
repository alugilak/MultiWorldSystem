package de.emptyWorld.main;


import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.loadworld;



public class rename implements CommandExecutor
{
	loadworld worldLoader;
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
  
  public rename(leerWelt instance)
  {

    plugin = instance;
  }
  public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if ((player.hasPermission(((String) this.settings.getpermData().get("mwsworldrename"))) && 
      (cmd.getName().equalsIgnoreCase("wren")))) {    	
      Rename(player, args[0], args[1]);
      this.settings.getData().set("warps." + args[0] , null);
      this.settings.saveData();        
      this.settings.getwData().set("worlds." + args[0], null);      
      this.settings.getwData().set("worlds." + args[1] + ".type", "NORMAL");
      this.settings.savewData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv" + " " + " remove" + " " + args[0]);
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv" + " " + "import" + " " + args[1] + " " + "normal");
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv" + " " + "confirm"); 
      player.sendMessage(ChatColor.YELLOW + "you are teleported now in world " + " " + ChatColor.GREEN + args[1] + " "+ ChatColor.YELLOW + "please wait");
      Bukkit.dispatchCommand(player, "swarp" + " " + args[1]);
      World world = org.bukkit.Bukkit.getServer().createWorld(new org.bukkit.WorldCreator(args[1]));
      player.getPlayer().teleport(world.getSpawnLocation()); 
      return true;
      }
	return false;}
      


	  
  
  
  public void RenameFile(File target, String newName, Player player) {
    player.sendMessage(ChatColor.GREEN + "Trying to rename file...");
    try {
      File file2 = new File(newName);
      target.renameTo(file2);
    } catch (Exception e) {
      player.sendMessage(ChatColor.RED + "Error: " + e);
    }
  }
  
  public void Rename(Player player, String worldName, String newName) {
    World worldChoosen = Bukkit.getWorld(worldName);
    if (worldChoosen != null) {
      player.sendMessage(ChatColor.GOLD + "Renaming File...");
      Bukkit.unloadWorld(worldChoosen, true);
      RenameFile(worldChoosen.getWorldFolder(), newName, player);
      player.sendMessage(ChatColor.GOLD + "Renamed: " + worldName + " to: " + newName);
    } else {
      worldLoader = new loadworld(null);      
      boolean loadedworld = worldLoader.LoadWorld(worldName, player);
      if (loadedworld)
      {
        player.sendMessage(ChatColor.GOLD + "Found. File.");
        Rename(player, worldName, newName);
      }
      else {
        player.sendMessage(ChatColor.RED + "File Does not exist aborting!");
      }
    }
  }
}
