package de.emptyWorld.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.inventivetalent.update.spigot.SpigotUpdater;

public class Updatechecker implements CommandExecutor {	
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
	  String updater = "MultiWorldSystem";
	  
public Updatechecker( leerWelt instance)
{

plugin = instance;
}
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
	Player p = (Player)sender;		  	    
	      if (commandLabel.equalsIgnoreCase("mwsupdate")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsenchant")))
	        {
	          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	          return false;}
	    	int resource = 51764;
	    	try {
	    		new SpigotUpdater(plugin, 51764);
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	sender.sendMessage(updater + "Checking for updates...");
	  	  	try {
	  	              HttpURLConnection con = (HttpURLConnection) new URL(
	  	                      "http://www.spigotmc.org/api/general.php").openConnection();
	  	              con.setDoOutput(true);
	  	              con.setRequestMethod("POST");
	  	              con.getOutputStream()
	  	                      .write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resource)
	  	                              .getBytes("UTF-8"));
	  	              String version = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
	  	              if (!version.equalsIgnoreCase(plugin.getDescription().getVersion())) {
	  	            	sender.sendMessage(updater + "A new update is aviable: version " + version + " " + " You can Download it here:  http://www.spigotmc.org/resources/51764");
	  	              } else {
	  	            	sender.sendMessage(updater + "You're running the newest plugin version!");
	  	              }
	  	          } catch (Exception ex) {
	  	        	sender.sendMessage(updater + "Failed to check for updates on spigotmc.org");
	  	          }
	  	  }
	    	  
		return false;}}