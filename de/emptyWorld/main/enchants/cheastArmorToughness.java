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

public class cheastArmorToughness implements CommandExecutor {	
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
	  
	  
public cheastArmorToughness( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	Player p = (Player)sender;		  	    
	      if (commandLabel.equalsIgnoreCase("atchest+")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	        {
	          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	          return false;
	        }
	    	  if (args.length <= 1);{
		  		
	    		     ItemStack item = new ItemStack (p.getInventory().getItemInMainHand());
	    		     ItemMeta itemmeta = item.getItemMeta();
	    		    		 itemmeta.setDisplayName(ChatColor.GOLD + (String)this.settings.getpData().get("ARMOR_TOUGHNESS_DisplayName_MYTHIC"));
	    		    		 itemmeta.setLore(Arrays.asList(((String)this.settings.getpData().get("ARMOR_TOUGHNESS_LORE"))));
	    		    		 item.setItemMeta(itemmeta);
	    		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);	    		
				NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();	    		
				NBTTagList modifiers = new NBTTagList();
	    		NBTTagCompound toughness = new NBTTagCompound();
	    		NBTTagCompound armor = new NBTTagCompound();	 
	    		int toughness1 = Integer.parseInt(args[0]);
	    		int armor1 = Integer.parseInt(args[1]);
	    		armor.set("AttributeName", new NBTTagString("generic.armor"));
	    		toughness.set("AttributeName", new NBTTagString("generic.armorToughness"));
	    		armor.set("Name", new NBTTagString("generic.armor"));
    			armor.set("Amount", new NBTTagInt(armor1));
    			armor.set("Operation", new NBTTagInt(0));
    			armor.set("UUIDLeast", new NBTTagInt(89452654));
    			armor.set("UUIDMost", new NBTTagInt(28453672));
    			armor.set("Slot", new NBTTagString("chest"));
	    			toughness.set("Name", new NBTTagString("generic.armorToughness"));
	    			toughness.set("Amount", new NBTTagInt(toughness1));
	    			toughness.set("Operation", new NBTTagInt(0));
	    			toughness.set("UUIDLeast", new NBTTagInt(87694655));
	    			toughness.set("UUIDMost", new NBTTagInt(2874673));
	    			toughness.set("Slot", new NBTTagString("chest"));
	    			modifiers.add(armor);
	    			modifiers.add(toughness);
	    			compound.set("AttributeModifiers", modifiers);
	    			nmsStack.setTag(compound);
	    			item = CraftItemStack.asBukkitCopy(nmsStack);
	    			compound.set(((String)this.settings.getpData().get("ARMOR_TOUGHNESS_MYTHIC")), new NBTTagByte((byte) 1));
	    			nmsStack.setTag(compound);	    			
	    			 p.getInventory().setItemInMainHand(CraftItemStack.asBukkitCopy(nmsStack));
	    			return true;}}else {return true;}}}
	  