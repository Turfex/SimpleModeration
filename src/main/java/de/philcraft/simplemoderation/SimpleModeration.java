package de.philcraft.simplemoderation;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class SimpleModeration extends JavaPlugin {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.config = getConfig();

        Bukkit.getLogger().log(Level.INFO, "Enable SimpleModeration");

    }

    @Override
    public void onDisable() {
        saveConfig();
        Bukkit.getLogger().log(Level.INFO, "Disable SimpleModeration");
    }

    public void reloadPlugin() {
        this.reloadConfig();
    }

    public FileConfiguration getConfig() {
        return this.config;
    }
}
