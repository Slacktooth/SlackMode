package me.slacktooth.slackmode;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SlackMode extends JavaPlugin {

    private static SlackMode instance;
    private static List<Player> players = new ArrayList<Player>();

    @Override
    public void onEnable() {
        instance = this;
        players.clear();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        players.clear();
    }

    public static SlackMode getInstance() {
        return instance;
    }

    public static List<Player> getPlayers() {
        return players;
    }
}
