package me.nullchips.ffa.threads;

import org.bukkit.Location;

import me.nullchips.ffa.FFA;

public class ArenaCreation {
	
	
	
	public static void createArena(String createdArenaId, int createdArenaSpawnHeight, Location createdArenaSpawn) {
		FFA.getPlugin().getConfig().set("Arenas." + createdArenaId + ".SpawnLocation", createdArenaSpawnHeight);
		FFA.getPlugin().getConfig().set("Arenas." + createdArenaId + ".SpawnLocation", createdArenaSpawn);
		FFA.getPlugin().getConfig().set("Arenas." + createdArenaId + ".DisplayItem", 267);
		FFA.getPlugin().getConfig().set("Arenas." + createdArenaId + ".Name", "Arena " + createdArenaId);
		FFA.getPlugin().saveConfig();
	}

}
