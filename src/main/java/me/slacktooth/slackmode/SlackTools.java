package me.slacktooth.slackmode;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SlackTools {

    private SlackMode PLUGIN = SlackMode.getInstance();

    private final ItemStack vanishTool() {
        ItemStack item = new ItemStack(Material.getMaterial(PLUGIN.getConfig().getString("items.vanish")), 1);
        return item;
    }
}
