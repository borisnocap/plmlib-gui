package ru.plm.gui;

import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import static net.kyori.adventure.text.format.NamedTextColor.*;

@SuppressWarnings("unused")
public abstract class GUI {

    public static final Style BLACK_NON_ITALIC = Style.style().color(BLACK).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_BLUE_NON_ITALIC = Style.style().color(DARK_BLUE).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_GREEN_NON_ITALIC = Style.style().color(DARK_GREEN).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_AQUA_NON_ITALIC = Style.style().color(DARK_AQUA).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_RED_NON_ITALIC = Style.style().color(DARK_RED).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_PURPLE_NON_ITALIC = Style.style().color(DARK_PURPLE).decoration(TextDecoration.ITALIC, false).build();
    public static final Style GOLD_NON_ITALIC = Style.style().color(GOLD).decoration(TextDecoration.ITALIC, false).build();
    public static final Style GRAY_NON_ITALIC = Style.style().color(GRAY).decoration(TextDecoration.ITALIC, false).build();
    public static final Style DARK_GRAY_NON_ITALIC = Style.style().color(DARK_GRAY).decoration(TextDecoration.ITALIC, false).build();
    public static final Style BLUE_NON_ITALIC = Style.style().color(BLUE).decoration(TextDecoration.ITALIC, false).build();
    public static final Style GREEN_NON_ITALIC = Style.style().color(GREEN).decoration(TextDecoration.ITALIC, false).build();
    public static final Style AQUA_NON_ITALIC = Style.style().color(AQUA).decoration(TextDecoration.ITALIC, false).build();
    public static final Style RED_NON_ITALIC = Style.style().color(RED).decoration(TextDecoration.ITALIC, false).build();
    public static final Style LIGHT_PURPLE_NON_ITALIC = Style.style().color(LIGHT_PURPLE).decoration(TextDecoration.ITALIC, false).build();
    public static final Style YELLOW_NON_ITALIC = Style.style().color(YELLOW).decoration(TextDecoration.ITALIC, false).build();
    public static final Style WHITE_NON_ITALIC = Style.style().color(WHITE).decoration(TextDecoration.ITALIC, false).build();

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
