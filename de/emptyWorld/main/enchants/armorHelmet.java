package de.emptyWorld.main.enchants;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import net.minecraft.server.v1_12_R1.NBTTagByte;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class armorHelmet implements CommandExecutor {	
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
	  
	  
public armorHelmet( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	Player p = (Player)sender;		  	    
	      if (commandLabel.equalsIgnoreCase("armorhead")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	        {
	          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	          return false;
	        }	 StringBuilder str = new StringBuilder();
	   		   for (int i = 0; i < args.length; i++) {
	   		        str.append(args[i] + " ");
	   		  }	if (args.length <= 2) {	
	   		  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.RED + "Use /armorhead <value> <Lore> <Displayname>");
	   		  	return false;}}
	   		  if (args.length == 3);{
	    		     ItemStack item = new ItemStack (p.getInventory().getItemInMainHand());
	    		     ItemMeta itemmeta = item.getItemMeta();
	    		     itemmeta.setDisplayName(ChatColor.GOLD + args[2]);
		    		 itemmeta.setLore(Arrays.asList(ChatColor.BLUE + args[1]));
	    		    		 item.setItemMeta(itemmeta);
	    		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);	    		
				NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();	    		
				NBTTagList modifiers = new NBTTagList();
	    		NBTTagCompound armor = new NBTTagCompound();	    		
	    		int armor1 = Integer.parseInt(args[0]);
	    		armor.set("AttributeName", new NBTTagString("generic.armor"));
	    			armor.set("Name", new NBTTagString("generic.armor"));
	    			armor.set("Amount", new NBTTagInt(armor1));
	    			armor.set("Operation", new NBTTagInt(0));
	    			armor.set("UUIDLeast", new NBTTagInt(894654));
	    			armor.set("UUIDMost", new NBTTagInt(2872));
	    			armor.set("Slot", new NBTTagString("head"));
	    			modifiers.add(armor);
	    			compound.set("AttributeModifiers", modifiers);
	    			nmsStack.setTag(compound);
	    			item = CraftItemStack.asBukkitCopy(nmsStack);
	    			compound.set(ChatColor.GOLD + args[2], new NBTTagByte((byte) 1));
	    			nmsStack.setTag(compound);	    			
	    			 p.getInventory().setItemInMainHand(CraftItemStack.asBukkitCopy(nmsStack));
	    			return true;}}}
	  