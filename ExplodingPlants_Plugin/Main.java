package me.james.ExplodingPlants;

import org.bukkit.plugin.java.JavaPlugin;

import me.james.ExplodingPlants.Poison.Plants;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		new Plants(this);
		
	}


}
