package de.emptyWorld.main.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class iteminfo implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  
  leerWelt plugin;
 
  
  public iteminfo(leerWelt instance)
  {
    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {	Player p = (Player) sender; 
  if (!sender.hasPermission((String) this.settings.getpermData().get("giveitem"))) {
  	  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("giveitem")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permissionErrorText")));
        return false;}
	  if (cmd.getName().equalsIgnoreCase("iteminfo")) {
	  if (args.length == 0);{		  	
      ItemStack item = new ItemStack (p.getInventory().getItemInMainHand()); 
		    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();	    
		    MaterialData DataMaterial = p.getInventory().getItemInMainHand().getData();{
		int itemTypeId = p.getInventory().getItemInMainHand().getTypeId();
		short itemDur = p.getInventory().getItemInMainHand().getDurability();    
		String dname = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		List<String> lore = p.getInventory().getItemInMainHand().getItemMeta().getLore();
		 		p.sendMessage(ChatColor.AQUA + "NAME = " + dname + ChatColor.RED + "<<<>>>"+ ChatColor.AQUA + "LORE = " + ChatColor.YELLOW + lore + ChatColor.RED + "<<<>>>" + ChatColor.BLUE + "Item info: " + ChatColor.GREEN + itemTypeId + ":" + itemDur + ChatColor.RED + "<<<>>>" + ChatColor.AQUA + "Item Material = "+ ChatColor.GOLD + DataMaterial + ChatColor.RED + "<<<>>>" + ChatColor.AQUA + "Enchant Infos = "+ ChatColor.YELLOW + compound );
	    		return false;
		     }}}else{return true; }}}

	
	  	    	  
		    
	