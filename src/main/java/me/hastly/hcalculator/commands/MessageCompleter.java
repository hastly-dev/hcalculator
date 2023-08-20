package me.hastly.hcalculator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MessageCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 1) {
            return List.of(
                    "<num1>",
                    "reload"
            );
        } else if (args.length == 2) {
            return List.of(
                    "+",
                    "-",
                    "/",
                    "*"
            );
        } else if (args.length == 3) {
            return List.of(
                    "<num2>"
            );
        }

        return null;
    }
}
