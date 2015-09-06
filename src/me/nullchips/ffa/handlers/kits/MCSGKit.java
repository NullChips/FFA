package me.nullchips.ffa.handlers.kits;

import java.util.AbstractMap.SimpleEntry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.nullchips.ffa.FFA;

public class MCSGKit extends Kit {
	
	public MCSGKit() {
		super(displayName, 0);
		setBoots(new ItemStack(Material.IRON_BOOTS));
		setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		setHelmet(new ItemStack(Material.IRON_HELMET));
		
		setPrice(0);
		
		addItem(Material.STONE_SWORD, 1, "Stone Sword", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.DURABILITY, 1));
		addItem(Material.FISHING_ROD, 1, "Fishing Rod", new String[0]);
	}

	private static String displayName = FFA.getPlugin().getConfig().getString("Kits.MCSG.DisplayName");
	
}
