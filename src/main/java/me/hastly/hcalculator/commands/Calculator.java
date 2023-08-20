package me.hastly.hcalculator.commands;

import me.hastly.hcalculator.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Calculator implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        int a, b;

        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("hcalculator.reload")) {
                    sender.sendMessage(ChatColor.RED + Plugin.getInstance().getConfig().getString("messages.noPermission"));
                    return true;
                }

                Plugin.getInstance().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + Plugin.getInstance().getConfig().getString("messages.reloadConfig"));
                return true;
            }
            sender.sendMessage(Objects.requireNonNull(Plugin.getInstance().getConfig().getString("messages.globalUsage")));
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            sender.sendMessage(Objects.requireNonNull(Plugin.getInstance().getConfig().getString("messages.globalUsage")));
            return true;
        }

        if (args[1].equals("+")) {
            sender.sendMessage(Plugin.getInstance().getConfig().getString("messages.resultMessage") + (a + b));
            return true;
        } else if (args[1].equals("-")) {
            sender.sendMessage(Plugin.getInstance().getConfig().getString("messages.resultMessage") + (a - b));
            return true;
        } else if (args[1].equals("/")) {
            sender.sendMessage(Plugin.getInstance().getConfig().getString("messages.resultMessage") + (a / b));
            return true;
        } else if (args[1].equals("*")) {
            sender.sendMessage(Plugin.getInstance().getConfig().getString("messages.resultMessage") + (a * b));
            return true;
        }

        sender.sendMessage(Objects.requireNonNull(Plugin.getInstance().getConfig().getString("messages.globalUsage")));
        return true;
    }
}
