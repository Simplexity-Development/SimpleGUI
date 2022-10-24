package adhdmc.simplegui.event;

import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

public class CustomGUIInteractEvent extends InventoryInteractEvent {

    public CustomGUIInteractEvent(@NotNull InventoryView transaction) {
        super(transaction);
    }

}
