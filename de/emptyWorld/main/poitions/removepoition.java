package de.emptyWorld.main.poitions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class removepoition implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  leerWelt plugin;

  
  public removepoition(leerWelt instance)
  {

    plugin = instance;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("poitionremove"))){
	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsPoitions"))) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	        return false;
	      }	   	if (args.length <= 1);	      
	      for (PotionEffect effect : p.getActivePotionEffects())
		        p.removePotionEffect(effect.getType());
      p.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwspoitionremove")));
      return true;}
  if (args.length >= 1);{	  
	  Player player = Bukkit.getPlayer(args[1]);
	  for (PotionEffect effect : player.getActivePotionEffects())
		  player.removePotionEffect(effect.getType());
  p.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwspoitionremove")));
  return true;
    }}}
  
