package me.nullchips.ffa.utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillStreakManager {
	
	private static KillStreakManager instance = new KillStreakManager();
	
	public static KillStreakManager getKillStreakManager() {
		return instance;
	}
	
	public HashMap<Player, Integer> killStreaks = new HashMap<Player, Integer>();
	
	public void removeKillStreak(Player p) {
		killStreaks.remove(p);
	}
	
	public void addKillStreakPlayer(Player p) {
		killStreaks.put(p, 0);
	}
	
	public void removeKillStreakPlayer(Player p) {
		try {
		killStreaks.remove(p);
		} catch(NullPointerException e) {
			Bukkit.getServer().getLogger().info("Player does not exist in Kill Streak HashMap!");
		}
	}
	
	public int getKillStreakNumber(Player p) {
		return killStreaks.get(p);
	}
	
	public void addKill(Player p) {
		if(killStreaks.containsKey(p)) {
			killStreaks.put(p, killStreaks.get(p)+1);
		}
	}
	
	public void resetKillStreak(Player p) {
		if(killStreaks.containsKey(p)) {
			killStreaks.put(p, 0);
		}
	}

}
