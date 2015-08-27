package me.nullchips.ffa.utils;

import java.util.ArrayList;

import me.nullchips.ffa.FFA;

public class ArenaManager {

	SettingsManager settings = FFA.getSettings();

	public static ArrayList<String> allArenas;

	public ArenaManager() {
		ArenaManager.allArenas = new ArrayList<String>();
		loadArenas();
	}

	public void loadArenas() {

		if (settings.getConfig().get("Arenas") != null) {
			for (String arenaId : settings.getConfig().getConfigurationSection("Arenas").getKeys(true)) {
				if (!arenaId.contains(".")) {
					allArenas.add(arenaId);
				}
			}
		}
	}
}
