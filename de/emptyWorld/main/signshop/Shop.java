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
import org.bukkit.Server;
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
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void GrabGenerieren(PlayerDeathEvent event)
  {
    Player spieler = event.getEntity();
    Location loc = spieler.getLocation();
    
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
      s.setLine(0, ChatColor.RED + "*****************");
      s.setLine(1, ChatColor.GOLD + "  ##" + ChatColor.RED + "R.I.P" + ChatColor.GOLD + "##");
      s.setLine(2, ChatColor.AQUA + " " + spieler.getName());
      s.setLine(3, ChatColor.RED + "*****************");
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
