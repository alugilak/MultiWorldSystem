package de.emptyWorld.main.signshop;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Shop implements Listener
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
  
  public Shop(leerWelt instance)
  {
    plugin = instance;
  }
  
  private WorldGuardPlugin getWorldGuard()
  {
    Plugin wplugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
    if ((wplugin == null) || (!(wplugin instanceof WorldGuardPlugin))) {
      return null;
    }
    return (WorldGuardPlugin)wplugin;
  }

@EventHandler
  public void GrabGenerieren(PlayerDeathEvent event)
  {
    Player spieler = event.getEntity();
    Location loc = spieler.getLocation();
    this.settings.getData().set("death." + spieler.getName() + ".world", spieler.getLocation().getWorld().getName());
    this.settings.getData().set("death." + spieler.getName() + ".x", Double.valueOf(spieler.getLocation().getX()));
    this.settings.getData().set("death." + spieler.getName() + ".y", Double.valueOf(spieler.getLocation().getY()));
    this.settings.getData().set("death." + spieler.getName() + ".z", Double.valueOf(spieler.getLocation().getZ()));
    this.settings.saveData();
    WorldGuardPlugin worldGuard = getWorldGuard();
    LocalPlayer lplayer = worldGuard.wrapPlayer(spieler);
    
    RegionManager rm = worldGuard.getRegionManager(spieler.getWorld());
    if ((spieler.hasPermission((String)this.settings.getpermData().get("mwsspawns"))) && (rm.getApplicableRegions(loc).canBuild(lplayer)))
    {
      loc.getBlock().setTypeId(60);
      
      loc.setY(loc.getBlockY() + 1);
      loc.getBlock().setTypeId(38);     
      
      loc.setZ(loc.getBlockZ() - 1);
      loc.getBlock().setTypeId(63);
      Sign s = (Sign)loc.getBlock().getState();
      
      loc.setY(loc.getBlockY() - 1);
      loc.getBlock().setTypeId(60);
      
      loc.setY(loc.getBlockY() - 1);
      Block block = loc.getBlock().getRelative(BlockFace.DOWN);
      block.setType(Material.CHEST);
      
      Chest chest = (Chest)block.getState();
      World welt = spieler.getWorld();
      @SuppressWarnings("unused")
	Block chestBlock = welt.getBlockAt(loc);
      
      List<ItemStack> drops = event.getDrops();
      for (ItemStack i : drops)
      {
        if (i != null) {
          chest.getInventory().addItem(new ItemStack[] { i });
        }
        if (chest.getInventory().firstEmpty() == -1)
        {
          block.getRelative(BlockFace.WEST).setType(Material.CHEST);
          chest = (Chest)block.getRelative(BlockFace.WEST).getState();
        }
      }
      for (ItemStack i : drops) {
        i.setTypeId(0);
      }
      s.setLine(0, plugin.getConfig().getString("GraveLine0"));
      s.setLine(1, plugin.getConfig().getString("GraveLine1"));
      s.setLine(2, plugin.getConfig().getString("GraveLine2") + spieler.getName());
      s.setLine(3, plugin.getConfig().getString("GraveLine3"));
      s.update();      
      
    }
  }
  
  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent event)
  {
    String nachricht = ChatColor.translateAlternateColorCodes('&', event.getMessage());
    event.setMessage(nachricht);
  }
}
