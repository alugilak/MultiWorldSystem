package de.emptyWorld.main.enchants;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class durability implements CommandExecutor {
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  FileConfiguration blockdata;
	  
	  
	  leerWelt plugin;  
	  
	  
public durability( leerWelt instance)
{

plugin = instance;
}
@Override
public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
	  Player p = (Player)sender;	    
	  if (cmd.getName().equalsIgnoreCase("durability")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	        {
	          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	          return false ;}
	    	  StringBuilder str = new StringBuilder();
 	          for (int i = 0; i < args.length; i++) {
	    	        str.append(args[i] + " ");
 	      }	if (args.length <= 2) {	
 	    	 p.sendMessage("Use /durability <value> <Lore> <Displayname>");
 	    		return false;}}
	         if (args.length == 3);{
		    		 ItemStack Enchant = new ItemStack (p.getInventory().getItemInMainHand());
		    		     ItemMeta EnchantMeta = Enchant.getItemMeta();	 
		    		     int n = Integer.parseInt(args[0]);	
		    		     EnchantMeta.addEnchant(Enchantment.DURABILITY, n, true);
		    		     String loreargs = args[1];
		    		     String dname = args[2];
		    		     	ArrayList<String> lore = new ArrayList<String>();	    		     	
		    				lore.add(loreargs);
		    				EnchantMeta.setDisplayName(ChatColor.GOLD + dname);
		    				EnchantMeta.setLore(lore);	    				   
		    				Enchant.setItemMeta(EnchantMeta);	    				
		    			p.getInventory().setItemInMainHand(Enchant);
		    			ItemStack Item = new ItemStack (p.getInventory().getItemInMainHand());
		    			this.settings.getblockData().set("Item." + dname + ".ID", Item);
		    			this.settings.saveblockData();
		    			p.sendMessage("top");
		    			return true;}}}
	    	  

		
		
