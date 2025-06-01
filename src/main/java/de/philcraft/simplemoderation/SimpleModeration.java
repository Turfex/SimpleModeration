package de.philcraft.simplemoderation;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SimpleModeration extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.config = getConfig();

        Bukkit.getLogger().log(Level.INFO, "Enable SimpleModeration");

        getCommand("simplemoderation").setExecutor(new SimpleModerationCommand(this));
        getCommand("simplemoderation").setTabCompleter(new SimpleModerationCommand(this));

        Bukkit.getPluginManager().registerEvents(new ModerationListener(config), this);

    }

    @Override
    public void onDisable() {
        saveConfig();
        Bukkit.getLogger().log(Level.INFO, "Disable SimpleModeration");
    }

    public void reloadPlugin() {
        reloadConfig();
        this.config = getConfig();

        HandlerList.unregisterAll(this);
        Bukkit.getPluginManager().registerEvents(new ModerationListener(config), this);
    }

    public FileConfiguration getConfig() {
        return this.config;
    }
}
