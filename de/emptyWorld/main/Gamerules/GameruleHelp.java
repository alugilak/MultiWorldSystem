package de.emptyWorld.main.Gamerules;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class GameruleHelp implements CommandExecutor
{
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
	  ConsoleCommandSender console = Bukkit.getConsoleSender();
	
  public GameruleHelp( leerWelt instance)
  {
	   
    plugin = instance;
  }  
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  Player p = (Player)sender;	  
	  if (!sender.hasPermission((String) this.settings.getpermData().get("GameruleHelp")))    		      
      {
 sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("GameruleHelp")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
    	  if (cmd.getName().equalsIgnoreCase("gamerulehelp")) { 		 
			p.sendMessage(ChatColor.GREEN + "/daa <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether advancements should be announced in chat ");
			p.sendMessage(ChatColor.GREEN + "/dcbo <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether command blocks should notify admins when they perform commands ");
			p.sendMessage(ChatColor.GREEN + "/demc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the server should skip checking player speed when the player is wearing elytra.");
			p.sendMessage(ChatColor.GREEN + "/dft <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() + " Whether the player should take fire damage ");
			p.sendMessage(ChatColor.GREEN + "/dlc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether players should only be able to craft recipes that they've unlocked first ");
			p.sendMessage(ChatColor.GREEN + "/dtd <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether blocks should have drops ");
			p.sendMessage(ChatColor.GREEN + "/dwc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the weather will change ");
			p.sendMessage(ChatColor.GREEN + "/ddc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the day-night cycle and moon phases progress ");
			p.sendMessage(ChatColor.GREEN + "/dml <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether mobs should drop items ");
			p.sendMessage(ChatColor.GREEN + "/dms <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether mobs should naturally spawn. Does not affect monster spawners. ");
			p.sendMessage(ChatColor.GREEN + "/ded <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether entities that are not mobs should have drops ");
			p.sendMessage(ChatColor.GREEN + "More Infos for Gamerules =" + ChatColor.YELLOW.toString() +" https://minecraft.gamepedia.com/Commands/gamerule");
	  return true;}
    	  if (args.length >= 1) {
  			p.sendMessage(ChatColor.GREEN + "/daa <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether advancements should be announced in chat ");
  			p.sendMessage(ChatColor.GREEN + "/dcbo <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether command blocks should notify admins when they perform commands ");
  			p.sendMessage(ChatColor.GREEN + "/demc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the server should skip checking player speed when the player is wearing elytra.");
  			p.sendMessage(ChatColor.GREEN + "/dft <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() + " Whether the player should take fire damage ");
  			p.sendMessage(ChatColor.GREEN + "/dlc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether players should only be able to craft recipes that they've unlocked first ");
  			p.sendMessage(ChatColor.GREEN + "/dtd <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether blocks should have drops ");
  			p.sendMessage(ChatColor.GREEN + "/dwc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the weather will change ");
  			p.sendMessage(ChatColor.GREEN + "/ddc <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether the day-night cycle and moon phases progress ");
  			p.sendMessage(ChatColor.GREEN + "/dml <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether mobs should drop items ");
  			p.sendMessage(ChatColor.GREEN + "/dms <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether mobs should naturally spawn. Does not affect monster spawners. ");
  			p.sendMessage(ChatColor.GREEN + "/ded <worldname> <on> " + ChatColor.AQUA.toString() + " or" + ChatColor.GREEN + " <off>" + ChatColor.AQUA.toString() + " = " + ChatColor.AQUA.toString() +" Whether entities that are not mobs should have drops ");
  			p.sendMessage(ChatColor.GREEN + "More Infos for Gamerules =" + ChatColor.YELLOW.toString() +" https://minecraft.gamepedia.com/Commands/gamerule");
    	  }
		return false;}}
	    		