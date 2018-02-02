package de.emptyWorld.main;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class homepage implements CommandExecutor {
	public static final String warpsName = null;
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
	  
	
  public homepage( leerWelt instance)
  {

    plugin = instance;
  }  

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender; 
if (cmd.getName().equalsIgnoreCase("discord")) {
		  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsdisc"))) {	   
		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsdisc")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	    p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    return false;} else { 
	    p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("DiscordText")) + ChatColor.GREEN.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("DiscordChanel")));
	    p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	    }}
if (cmd.getName().equalsIgnoreCase("sdiscord")) {
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwssdisc"))) {
      sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
      return true;
    }
    if (args.length == 0) {
      sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
      return true;
    }
    StringBuilder dstr = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      dstr.append(args[i] + " ");
    }
    String disc = dstr.toString();
    this.settings.getsysoData().set("DiscordText", disc);
    this.settings.savesysoData();
    String newdisc = (disc + (String) this.settings.getsysoData().get("DiscordText"));
    disc = disc.replaceAll("&", "§");
    sender.sendMessage(ChatColor.GREEN + "DISCORD set to: "+ newdisc + disc );
    return true;
}
    
  if (cmd.getName().equalsIgnoreCase("homepage")) { 
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwsswww")))
    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwswww")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return false;}else {
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("homepageText")) + ChatColor.GREEN.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("homepageURL")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return true;}}
  
  
  if (cmd.getName().equalsIgnoreCase("shomepage")) {
	    if (!sender.hasPermission((String)this.settings.getpermData().get("mwssdisc"))) {
	      sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	      return true;
	    }
	    if (args.length == 0) {
	      sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
	      return true;
	    }
	    StringBuilder wstr = new StringBuilder();
	    for (int i = 0; i < args.length; i++) {
	      wstr.append(args[i] + "/");
	    }
	    String www = wstr.toString();
	    this.settings.getsysoData().set("homepageText", www);
	    this.settings.savesysoData();
	    String newwww = (www + (String) this.settings.getsysoData().get("homepageText"));
	    www = www.replaceAll("&", "§");
	    sender.sendMessage(ChatColor.GREEN + "HOMEPAGE set to: " + newwww + www  );
	    return true;
}
return false;}}

