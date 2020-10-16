package dev.floffah.util.chat;

import org.bukkit.ChatColor;

public class Colours {
    public static String def(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
