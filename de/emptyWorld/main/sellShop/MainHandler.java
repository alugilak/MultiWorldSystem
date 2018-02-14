package de.emptyWorld.main.sellShop;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import de.emptyWorld.main.sellShop.GUI;
import de.emptyWorld.main.sellShop.ShopInventory;
import de.emptyWorld.main.sellShop.Tab;
import de.emptyWorld.main.sellShop.ShopInventory.OperationType;

public class MainHandler implements Listener {
    public MainHandler() {
        de.emptyWorld.main.leerWelt.instance().getServer().getPluginManager().registerEvents(this, de.emptyWorld.main.leerWelt.instance());
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if(e.getInventory() != null) {
            if(e.getView().getTopInventory() != null) {
                Player p = (Player)e.getWhoClicked();
                if(GUI.getInventories().containsKey(e.getView().getTopInventory())) {
                    Iterator<?> var4 = e.getRawSlots().iterator();

                    while(var4.hasNext()) {
                        int i = ((Integer)var4.next()).intValue();
                        if(i < e.getView().getTopInventory().getSize()) {
                            e.setCancelled(true);
                            p.updateInventory();
                            return;
                        }
                    }
                }

            }
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getInventory() != null) {
            if(getClickedInventory(e) != null) {
                if(GUI.getInventories().containsKey(e.getView().getTopInventory())) {
                    Player p = (Player)e.getWhoClicked();
                    if(e.getClick().isShiftClick()) {
                        p.updateInventory();
                        e.setCancelled(true);
                    }

                    if(!getClickedInventory(e).equals(e.getView().getTopInventory())) {
                        return;
                    }

                    e.setCancelled(true);
                    GuiShopClickEvent mainEvent = new GuiShopClickEvent(e);
                    Bukkit.getServer().getPluginManager().callEvent(mainEvent);
                    if(mainEvent.isCancelled()) {
                        return;
                    }

                    if(mainEvent.getInventory().equals(GUI.getMainInventory())) {
                        GuiShopClickMainInventoryEvent event = new GuiShopClickMainInventoryEvent(mainEvent);
                        Bukkit.getServer().getPluginManager().callEvent(event);
                        return;
                    }

                    if(Tab.getTabs().containsKey(mainEvent.getView().getTopInventory())) {
                        GuiShopClickTabEvent event = new GuiShopClickTabEvent(mainEvent, Tab.getTab(mainEvent.getView().getTopInventory()), ((ShopInventory)GUI.getInventories().get(mainEvent.getView().getTopInventory())).getType());
                        Bukkit.getServer().getPluginManager().callEvent(event);
                        return;
                    }

                    GuiShopClickTabsListEvent event;
                    if(GUI.getBuyTabsPages().contains(mainEvent.getInventory())) {
                        event = new GuiShopClickTabsListEvent(mainEvent, OperationType.BUY);
                        Bukkit.getServer().getPluginManager().callEvent(event);
                        return;
                    }

                    if(GUI.getSellTabsPages().contains(mainEvent.getView().getTopInventory())) {
                        event = new GuiShopClickTabsListEvent(mainEvent, OperationType.SELL);
                        Bukkit.getServer().getPluginManager().callEvent(event);
                        return;
                    }
                }

            }
        }
    }

    public static Inventory getClickedInventory(InventoryClickEvent e) {
        return e == null?null:(e.getView() == null?null:(e.getSlot() == e.getRawSlot()?e.getView().getTopInventory():e.getView().getBottomInventory()));
    }
}
