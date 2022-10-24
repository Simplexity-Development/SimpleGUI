package adhdmc.simplegui.listener;

import adhdmc.simplegui.event.CustomGUIInteractEvent;
import adhdmc.simplegui.inventory.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class CustomGUIListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onCustomGUIListener(InventoryInteractEvent event) {
        if (!CustomInventory.isSimpleGUI(event.getInventory())) return;
        event.setCancelled(true);
        Bukkit.getPluginManager().callEvent(new CustomGUIInteractEvent(event.getView()));
    }

}
