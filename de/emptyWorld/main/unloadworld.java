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

public class unloadworld implements CommandExecutor
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
  
  public unloadworld(leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("wunload")) {
      if (!player.hasPermission((String)this.settings.getpermData().get("mwsworldunl"))) {
    	  player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("permError")));
      return false;}
        try {
          UnloadWorld(args[0], player);
          player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("unloadWorldTrue")));
          return true;
        } catch (Exception e)
        {
          player.sendMessage((String)this.settings.getsysoData().get("unloadWorldTrue") + " " + e);
          return false;
        }}
	return false;}
    
  
  public void UnloadWorld(String WorldName, Player player) {
    World world = Bukkit.getWorld(WorldName);
    
    if (world != null) {
      player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("unloadWorldTrue")) + " " + world.getName());
      Bukkit.unloadWorld(world, true);
      
      for (Player p : Bukkit.getOnlinePlayers()) {
        if (p.getWorld() == world) {
          player.sendMessage(ChatColor.BLUE + ((String)this.settings.getsysoData().get("worldplayerremove")) + " " + world.getName() + " " + ((String)this.settings.getsysoData().get("worlddelePlayertp")));
          
          World Default = (World)Bukkit.getWorlds().get(0);
          if (Default != null) {
            p.getPlayer().teleport(Default.getSpawnLocation());
          } else {
            p.kickPlayer((String)this.settings.getsysoData().get("worldnoexist"));
          }
        }
      }
      
      player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("unloadWorldTrue")) + " " + world.getName());
     {
      player.sendMessage(ChatColor.RED + world.getName() + ((String)this.settings.getsysoData().get("unloadWorldTrue")));
    }
  }}}
