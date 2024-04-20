package net.tv.twitch.chrono_fish.healthbar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HealthBar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new HealthManager(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
