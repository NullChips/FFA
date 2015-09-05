package me.nullchips.ffa.handlers.kits;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public abstract class Kit {

	public static ArrayList<Kit> allKits = new ArrayList<Kit>();

	private int displayItem;
	private String displayName;
	private String id;
	private int price;

	public String getDisplayName() {
		return displayName;
	}

	public static Kit getKit(Player p, Kit k) {
		for(Kit kit : allKits) {
			if(kit.getDisplayName().equalsIgnoreCase(kit.getDisplayName())) {
				return k;
			}
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getDisplayItem() {
		return displayItem;
	}

	public void setDisplayItem(int displayItem) {
		this.displayItem = displayItem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<Kit> getKits() {
		return allKits;
	}

	public void addKit(Kit kit) {
		allKits.add(kit);
	}

	public void removeKit(Kit kit) {
		allKits.remove(kit);
	}

	public boolean isKit(Kit kit) {
		return allKits.contains(kit);
	}

	public abstract void giveKit(Player  p);
}


