package de.emptyWorld.main.commands;

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

public class lvl implements CommandExecutor {	
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
	  
	  
public lvl( leerWelt instance)
{

plugin = instance;
}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { 
		  Player p = (Player)sender;	    
	      if (commandLabel.equalsIgnoreCase("lvl")) {
	    	  if (!sender.hasPermission((String)this.settings.getpermData().get("mwslvl")))
	        {
	    		  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsenchant")) + " " + ((String)this.settings.getsysoData().get("permError")));
	    		  p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 50);
	    		  return false ;}
                                if(args.length == 0)
                                {
                                        p.sendMessage(ChatColor.RED+ "/lvl" + ChatColor.RED+ " <+|-|set> " + ChatColor.RED+ "<player> <amount>");
                                        
                                }
                               
                                if(args.length == 1)
                                {
                                        if(args[0].equalsIgnoreCase("+"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {
                                                        p.sendMessage(ChatColor.RED+ "/lvl <+|-|set> " + ChatColor.RED+ "<player> <amount>");
                                                        
                                                }
                                        }
                                }
                               
                                if(args.length == 2)
                                {
                                        if(args[0].equalsIgnoreCase("+"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                p.sendMessage(ChatColor.RED+ "/lvl <+|-|set> <player> " + ChatColor.RED+ " <#>");
                                                                
                                                        }
                                                }
                                        }
                                }
                               
                                if(args.length == 3)
                                {
                                        if(args[0].equalsIgnoreCase("+"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {                                                      
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                int i = Integer.valueOf((args[2]));
                                                                target.setLevel(target.getLevel() +i);
                                                                target.sendMessage(ChatColor.RED+ "Your level has been set to " + ChatColor.RED+ "+" + i);
                                                                p.sendMessage(ChatColor.RED+ "You set " + ChatColor.RED+ target.getDisplayName() + ChatColor.RED+ " level to " + ChatColor.RED+ "+" + i);
                                                        }
                                                }
                                        }
                                }
                               
                                if(args.length == 1)
                                {
                                        if(args[0].equalsIgnoreCase("set"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {
                                                        p.sendMessage(ChatColor.RED+ "/lvl <+|-|set> " + ChatColor.RED+ "<player> <amount>");
                                                        
                                                }
                                        }
                                }
                               
                                if(args.length == 2)
                                {
                                        if(args[0].equalsIgnoreCase("set"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                p.sendMessage(ChatColor.RED+ "/lvl <+|-|set> <player> " + ChatColor.RED+ " <#>");
                                                                
                                                        }
                                                }
                                        }
                                }
                               
                                if(args.length == 3)
                                {
                                        if(args[0].equalsIgnoreCase("set"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {                                                      
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                int i = Integer.valueOf((args[2]));
                                                                target.setLevel(i);
                                                                target.sendMessage(ChatColor.RED+ "Your level has been set to " + ChatColor.RED+ i);
                                                                p.sendMessage(ChatColor.RED+ "You set " + ChatColor.RED+ target.getDisplayName() + ChatColor.RED+ " level to " + ChatColor.RED+ i);
                                                        }
                                                }
                                        }
                                }
                               
                                if(args.length == 1)
                                {
                                        if(args[0].equalsIgnoreCase("-"))
                                        {
                                                if(p.hasPermission("-"))
                                                {
                                                        p.sendMessage(ChatColor.RED+ "/lvl <+|-|set> " + ChatColor.RED + "<player> <amount>");
                                                        
                                                }
                                        }
                                }
                               
                                if(args.length == 2)
                                {
                                        if(args[0].equalsIgnoreCase("-"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                p.sendMessage(ChatColor.RED + "/lvl <+|-|set> <player> " + ChatColor.RED+ " <#>");
                                                                
                                                        }
                                                }
                                        }
                                }
                               
                                if(args.length == 3)
                                {
                                        if(args[0].equalsIgnoreCase("-"))
                                        {
                                                if(p.hasPermission((String)this.settings.getpermData().get("mwslvl")))
                                                {                                                      
                                                        Player target = Bukkit.getServer().getPlayer(args[1]);
                                                        if(target != null)
                                                        {
                                                                int i = Integer.valueOf((args[2]));
                                                                target.setLevel(target.getLevel() -i);
                                                                target.sendMessage(ChatColor.RED+ "Your level has been set to " + ChatColor.RED+ "-" + i);
                                                                p.sendMessage(ChatColor.RED+ "You set " + ChatColor.RED+ target.getDisplayName() + ChatColor.RED+ " level to " + ChatColor.RED+ "-" + i);
                                                        }
                                                }
                                        }
                                }}
		return false;}}
                        