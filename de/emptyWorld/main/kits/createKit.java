package de.emptyWorld.main.kits;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class createKit implements CommandExecutor
{
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public createKit( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
  Player p = (Player)sender;
  Inventory pi = p.getInventory();
  if (commandLabel.equalsIgnoreCase("createkit"))
  {
    if ((p.hasPermission("mwsKit.savekit")) || (p.hasPermission("mwsKit.*")))
    {
    	if (args.length == 1)
      {
        if (!this.settings.getkitData().getStringList("Kits").contains(args[0]))
        {
          List<String> Kits = this.settings.getkitData().getStringList("Kits");
          Kits.add(args[0]);
          this.settings.getkitData().set("Kits", Kits);
          this.settings.savekitData();
          for (int i = 0; i < p.getInventory().getSize(); i++)
          {
            ItemStack item = p.getInventory().getItem(i);
            this.settings.getkitData().set(args[0] + i, item);
            this.settings.savekitData();
          }
          p.getInventory().clear();
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou successfully saved your inventory as kit &b" + args[0]));
        }
        else
        {
          p.sendMessage(ChatColor.RED + "That kit already exists");
        }
      }
      else {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect usage: /savekit <Kit Name>"));
      }
    }
    else {
      p.sendMessage(ChatColor.RED + "You don't have permissions.mwsKit.savekit or mwsKit.*");
    }
  }
  else if (commandLabel.equalsIgnoreCase("getkit"))
  {
    if (args.length == 1)
    {
      if (this.settings.getkitData().getStringList("Kits").contains(args[0]))
      {
        if ((p.hasPermission("mwsKit.kits." + args[0])) || (p.hasPermission("mwsKit.*")) || (p.hasPermission("mwsKit.kits.*")))
        {
          for (int i = 0; i < 36; i++) {
            if (this.settings.getkitData().getItemStack(args[0] + i) != null)
            {
              ItemStack loading = this.settings.getkitData().getItemStack(args[0] + i);
              p.getInventory().addItem(new ItemStack[] { loading });
            }
          }
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou successfully recieved the kit&7: &b" + args[0]));
        }
        else
        {
          p.sendMessage(ChatColor.RED + "You don't have permissions. mwsKit.* or mwsKit.kits.* or mwsKit.kits." + args[0]);
        }
      }
      else {
        p.sendMessage(ChatColor.RED + "There is no such kit.");
      }
    }
    if (args.length >= 2) { 
  	  Player target = Bukkit.getServer().getPlayer(args[1]);
        Inventory targeti = target.getInventory();
  	    if (this.settings.getkitData().getStringList("Kits").contains(args[0]))
  	    {
  	      if ((p.hasPermission("mwsKit.kits." + args[0])) || (p.hasPermission("mwsKit.*")) || (p.hasPermission("mwsKit.kits.*")))
  	      {
  	        for (int i = 0; i < 36; i++) {
  	          if (this.settings.getkitData().getItemStack(args[0] + i) != null)
  	          { 
  		    	
  	          ItemStack loading = this.settings.getkitData().getItemStack(args[0] + i);
  		    	if(!(pi.firstEmpty() == -1)) { 
  		    		targeti.addItem(new ItemStack[] { loading }); }
  		    	else target.sendMessage( "not enough free slots"); }} p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou successfully recieved the kit&7: &b" + args[0]));
  	        } else
  	        {
  	          p.sendMessage(ChatColor.RED + "You don't have permissions. mwsKit.* or mwsKit.kits.* or mwsKit.kits." + args[0]);
  	        }	
  		
  	          }
        else {
            p.sendMessage(ChatColor.RED + "There is no such kit.");
          }
  	        }}
  else if (commandLabel.equalsIgnoreCase("listkit")) {
     if (args.length == 0)
    {
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l&m---------&8&l&m[-&r  &8&l[&6&lMWS-Kit&f&lCreator&8&l] &8&l&m-]&c&l&m--------------------"));
      for (int i = 0; i < this.settings.getkitData().getStringList("Kits").toArray().length; i++) {
        if (p.hasPermission("mwsKit.kits." + this.settings.getkitData().getStringList("Kits").toArray()[i])) {
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f" + this.settings.getkitData().getStringList("Kits").toArray()[i]));
        }
      }
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l&m---------------------------------------------"));
    }
    else
    {
      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect usage: /getkit <Kit Name> or /getkit <Kit Name> <Player Name>"));
    }}
   if (commandLabel.equalsIgnoreCase("removekit")) {
    if ((p.hasPermission("mwsKit.removekit")) || (p.hasPermission("mwsKit.*")))
    {
      if (args.length == 1)
      {
        if (this.settings.getkitData().getStringList("Kits").contains(args[0]))
        {
          List<String> remove = this.settings.getkitData().getStringList("Kits");
          remove.remove(args[0]);
          this.settings.getkitData().set("Kits", remove);
          this.settings.savekitData();
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have successfuly removed:&7 " + args[0]));
        }
        else
        {
          p.chat("/listkit");
          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cKit Not Found. We gave you a list here above of the current kits."));
        }
      }
      else {
        p.sendMessage(ChatColor.RED + "Correct usage: /removekit <Name>");
      }}
        
    else {
      p.sendMessage(ChatColor.RED + "You don't have permissions. mwsKit.removekit or mwsKit.*");
    }
  }
return false;}}
 