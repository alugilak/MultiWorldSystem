package de.emptyWorld.main.commands;

import java.util.List;

import org.bukkit.Bukkit;
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

public class itemisend implements CommandExecutor
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
 
  
  public itemisend(leerWelt instance)
  {
    plugin = instance;
  }
  


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
{	Player pl = Bukkit.getPlayer(args[0]); 
String name = sender.getName();  
if (!Bukkit.getPlayer(name).hasPermission((String) this.settings.getpermData().get("giveitem"))) {
	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("giveitem")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permissionErrorText")));
      return true;}
	  if (cmd.getName().equalsIgnoreCase("iisend")) {	  
	  if (args.length ==1);{	  	
    ItemStack item = new ItemStack (Bukkit.getPlayer(name).getInventory().getItemInMainHand()); 
		    net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		    NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();	    
		    MaterialData DataMaterial = Bukkit.getPlayer(name).getInventory().getItemInMainHand().getData();{
		int itemTypeId = Bukkit.getPlayer(name).getInventory().getItemInMainHand().getTypeId();
		short itemDur = Bukkit.getPlayer(name).getInventory().getItemInMainHand().getDurability();    
		String dname = Bukkit.getPlayer(name).getInventory().getItemInMainHand().getItemMeta().getDisplayName();		
		List<String> lore = Bukkit.getPlayer(name).getInventory().getItemInMainHand().getItemMeta().getLore();
	pl.sendMessage(ChatColor.GREEN + sender.getName()+ " " + "send you Item infos!" + " " + ChatColor.AQUA + "NAME = " + dname + ChatColor.RED + "<<<>>>"+ ChatColor.AQUA + "LORE = " + ChatColor.YELLOW + lore + ChatColor.RED + "<<<>>>" + ChatColor.BLUE + "Item info: " + ChatColor.GREEN + itemTypeId + ":" + itemDur + ChatColor.RED + "<<<>>>" + ChatColor.AQUA + "Item Material = "+ ChatColor.GOLD + DataMaterial + ChatColor.RED + "<<<>>>" + ChatColor.AQUA + "Enchant Infos = "+ ChatColor.YELLOW + compound );
	    		return true;
		     }}}
	return true;}}
