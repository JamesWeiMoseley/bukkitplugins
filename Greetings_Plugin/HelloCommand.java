package me.james.greetings.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.james.greetings.Main;

public class HelloCommand implements CommandExecutor {

	private Main plugin;

	public HelloCommand(Main plugin) {
		this.setPlugin(plugin);
		plugin.getCommand("Hello").setExecutor(this);

	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can send this command!");
			return true;
		}

		Player player = (Player) sender;

		player.sendMessage(ChatColor.BLUE + "Hello there Everyone!");

		return false;
	}

}
