package me.james.broadcast.annoucement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.james.broadcast.Main;

public class Announcement implements Listener {

	private Main plugin;

	public Announcement(Main plugin) {

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if (!player.hasPlayedBefore()) {
			Bukkit.broadcastMessage(ChatColor.GOLD
					+ (plugin.getConfig().getString("firstBroadcast").replace("<player>", player.getName())));
		} else {
			Bukkit.broadcastMessage(
					ChatColor.GOLD + (plugin.getConfig().getString("Broadcast").replace("<player>", player.getName())));
		}

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();

		Bukkit.broadcastMessage(
				ChatColor.GOLD + (plugin.getConfig().getString("Quit").replace("<player>", player.getName())));
	}

}
