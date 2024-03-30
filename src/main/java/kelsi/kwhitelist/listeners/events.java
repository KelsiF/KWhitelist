package kelsi.kwhitelist.listeners;

import kelsi.kwhitelist.utils.whitelistUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class events implements Listener {

    JavaPlugin plugin;
    public events(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static List<String> list = new ArrayList<>();
    String message = plugin.getConfig().getString("messages.not-whitelisted");


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        String name = player.getDisplayName().toLowerCase();
        if (list.contains(name)) {
            event.setCancelled(false);
        }
        if (!list.contains(name)) {
            event.setCancelled(true);
            whitelistUtils.notWhitelisted(player, message);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            whitelistUtils.notWhitelisted(player, message);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            whitelistUtils.notWhitelisted(player, message);
        }
    }

    @EventHandler
    public void onDamaged(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(false);
            }
            if (!list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(true);
                whitelistUtils.notWhitelisted(player, message);
            }
        }
    }

    @EventHandler
    public void onDamageByPlayer(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(false);
            }
            if (!list.contains(player.getDisplayName().toLowerCase())) {
                event.setCancelled(true);
                whitelistUtils.notWhitelisted(player, message);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(false);
        }
        if (!list.contains(player.getDisplayName().toLowerCase())) {
            event.setCancelled(true);
            whitelistUtils.notWhitelisted(player, message);
        }
    }


}
