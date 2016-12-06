package me.slacktooth.slackmode.commands;

import me.slacktooth.slackmode.SlackMode;
import me.slacktooth.slackmode.util.ColorUtil;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class SlackModeCommand implements CommandExecutor {

    private SlackMode PLUGIN = SlackMode.getInstance();
    private List<Player> players = SlackMode.getPlayers();
    private HashMap<Player, ItemStack[]> inventory = new HashMap<Player, ItemStack[]>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("slackmode.use")) {
            player.sendMessage(ColorUtil.colorize(PLUGIN.getConfig().getString("NO_PERMISSION")));
            return true;
        }
        if (players.contains(player)) {
            players.remove(player);
            player.getInventory().clear();
            player.getInventory().setContents(inventory.get(player));
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(ColorUtil.colorize(PLUGIN.getConfig().getString("LEFT_SLACKMODE")));
            return true;
        } else if (!players.contains(player)) {
            players.add(player);
            inventory.put(player, player.getInventory().getContents());
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();
        }
        return false;
    }
}
