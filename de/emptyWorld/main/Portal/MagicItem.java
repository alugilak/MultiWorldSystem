package de.emptyWorld.main.Portal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class MagicItem implements CommandExecutor, Listener {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  
	  
	  public MagicItem( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public static Map<String, Location> MIT1 = new HashMap<String, Location>();
	  public static Map<String, Location> MIT2 = new HashMap<String, Location>();

	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		  Player p = (Player)sender;
			Inventory pi = p.getInventory();
	if (commandLabel.equalsIgnoreCase("magicitem")) {
		  if (!sender.hasPermission(this.settings.getportalData().getString("mwsItemperm")))
	{	    	        
	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getsysoData().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getsysoData().getString("permError") + " " + this.settings.getportalData().getString("mwsItemperm"));
	p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
	return false ;}
		  if (args.length == 0) {	
			
			  if(!(pi.firstEmpty() == -1)) {
				  int idt = this.settings.getportalData().getInt("MagicItemID");		
					Material material = Material.getMaterial(idt);					
					ItemStack Enchant = new ItemStack (material);
					     ItemMeta EnchantMeta = Enchant.getItemMeta();	 
					     int a = (10);
					     int b = (9);
					     int c = (9);
					     int d = (9);	
					     int e = (10);
					     int f = (9);
					     int g = (9);
					     int h = (9);
					     int i = (10);
					     int j = (9);
					     int k = (9);
					     int l = (4);
					     int m = (4);
					     EnchantMeta.addEnchant(Enchantment.DAMAGE_ALL, a, true);
					     EnchantMeta.addEnchant(Enchantment.LUCK, b, true);
					     EnchantMeta.addEnchant(Enchantment.PROTECTION_FALL, c, true);
					     EnchantMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, d, true);
					     EnchantMeta.addEnchant(Enchantment.PROTECTION_FIRE, e, true);
					     EnchantMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, f, true);
					     EnchantMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, g, true);
					     EnchantMeta.addEnchant(Enchantment.THORNS, h, true);
					     EnchantMeta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, i, true);
					     EnchantMeta.addEnchant(Enchantment.DAMAGE_UNDEAD, j, true);
					     EnchantMeta.addEnchant(Enchantment.DEPTH_STRIDER, k, true);
					     EnchantMeta.addEnchant(Enchantment.KNOCKBACK, l, true);
					     EnchantMeta.addEnchant(Enchantment.FIRE_ASPECT, m, true);
					     String loreargs = this.settings.getportalData().getString("MagicItemLore");
					     String dname = this.settings.getportalData().getString("MagicItemDisplayName");
					     	ArrayList<String> lore = new ArrayList<String>();	    		     	
							lore.add(loreargs);
							EnchantMeta.setDisplayName(ChatColor.GOLD + dname);
							EnchantMeta.setLore(lore);	    				   
							Enchant.setItemMeta(EnchantMeta); 
							ItemStack Enchantnew = new ItemStack (Enchant);
		    		pi.addItem(Enchantnew);
		    		int Absortption = (20);
				    int Damageresistance = (20);
				    int Waterbreathing = (20);
				    int Nightvision = (20);
		    		p.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.ABSORPTION, Integer.MAX_VALUE, Absortption, true, false));
		    		p.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, Damageresistance, true, false));
		    		p.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, Waterbreathing, true, false));
		    		p.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, Nightvision, true, false));
		    		return true;}
					else p.sendMessage( "not enough free slots");
					return false;}}
	return false;}}	
		  
		  