package de.emptyWorld.main.poitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.enchants.util.DAMAGEALL;

public class poitionWeapon   implements CommandExecutor, Listener {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  

	     
	  public poitionWeapon( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public static Map<String, Location> MIT1 = new HashMap<String, Location>();
	  public static Map<String, Location> MIT2 = new HashMap<String, Location>();

	  
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		  Player p = (Player)sender;
			Inventory pi = p.getInventory();
	if (commandLabel.equalsIgnoreCase("superitem")) {
		if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	{	    	        
	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getsysoData().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + this.settings.getsysoData().getString("permError") + " " + this.settings.getpermData().get("mwsenchant"));
	p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
	return false ;}else
		  if (args.length == 0) {
			  p.sendMessage(ChatColor.GREEN + "+++++++SUPERITEM ENCHANTING++++++++");
			  p.sendMessage(ChatColor.GOLD + "Use "+ ChatColor.AQUA + "<EnchantID> "+ ChatColor.YELLOW + "<EnchantLevel>");
			  p.sendMessage(ChatColor.GREEN +"Use for ID Help /superitem <Armor> or <Sword> or <Axe> or <Shovel> or <Pickaxe> or <Hoe> or <Bow> or <Elytra> or <Rod>");
			  p.sendMessage(ChatColor.BLUE +"Use /superitem lore <your endless Lore> for Lore! Use it After Enchanting!");
			  p.sendMessage(ChatColor.DARK_PURPLE +"Displayname use /superitem <EnchantID> <EnchantLevel> <EndlessDisplayname> for Displayname!" + ChatColor.RED + "Or use /displayname <Endless Displayname> After Enchanting!");
			  p.sendMessage(ChatColor.AQUA + " For individual Armor & Toughness use /atboots+ /atchest+ / atlegs+ /athelm+ <ArmorLVL> <ToughnessLVL>");
			  p.sendMessage(ChatColor.RED + " For individual Attackspeed & Damage use /spdm+ <SpeedLVL> <DamageLVL>");
			  return false;
		  }if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Armor")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++ARMOR IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 0"+ ChatColor.GREEN +" protection  " + ChatColor.BLUE +" <Schutz>");
				  p.sendMessage(ChatColor.AQUA + " ID 1"+ ChatColor.GREEN +" fire_protection  " + ChatColor.BLUE +" <Feuerschutz>");
				  p.sendMessage(ChatColor.AQUA + " ID 2"+ ChatColor.GREEN +" feather_falling  " + ChatColor.BLUE +" <Federfall>");
				  p.sendMessage(ChatColor.AQUA + " ID 3"+ ChatColor.GREEN +" blast_protection  " + ChatColor.BLUE +" <Explosionsschutz>");
				  p.sendMessage(ChatColor.AQUA + " ID 4"+ ChatColor.GREEN +" projectile_protection  " + ChatColor.BLUE +" <Schusssicher>");
				  p.sendMessage(ChatColor.AQUA + " ID 5"+ ChatColor.GREEN +" respiration  " + ChatColor.BLUE +" <Wasser Atmung>");
				  p.sendMessage(ChatColor.AQUA + " ID 6"+ ChatColor.GREEN +" aqua_affinity  " + ChatColor.BLUE +" <Abbaugeschwindigkeit unter Wasser>");
				  p.sendMessage(ChatColor.AQUA + " ID 7"+ ChatColor.GREEN +" thorns  " + ChatColor.BLUE +" <Dornen>");
				  p.sendMessage(ChatColor.AQUA + " ID 8"+ ChatColor.GREEN +" depth_strider  " + ChatColor.BLUE +" <Wasserläufer>");
				  p.sendMessage(ChatColor.AQUA + " ID 9"+ ChatColor.GREEN +" frost_walker  " + ChatColor.BLUE +" <Eisläufer>");
				  p.sendMessage(ChatColor.AQUA + " ID 10"+ ChatColor.GREEN +" binding_curse  " + ChatColor.BLUE +" <Fluch der Bindung>");
				  p.sendMessage(ChatColor.AQUA + " ID 34"+ ChatColor.GREEN +" unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 70"+ ChatColor.GREEN +" mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71"+ ChatColor.GREEN +" vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");				  
				  return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Sword")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++SWORD IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 16"+ ChatColor.GREEN +" sharpness  " + ChatColor.BLUE +" <Schärfe>");
				  p.sendMessage(ChatColor.AQUA + " ID 17 " + ChatColor.GREEN +" smite  " + ChatColor.BLUE +" <Erhöht Schaden gegen Zombies, Schweinezombies, Skelette, Witherskelette und Wither>");
				  p.sendMessage(ChatColor.AQUA + " ID 18 " + ChatColor.GREEN +"  bane_of_arthropods  " + ChatColor.BLUE +" <Erhöht Schaden gegen Spinnen, Höhlenspinnen, Silberfischchen und Endermiten>");
				  p.sendMessage(ChatColor.AQUA + " ID 19 " + ChatColor.GREEN +"  knockback  " + ChatColor.BLUE +" <Wirft Spieler und Kreaturen beim Schlagen ein Stück zurück >");
				  p.sendMessage(ChatColor.AQUA + " ID 20 " + ChatColor.GREEN +"  fire_aspect  " + ChatColor.BLUE +" <Verbrennung>");
				  p.sendMessage(ChatColor.AQUA + " ID 21 " + ChatColor.GREEN +"  looting  " + ChatColor.BLUE +" <Plünderung>");
				  p.sendMessage(ChatColor.AQUA + " ID 22 " + ChatColor.GREEN +"  sweeping  " + ChatColor.BLUE +" <Der Schwungschlag von Schwertern macht mehr Schaden>");
				  p.sendMessage(ChatColor.AQUA + " ID 34 " + ChatColor.GREEN +"  unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Axe")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++AXE IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 16 " + ChatColor.GREEN +"  sharpness  " + ChatColor.BLUE +" <Schärfe>");
				  p.sendMessage(ChatColor.AQUA + " ID 17 " + ChatColor.GREEN +"  smite  " + ChatColor.BLUE +" <Erhöht Schaden gegen Zombies, Schweinezombies, Skelette, Witherskelette und Wither>");
				  p.sendMessage(ChatColor.AQUA + " ID 18 " + ChatColor.GREEN +"  bane_of_arthropods  " + ChatColor.BLUE +" <Erhöht Schaden gegen Spinnen, Höhlenspinnen, Silberfischchen und Endermiten>");
				  p.sendMessage(ChatColor.AQUA + " ID 32 " + ChatColor.GREEN +"  efficiency  " + ChatColor.BLUE +" <Abbaugeschwindigkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 33 " + ChatColor.GREEN +"  silk_touch  " + ChatColor.BLUE +" <Lässt Blöcke sich selbst droppen, auch solche, die sonst einen Gegenstand droppen >");
				  p.sendMessage(ChatColor.AQUA + " ID 34 " + ChatColor.GREEN +"  unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 35 " + ChatColor.GREEN +"  fortune  " + ChatColor.BLUE +" <Erhöht die Anzahl beim Abbau von Blöcken >");
				  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Shovel")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++SHOVEL IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 32 " + ChatColor.GREEN +"  efficiency  " + ChatColor.BLUE +" <Abbaugeschwindigkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 33 " + ChatColor.GREEN +"  silk_touch  " + ChatColor.BLUE +" <Lässt Blöcke sich selbst droppen, auch solche, die sonst einen Gegenstand droppen >");
				  p.sendMessage(ChatColor.AQUA + " ID 34 " + ChatColor.GREEN +"  unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 35 " + ChatColor.GREEN +"  fortune  " + ChatColor.BLUE +" <Erhöht die Anzahl beim Abbau von Blöcken >");
				  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Pickaxe")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++PICKAXE IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 32 " + ChatColor.GREEN +"  efficiency  " + ChatColor.BLUE +" <Abbaugeschwindigkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 33 " + ChatColor.GREEN +"  silk_touch  " + ChatColor.BLUE +" <Lässt Blöcke sich selbst droppen, auch solche, die sonst einen Gegenstand droppen >");
				  p.sendMessage(ChatColor.AQUA + " ID 34 " + ChatColor.GREEN +"  unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 35 " + ChatColor.GREEN +"  fortune  " + ChatColor.BLUE +" <Erhöht die Anzahl beim Abbau von Blöcken >");
				  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Hoe")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++HOE IDS++++++++");
				  p.sendMessage(ChatColor.AQUA + " ID 34 " + ChatColor.GREEN +"  unbreaking  " + ChatColor.BLUE +" <Haltbarkeit>");
				  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
				  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Bow")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++BOW IDS++++++++");
					  p.sendMessage(ChatColor.AQUA + " ID 48 " + ChatColor.GREEN +"  power  " + ChatColor.BLUE +" <Erhöht Schaden gegen Spieler und Kreaturen>");
					  p.sendMessage(ChatColor.AQUA + " ID 49 " + ChatColor.GREEN +"  punch  " + ChatColor.BLUE +" <Wirft Spieler und Kreaturen ein Stück zurück, wenn sie getroffen werden >");
					  p.sendMessage(ChatColor.AQUA + " ID 50 " + ChatColor.GREEN +"  flame  " + ChatColor.BLUE +" <Setzt getroffene Gegner mithilfe von brennenden Pfeilen in Brand >");
					  p.sendMessage(ChatColor.AQUA + " ID 51 " + ChatColor.GREEN +"  infinity  " + ChatColor.BLUE +" <Ermöglicht es mit dem Bogen unendlich Pfeile zu schießen, solange man mindestens einen Pfeil im Inventar hat>");
					  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
					  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Elytra")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++ELYTRA IDS++++++++");
					  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
					  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length == 1) {
			  if (args[0].equalsIgnoreCase("Rod")) {
				  p.sendMessage(ChatColor.GREEN + "+++++++ROD IDS++++++++");
					  p.sendMessage(ChatColor.AQUA + " ID 61 " + ChatColor.GREEN +"  luck_of_the_sea  " + ChatColor.BLUE +" <Verringert die Wahrscheinlichkeit, wertlosen Müll zu angeln>");
					  p.sendMessage(ChatColor.AQUA + " ID 62 " + ChatColor.GREEN +"  lure  " + ChatColor.BLUE +" <Köder erhöht die Anzahl gefangener Fische in gleicher Zeit>");
					  p.sendMessage(ChatColor.AQUA + " ID 70 " + ChatColor.GREEN +"  mending  " + ChatColor.BLUE +" <Reparatur>");
					  p.sendMessage(ChatColor.AQUA + " ID 71 " + ChatColor.GREEN +"  vanishing_curse  " + ChatColor.BLUE +" <Fluch des Verschwindens>");return false;}}
		  if (args.length >= 1) {
			  if (args[0].equalsIgnoreCase("lore")) {
			  StringBuilder str = new StringBuilder();
			    for (int i = 1; i < args.length; i++) {
			      str.append(args[i] + " ");
			    }
			      String lore = str.toString();
			  	 ItemStack Enchant = new ItemStack (p.getInventory().getItemInMainHand());
			  	     ItemMeta EnchantMeta = Enchant.getItemMeta();	        
			  	     	ArrayList<String> lore1 = new ArrayList<String>();	    		     	
			  			lore1.add(lore);			
			  			EnchantMeta.setLore(lore1);	    				   
			  			Enchant.setItemMeta(EnchantMeta);	    				
			  		p.getInventory().setItemInMainHand(Enchant);
			  		p.sendMessage("lore" + " " + args[0]+ " " + "set");
			  		return true;}}
			if (args.length == 2) {	
				int superenchant = Integer.parseInt(args[0]);				  
					  ItemStack item = new ItemStack (p.getInventory().getItemInMainHand());
					  int a = Integer.parseInt(args[1]);
						ItemStack Enchant = new ItemStack (item);
						     ItemMeta EnchantMeta = Enchant.getItemMeta();
						     DAMAGEALL aa1 = new DAMAGEALL(superenchant);					    
						     EnchantMeta.addEnchant(aa1, a, true);
						     	ArrayList<String> lore = new ArrayList<String>();								
								EnchantMeta.setLore(lore);	    				   
								Enchant.setItemMeta(EnchantMeta); 
								ItemStack Enchantnew = new ItemStack (Enchant);
			    		p.getInventory().setItemInMainHand(Enchantnew);			    		
			    		return true;}	    		  
	if (args.length >= 4);{
		StringBuilder str = new StringBuilder();
	    for (int i = 2; i < args.length; i++) {
	      str.append(args[i] + " ");
	    }
	    String dname = str.toString();
			int superenchant = Integer.parseInt(args[0]);
			  if(!(pi.firstEmpty() == -1)) {
				  ItemStack item = new ItemStack (p.getInventory().getItemInMainHand());
				  int a = Integer.parseInt(args[1]);
					ItemStack Enchant = new ItemStack (item);
					     ItemMeta EnchantMeta = Enchant.getItemMeta();
					     DAMAGEALL aa1 = new DAMAGEALL(superenchant);					    
					     EnchantMeta.addEnchant(aa1, a, true);
					     	ArrayList<String> lore = new ArrayList<String>();
							EnchantMeta.setDisplayName(ChatColor.GOLD + dname);
							EnchantMeta.setLore(lore);	    				   
							Enchant.setItemMeta(EnchantMeta); 
							ItemStack Enchantnew = new ItemStack (Enchant);
		    		p.getInventory().setItemInMainHand(Enchantnew);		    		
		    		return true;}
					else p.sendMessage( "not enough free slots");
					return false;}}
	return false;}}	