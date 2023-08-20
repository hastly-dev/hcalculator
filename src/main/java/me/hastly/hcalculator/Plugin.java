package me.hastly.hcalculator;

import me.hastly.hcalculator.commands.Calculator;
import me.hastly.hcalculator.commands.MessageCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    private static Plugin instance;

    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();

        getCommand("hcalculator").setExecutor(new Calculator());
        getCommand("hcalculator").setTabCompleter(new MessageCompleter());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getInstance() {
        return instance;
    }
}
