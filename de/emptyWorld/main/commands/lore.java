package de.emptyWorld.main.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class lore  implements CommandExecutor {
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  
	
  public lore( leerWelt instance)
  {

    plugin = instance;
  }  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	  Player p = (Player)sender;	    
      if (commandLabel.equalsIgnoreCase("lore")) {
    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
        {	    	        
sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
return false ;}
StringBuilder str = new StringBuilder();
for (int i = 0; i < args.length; i++) {
  str.append(args[i] + " ");
}	if (args.length <= 0) {	
p.sendMessage("Use /lore <Lore>");
return false;}}
if (args.length == 1);{
	StringBuilder str = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
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
		return true;}}}			  