package me.james.killed;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.killed.messsage.KillMessage;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new KillMessage(this);
	}

}
