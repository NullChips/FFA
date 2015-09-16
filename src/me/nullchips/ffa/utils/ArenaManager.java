package me.nullchips.ffa.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.handlers.Arena;

public class ArenaManager {
	
	private static ArenaManager arenaManager = new ArenaManager();
	
	public static ArenaManager getArenaManager() {
		return arenaManager;
	}
	
	public ArrayList<Player> arena1Players = new ArrayList<Player>();

	public ArenaManager() {
		loadArenas();
	}

	public void loadArenas() {

		if (FFA.getPlugin().getConfig().get("Arenas") != null) {
			for (String arenaId : FFA.getPlugin().getConfig().getConfigurationSection("Arenas").getKeys(true)) {
				if (!arenaId.contains(".")) {
					Arena arena = new Arena(arenaId);
					arena.addArena(arena);
				}
			}
		}
	}
	
	public void addArena1Player(Player p) {
		arena1Players.add(p);
	}
	
	public void removeArena1Player(Player p) {
		arena1Players.remove(p);
	}
	
	public boolean isArena1Player(Player p) {
		if(arena1Players.contains(p)) {
			return true;
		}
		else {
			return false;
		}
	}
}
