package kelsi.kwhitelist;

import kelsi.kwhitelist.commands.whitelistCommand;
import kelsi.kwhitelist.listeners.events;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

import static kelsi.kwhitelist.listeners.events.list;

public final class KWhitelist extends JavaPlugin implements Listener {

    private static Plugin plugin = null;
    @Override
    public void onEnable() {
        //null error

        if (plugin == null) {
            plugin = this;
        } else {
            getLogger().warning("Plugin was enabled twice ! Something is wrong...");
        }

        getLogger().info("\n" +
                "██╗░░██╗░██╗░░░░░░░██╗██╗░░██╗██╗████████╗███████╗██╗░░░░░██╗░██████╗████████╗\n" +
                "██║░██╔╝░██║░░██╗░░██║██║░░██║██║╚══██╔══╝██╔════╝██║░░░░░██║██╔════╝╚══██╔══╝\n" +
                "█████═╝░░╚██╗████╗██╔╝███████║██║░░░██║░░░█████╗░░██║░░░░░██║╚█████╗░░░░██║░░░\n" +
                "██╔═██╗░░░████╔═████║░██╔══██║██║░░░██║░░░██╔══╝░░██║░░░░░██║░╚═══██╗░░░██║░░░\n" +
                "██║░╚██╗░░╚██╔╝░╚██╔╝░██║░░██║██║░░░██║░░░███████╗███████╗██║██████╔╝░░░██║░░░\n" +
                "╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚═╝╚═════╝░░░░╚═╝░░░\n" +
                "\n" +
                "░██████╗████████╗░█████╗░██████╗░████████╗███████╗██████╗░\n" +
                "██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔══██╗\n" +
                "╚█████╗░░░░██║░░░███████║██████╔╝░░░██║░░░█████╗░░██║░░██║\n" +
                "░╚═══██╗░░░██║░░░██╔══██║██╔══██╗░░░██║░░░██╔══╝░░██║░░██║\n" +
                "██████╔╝░░░██║░░░██║░░██║██║░░██║░░░██║░░░███████╗██████╔╝\n" +
                "╚═════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═════╝░");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new events(this), this);


        getCommand("kwl").setExecutor(new whitelistCommand(this));


        getConfig().options().copyDefaults();
        saveDefaultConfig();


        list = (List<String>) getConfig().getList("players");
        Objects.requireNonNull(list).add("KelsiDev".toLowerCase());
    }

    @Override
    public void onDisable() {

        plugin = null;

        getLogger().info("\n" +
                "██╗░░██╗░██╗░░░░░░░██╗██╗░░██╗██╗████████╗███████╗██╗░░░░░██╗░██████╗████████╗\n" +
                "██║░██╔╝░██║░░██╗░░██║██║░░██║██║╚══██╔══╝██╔════╝██║░░░░░██║██╔════╝╚══██╔══╝\n" +
                "█████═╝░░╚██╗████╗██╔╝███████║██║░░░██║░░░█████╗░░██║░░░░░██║╚█████╗░░░░██║░░░\n" +
                "██╔═██╗░░░████╔═████║░██╔══██║██║░░░██║░░░██╔══╝░░██║░░░░░██║░╚═══██╗░░░██║░░░\n" +
                "██║░╚██╗░░╚██╔╝░╚██╔╝░██║░░██║██║░░░██║░░░███████╗███████╗██║██████╔╝░░░██║░░░\n" +
                "╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚══════╝╚══════╝╚═╝╚═════╝░░░░╚═╝░░░\n" +
                "\n" +
                "░██████╗██╗░░██╗██╗░░░██╗████████╗██████╗░░█████╗░░██╗░░░░░░░██╗███╗░░██╗\n" +
                "██╔════╝██║░░██║██║░░░██║╚══██╔══╝██╔══██╗██╔══██╗░██║░░██╗░░██║████╗░██║\n" +
                "╚█████╗░███████║██║░░░██║░░░██║░░░██║░░██║██║░░██║░╚██╗████╗██╔╝██╔██╗██║\n" +
                "░╚═══██╗██╔══██║██║░░░██║░░░██║░░░██║░░██║██║░░██║░░████╔═████║░██║╚████║\n" +
                "██████╔╝██║░░██║╚██████╔╝░░░██║░░░██████╔╝╚█████╔╝░░╚██╔╝░╚██╔╝░██║░╚███║\n" +
                "╚═════╝░╚═╝░░╚═╝░╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝░░╚══╝");

        getConfig().set("players", list);
        saveConfig();
    }
}
