package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.leerWelt;


public class worldcheck implements CommandExecutor
{
	
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
  
  public worldcheck(leerWelt instance)
  {

    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("wstats")) {
      try {
        if (player.hasPermission("doubleverse.world.worldcheck"))
        {
          CheckWorld(player, args[0]);
        }
        else {
          player.sendMessage(ChatColor.RED + "Invalid Perms!");
        }
      } catch (Exception e) {
        player.sendMessage(ChatColor.RED + "Du musst einen Weltnamen eingeben! ");
        
      }
	  if (args.length == 0);
      return false;}
	return false;
    
  }
  
  public void CheckWorld(Player player, String WorldName) {
    World worldSelected = org.bukkit.Bukkit.getWorld(WorldName);
    if (WorldName != null) {
      if (worldSelected != null) {
        player.sendMessage(ChatColor.YELLOW + "Checking " + worldSelected.getName());
        player.sendMessage(ChatColor.BLUE + worldSelected.getName() + " Consists of");
        player.sendMessage(ChatColor.GREEN + "Generate Structures: " + worldSelected.canGenerateStructures());
        player.sendMessage(ChatColor.GREEN + "WorldType: " + worldSelected.getWorldType());
        player.sendMessage(ChatColor.GREEN + "Animal Spawn Limit: " + worldSelected.getAnimalSpawnLimit());
        player.sendMessage(ChatColor.GREEN + "Build Max Height: " + worldSelected.getMaxHeight());
        player.sendMessage(ChatColor.GREEN + "Seed: " + worldSelected.getSeed());
        player.sendMessage(ChatColor.GREEN + "Monster Spawn Limit: " + worldSelected.getMonsterSpawnLimit());
        player.sendMessage(ChatColor.GREEN + "Current Time: " + worldSelected.getTime());
        player.sendMessage(ChatColor.GREEN + "Sea Level: " + worldSelected.getSeaLevel());
        player.sendMessage(ChatColor.GREEN + "Water Animal Spawn Limit: " + worldSelected.getWaterAnimalSpawnLimit());
      }
      
    }
    else {
    	return;
      
    }
  }
}
