package me.james.ExplodingPlants.Poison;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.james.ExplodingPlants.Main;

public class Plants implements Listener {

	private Main plugin;

	public Plants(Main plugin) {
		this.setPlugin(plugin);

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void findFlowers(PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		final Material mat = p.getLocation().getBlock().getType();

//		These are the poisonous flowers
		if (mat == Material.OXEYE_DAISY) {
			poison(p);
		}
		if (mat == Material.DANDELION) {
			poison(p);
		}
		if (mat == Material.POPPY) {
			poison(p);
		}

		if (mat == Material.RED_TULIP) {
			poison(p);
		}

	}

	public void poison(Player p) {

//		first must find the location of the player
		final Location l = p.getLocation();
		final World w = l.getWorld();

//		colored dust lets you know that you are being poisoned
		final Particle.DustOptions colors = new Particle.DustOptions(Color.ORANGE, 4);
		w.spawnParticle(Particle.REDSTONE, l, 20, 1, 1, 1, colors);

//		the different effects it will have
		final PotionEffect health = new PotionEffect(PotionEffectType.POISON, 80, 1),
				stun = new PotionEffect(PotionEffectType.SLOW, 120, 1);

//		Make the flower disappear and make a sound
		l.getBlock().setType(Material.AIR);
		p.playSound(l, Sound.BLOCK_CAMPFIRE_CRACKLE, 1, 5);

		p.addPotionEffect(health, true);
		p.addPotionEffect(stun, true);

		p.sendMessage(ChatColor.RED + "You are being poisoned!!!");
	}

}
