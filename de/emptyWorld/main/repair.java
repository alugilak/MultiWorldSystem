package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class repair implements CommandExecutor
{   	einstellungen settings = einstellungen.getInstance();
	FileConfiguration pdata;
	FileConfiguration permdata;
	FileConfiguration sysodata;
	leerWelt plugin;
	public repair(leerWelt instance)
  {

    plugin = instance;
  }
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		  Player player = (Player)sender;
		  ItemStack inhand = player.getInventory().getItemInMainHand();
	    if (player.hasPermission((String)this.settings.getpermData().get("mwsrepair"))) {
	      if (commandLabel.equalsIgnoreCase("repair")) {
	        if (args.length == 0) {
	          ((ItemStack) inhand).setDurability((short)0);
	          return true;
	        }
	        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("repairError1")));
	      }
	      

	      if (commandLabel.equalsIgnoreCase("mwsrepair")) {
	        if (args.length == 0) {
	         
	            ((ItemStack) inhand).setDurability((short)0);	           
	            player.sendMessage(ChatColor.YELLOW + ((String)this.settings.getsysoData().get("mwsrepairon")));
	            return true;
	          }	       
	          player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("mwsrepairoff")));
	          return true;
	        }
	        
	        player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("repairError1")));
	        return true;
	      }
	    {
	    
	      player.sendMessage(ChatColor.RED + ((String)this.settings.getsysoData().get("permError")));	   
	    return false;}
	  }
	  
	  @org.bukkit.event.EventHandler
	  public void onMine(PlayerInteractEvent event) {
	    Player p = event.getPlayer();
	    ItemStack is =  p.getInventory().getItemInMainHand();
	    if ((is != null) && 
	      (event.getAction() == org.bukkit.event.block.Action.LEFT_CLICK_BLOCK) && 	     
	      (is.getDurability() != 0)) {
	      is.setDurability((short)0);
	    }
	  }
	}

