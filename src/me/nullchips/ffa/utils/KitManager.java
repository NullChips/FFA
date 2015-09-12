package me.nullchips.ffa.utils;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

	public ArrayList<Kit> allKits = new ArrayList<Kit>();
	private Inventory kitMenu;

	private KitManager() {

		kitMenu = Bukkit.getServer().createInventory(null, InventoryType.CHEST, ChatColor.GOLD + "Kit Selector");

		allKits.add(new ArcherKit());
		allKits.add(new MCSGKit());
		ItemStack close = new ItemStack(Material.REDSTONE_BLOCK);
		close.getItemMeta().setDisplayName("Close menu");

		for (Kit kit : allKits) {
			@SuppressWarnings("deprecation")
			ItemStack item = new ItemStack(Material.getMaterial(kit.getDisplayItem()));
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(kit.getName());
			meta.setLore(Arrays.asList("Click to get", "the " + kit.getName() + " kit!", "", ChatColor.RED + "Price: " + kit.getPrice()));
			item.setItemMeta(meta);
			kitMenu.addItem(item);
		}
		kitMenu.setItem(8, close);
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
