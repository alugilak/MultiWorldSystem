package de.emptyWorld.main.sellShop;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import de.emptyWorld.main.sellShop.ShopInventory.OperationType;

public class PlayerTradeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private String cancelMessage = "";
    private Player player;
    private ItemStack item;
    private OperationType operationType;
    private int amount;
    private double sale;
    private double price;

    public PlayerTradeEvent(Player player, ItemStack item, OperationType type, int amount, double sale, double price) {
        this.player = player;
        this.item = item;
        this.operationType = type;
        this.amount = amount;
        this.sale = sale;
        this.price = price;
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

    public void setMessage(String message) {
        this.cancelMessage = message;
    }

    public String getMessage() {
        return this.cancelMessage;
    }

    public Player getPlayer() {
        return this.player;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public OperationType getType() {
        return this.operationType;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSale() {
        return this.sale;
    }

    public void setSale(double sale) {
        if(sale > 1.0D) {
            sale = 1.0D;
        }

        this.sale = sale;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
