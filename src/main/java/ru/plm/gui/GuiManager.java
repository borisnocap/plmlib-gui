package ru.plm.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

@SuppressWarnings("unused")
public class GuiManager implements Listener {

    /*
    Список зарегистрированных GUI.
    В качестве ключа используется актуальный инвентарь GUI.
    После инициализации инвентаря GUI необходимо зарегистрировать GUI в менеджере.
    Если инвентарь был пересоздан (например, нужно было изменить заголовок), нужно до пересоздания инвентаря удалить
    регистрацию GUI, а потом, после пересоздания инвентаря, зарегистрировать GUI заново.
    */
    private final HashMap<Inventory, GUI> guis = new HashMap<>();

    public GuiManager(@NotNull JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void registerGuiByInventory(@NotNull GUI gui) {
        guis.put(gui.getInventory(), gui);
    }

    public void unregisterGuiByInventory(@NotNull GUI gui) {
        guis.remove(gui.getInventory());
    }

    /**
     * Менеджер отслеживает взаимодействия с GUI с помощью InventoryClickEvent.
     * Отслеживаются только обычные клики ЛКМ (InventoryAction.PICKUP_ALL) и ПКМ (PICKUP_HALF), иначе
     * могут возникать двойные срабатывания нажатий.
     * Если инвентарь, в котором кликнул игрок, отслеживается менеджером и имеет привязанный GUI, тогда
     * нажатие будет отменено, и кликнутый слот будет передан в соответствующий GUI.
     */
    @EventHandler
    private void onInventoryClick(final @NotNull InventoryClickEvent event) {
        GUI gui = guis.get(event.getClickedInventory());
        if (gui == null) return;
        event.setCancelled(true);
        switch (event.getAction()) {
            case InventoryAction.PICKUP_ALL -> gui.onLeftClick(event.getSlot());
            case InventoryAction.PICKUP_HALF -> gui.onRightClick(event.getSlot());
        }
    }
}
