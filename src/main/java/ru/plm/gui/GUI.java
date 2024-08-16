package ru.plm.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public abstract class GUI {

    // Символ отступа для правильного наложения оверлея.
    protected final String OVERLAY_INDENT = "⼆";

    // Символ отступа для правильного наложения заголовка на оверлей.
    protected final String TITLE_INDENT = "⼇";

    protected Player owner;
    protected Inventory inventory;
    protected boolean blocked;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void block() {
        blocked = true;
    }

    public void unblock() {
        blocked = false;
    }

    public abstract void onClick(int slot);

    public void show() {
        owner.openInventory(inventory);
    }

    public void hide() {
        owner.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
    }
}
