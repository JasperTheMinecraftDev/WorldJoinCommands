package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.files.CustomConfig1;
import nl.juriantech.worldjoincommands.files.CustomConfig2;
import nl.juriantech.worldjoincommands.files.CustomConfig3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;

@Command({"worldjoincommands", "wjc"})
public class Reload {

    @Subcommand("reload")
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.reload")) {
                CustomConfig1.save();
                CustomConfig2.save();
                CustomConfig3.save();
            player.sendMessage(ChatColor.GREEN + CustomConfig1.get().getString("messages.reload-message"));
        } else if (!player.hasPermission("worldjoincommands.reload")) {
            player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.no-permission"));

        }
    }
}



