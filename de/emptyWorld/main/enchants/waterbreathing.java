package de.emptyWorld.main.enchants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class waterbreathing implements CommandExecutor
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
  public waterbreathing( leerWelt instance)
  {

    plugin = instance;
  }
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)  {Player p = (Player)sender;
  if ((cmd.getName().equalsIgnoreCase("breath"))){
	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwsPoitions"))) {		
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	        return false;
	      } if(args.length == 0){
              sender.sendMessage(ChatColor.RED + "Too few arguments! make /speed <value> and or <playername> ");}else if(args.length < 2){      
	      int nv = Integer.parseInt(args[0]);
      PotionEffect effect = new PotionEffect(org.bukkit.potion.PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, nv, true, false);
      ((Player)sender).addPotionEffect(effect);
      p.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwsnightwatch")));
      }else{   if (args.length < 3);{
	  int nv = Integer.parseInt(args[0]);
	  Player player = Bukkit.getPlayer(args[1]);
  PotionEffect effect1 = new PotionEffect(org.bukkit.potion.PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, nv, true, false);
  player.addPotionEffect(effect1);
  p.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwsnightwatch")));
  }  {
  return false;
    }}}
return false;}}
  

