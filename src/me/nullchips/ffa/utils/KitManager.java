package me.nullchips.ffa.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.nullchips.ffa.handlers.kits.ArcherKit;
import me.nullchips.ffa.handlers.kits.Kit;
import me.nullchips.ffa.handlers.kits.MCSGKit;

public class KitManager {

	private static KitManager instance = new KitManager();

	public static KitManager getInstance() {
		return instance;
	}

	private ArrayList<Kit> allKits;
	private Inventory kitMenu;

	private KitManager() {
		allKits = new ArrayList<Kit>();

		allKits.add(new ArcherKit());
		allKits.add(new MCSGKit());

		kitMenu = Bukkit.getServer().createInventory(null, InventoryType.CHEST, ChatColor.GOLD + "Kit Selector");

		for (Kit kit : allKits) {
			ItemStack item = new ItemStack(kit.getItems().get(0).getType(), 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(kit.getName());
			meta.setLore(Arrays.asList("Click here", "to select", "the " + kit.getName() + " kit."));
			item.setItemMeta(meta);
			kitMenu.addItem(item);
		}
	}

	public Kit getKit(String name) {
		for (Kit kit : allKits) {
			if (kit.getName().equals(name)) {
				return kit;
			}
		}
		return null;
	}
	
	public Inventory getKitMenu() {
		return kitMenu;
	}
}


