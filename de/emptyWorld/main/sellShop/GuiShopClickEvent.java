package de.emptyWorld.main.sellShop;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import de.emptyWorld.main.sellShop.GUI;
import de.emptyWorld.main.sellShop.ShopInventory;

public class GuiShopClickEvent extends InventoryClickEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private ShopInventory shopInventory;
    private boolean cancelled;
    public final Inventory originalInventory;

    private GuiShopClickEvent(InventoryView view, SlotType type, int slot, ClickType click, InventoryAction action) {
        super(view, type, slot, click, action);
        this.shopInventory = (ShopInventory)GUI.getInventories().get(view.getTopInventory());
        this.originalInventory = this.shopInventory.getInventory();
    }

    public GuiShopClickEvent(InventoryClickEvent event) {
        this(event.getView(), event.getSlotType(), event.getSlot(), event.getClick(), event.getAction());
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public ShopInventory getShopInventory() {
        return this.shopInventory;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
