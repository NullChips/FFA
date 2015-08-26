package me.nullchips.ffa.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InvUtils {
	
	@SuppressWarnings("deprecation")
	public static void clearInventory(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(new ItemStack[] { air(),air(),air(),air() });
		p.updateInventory();
	}
	
	private static ItemStack air() {
		return new ItemStack(org.bukkit.Material.AIR);
	}

}
