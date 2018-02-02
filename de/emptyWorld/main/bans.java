package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class bans implements org.bukkit.command.CommandExecutor, Listener
{	einstellungen settings = einstellungen.getInstance();

FileConfiguration permdata;
FileConfiguration sysodata;
World world;

leerWelt plugin;


public bans( leerWelt instance)
{

plugin = instance;
}  
	  public bans() {}
	  
public static String prefix = "ß7[ß9KickßfSystemß7] ";
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	Player p = (Player)sender;
	 Player target = Bukkit.getServer().getPlayerExact(args[0]);
    if (cmd.getName().equalsIgnoreCase("kick")) {
      if (!sender.hasPermission(((String) this.settings.getpermData().get("mwskickMemb")))) {
        sender.sendMessage(prefix + "ß7Du hast leider keine Rechte.");
      }
      
      if (args.length == 0)
      {
        sender.sendMessage(prefix + "ß7Bitte definiere den Spieler, den du kicken willst.");
      }
      else if (args.length == 1)
      {    	 
    	  target.sendMessage("ß7Du wurdest vonß9" + " " + p.getName() + " " + "wegen Regelverstoﬂ gekickt. ßcGrund: ß7Hacking/Beleidung/Spam/Betrug");
    	  int delay = 4 * 20;
    	    if (delay != 0)     	   
    	  target.kickPlayer("ß7Du wurdest vonß9" + " " + p.getName() +" " + "wegen Regelverstoﬂ gekickt. ßcGrund: ß7Hacking/Beleidung/Spam/Betrug! Bei Widerholung erfolgt Ban!!!");
    	 p.sendMessage(prefix + "ß7Du hast erfolgreich den Spieler ß6" + " " + target.getName() + " " + "ß7gebannt.");         
    	         return true;
      }} 
	return false;  }}
    
   







