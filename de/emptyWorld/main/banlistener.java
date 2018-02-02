package de.emptyWorld.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;

public class banlistener implements org.bukkit.event.Listener
{
	einstellungen settings = einstellungen.getInstance();

FileConfiguration sysodata;

leerWelt plugin;


public banlistener( leerWelt instance)
{

plugin = instance;
}  
	  public banlistener() {}
	  
	  @org.bukkit.event.EventHandler(priority=org.bukkit.event.EventPriority.HIGH)
	  public void onJoin(PlayerLoginEvent e)
	  {
	    Player p = e.getPlayer();
	    
	    if (p.isBanned()) {
	      e.setKickMessage((String)this.settings.getsysoData().get("BanMessage"));
	    }
	  }
	}