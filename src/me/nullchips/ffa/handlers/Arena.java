package me.nullchips.ffa.handlers;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;

import me.nullchips.ffa.FFA;

public class Arena {
	
	public static ArrayList<Arena> allArenas = new ArrayList<Arena>();
	public static HashMap<String, String> ffaPlayers = new HashMap<String, String>();
	
	private String name;
	private Location spawn;
	private int spawnHeight;
	private String id;
	private int displayItem;

	public Arena(String id) {
		this.id =  id;
		this.name = (String) FFA.getPlugin().getConfig().get("Arenas." + id + "Name");
		this.spawn = (Location) FFA.getPlugin().getConfig().get("Arenas." + name + ".Spawn");
		this.displayItem = (int) FFA.getPlugin().getConfig().get("Arenas." + id + ".DisplayItem");
		this.spawnHeight = (int) FFA.getPlugin().getConfig().get("Arenas." + id + ".SpawnHeight");
	}

	public String getName() {
		return name;
	}

	public Location getSpawn() {
		return spawn;
	}
	
	public int getSpawnHeight() {
		return spawnHeight;
	}
	
	public void setSpawnHeight(int spawnHeight) {
		this.spawnHeight = spawnHeight;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public int getDisplayItem() {
		return displayItem;
	}

	public void setDisplayItem(int displayItem) {
		this.displayItem = displayItem;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;

		FFA.getPlugin().getConfig().set("Arenas." + name + ".Spawn", spawn);
		FFA.getPlugin().saveConfig();
	}

	public ArrayList<Arena> getArenas() {
		return allArenas;
	}

	public void addArena(Arena arena) {
		allArenas.add(arena);
	}

	public void removeArena(Arena arena) {
		allArenas.remove(arena);
	}

	public boolean isAreana(Arena arena) {
		return allArenas.contains(arena);
	}

}
