package me.slacktooth.slackmode.util;

import org.bukkit.ChatColor;

public class ColorUtil {

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
