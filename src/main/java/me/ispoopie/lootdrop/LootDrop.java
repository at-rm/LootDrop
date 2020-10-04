package me.ispoopie.lootdrop;

import org.bukkit.plugin.java.JavaPlugin;

public final class LootDrop extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("drop").setExecutor(new DropCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
