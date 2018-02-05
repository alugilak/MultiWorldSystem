package de.emptyWorld.main.commands;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import net.md_5.bungee.api.ChatColor;

public class killmobs implements CommandExecutor {
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
public killmobs( leerWelt instance)
{

  plugin = instance;
}
    private int mobsKilled;
    

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	{for(Player p: Bukkit.getServer().getOnlinePlayers())
    	  if (!(sender instanceof Player))
    		  if (cmd.getName().equalsIgnoreCase("killmob"))
    		    {    	    if (!sender.hasPermission((String)this.settings.getpermData().get("mwskillmobs")))
    		    {
    		        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ((String)this.settings.getpermData().get("mwskillmobs")));
    		        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
    		        return false;
    		      }
    	    sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwsbeaplayer")));
    	    return false;}
    	  
    	killmobs1();
        sender.sendMessage(ChatColor.AQUA + "Killed " + ChatColor.RED + mobsKilled + ChatColor.GOLD + " mobs!");}
		return false;
    }

	private void killmobs1() {
        LivingEntity mobs;
        mobsKilled = 0;
        for (World world : (World[])Bukkit.getServer().getWorlds().toArray(new World[0])) {
            for (Iterator<LivingEntity> localIterator1 = world.getLivingEntities().iterator(); localIterator1.hasNext(); ) { mobs = (LivingEntity)localIterator1.next();
                if (!(mobs instanceof Player)) {
                    mobs.remove();
                    mobsKilled++;}}}}
	}

    


    