package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.WorldJoinCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

import java.io.IOException;

@Command({"worldjoincommands", "wjc"})
public class Reload {

    private final WorldJoinCommands plugin;

    public Reload(WorldJoinCommands plugin) {
        this.plugin = plugin;
    }

    @Subcommand("reload")
    public void perform(Player player) throws IOException {
        if (player.hasPermission("worldjoincommands.reload")) {
            plugin.getCustomizationFile().reload();
            plugin.getWorldsFile().reload();
            player.sendMessage(ChatColor.GREEN + plugin.getCustomizationFile().getString("messages.reload-message"));
        } else if (!player.hasPermission("worldjoincommands.reload")) {
            player.sendMessage(ChatColor.RED + plugin.getCustomizationFile().getString("messages.no-permission"));

        }
    }
}



