package de.emptyWorld.main.itemBank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.loadworld;

public class playerbank implements CommandExecutor
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
	  loadworld loader;
		loadworld worldLoader;
	  leerWelt plugin;   
  public playerbank( leerWelt instance)
  {
    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {Player p = (Player)sender;
  if (cmd.getName().equalsIgnoreCase("pbo")||cmd.getName().equalsIgnoreCase("bankopen"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsbanking")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsbanking")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else {  
    	  int b1 = plugin.getConfig().getInt(p.getPlayer().getName() + ".Pslots");
    	  Inventory inventory = Bukkit.createInventory(p, b1, ChatColor.GOLD.toString() + p.getName() + "´s ItemBank");
      for (int slotIndex = 0; slotIndex != b1; slotIndex++)
        inventory.setItem(slotIndex, this.settings.getbData().getItemStack(p.getUniqueId().toString() + ".item" + slotIndex));      
      p.openInventory(inventory);
      leerWelt.playerBank.put(p, inventory);
    }
	return true;
  }
  if (cmd.getName().equalsIgnoreCase("ebo"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsbanking2")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsbanking2")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else { 
    	  int b2 = plugin.getConfig().getInt(p.getPlayer().getName() + ".P2slots");	 
    	  Inventory inventory2 = Bukkit.createInventory(p, b2, ChatColor.GOLD.toString() + p.getName() + "´s ItemBank 2");
    	  
    	        for (int slotIndex2 = 0; slotIndex2 != b2; slotIndex2++)
        inventory2.setItem(slotIndex2, this.settings.getblockData().getItemStack(p.getUniqueId().toString() + ".item" + slotIndex2));      
      p.openInventory(inventory2);
      leerWelt.EnchantInv.put(p, inventory2);
    }  
	return true;

  }
return false;}}