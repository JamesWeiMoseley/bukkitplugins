package me.james.broadcast;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.broadcast.annoucement.Announcement;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		saveDefaultConfig();
		new Announcement(this);
	}
	
}
