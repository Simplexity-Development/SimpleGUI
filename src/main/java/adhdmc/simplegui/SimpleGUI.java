package adhdmc.simplegui;

import adhdmc.simplegui.command.CommandHandler;
import adhdmc.simplegui.config.CustomGUI;
import adhdmc.simplegui.util.InventoryBuilder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleGUI extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        CustomGUI.getInstance().reloadConfig();
        CustomGUI.getInstance().saveConfig();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    public void reloadPlugin() {
        InventoryBuilder.clearCache();
    }

    private void registerCommands() {
        this.getCommand("simplegui").setExecutor(new CommandHandler());
    }

    public static Plugin getPlugin() { return plugin; }
}
