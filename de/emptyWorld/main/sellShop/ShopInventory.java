package de.emptyWorld.main.sellShop;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ShopInventory {
    private ShopInventory.OperationType type;
    private Inventory inventory;

    public ShopInventory(InventoryHolder owner, int size, String title, ShopInventory.OperationType type) {
        this.setType(type);
        this.inventory = Bukkit.createInventory(owner, size, title);
    }

    public ShopInventory(Inventory inventory, ShopInventory.OperationType type) {
        this.setType(type);
        this.setInventory(inventory);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ShopInventory.OperationType getType() {
        return this.type;
    }

    public void setType(ShopInventory.OperationType type) {
        this.type = type;
    }

    public static enum OperationType {
        SELL,
        BUY;

        private OperationType() {
        }
    }
}
