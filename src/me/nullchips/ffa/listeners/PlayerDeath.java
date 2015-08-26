package me.nullchips.ffa.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.nullchips.ffa.utils.PlayerStatsFileUtils;

public class PlayerDeath implements Listener {

	PlayerStatsFileUtils stats = new PlayerStatsFileUtils();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player victim = (Player) e.getEntity();
		Player damager = victim.getKiller();
		if (damager instanceof Player && victim instanceof Player) {
			stats.addDeath(victim.getUniqueId().toString());
			stats.addKill(damager.getUniqueId().toString());
		}
	}
}
