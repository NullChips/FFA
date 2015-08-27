package me.nullchips.ffa.handlers;

import java.util.ArrayList;

import me.nullchips.ffa.FFA;

public class Kit {
	
	public static ArrayList<String> allKits = new ArrayList<String>();
	
	private int displayItem;
	private String displayName;
	private int price;
	
	public Kit(String name) {
		this.displayName = name;
		this.displayItem = (int) FFA.getPlugin().getConfig().get("Kits." + name + ".DisplayItem");
		this.price = (int) FFA.getPlugin().getConfig().get("Kits." + name + ".Price");
	}

	public String getDisplayName() {
		return displayName;
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
	
	public ArrayList<String> getKits() {
		return allKits;
	}

	public void addKit(String kit) {
		allKits.add(kit);
	}

	public void removeKit(String kit) {
		allKits.remove(kit);
	}

	public boolean isKit(String kit) {
		return allKits.contains(kit);
	}

}
