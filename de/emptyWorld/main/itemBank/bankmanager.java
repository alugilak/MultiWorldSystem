package de.emptyWorld.main.itemBank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.loadworld;

public class bankmanager implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	  loadworld loader;
		loadworld worldLoader;
	  leerWelt plugin;   
  public bankmanager( leerWelt instance)
  {

    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {Player p = (Player)sender;
  if (cmd.getName().equalsIgnoreCase("mwsbanking")) 
  { if ((sender instanceof Player))  {    	    
      if (!sender.hasPermission(this.settings.getpermData().getString("mwsadminbanking")))
      {
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwsadminbanking")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }}if (args.length ==0) {        		
      	p.sendMessage(ChatColor.GREEN +  "*****************" + ChatColor.GOLD + "MWS-ITEM-BANK-ADMINMENU-" + ChatColor.GREEN + "*******************");
		  p.sendMessage(ChatColor.AQUA+ "Set Slot for every Players Item Bank!");
		  p.sendMessage(ChatColor.GREEN +  "************************************************************");
		  p.sendMessage(ChatColor.AQUA+ "For Player Item Bank use " + ChatColor.DARK_PURPLE + " /mwsbanking pb <PlayerName> <SlotAmount> !");
		  p.sendMessage(ChatColor.AQUA+ "************************************************************");
		  p.sendMessage(ChatColor.AQUA+ "For Enchant Player Item Bank use " + ChatColor.DARK_PURPLE + " /mwsbanking eb <PlayerName> <SlotAmount> ");  		 
		  p.sendMessage(ChatColor.GREEN +  "************************************************************");
		  p.sendMessage(ChatColor.AQUA+ "For VIP Player Item Bank use " + ChatColor.DARK_PURPLE + " /mwsbanking vb <PlayerName> <SlotAmount> ");  		 
		  p.sendMessage(ChatColor.GREEN +  "************************************************************");
		  p.sendMessage(ChatColor.AQUA+ "Permissions Playerbank: " + ChatColor.DARK_PURPLE + this.settings.getpermData().getString("mwsbanking"));
		  p.sendMessage(ChatColor.AQUA+ "Permissions Playerbank 2: " + ChatColor.DARK_PURPLE + this.settings.getpermData().getString("mwsbanking2"));
	   	p.sendMessage(ChatColor.AQUA+ "Permissions VIP-Playerbank: " + ChatColor.DARK_PURPLE + this.settings.getpermData().getString("mwsvipbanking")); 
	    p.sendMessage(ChatColor.AQUA+ "Permissions Bankadmin: " + ChatColor.DARK_PURPLE + this.settings.getpermData().getString("mwsadminbanking")); 
		  p.sendMessage(ChatColor.GREEN +  "************************************************************");
		  return true;}  else {         	       
      	if (args.length >=2) 
      		if (args[0].equalsIgnoreCase("pb")) {
            	int Slots = Integer.parseInt(args[2]); 
            	Player target = Bukkit.getServer().getPlayer(args[1]);
            	plugin.getConfig().set(target.getPlayer().getName() + ".Pslots", Slots);                               
            	plugin.saveConfig();
            	plugin.reloadConfig();
            		p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + this.settings.getsysoData().getString("SystemName") + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.GREEN + target.getPlayer().getName() + " " + ChatColor.BLUE + this.settings.getsysoData().getString("mwsbankingSlotset")  + " " + Slots);
		    		
   return true;}else {  
              if (args.length >=2) 
          		if (args[0].equalsIgnoreCase("vb")) {
                	int VSlots = Integer.parseInt(args[2]); 
                	Player Vtarget = Bukkit.getServer().getPlayer(args[1]);
                	plugin.getConfig().set(Vtarget.getPlayer().getName() + ".Vslots", VSlots);                               
                	plugin.saveConfig();
                	plugin.reloadConfig();                	
                	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >"  + ChatColor.GREEN + Vtarget.getPlayer().getName() + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("mwsVipBankingSlotset"))   + " " + VSlots);
     return true; }else {  
         if (args.length >=2) 
     		if (args[0].equalsIgnoreCase("eb")) {
           	int P2Slots = Integer.parseInt(args[2]); 
           	Player P2 = Bukkit.getServer().getPlayer(args[1]);
           	plugin.getConfig().set(P2.getPlayer().getName() + ".P2slots", P2Slots);                               
           	plugin.saveConfig();
           	plugin.reloadConfig();                	
           	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >"  + ChatColor.GREEN + P2.getPlayer().getName() + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("mwsEnchantbankingSlotset"))   + " " + P2Slots);
return true; }
}
	}}

}
return false;}}