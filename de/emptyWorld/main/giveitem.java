package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveitem implements CommandExecutor{

	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	
	
	  leerWelt plugin;   
  public giveitem( leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

if (cmd.getName().equalsIgnoreCase("gi")) { // Give Player Items
    Player player = (Player) sender;

    if (!player.hasPermission((String) this.settings.getpermData().get("giveitem"))) {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("giveitem")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permissionErrorText")));
        return true;
    } else {
        if (args.length == 2 || args.length == 3) {
        if (Bukkit.getServer().getPlayer(args[0]) != null) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (args.length == 3) {
                if (Material.matchMaterial(args[1]) != null) {
                Integer i = Integer.parseInt(args[2]);
                if (i > 64) {
                i = 64;
                }
                if (i < 1) {
                i = 1;
                }
                if (target.getInventory().addItem(new ItemStack(Material.matchMaterial(args[1]), i)) != null) {   
              	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("ItemGiven")));
                    return true;                 
            } else 
            {
                if (target.getInventory().addItem(new ItemStack(Material.matchMaterial(args[1]), 64)) != null) {
                
                } else {
                    
                    return false;               
          
            }}}} else {
          	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("itemAmount")));
                return false;
            }
    } else {
  	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("plOff")));
        }
        player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("noitemName")));
        return false;}}}
return false;}}