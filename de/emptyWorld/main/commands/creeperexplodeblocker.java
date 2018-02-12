package de.emptyWorld.main.commands;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class creeperexplodeblocker implements CommandExecutor, Listener
{
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;	 
	
  public creeperexplodeblocker( leerWelt instance)
  {

    plugin = instance;
    
  }  



public creeperexplodeblocker() {

}



public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;  
	    if (cmd.getName().equalsIgnoreCase("creeper"))
	    {
	    	 if (!sender.hasPermission((String) this.settings.getpermData().get("creeper")))    		      
	    		      {
	    		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("creeper")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permissionErrorText")));
	    		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    		        return false;
	    		      }   if (args.length == 1)	
	    	 if (args[0].equals("on"))
	    	 {		    		
	    		 plugin.getConfig().set("creeper", false);
	    		 plugin.saveConfig();
	    		 plugin.reload();
	    		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("creeperFalse")));
	    		 return true;}
	    	 if (args[0].equals("off"))
	    		 if (args.length == 1);{ 	    			 
	    		 plugin.getConfig().set("creeper", true);
	    		 plugin.saveConfig();
	    		 plugin.reload();
	    		 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getsysoData().get("creeperTrue")));
	    		 return true;
	    	 }}
		return false;}}



