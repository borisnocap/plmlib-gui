package ru.plm.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public abstract class GUI {

    // Символ отступа для правильного наложения оверлея.
    final String OVERLAY_INDENT = "⼆";

    // Символ отступа для правильного наложения заголовка на оверлей.
    final String TITLE_INDENT = "⼇";

    Player owner;
    Inventory inventory;
    private boolean blocked;

    abstract void onClick(int slot);

    public void show() {
        owner.openInventory(inventory);
    }

    public void hide() {
        owner.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
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

    public void setOwner(Player player) {
        owner = player;
    }
}
