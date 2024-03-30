package kelsi.kwhitelist.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class whitelistUtils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static void notWhitelisted(Player player, String msg) {
        player.sendMessage(color(msg));
    }
    public static void sendMessage(Player player, String msg) {
        player.sendMessage(color(msg));
    }

}
