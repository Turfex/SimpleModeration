package de.philcraft.simplemoderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SimpleModerationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            switch (args[0].toUpperCase()) {
                case "RELOAD":
                    new SimpleModeration().reloadPlugin();
                    commandSender.sendMessage("SimpleModeration got reloaded!");
                    break;
                default:
                    commandSender.sendMessage("Unkown argument!");
                    break;
            }
        } else {
            commandSender.sendMessage("Use /simplemoderation <arg>");
        }

        return false;
    }
}
