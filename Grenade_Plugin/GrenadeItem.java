package me.james.grenade.grenadeItem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.james.grenade.Main;

public class GrenadeItem implements Listener {

	private Main plugin;

	public GrenadeItem(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void makeGrenade(PlayerInteractEvent e) {
		ItemStack i = e.getItem();
		Action act = e.getAction();
		Player p = e.getPlayer();
		Location l = p.getLocation();
		l.setY(l.getY() + 1);

//		if they have nothing, then nothing will happen
		if (i == null) {
			return;
		}
//		set the action to a right click only (so it doesnt work on left click)
		if (act.equals(Action.RIGHT_CLICK_AIR)) {
//			this is the material/i that will be affected
			if (i.getType().equals(Material.OAK_WOOD)) {
				i.setAmount((i.getAmount() - 1));
				ItemStack bomb = new ItemStack(i.getType(), 1);
				Entity drop = l.getWorld().dropItemNaturally(l, bomb);
				drop.setVelocity(l.getDirection().multiply(1));
//				delays the explosion
				new BukkitRunnable() {

					@Override
					public void run() {
//						int parameter is how big the explosion is and the boolean if everything will catch fire
						l.getWorld().createExplosion(drop.getLocation(), 2, false);
					}
				}.runTaskLater(plugin, 40);

			}

			if (i.getType().equals(Material.BIRCH_WOOD)) {
				i.setAmount((i.getAmount() - 1));
				ItemStack bomb = new ItemStack(i.getType(), 1);
				Entity drop = l.getWorld().dropItemNaturally(l, bomb);
				drop.setVelocity(l.getDirection().multiply(1));
//				delays the explosion
				new BukkitRunnable() {

					@Override
					public void run() {
						l.getWorld().createExplosion(drop.getLocation(), 6, false);
					}
				}.runTaskLater(plugin, 40);

			}

		}
	}
}
