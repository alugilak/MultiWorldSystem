package de.emptyWorld.main.sellShop;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class GuiShopClickMainInventoryEvent extends GuiShopClickEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    public GuiShopClickMainInventoryEvent(GuiShopClickEvent event) {
        super(event);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
