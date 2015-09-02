package me.nullchips.ffa.handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.nullchips.ffa.FFA;

public class Kit {

	public static ArrayList<Kit> allKits = new ArrayList<Kit>();

	private int displayItem;
	private String displayName;
	private String id;
	private int price;

	public Kit(String id) {
		this.id = id;
		this.displayName = (String) FFA.getPlugin().getConfig().get("Kits." + id + ".DisplayName");
		this.displayItem = (int) FFA.getPlugin().getConfig().get("Kits." + id + ".DisplayItem");
		this.price = (int) FFA.getPlugin().getConfig().get("Kits." + id + ".Price");
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

	@SuppressWarnings("unchecked")
	public void giveKit(Player p, String id) {

		ItemStack[] content;
		content = ((List<ItemStack>) FFA.getPlugin().getConfig().get("Kits." + id +".Armor")).toArray(new ItemStack[0]);
		p.getInventory().setArmorContents(content);
		content = ((List<ItemStack>) FFA.getPlugin().getConfig().get("Kits." + id +".Items")).toArray(new ItemStack[0]);
		p.getInventory().setContents(content);

	}
}


