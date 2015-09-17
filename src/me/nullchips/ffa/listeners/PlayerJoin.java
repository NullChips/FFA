package me.nullchips.ffa.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.nullchips.ffa.utils.PlayerStatsFileUtils;

public class PlayerJoin implements Listener {
	
	PlayerStatsFileUtils stats = new PlayerStatsFileUtils();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
	    stats.createFile(p);
	    stats.addDeath(p.getUniqueId().toString());
	}

}
