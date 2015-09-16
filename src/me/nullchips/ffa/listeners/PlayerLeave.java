package me.nullchips.ffa.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.nullchips.ffa.utils.ArenaManager;

public class PlayerLeave implements Listener {
	
	ArenaManager arenaManager = ArenaManager.getArenaManager();
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(arenaManager.isArena1Player(e.getPlayer())) {
			arenaManager.removeArena1Player(e.getPlayer());
		}
	}

}
