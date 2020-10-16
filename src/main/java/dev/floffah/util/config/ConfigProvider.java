package dev.floffah.util.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ConfigProvider {
    public JavaPlugin plugin;
    String resourceName;

    public File file;
    public YamlConfiguration conf;

    public ConfigProvider(JavaPlugin plugin, String resourceName) {
        this.plugin = plugin;
        this.resourceName = resourceName;

        file = new File(Paths.get(plugin.getDataFolder().getAbsolutePath(), resourceName).toString());
        if(!file.exists()) {
            plugin.saveResource(resourceName, false);
        }
        conf = YamlConfiguration.loadConfiguration(file);

        load();
    }

    public void reload() {
        save();
        conf = null;
        file = null;

        file = new File(Paths.get(plugin.getDataFolder().getAbsolutePath(), resourceName).toString());
        if(!file.exists()) {
            plugin.saveResource(resourceName, false);
        }
        conf = YamlConfiguration.loadConfiguration(file);

        load();
    }

    public void load() {

    }

    public void save() {
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}