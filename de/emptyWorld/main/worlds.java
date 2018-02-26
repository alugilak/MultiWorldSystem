package de.emptyWorld.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
	File[] directories = new File(plugin.getDataFolder() + File.separator + ".." + File.separator + "..").listFiles(File::isDirectory);
	List<File> worlds = new ArrayList<>();
	
	for (File ia : directories) {
		File levelDat = new File(ia + File.separator + "level.dat");
		if (levelDat.exists()) {
			worlds.add(ia);
			
			for (File w : worlds) {
				File wFile = new File(ia + File.separator + "level.dat");
				
				if (wFile.exists()) {
					
					String allworlds = levelDat.getParentFile().getName();
    if (player.hasPermission((String)this.settings.getpermData().get("mwswlist"))) {
      if (cmd.getName().equalsIgnoreCase("wlist")) {
        player.sendMessage(ChatColor.YELLOW + "There are: " + allworlds);
        
      }
    }}}}} 
    return false;
  }}
  
 