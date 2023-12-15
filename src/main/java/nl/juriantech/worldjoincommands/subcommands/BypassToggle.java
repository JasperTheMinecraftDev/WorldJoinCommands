package nl.juriantech.worldjoincommands.subcommands;

import nl.juriantech.worldjoincommands.files.CustomConfig1;
import nl.juriantech.worldjoincommands.files.CustomConfig3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;


@Command({"worldjoincommands", "wjc"})
public class BypassToggle {

    @Subcommand("bypass")
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.bypasstoggle")) {
            if (CustomConfig3.get().getBoolean("players." + player.getName())) {
                CustomConfig3.get().set("players." + player.getName(), false);
                CustomConfig3.save();
                player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.bypassmode-disabled"));
        }else if (!CustomConfig3.get().getBoolean("players." + player.getName())) {
                CustomConfig3.get().set("players." + player.getName(), true);
                CustomConfig3.save();
                player.sendMessage(ChatColor.GREEN + CustomConfig1.get().getString("messages.bypassmode-enabled"));
            }
        }
    }
}