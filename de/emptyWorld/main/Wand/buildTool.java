package de.emptyWorld.main.Wand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class buildTool implements CommandExecutor{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public buildTool ( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    Player p = (Player)sender;
		    Inventory pi = p.getInventory();
		    if (cmd.getName().equalsIgnoreCase("buildTool"))
		    {
		      if (!sender.hasPermission((String) this.settings.getpermData().get("buildTool"))){
		    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouse2")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
		        return false;}
		      if (args.length == 0) {
		      String idt = this.settings.getmobData().getString("BuildToolName");
		      Material material = Material.matchMaterial(idt);
		      ItemStack Item = new ItemStack (material);
	    			if(!(pi.firstEmpty() == -1)) {
	    				pi.addItem(Item); }else p.sendMessage( "not enough free slots");}	  				
		      if (args.length >= 1) {
		    	  String idt = this.settings.getmobData().getString("BuildToolName");
			      Material material = Material.matchMaterial(idt);		     
		    	ItemStack Item1 = new ItemStack (material);
		    	Player target = Bukkit.getServer().getPlayer(args[0]);
		    	Inventory targeti = target.getInventory();	    	
		    	if(!(pi.firstEmpty() == -1)) {
		    		targeti.addItem(Item1); }else target.sendMessage( "not enough free slots");}}
			return false;}}
			
