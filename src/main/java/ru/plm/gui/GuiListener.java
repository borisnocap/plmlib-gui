package ru.plm.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class GuiListener implements Listener {

    private final HashMap<Inventory, GUI> guis = new HashMap<>();

    public GuiListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void registerGUI(GUI gui) {
        guis.put(gui.inventory, gui);
    }

    public void unregisterGUI(GUI gui) {
        guis.remove(gui.inventory);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();
        GUI gui = guis.get(inventory);
        // Все GUI хранятся в HashMap. Если GUI не найден, значит текущий инвентарь не привязан к GUI.
        if (gui == null) return;
        event.setCancelled(true);
        // Важно проверять тип клика иначе могут происходить двойные срабатывания нажатий.
        if (event.getAction() != InventoryAction.PICKUP_ALL) return;
        gui.block();
        gui.onClick(event.getSlot());
    }
}
