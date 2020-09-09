package me.james.flying;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.flying.commands.Fly;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		new Fly(this);
	}
	
}
