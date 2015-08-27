package me.nullchips.ffa.utils;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.handlers.Arena;

public class KitManager {
	
	public void Kit() {
		loadKits();
	}
	
	public void loadKits() {
		if (FFA.getPlugin().getConfig().get("Kits") != null) {
			for (String kitName : FFA.getPlugin().getConfig().getConfigurationSection("Kits").getKeys(true)) {
				if (!kitName.contains(".")) {
					Arena.allArenas.add(kitName);
				}
			}
		}
	}

}
