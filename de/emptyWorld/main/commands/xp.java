package de.emptyWorld.main.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class xp implements CommandExecutor {	
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
	  
	  

public xp( leerWelt instance)
{

plugin = instance;
}

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().toLowerCase().contentEquals("xp")) {
            if (args.length > 2) {                         
                    if (checkValid(args[1], args[2]) != true) {
                    	return true; }                   
                    String param = args[0];
                    Player p = Bukkit.getServer().getPlayer(args[1]);
                    int value = Integer.parseInt(args[2]);
                   
                    if (checkPermission(sender, this.settings.getpermData().getString("mwsxpset"))) {
                            if (param.equalsIgnoreCase("set")) {
                                    setXP(p, value);
                                    return true;
                            } else if (param.equalsIgnoreCase("setlevel")) {
                                    setXP(p, calcXPLevels(value));
                                    return true;
                            }
                    }
                   
                    if (checkPermission(sender, this.settings.getpermData().getString("mwsxptake"))) {
                            if (param.equalsIgnoreCase("-")) {
                                    setXP(p, p.getTotalExperience() - value);
                                    return true;
                            } else if (param.equalsIgnoreCase("-levels")) {
                                    setXP(p, calcXPLevels(p.getLevel() - value));
                                    return true;
                            }
                    }
                   
                    if (checkPermission(sender, this.settings.getpermData().getString("mwsxpgive"))) {
                            if (param.equalsIgnoreCase("+")) {
                                    setXP(p, p.getTotalExperience() + value);
                                    return true;
                            } else if (param.equalsIgnoreCase("+levels")) {
                            int xpToAdd;
                            int xpNextLevel = calcXPLevels(p.getLevel() + 1);
                            int xpTNL = xpNextLevel - p.getTotalExperience();
                            int futureLevel = p.getLevel() + value;
                           
                            if (xpTNL == 0) {
                                    xpToAdd = calcXPLevels(futureLevel) - calcXPLevels(p.getLevel());
                            } else {

                                    xpToAdd = calcXPLevels(futureLevel) - xpNextLevel;
                            }                           
                            xpToAdd += xpTNL;      
                            setXP(p, p.getTotalExperience() + xpToAdd);                           
                                    return true;
                            }
                    }
            }
    }              
    return true;
}
protected Boolean checkPermission (CommandSender p, String perm) {             
    if (p.hasPermission(this.settings.getpermData().getString("mwsxp") + "*") || p.hasPermission(this.settings.getpermData().getString("mwsxp") + perm) || p.isOp()) {
            return true;
    }
   
    return false;
}

protected void setXP (Player p, int amount) {      
p.setExp(0);
p.setLevel(0);
p.setTotalExperience(0);
p.giveExp(amount);

if (calcXPLevels(p.getLevel() + 1) == p.getTotalExperience()) {
    p.setLevel(p.getLevel() + 1);
    p.setExp(0);
}
}

protected int calcXPLevels (int levels) {
    int xp = 0;
   
    for (int i = 1; i <= levels; i++) {
            if (i <= 16) {
                    xp += 17;
            } else if (i > 16 && i <= 31) {
                    xp += (i - 16) * 3 + 17;
            } else if (i > 31) {
                    xp += (i - 31) * 7 + 62;
            }
    }
   
    return xp;
}

protected Boolean checkValid (String player, String value) {
    if (!Bukkit.getServer().getOfflinePlayer(player).isOnline()) {
    	return false; }   
    try {
            Integer.parseInt(value);
    } catch (NumberFormatException nfe) {
            return false;
    }              
   
    return true;
}
}