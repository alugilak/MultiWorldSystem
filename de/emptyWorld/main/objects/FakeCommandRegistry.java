package de.emptyWorld.main.objects;

import de.emptyWorld.main.leerWelt;

import de.emptyWorld.main.einstellungen;


import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class FakeCommandRegistry extends BukkitCommand
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;	 
	  World world;
	private leerWelt plugin;  

  public FakeCommandRegistry(leerWelt m, String permission, String name, String description, String usageMessage, List<String> aliases)
  {
    super(name, description, usageMessage, aliases);
    this.plugin = m;
    setPermission(permission);
  }
  
  public boolean execute(CommandSender sender, String arg1, String[] args)
  {
    if (!sender.hasPermission(getPermission())) {
      sender.sendMessage(ChatColor.RED + "You dont have permission to do this!");
      return true;
    }
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + "Only players can do this!");
      return false;
    }
    Player p = (Player)sender;
    p.openInventory(plugin.gui);
    return false;
  }
}
