package me.nullchips.ffa.handlers;

import java.util.ArrayList;

import org.bukkit.Location;

import me.nullchips.ffa.FFA;

public class Arena {
	
	private String name;
	private Location spawn;
	private ArrayList<String> players;
	private int spawnHeight;
	private String id;
	private int displayItem;

	public Arena(String id) {
		this.id =  id;
		this.name = (String) FFA.getPlugin().getConfig().get("Arenas." + id + "Name");
		this.spawn = (Location) FFA.getPlugin().getConfig().get("Arenas." + name + ".Spawn");
		this.displayItem = (int) FFA.getPlugin().getConfig().get("Arenas." + id + ".DisplayItem");
		this.spawnHeight = (int) FFA.getPlugin().getConfig().get("Arenas." + id + ".SpawnHeight");
		this.players = new ArrayList<String>();
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

	public ArrayList<String> getPlayers() {
		return players;
	}

	public void addPlayer(String player) {
		this.players.add(player);
	}

	public void removePlayer(String player) {
		this.players.remove(player);
	}

	public boolean isPlayer(String player) {
		return this.players.contains(player);
	}

}
