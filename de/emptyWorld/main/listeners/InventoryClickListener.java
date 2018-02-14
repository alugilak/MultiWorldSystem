package de.emptyWorld.main.listeners;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.objects.GuiItem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener
{einstellungen settings = einstellungen.getInstance();
FileConfiguration data;
FileConfiguration wdata;
FileConfiguration pdata;
FileConfiguration dedata;
FileConfiguration endata;
FileConfiguration permdata;
FileConfiguration sysodata;
  private leerWelt m;
  
  public InventoryClickListener(leerWelt m)
  {
    this.m = m;
  }
  
  @org.bukkit.event.EventHandler
  public void click(InventoryClickEvent e) {
    if (!e.getInventory().equals(m.gui)) return;
    if (e.getCurrentItem() == null) return;
    GuiItem it = m.getGuiItem(e.getCurrentItem());
    if (it == null) return;
    e.setCancelled(true);
    it.executeCommands((org.bukkit.entity.Player)e.getWhoClicked());
  }
}
