package me.james.eatcommand;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.eatcommand.commands.EatCommand;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new EatCommand(this);
	}
	
}
