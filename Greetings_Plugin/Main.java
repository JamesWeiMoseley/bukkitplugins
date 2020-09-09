package me.james.greetings;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.greetings.commands.GoodbyeCommand;
import me.james.greetings.commands.HelloCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		getLogger().info("Greetings has been enabled");

		new HelloCommand(this);
		new GoodbyeCommand(this);
	}
}
