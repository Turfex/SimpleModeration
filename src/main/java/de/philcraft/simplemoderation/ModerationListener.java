package de.philcraft.simplemoderation;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class ModerationListener implements Listener {

    FileConfiguration configuration;

    public ModerationListener(FileConfiguration config) {
        this.configuration = config;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        if (event.getPlayer().hasPermission("simplemoderation.admin")) return;

        ArrayList<String> blockedWords = (ArrayList<String>) configuration.getList("blockedWords");

        for (String word : blockedWords) {
            if (event.getMessage().toUpperCase().contains(word.toUpperCase())) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(configuration.getString("cantDoThisMessage"));
            }
        }
    }
}
