package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.WorldJoinCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

import java.io.IOException;


@Command({"worldjoincommands", "wjc"})
public class BypassToggle {

    private final WorldJoinCommands plugin;

    public BypassToggle(WorldJoinCommands plugin) {
        this.plugin = plugin;
    }

    @Subcommand("toggle-bypass")
    public void perform(Player player) {
        if (player.hasPermission("worldjoincommands.bypasstoggle")) {
            if (plugin.getDataFile().getBoolean("players." + player.getName())) {
                plugin.getDataFile().set("players." + player.getName(), false);
                save();

                player.sendMessage(ChatColor.RED + plugin.getCustomizationFile().getString("messages.bypassmode-disabled"));
        }else if (!plugin.getDataFile().getBoolean("players." + player.getName())) {
                plugin.getDataFile().set("players." + player.getName(), true);
                save();

                player.sendMessage(ChatColor.GREEN + plugin.getCustomizationFile().getString("messages.bypassmode-enabled"));
            }
        }
    }

    public void save() {
        try {
            plugin.getDataFile().save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}