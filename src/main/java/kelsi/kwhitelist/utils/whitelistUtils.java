package kelsi.kwhitelist.utils;

import org.bukkit.entity.Player;

public class whitelistUtils {

    public static void notWhitelisted(Player player, String msg) {
        player.sendMessage(msg);
    }

}
