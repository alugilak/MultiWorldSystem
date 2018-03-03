package de.emptyWorld.main.itemBank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.loadworld;

public class vipbank implements CommandExecutor, Listener
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
  public vipbank( leerWelt instance)
  {
    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {Player player = (Player)sender;
  if (cmd.getName().equalsIgnoreCase("vbo")||cmd.getName().equalsIgnoreCase("vipbank"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsvipbanking")))
      {
    	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + (this.settings.getsysoData().getString("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + (this.settings.getpermData().getString("mwsvipbanking")) + " " + ChatColor.GREEN + (this.settings.getsysoData().getString("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else { 
    	  int b1 = plugin.getConfig().getInt(player.getPlayer().getName() + ".Pslots");
    	  Inventory inventory1 = Bukkit.createInventory(player, b1, ChatColor.GOLD.toString() + player.getName() + "´s VIP ItemBank");
      for (int slotIndex1 = 0; slotIndex1 != b1; slotIndex1++)
        inventory1.setItem(slotIndex1, this.settings.getb2Data().getItemStack(player.getUniqueId().toString() + ".item" + slotIndex1));      
      player.openInventory(inventory1);
      leerWelt.playerBank2.put(player, inventory1);
    }  
	return true;
  }
return false;}
  @EventHandler
  public void inventoryCloseEvent(InventoryCloseEvent event)
  {
  if (((event.getPlayer() instanceof Player)) && 
  	      (leerWelt.getPlayerBank2().containsKey(event.getPlayer())))
  	    {
  	    int b1 = plugin.getConfig().getInt(event.getPlayer().getName() + ".Vslots");
  	      Inventory inventory = leerWelt.getPlayerBank2().get(event.getPlayer());
  	      for (int slotIndex = 0; slotIndex != b1; slotIndex++)
  	      {
  	        ItemStack itemStack;	        
  	        if (inventory.getItem(slotIndex) == null) {
  	          itemStack = new ItemStack(Material.AIR);
  	        } else {
  	          itemStack = new ItemStack(inventory.getItem(slotIndex));	       
  	        this.settings.getb2Data().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex, itemStack);
  	        this.settings.saveb2Data();	     
  	      event.getPlayer().sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("VipBankSaveMessageTitel") + ChatColor.AQUA + " " + event.getPlayer().getName() + ChatColor.GOLD + " " + plugin.getConfig().getString("VipBankSaveMesssageTitel2"));
  	      
  	    leerWelt.getPlayerBank2().remove(event.getPlayer());
  	    }}}

}}