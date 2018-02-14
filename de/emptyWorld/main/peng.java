
package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class peng implements CommandExecutor
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
	
	  leerWelt plugin;   
  public peng( leerWelt instance)
  {

    plugin = instance;
  }
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {
	  Player p = (Player)sender;
	  if (cmd.getName().equalsIgnoreCase("peng"))
  {
    if (!sender.hasPermission((String)this.settings.getpermData().get("mwskill")))
    {
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwskill")) + " " + ((String)this.settings.getsysoData().get("permError")));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
      return false;
    }
    if(args.length == 0){
    	sender.sendMessage(ChatColor.RED + "Too few arguments! make /confusion <value> and or <playername> ");}
    if (args.length == 1)
    {
      Player tot = Bukkit.getPlayer(args[0]);
      if (tot.isOnline())
      {
        tot.setHealth(0.0D);
        tot.sendMessage(ChatColor.GOLD + "OP Kill von" + " " + ChatColor.GOLD + p.getDisplayName() + ChatColor.BLUE + " " + " aus der Ferne");
        p.sendMessage("Du hast " + ChatColor.RED + tot.getDisplayName() + " " + "getötet ");
        sender.sendMessage(ChatColor.GOLD + "Du hast" + " " + tot.getDisplayName() + " " + "getötet ");
        tot.sendMessage(ChatColor.GOLD + "OP Kill from" + " " + ChatColor.GOLD + p.getDisplayName() + " " + ChatColor.BLUE + " from far");
        p.sendMessage("you have " + ChatColor.RED + tot.getDisplayName() + " " + "killed ");
        sender.sendMessage(ChatColor.GOLD + "you has" + " " + tot.getDisplayName() + " " + "killed ");
        return true;
      }}}else {
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwskill")));
     return false;}
	return false;}}