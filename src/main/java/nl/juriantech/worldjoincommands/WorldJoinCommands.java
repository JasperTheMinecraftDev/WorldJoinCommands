package nl.juriantech.worldjoincommands;

import dev.dejvokep.boostedyaml.YamlDocument;
import nl.juriantech.worldjoincommands.listeners.JoinListener;

import nl.juriantech.worldjoincommands.subcommands.BypassToggle;
import nl.juriantech.worldjoincommands.subcommands.Help;
import nl.juriantech.worldjoincommands.subcommands.Reload;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.CommandHandler;
import revxrsal.commands.bukkit.BukkitCommandHandler;

import java.io.File;
import java.io.IOException;

public class WorldJoinCommands extends JavaPlugin {

    private YamlDocument customizationFile, worldsFile, dataFile;

    public void onEnable() {
        files();
        commands();
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        printConsoleMessage("Enabling");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            System.out.println(customizationFile.getString("console-messages.activating-papi-hook"));
            System.out.println(customizationFile.getString("console-messages.papi-hook-activated"));
        } else {
            System.out.println(customizationFile.getString("console-messages.placeholderapi-not-found"));
        }
    }

    private void commands() {
        CommandHandler commandHandler = BukkitCommandHandler.create(this);

        commandHandler.register(new BypassToggle());
        commandHandler.register(new Help());
        commandHandler.register(new Reload());
    }

    private YamlDocument loadFile(String fileName) {
        try {
            return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void files() {
        customizationFile = loadFile("messages.yml");
        worldsFile = loadFile("worlds.yml");
        dataFile = loadFile("data.yml");
    }

    public void onDisable() {
        printConsoleMessage("Disabling");
    }

    private void printConsoleMessage(String action) {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]=====[" + action + " WorldJoinCommands]=====[]");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Information:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Name: WorldJoinCommands");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Developer: JasperTheDev");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Version: 3.0");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Support:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    SpigotMC: https://spigotmc.org/resources/worldjoincommands.99230/");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Discord: https://discord.gg/mAkedyvQMD");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]================================[]");
    }

    public YamlDocument getCustomizationFile() {
        return customizationFile;
    }

    public YamlDocument getWorldsFile() {
        return worldsFile;
    }

    public YamlDocument getDataFile() {
        return dataFile;
    }
}