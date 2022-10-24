package adhdmc.simplegui.inventory;

import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.HashSet;

public class CustomInventory {

    private static HashMap<String, CustomInventory> customGUIs = new HashMap<>();
    private static HashSet<Inventory> inventories = new HashSet<>();
    private String id;
    private Inventory inventory;

    private CustomInventory(String id, Inventory inventory) {
        this.id = id;
        this.inventory = inventory;
        inventories.add(inventory);
        customGUIs.put(id, this);
    }

    /**
     * Assigns an ID to an inventory and adds CustomGUI functionality on top of it.
     * If an ID already exists, but the inventory is different, the ID is associated with the new inventory.
     * @param id SimpleGUI ID
     * @param inventory Inventory
     * @return CustomInventory belonging to that ID.
     */
    public CustomInventory wrapInventory(String id, Inventory inventory) {
        if (customGUIs.containsKey(id) && inventories.contains(inventory)) return customGUIs.get(id);
        if (customGUIs.containsKey(id)) inventories.remove(inventory);
        return new CustomInventory(id, inventory);
    }

    public static boolean isSimpleGUI(Inventory inventory) {
        return inventories.contains(inventory);
    }

}
