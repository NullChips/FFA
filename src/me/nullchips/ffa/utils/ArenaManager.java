package me.nullchips.ffa.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.handlers.Arena;

public class ArenaManager {
	
	SettingsManager settings = FFA.getSettings();
	
	private ArrayList<Arena> arenas;

	public ArenaManager() {
		this.arenas = new ArrayList<Arena>();
		loadArenas();
	}

	public void loadArenas() {

		if (settings.getConfig().get("Arenas") != null) {
			for (String arenaName : settings.getConfig().getConfigurationSection("Arenas").getKeys(true)) {
				if (!arenaName.contains(".")) {
					arenas.add(new Arena(arenaName));
				}
			}
		}
	}

	public Arena getArena(String arenaName) {
		for (Arena arena : arenas)
			if (arena.getName().equalsIgnoreCase(arenaName))
				return arena;
		return null;
	}

	public Arena getArena(Player player) {

		for (Arena arena : arenas)
			if (arena.isPlayer(player.getName()))
				return arena;
		return null;
	}

}
