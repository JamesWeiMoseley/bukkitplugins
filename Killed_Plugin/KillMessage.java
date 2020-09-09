package me.james.killed.messsage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.james.killed.Main;


public class KillMessage implements Listener {

	private Main plugin;

	public KillMessage(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void messages(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {

			Player player = e.getEntity(); // player who has just been killed
			Player killer = e.getEntity().getKiller(); // player or entity that killed

			player.sendMessage(ChatColor.DARK_RED + "You have just been killed by " + killer.getDisplayName());
			killer.sendMessage(ChatColor.DARK_RED + "You just killed " + player.getDisplayName());

			return;

		} else {
			Player player = e.getEntity();
			player.sendMessage(ChatColor.DARK_RED + "You have been killed =(");
			return;
		}
	}

}