package me.nullchips.ffa.handlers.kits;

import java.util.AbstractMap.SimpleEntry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ArcherKit extends Kit {

	//private static String displayName = "Archer";
	//private static int price =  FFA.getPlugin().getConfig().getInt("Kits.Archer.Price");
	
	private static int price = 0;
	private static String displayName = "Archer";

	public ArcherKit() {
		super(displayName, price);

		setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
		setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
		setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));

		addItem(Material.STONE_SWORD, 1, "Stone Sword", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.DURABILITY, 1));
		addItem(Material.BOW, 1, "Bow", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.ARROW_INFINITE, 1));
		addItem(Material.ARROW, 1, "Arrow", new String[0]);
	}
}
