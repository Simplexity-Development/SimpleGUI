package adhdmc.simplegui.util;

import adhdmc.simplegui.config.CustomGUI;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class InventoryBuilder {

    private static final HashMap<String, Inventory> cache = new HashMap<>();

    public static void clearCache() {
        cache.clear();
    }

    public static Inventory getInventory(String id) {
        if (cache.containsKey(id)) return cache.get(id);

        YamlConfiguration config = CustomGUI.getInstance().getConfig();
        String title = config.getString(id+".title", null);
        int size = config.getInt(id+".size", -1);
        if (title == null) return null;
        if (size < 9 || size > 54 || size % 9 != 0) return null;

        Inventory inventory = Bukkit.createInventory(null, size, MiniMessage.miniMessage().deserialize("<white>" + title));
        cache.put(id, inventory);
        return inventory;
    }

}
