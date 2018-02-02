package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.leerWelt;

public class worlds implements CommandExecutor
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
  
  public worlds(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (player.hasPermission((String)this.settings.getpermData().get("mwswlist"))) {
      if (cmd.getName().equalsIgnoreCase("wlist")) {
        player.sendMessage(ChatColor.YELLOW + "There are: ");
        player.sendMessage(ChatColor.WHITE + Worlds());
      }
    } else {
      player.sendMessage(ChatColor.RED + "Invalid Perms!");
    }
    return false;
  }
  
  public String Worlds() {
    String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
    int count = 0;
    for (org.bukkit.World w : Bukkit.getServer().getWorlds()) {
      worldNames[count] = w.getName();
      count++;
    }
    for (String s : worldNames) {
      System.out.println("World Names = " + s);
    }
    String FinalNames = "";
    for (int i = 0; i < worldNames.length; i++) {
      if (i != worldNames.length - 1) {
        FinalNames = FinalNames + worldNames[i] + ", ";
      } else {
        FinalNames = FinalNames + worldNames[i] + ".";
      }
    }
    return FinalNames;
  }
  
}
