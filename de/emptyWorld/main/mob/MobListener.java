package de.emptyWorld.main.mob;

import java.util.Map;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class MobListener implements Listener
{einstellungen settings = einstellungen.getInstance();
FileConfiguration data;
FileConfiguration wdata;
FileConfiguration pdata;
FileConfiguration dedata;	  
FileConfiguration endata;
FileConfiguration permdata;
FileConfiguration sysodata;

leerWelt plugin;   
public MobListener( leerWelt instance)
	  {

	  plugin = instance;
	  }
@EventHandler
public void onEntityDeath(EntityDeathEvent event)
{
  if (!plugin.isEnabled()) {
    return;
  }
  Loot loot = (Loot)Config.lootByEntity.get(event.getEntityType());
  if (loot == null) {
    return;
  }
  if (loot.cancelDefaultLoot) {
    event.getDrops().clear();
  }
  for (Map.Entry<Byte, ItemStack> entry : loot.loot.entrySet()) {
    if (((Byte)entry.getKey()).byteValue() == 100) {
      event.getDrops().add(entry.getValue());
    } else if (Math.random() * 100.0D > -((Byte)entry.getKey()).byteValue() + 100) {
      event.getDrops().add(entry.getValue());
    }
  }
  loot = null;
}
}

