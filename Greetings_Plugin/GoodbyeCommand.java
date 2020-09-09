package me.james.greetings.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.james.greetings.Main;

public class GoodbyeCommand implements CommandExecutor {

	private Main plugin;

	public GoodbyeCommand(Main plugin) {

		plugin.getCommand("bye").setExecutor(this);
		plugin.getCommand("goodbye").setExecutor(this);

	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String arg2, String[] arg3) {
		if (cmd.getName().equalsIgnoreCase("bye")) {

			Bukkit.broadcastMessage(ChatColor.BLUE + "Goodbye who ever is out there!");
			return true;

		} else if (cmd.getName().equalsIgnoreCase("goodbye")) {

			if (!(s instanceof Player)) {
				s.sendMessage(ChatColor.BLUE + "This command can only be run by a player");
			} else {
				Bukkit.broadcastMessage(ChatColor.BLUE + "Goodbye Everyone!!!!!!");
			}
			return true;

		}

		return false;
	}

}