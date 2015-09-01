package me.nullchips.ffa.utils;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.handlers.Arena;

public class ArenaManager {

	public ArenaManager() {
		loadArenas();
	}

	public void loadArenas() {

		if (FFA.getPlugin().getConfig().get("Arenas") != null) {
			for (String arenaId : FFA.getPlugin().getConfig().getConfigurationSection("Arenas").getKeys(true)) {
				if (!arenaId.contains(".")) {
					Arena.allArenas.add(arenaId.trim());
				}
			}
		}
	}
}
