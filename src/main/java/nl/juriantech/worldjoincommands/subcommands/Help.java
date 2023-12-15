package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.WorldJoinCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

@Command({"worldjoincommands", "wjc"})
public class Help {

    private final WorldJoinCommands plugin;

    public Help(WorldJoinCommands plugin) {
        this.plugin = plugin;
    }

    @Subcommand("help")
    public void perform(Player player) {
        player.sendMessage(ChatColor.BLUE + plugin.getCustomizationFile().getString("helpmenu.line1"));
        player.sendMessage(ChatColor.YELLOW + plugin.getCustomizationFile().getString("helpmenu.line2"));
        player.sendMessage(ChatColor.YELLOW + plugin.getCustomizationFile().getString("helpmenu.line3"));
        player.sendMessage(ChatColor.YELLOW + plugin.getCustomizationFile().getString("helpmenu.line4"));

    }
}

