package de.emptyWorld.main;


import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import de.emptyWorld.main.leerWelt;
public class customcreates implements CommandExecutor
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
World world;
	  
	  public customcreates(leerWelt instance)
	  {

	    plugin = instance;}
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
  {
	  if (cmd.getName().equalsIgnoreCase("mwshelp")) {			
          if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
          	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
              return false;	               
      }sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + "HELP MENU" + ChatColor.YELLOW + "********************");
      sender.sendMessage(ChatColor.LIGHT_PURPLE + "Helpmenus");
      sender.sendMessage(ChatColor.AQUA + " /mwshelp1 - /mwshelp9" + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + " /mwsenchant - /mwsenchant3" + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + " /mwspoition - /mwspoition1" + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.YELLOW + "********************************************************");
      sender.sendMessage(ChatColor.AQUA + "/mwsgroups" + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + " /chatcolor help" + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + "/permsl " + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + "/wlist " + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + "/warplist " + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + "/vipbank " + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.AQUA + "/bankopen " + ChatColor.LIGHT_PURPLE);
      sender.sendMessage(ChatColor.GOLD + "the german help menu is disabled until complete translation" + ChatColor.RED);
      
      sender.sendMessage(ChatColor.YELLOW + "********************************************************");
      return true;}
	  
	  if (cmd.getName().equalsIgnoreCase("mwshelpDe1")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return false;	               
	        }	       
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel")) + ChatColor.YELLOW + "****");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyWwMVH1")));
		        sender.sendMessage(ChatColor.YELLOW + ((String) this.settings.getdeData().get("mwemptyWwMVcmd1")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyWautoCreateMV1")) + ChatColor.WHITE + " " + ((String) this.settings.getdeData().get("mwemptyWautoCreateMV2")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyWautoCreateMV3")) + " " + ChatColor.YELLOW + ((String) this.settings.getdeData().get("mwemptyWautoCreateMVcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyUnlautoCreateMV1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyUnlautoCreateMV2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwemptyUnlautoCreateMVcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyRemautoCreateMV1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyRemautoCreateMV2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwemptyRemautoCreateMVcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyDelautoCreateMV1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwemptyDelautoCreateMV2")) + " " +  ChatColor.YELLOW + ((String) this.settings.getdeData().get("mwemptyDelautoCreateMVcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwfCreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwfCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwfCreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe2")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}	        
		        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel2")) + ChatColor.YELLOW + "****");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwiCreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwiCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwiCreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwnCreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwnCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwnCreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlbCreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlbCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwlbCreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwv1CreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwv1CreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwv1CreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwskyCreateH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwskyCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwskyCreateHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe3")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel3")) + ChatColor.YELLOW + "****");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwloadWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwloadWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwloadWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwunloadWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwunloadWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwunloadWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdeleteWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdeleteWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwdeleteWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwrenameWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwrenameWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwrenameWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwstatsWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwstatsWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwstatsWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe4")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel4")) + ChatColor.YELLOW + "********************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlistWorldH1")));
			    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlistWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwlistWorldHcmd")));
			    sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
			    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlistWorldaH1")));
			    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwlistWorldaH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwlistWorldaHcmd")));
			    sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetSpawnH1")));
			    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetSpawnH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetSpawnHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetHubH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetHubH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetHubHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoHubH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoHubH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwgoHubHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetHomeH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetHomeHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoHomeH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwgoHomeHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdelHomeH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdelHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwdelHomeHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");               
	            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoSpawnH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoSpawnH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwgoSpawnHcmd")));
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe5")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel5")) + ChatColor.YELLOW + "********************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetWarpH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetWarpHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoWarpH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgoWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwgoWarpHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdelWarpH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdelWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwdelWarpHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtptoplH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtptoplH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwtptoplHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtppltomeH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtppltomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwtppltomeHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwskickH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwskickH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwskickHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe6")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel6")) + ChatColor.YELLOW + "********************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtpworldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtpworldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwtpworldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtpxyzH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwtpxyzH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwtpxyzHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwflyH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwflyH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwflyHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwflyspeedH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwflyspeedH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwflyspeedHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwalkspeedH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwalkspeedH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwwalkspeedHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsdayH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsdayH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsdayHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsnightH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsnightH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsnightHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgiveH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwgiveH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwgiveHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwcH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwcH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwwcHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwrainH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwrainH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwrainHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe7")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel7")) + ChatColor.YELLOW + "********************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwstormH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwstormH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwstormHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetgmH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetgmH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetgmHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsdiscordH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsdiscordH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsdiscordHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdiscordH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwdiscordH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwdiscordHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwswwwH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwswwwH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwswwwHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwwwH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwwwwH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwwwwHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwschatcolorH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwschatcolorH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwschatcolorHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsrepairH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsrepairH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsrepairHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");

		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe8")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel8")) + ChatColor.YELLOW + "********************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdHeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdHeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdHeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetsysMotdHeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetsysMotdHeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetsysMotdHeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");		        
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl1HeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl1HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdl1HeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl2HeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl2HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdl2HeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl3HeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl3HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdl3HeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl4HeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl4HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdl4HeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl5HeadH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsetMotdl5HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsetMotdl5HeadHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		          return true;
		  }
		        if (cmd.getName().equalsIgnoreCase("mwshelpDe9")) {			
		            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
		            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
		                return true;}
		        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getdeData().get("helpmenuTitel9")) + ChatColor.YELLOW + "********************");		            
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsPlayerWorldH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsPlayerWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsPlayerWorldHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsplworldaddMembH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsplworldaddMembH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsplworldaddMembHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsplworlddelMembH1")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsplworlddelMembH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsplworlddelMembHcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsCommandSignH1")) + " " + ((String) this.settings.getdeData().get("mwsCommandSignH2")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("mwsCommandSignH3")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("mwsCommandSignH4")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("ItemBank1")) + " " + ((String) this.settings.getdeData().get("mwsCommandSignH2")));
		        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getdeData().get("ItemBank2")) + ChatColor.YELLOW + " " + ((String) this.settings.getdeData().get("ItemBankcmd")));
		        sender.sendMessage(ChatColor.YELLOW + "********************************************************");		        
		        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
		        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
		        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		        return true;
	    }
	        if (cmd.getName().equalsIgnoreCase("mwshelp1")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;	               
	        }
	        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyWwMVH1")));
	        sender.sendMessage(ChatColor.YELLOW + ((String) this.settings.getenData().get("mwemptyWwMVcmd1")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyWautoCreateMV1")) + ChatColor.WHITE + " " + ((String) this.settings.getenData().get("mwemptyWautoCreateMV2")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyWautoCreateMV3")) + " " + ChatColor.YELLOW + ((String) this.settings.getenData().get("mwemptyWautoCreateMVcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyUnlautoCreateMV1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyUnlautoCreateMV2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwemptyUnlautoCreateMVcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyRemautoCreateMV1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyRemautoCreateMV2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwemptyRemautoCreateMVcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyDelautoCreateMV1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwemptyDelautoCreateMV2")) + " " +  ChatColor.YELLOW + ((String) this.settings.getenData().get("mwemptyDelautoCreateMVcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwfCreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwfCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwfCreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp2")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}	        
	        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel2")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwiCreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwiCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwiCreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwnCreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwnCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwnCreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlbCreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlbCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwlbCreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwv1CreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwv1CreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwv1CreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskyCreateH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskyCreateH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwskyCreateHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp3")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel3")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwloadWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwloadWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwloadWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwunloadWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwunloadWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwunloadWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdeleteWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdeleteWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwdeleteWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwrenameWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwrenameWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwrenameWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwstatsWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwstatsWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwstatsWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp4")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel4")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlistWorldH1")));
		    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlistWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwlistWorldHcmd")));
		    sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
		    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlistWorldaH1")));
		    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwlistWorldaH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwlistWorldaHcmd")));
		    sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetSpawnH1")));
		    sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetSpawnH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetSpawnHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetHubH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetHubH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetHubHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoHubH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoHubH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwgoHubHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetHomeH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetHomeHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoHomeH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwgoHomeHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdelHomeH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdelHomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwdelHomeHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");               
            sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoSpawnH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoSpawnH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwgoSpawnHcmd")));
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp5")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        
	        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel5")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetWarpH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetWarpHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoWarpH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgoWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwgoWarpHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdelWarpH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdelWarpH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwdelWarpHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtptoplH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtptoplH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwtptoplHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtppltomeH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtppltomeH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwtppltomeHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskickH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskickH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwskickHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ItemBank1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ItemBank2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ItemBankcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");	
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp6")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel6")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtpworldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtpworldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwtpworldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtpxyzH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwtpxyzH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwtpxyzHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwflyH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwflyH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwflyHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwflyspeedH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwflyspeedH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwflyspeedHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwalkspeedH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwalkspeed21")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwwalkspeedHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsdayH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsdayH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsdayHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsnightH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsnightH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsnightHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgiveH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwgiveH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwgiveHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwcH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwcH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwwcHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwrainH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwrainH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwrainHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp7")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel7")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwstormH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwstormH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwstormHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetgmH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetgmH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetgmHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsdiscordH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsdiscordH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsdiscordHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdiscordH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwdiscordH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwdiscordHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwswwwH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwswwwH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwswwwHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwwwH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwwwwH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwwwwHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwschatcolorH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwschatcolorH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwschatcolorHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsrepairH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsrepairH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsrepairHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsback1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsback2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsbackcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");

	        return true;
	  }
	        if (cmd.getName().equalsIgnoreCase("mwshelp8")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	        sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel8")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdHeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdHeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdHeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetsysMotdHeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetsysMotdHeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetsysMotdHeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");	        
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl1HeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl1HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdl1HeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl2HeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl2HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdl2HeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl3HeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl3HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdl3HeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl4HeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl4HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdl4HeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl5HeadH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsetMotdl5HeadH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsetMotdl5HeadHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	          return true;
	  }}
	        if (cmd.getName().equalsIgnoreCase("mwshelp9")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	            sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel9")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsPlayerWorldH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsPlayerWorldH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsPlayerWorldHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsplworldaddMembH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsplworldaddMembH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsplworldaddMembHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsplworlddelMembH1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsplworlddelMembH2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsplworlddelMembHcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsCommandSignH1")) + " " + ((String) this.settings.getenData().get("mwsCommandSignH2")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsCommandSignH3")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsCommandSignH4")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskillallmobs1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwskillallmobs2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwskillallmobscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        return true;
	    }
	        if (cmd.getName().equalsIgnoreCase("mwshelp10")) {			
	            if (!sender.hasPermission((String) this.settings.getpermData().get("mwshelp"))) {
	            	sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshelp")) + " " + ChatColor.GREEN + ((String) this.settings.getsysoData().get("permError")));
	                return true;}
	            sender.sendMessage(ChatColor.YELLOW + "*********************" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuTitel10")) + ChatColor.YELLOW + "********************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwssavepos1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwssavepos2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwssaveposcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsloadpos1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsloadpos2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsloadposcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        return true;
	    }
	        if (cmd.getName().equalsIgnoreCase("mwsenchant")) {	
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuEnchantTitel")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_DAMAGE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_DAMAGE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ARROW_DAMAGEcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_FIRE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_FIRE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ARROW_FIREcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_INFINITE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_INFINITE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ARROW_INFINITEcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_KNOCKBACK1")) + " " + ((String) this.settings.getenData().get("mwsCommandSignH2")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ARROW_KNOCKBACK2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ARROW_KNOCKBACKcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FIRE_ASPECT1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FIRE_ASPECT2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("FIRE_ASPECTcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_ALL1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_ALL2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DAMAGE_ALLcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "/mwsenchant1 for more Help");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");}
	        if (cmd.getName().equalsIgnoreCase("mwsenchant1")) {
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuEnchantTitel1")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_DAMAGE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_DAMAGE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ATTACK_DAMAGEcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_DAMAGE_Speed1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_DAMAGE_Speed2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ATTACK_DAMAGE_Speedcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_SPEED1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ATTACK_SPEED2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ATTACK_SPEEDcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("bootsArmorToughness1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("bootsArmorToughness2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("bootsArmorToughnesscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("cheastArmorToughness1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("cheastArmorToughness2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("cheastArmorToughnesscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("helmetArmorToughness1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("helmetArmorToughness2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("helmetArmorToughnesscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("legArmorToughness1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("legArmorToughness2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("legArmorToughnesscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("Armor1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("Armor2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("Armorcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("Toughness1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("Toughness2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("Toughnesscmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin! (look at Help for /mwsPoition");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");}
	        if (cmd.getName().equalsIgnoreCase("mwsenchant2")) {
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuEnchantTitel2")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_ARTHROPODS1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_ARTHROPODS2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DAMAGE_ARTHROPODScmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_UNDEAD1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_UNDEAD2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DAMAGE_UNDEADcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DIG_SPEED1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DIG_SPEED2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DIG_SPEEDcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DURABILITY1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DURABILITY2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DURABILITYcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("KNOCKBACK1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("KNOCKBACK2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("KNOCKBACKcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LOOT_BONUS_BLOCKS1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LOOT_BONUS_BLOCKS2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("LOOT_BONUS_BLOCKScmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LOOT_BONUS_MOBS1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LOOT_BONUS_MOBS2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("LOOT_BONUS_MOBScmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LUCK1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LUCK2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("LUCKcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin! (look at Help for /mwsPoition");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");}
	        if (cmd.getName().equalsIgnoreCase("mwsenchant3")) {
	        sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuEnchantTitel3")) + ChatColor.YELLOW + "****");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LURE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("LURE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("LUREcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("MENDING1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("MENDING2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("MENDINGcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("OXYGEN1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("OXYGEN2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("OXYGENcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("WATER_WORKER1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("WATER_WORKER2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("WATER_WORKERcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin! (look at Help for /mwsPoition");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");}  
	        if (cmd.getName().equalsIgnoreCase("mwspoition")) {	
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuPoitionTitel")) + ChatColor.YELLOW + "****");	            
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_RESISTANCE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("DAMAGE_RESISTANCE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("DAMAGE_RESISTANCEcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FAST_DIGGING1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FAST_DIGGING2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("FAST_DIGGINGcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("NIGHT_VISION1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("NIGHT_VISION2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("NIGHT_VISIONcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FIRE_RESISTANCE1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("FIRE_RESISTANCE2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("FIRE_RESISTANCEcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("CONFUSION1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("CONFUSION2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("CONFUSIONcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ABSORPTION1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("ABSORPTION2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("ABSORPTIONcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("GLOWING1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("GLOWING2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("GLOWINGcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("REMOVE_POITION1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("REMOVE_POITION2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("REMOVE_POITIONcmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        return true;}
	        if (cmd.getName().equalsIgnoreCase("mwspoition1")) {	
	            sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuPoitionTitel1")) + ChatColor.YELLOW + "****");	            
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsbreathpoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsbreathpoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsbreathpoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsspeedpoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsspeedpoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsspeedpoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsregenerationpoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsregenerationpoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsregenerationpoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwslevitationpoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwslevitationpoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwslevitationpoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsjumppoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsjumppoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsjumppoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsinvisiblepoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwsinvisiblepoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwsinvisiblepoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspoisonpoition1")));
	        sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspoisonpoition2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwspoisonpoitioncmd")));
	        sender.sendMessage(ChatColor.YELLOW + "********************************************************");
	        sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
	        sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
	        sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
	        return true;}
  if (cmd.getName().equalsIgnoreCase("mwsgroups")) {	
      sender.sendMessage(ChatColor.YELLOW + "****" + ChatColor.DARK_RED + ((String) this.settings.getenData().get("helpmenuGroupsTitel")) + ChatColor.YELLOW + "****");	            
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addPermissionPlayer1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addPermissionPlayer2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("addPermissionPlayercmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("removePermissionPlayer1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("removePermissionPlayer2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("removePermissionPlayercmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addPermissionPlayerWorld1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addPermissionPlayerWorld2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("addPermissionPlayerWorldcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("removePermissionPlayerWorld1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("removePermissionPlayerWorld2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("removePermissionPlayerWorldcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addGroup1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("addGroup2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("addGroupcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("deleteGroup1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("deleteGroup2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("deleteGroupcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("setdefaultGroup1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("setdefaultGroup2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("setdefaultGroupcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("setdefaultGroupWorld1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("setdefaultGroupWorld2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("setdefaultGroupWorldcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");  
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermaddgroup1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermaddgroup2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwspermaddgroupcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermdelgroup1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermdelgroup2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwspermdelgroupcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermaddgroupw1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermaddgroupw2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwspermaddgroupwcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermdelgroupw1")));
  sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getenData().get("mwspermdelgroupw2")) + ChatColor.YELLOW + " " + ((String) this.settings.getenData().get("mwspermdelgroupwcmd")));
  sender.sendMessage(ChatColor.YELLOW + "********************************************************");
  sender.sendMessage(ChatColor.GREEN + "I hope you have fun with this Plugin!");
  sender.sendMessage(ChatColor.GREEN + "Please inform me" + ChatColor.YELLOW + " " + "if you found a bug" + " " + "https://www.spigotmc.org/threads/multiworldsystem-spigot-1-8.297346/");
  sender.sendMessage(ChatColor.YELLOW + "*********************************************************");
  return true;}
return false;}}
