package me.nullchips.ffa.handlers.kits;

import java.util.AbstractMap.SimpleEntry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class MCSGKit extends Kit {

	//private static String displayName = FFA.getPlugin().getConfig().getString("Kits.MCSG.DisplayName");
	//private static int price = FFA.getPlugin().getConfig().getInt("Kits.MCSG.Price");
	
	private static int price = 0;
	private static String displayName = "MCSG";
	
	public MCSGKit() {
		super(displayName, price);
		
		setBoots(new ItemStack(Material.IRON_BOOTS));
		setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
		setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));		
		
		addItem(Material.STONE_SWORD, 1, "Stone Sword", new String[0], new SimpleEntry<Enchantment, Integer>(Enchantment.DURABILITY, 1));
		addItem(Material.FISHING_ROD, 1, "Fishing Rod", new String[0]);
	}	
}
