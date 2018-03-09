package de.emptyWorld.main.books;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class KitBook implements CommandExecutor, Listener {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	  public Inventory servers = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "Server List");
	  
	  public KitBook( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  
	
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		{Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("JoinKit"))
			if (!sender.hasPermission((String) this.settings.getpermData().get("JoinKit")))  
			{
		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsJoinItem")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permissionErrorText")));
		        		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
		        		        return false;}
		        if (args.length == 0)
			      {p.sendMessage(ChatColor.GREEN + "************************" + ChatColor.GOLD + "MWS-JoinKits" + ChatColor.GREEN + "************************");
				  p.sendMessage(ChatColor.AQUA+ "Put all Items for a JoinKit in your Inventory.No other Items!");
				  p.sendMessage(ChatColor.AQUA+ "Now Use /createkit JoinKit to save the JoinKit!");
				  p.sendMessage(ChatColor.AQUA+ "If you want to use a Book in your JoinKit. Put the Created Book in your Inventory bevor");
				  p.sendMessage(ChatColor.AQUA+ "With </JoinKit off> no Player become the JoinKit at Join!");
				  p.sendMessage(ChatColor.AQUA+ "With </JoinKit on> you set give every Player the JoinKit at Join!");
				  p.sendMessage(ChatColor.AQUA+ "With </JoinKit default> you set a JoinKit in the file from this Plugin Author!");
				  p.sendMessage(ChatColor.GREEN +  "************************************************************");
		      } 
	 if (args.length == 1) {
	 if (args[0].equals("on")) {
		 plugin.getConfig().set("JoinKit", true);
	 plugin.saveConfig();
	 plugin.reload();
	 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("mwsJoinItemOn")+ " " + ChatColor.AQUA + this.settings.getkitData().getStringList("Kits").contains("JoinKit")));
	 return true;}
 if (args[0].equals("off")){ 	    			 
	 plugin.getConfig().set("JoinKit", false);
	 plugin.saveConfig();
	 plugin.reload();
	 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("mwsJoinItemOff")));
	 return true;
 }
 if (args[0].equals("default")){ 	    			 
		plugin.saveResource("kits.yml", true);
		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("mwsJoinItemDefault")));
		 return true;
		}
 }
	return false;}
	  


}
	 

			
			
		
		 
		
		 
