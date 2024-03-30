package kelsi.kwhitelist;

import kelsi.kwhitelist.commands.whitelistCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static kelsi.kwhitelist.listeners.events.list;

public final class KWhitelist extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
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


        getCommand("kwl").setExecutor(new whitelistCommand(this));


        getConfig().options().copyDefaults();
        saveDefaultConfig();


        list = (List<String>) getConfig().getList("players");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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