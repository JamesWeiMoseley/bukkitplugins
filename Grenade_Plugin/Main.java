package me.james.grenade;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.grenade.grenadeItem.GrenadeItem;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new GrenadeItem(this);
	}

}
