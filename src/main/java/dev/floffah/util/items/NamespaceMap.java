package dev.floffah.util.items;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class NamespaceMap {
    Map<String, NamespacedKey> keys;
    JavaPlugin plugin;

    public NamespaceMap(JavaPlugin pl) {
        keys = new HashMap<String, NamespacedKey>();
        plugin = pl;
    }

    public NamespacedKey get(String name) {
        if(keys.containsKey(name)) {
            return keys.get(name);
        } else {
            NamespacedKey key = new NamespacedKey(plugin, name);
            keys.put(name, key);
            return key;
        }
    }
}
