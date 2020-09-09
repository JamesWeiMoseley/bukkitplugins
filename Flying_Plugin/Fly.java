package me.james.flying.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.james.flying.Main;

public class Fly implements CommandExecutor {

	private Main plugin;

	public Fly(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("fly").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

//		This is in the instance that the command is not from a player (thus from the console)
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.AQUA + (plugin.getConfig().getString("error_message")));

			return true;
		}

		Player player = (Player) sender;

		if (player.isFlying()) {
			player.setAllowFlight(false);
			player.setFlying(false);
			player.sendMessage(ChatColor.AQUA + (plugin.getConfig().getString("FlyCommand.stop_fly")));
			return true;
		} else {
			player.setAllowFlight(true);
			player.setFlying(true);
			player.sendMessage(ChatColor.AQUA + (plugin.getConfig().getString("FlyCommand.start_fly")));
		}

		return false;
	}

}
