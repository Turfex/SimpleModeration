package de.philcraft.simplemoderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleModerationCommand implements CommandExecutor, TabCompleter {

    SimpleModeration plugin;

    public SimpleModerationCommand(SimpleModeration pl) {
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            switch (args[0].toUpperCase()) {
                case "RELOAD":
                    plugin.reloadPlugin();
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

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        ArrayList<String> results = new ArrayList<>();

        if (args.length == 1) {
            results.add("reload");
        }

        return results;
    }
}
