package adhdmc.simplegui.config;

import adhdmc.simplegui.SimpleGUI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CustomGUI {

    private static CustomGUI instance = null;
    private final String fileName = "custom.yml";
    private File file;
    private YamlConfiguration config;

    private CustomGUI() {}

    public static CustomGUI getInstance() {
        if (instance == null) {
            instance = new CustomGUI();
        }
        instance.reloadConfig();
        return instance;
    }

    public void reloadConfig() {
        if (file == null) file = new File(SimpleGUI.getPlugin().getDataFolder(), fileName);
        config = YamlConfiguration.loadConfiguration(file);
        saveDefaults();
        config.options().copyDefaults(true);
        InputStream stream = SimpleGUI.getPlugin().getResource(fileName);
        if (stream != null) config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(stream)));
    }

    public YamlConfiguration getConfig() {
        if (config == null) reloadConfig();
        return config;
    }

    public void saveConfig() {
        getConfig();
        if (config == null || file == null) return;
        try {
            config.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (!file.exists()) SimpleGUI.getPlugin().saveResource(fileName, false);
    }

    public void saveDefaults() {
        config.addDefault("example.title", "\uE800");
        config.addDefault("example.size", 54);
    }

}
