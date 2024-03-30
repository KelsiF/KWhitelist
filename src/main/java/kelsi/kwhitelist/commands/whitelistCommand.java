package kelsi.kwhitelist.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static kelsi.kwhitelist.listeners.events.list;
import kelsi.kwhitelist.utils.whitelistUtils;

public class whitelistCommand implements CommandExecutor {

    JavaPlugin plugin;
    public whitelistCommand(JavaPlugin plugin) {this.plugin = plugin;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = null;
        if(sender.hasPermission("kwl.admin")) {
            if (args.length >= 1) {
                if (sender instanceof Player) {
                    player = (Player) sender;
                }
                switch (args[0]) {
                    case "help": return false;
                    case "add":
                        if (args[1] != null) {
                            list.add(args[1].toLowerCase());
                            whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.player-added")));
                            plugin.getConfig().set("players", list);
                            plugin.saveConfig();
                            return true;
                        } else {
                            return false;
                        }
                    case "remove":
                        if (args[1] != null) {
                            list.remove(args[1].toLowerCase());
                            whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.player-removed")));
                            plugin.getConfig().set("players", list);
                            plugin.saveConfig();
                            return true;
                        } else {
                            return false;
                        }
                    case "list": sender.sendMessage(list.toString());
                        return true;
                    case "update":
                        whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.files-updated")));
                        list = (List<String>) plugin.getConfig().getList("players");
                        plugin.reloadConfig();
                        return true;
                    case "on":
                        whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.whitelist-enabled")));
                        plugin.getConfig().set("whitelist", true);
                        return true;
                    case "off":
                        whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.whitelist-disabled")));
                        plugin.getConfig().set("whitelist", false);
                        return true;
                    default:
                        return false;
                }
            } else {
                return false;
            }
        } else if (!sender.hasPermission("kwl.admin")) {
            whitelistUtils.sendMessage(player, Objects.requireNonNull(plugin.getConfig().getString("messages.not-permission")));
            return true;
        }
        return true;
    }
}
