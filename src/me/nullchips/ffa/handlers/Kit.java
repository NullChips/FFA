package me.nullchips.ffa.handlers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;

public class Kit {
	
	public static ArrayList<Kit> allKits = new ArrayList<Kit>();
	
	private int displayItem;
	private String displayName;
	private int price;
	
	public Kit(String displayName) {
		this.displayName = displayName;
		this.displayItem = (int) FFA.getPlugin().getConfig().get("Kits." + displayName + ".DisplayItem");
		this.price = (int) FFA.getPlugin().getConfig().get("Kits." + displayName + ".Price");
	}

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

}
