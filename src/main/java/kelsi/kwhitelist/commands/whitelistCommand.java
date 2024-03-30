package kelsi.kwhitelist.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static kelsi.kwhitelist.listeners.events.list;

public class whitelistCommand implements CommandExecutor {

    JavaPlugin plugin;
    public whitelistCommand(JavaPlugin plugin) {this.plugin = plugin;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("kwl.admin")) {
            if (args.length >= 1) {
                switch (args[0]) {
                    case "help": return false;
                    case "add":
                        if (args[1] != null) {
                            list.add(args[1].toLowerCase());
                            sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("messages.player-added")));
                            plugin.getConfig().set("players", list);
                            plugin.saveConfig();
                            return true;
                        } else {
                            return false;
                        }
                    case "remove":
                        if (args[1] != null) {
                            list.remove(args[1].toLowerCase());
                            sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("messages.player-removed")));
                            plugin.getConfig().set("players", list);
                            plugin.saveConfig();
                            return true;
                        } else {
                            return false;
                        }
                    case "list": sender.sendMessage(list.toString());
                    case "update":
                        sender.sendMessage(ChatColor.GREEN + Objects.requireNonNull(plugin.getConfig().getString("messages.files-updated")));
                        list = (List<String>) plugin.getConfig().getList("players");
                        plugin.reloadConfig();
                    case "on":
                        sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("messages.whitelist-enabled")));
                        plugin.getConfig().set("whitelist", true);
                    case "off":
                        sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("messages.whitelist-disabled")));
                        plugin.getConfig().set("whitelist", false);
                    default:
                        return false;
                }
            }
            return true;
        } else if (!sender.hasPermission("kwl.admin")) {
            sender.sendMessage(Objects.requireNonNull(plugin.getConfig().getString("messages.not-permission")));
            return true;
        }
        return true;
    }
}
