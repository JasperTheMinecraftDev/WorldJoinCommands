package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.files.CustomConfig1;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

@Command({"worldjoincommands", "wjc"})
public class Help {

    @Subcommand("help")
    public void perform(Player player, String[] args) {
        player.sendMessage(ChatColor.BLUE + CustomConfig1.get().getString("helpmenu.line1"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line2"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line3"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line4"));

    }
}

