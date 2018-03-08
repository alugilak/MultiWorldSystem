package de.emptyWorld.main.mob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.NumberConversions;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import net.milkbowl.vault.economy.EconomyResponse;

public class MobListener implements Listener
{einstellungen settings = einstellungen.getInstance();
FileConfiguration data;
FileConfiguration wdata;
FileConfiguration pdata;
FileConfiguration dedata;	  
FileConfiguration endata;
FileConfiguration permdata;
FileConfiguration sysodata;

leerWelt plugin;
private Random rand; 

public MobListener( leerWelt instance)
	  {
	
	  plugin = instance;
	  this.rand = new Random();
	  }

public HashMap<String, Double> max = new HashMap<String, Double>();
public HashMap<String, Double> min = new HashMap<String, Double>();

@EventHandler
public void onEntityDeath(EntityDeathEvent event)
{
  if (!plugin.isEnabled()) {
    return;
  }
  Loot loot = (Loot)Config.lootByEntity.get(event.getEntityType());
  if (loot == null) {
    return;
  }
  if (loot.cancelDefaultLoot) {
    event.getDrops().clear();
  }
  for (Map.Entry<Byte, ItemStack> entry : loot.loot.entrySet()) {
    if (((Byte)entry.getKey()).byteValue() == 100) {
      event.getDrops().add(entry.getValue());
    } else if (Math.random() * 100.0D > -((Byte)entry.getKey()).byteValue() + 100) {
      event.getDrops().add(entry.getValue());
    }
  }
  loot = null;
}
@EventHandler
public void onEntityDeath1(EntityDeathEvent event) {
     LivingEntity entity = event.getEntity();
    	 String idt = this.settings.getmoblootData().getString("main.droppedItem");
         String dname = this.settings.getmoblootData().getString("main.droppedItemLore");
         Material material = Material.matchMaterial(idt);
         ItemStack Item = new ItemStack (material);
     ItemMeta EnchantMeta = Item.getItemMeta();
     double max = this.settings.getmoblootData().getDouble("main.DropMoneyMax");
     double min = this.settings.getmoblootData().getDouble("main.DropMoneyMin");     
     double Random = min + (max - min) * this.rand.nextDouble();
     EnchantMeta.setDisplayName(ChatColor.GOLD + dname);
     List<String> lore = new ArrayList<String>();
     lore.add(Double.toString(Random));
     EnchantMeta.setLore(lore);
     Item.setItemMeta(EnchantMeta);
		ItemStack Item1 = new ItemStack (Item);
     Location loc = entity.getLocation();
     World w = entity.getWorld();
     w.dropItemNaturally(loc, Item1);
     }
   
public String getRandom(double d) 
	 {
		    return Double.toString(Math.round(d * 100.0D) / 100L);
		  }

@EventHandler
public void onInventoryClickE(InventoryClickEvent e) {
	HumanEntity p = e.getWhoClicked();
	String dname = this.settings.getmoblootData().getString("main.droppedItemLore");
	if (e.getCurrentItem() == null) return;
    if(e.getCurrentItem().getItemMeta() == null) return;
    if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
    if (e.getCurrentItem().getItemMeta().getDisplayName().contains(dname)){
        e.setCancelled(true);
        //NEED THE WITHDRAW CODEHERE!        
        ItemStack item = (e.getCurrentItem());
        if(item.getItemMeta().getLore() != null && item != null){
        for(String line : item.getItemMeta().getLore()) {      
        double price = Double.parseDouble(line);
        leerWelt.econ.depositPlayer((OfflinePlayer) e.getWhoClicked(), price);
        e.getWhoClicked().getInventory().removeItem(e.getCurrentItem());
        e.getWhoClicked().sendMessage(ChatColor.YELLOW + this.settings.getmoblootData().getString("main.pickup") + " " + ChatColor.AQUA + getRandom(price) + ChatColor.YELLOW +" cash");
      
    }}}
}     

	}




        