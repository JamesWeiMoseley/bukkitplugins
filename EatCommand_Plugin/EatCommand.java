package me.james.eatcommand.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.james.eatcommand.Main;

public class EatCommand implements CommandExecutor {

	private Main plugin;

	public EatCommand(Main plugin) {
		this.setPlugin(plugin);

		plugin.getCommand("eat").setExecutor(this);

	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (!(arg0 instanceof Player)) {
			arg0.sendMessage(ChatColor.DARK_RED + "You must be a player to eat");
			return true;
		} else {
			Player player = (Player) arg0;

			int foodBar = 20;
			if (player.getFoodLevel() < foodBar) {
				player.setFoodLevel(foodBar);
				player.sendMessage(ChatColor.DARK_GREEN + "You're food bar is now full!");
			} else {
				player.sendMessage(ChatColor.DARK_GREEN + "You are already full!");
			}

			return false;
		}
	}
	
}
