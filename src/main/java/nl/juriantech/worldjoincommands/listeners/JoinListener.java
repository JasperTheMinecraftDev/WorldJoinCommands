package nl.juriantech.worldjoincommands.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import nl.juriantech.worldjoincommands.WorldJoinCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Objects;

public class JoinListener implements Listener {
    private final WorldJoinCommands plugin;

    public JoinListener(WorldJoinCommands instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        handlePlayerEvent(event.getPlayer());
    }

    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        handlePlayerEvent(event.getPlayer());
    }

    private void handlePlayerEvent(Player player) {
        String wname = player.getWorld().getName();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (player.hasPermission(Objects.requireNonNull(plugin.getWorldsFile().getString(wname + ".permission")))) {
                    if (plugin.getDataFile().contains("players." + player.getUniqueId())) {
                        player.sendMessage(ChatColor.RED + Objects.requireNonNull(plugin.getCustomizationFile().getString("messages.bypassed-message")));
                    } else {
                        for (String command : plugin.getWorldsFile().getStringList(wname + ".commands")) {
                            command = PlaceholderAPI.setPlaceholders(player, Objects.requireNonNull(command));
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(command));
                        }
                    }
                }
            }
        }.runTaskLater(plugin, Long.parseLong((Objects.requireNonNull(plugin.getWorldsFile().getString(wname + ".delay")))));
    }

}