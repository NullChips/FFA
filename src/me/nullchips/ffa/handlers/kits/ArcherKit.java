package me.nullchips.ffa.handlers.kits;

import java.util.AbstractMap.SimpleEntry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import me.nullchips.ffa.FFA;

public class ArcherKit extends Kit {

private static String displayName = FFA.getPlugin().getConfig().getString("Kits.Archer.DisplayName");

	public ArcherKit() {
		super(displayName, 0);
		
		setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
		
		setPrice(0);
		
		addItem(Material.STONE_SWORD, 1, "Stone Sword", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.DURABILITY, 1));
		addItem(Material.BOW, 1, "Bow", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.ARROW_INFINITE, 1));
		addItem(Material.ARROW, 1, "Arrow", new String[0]);
	}
}
