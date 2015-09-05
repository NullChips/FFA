package me.nullchips.ffa.handlers.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.nullchips.ffa.utils.ChatUtils;

public class ArcherKit extends Kit {

	@Override
	public void giveKit(Player p) {
		if(!p.hasPermission("ffa.kit.archer")) {
			ChatUtils.noPermission(p);
			return;
		}
		
		PlayerInventory in = p.getInventory();
		
		in.setArmorContents(null);
		in.setContents(null);
		
		ItemStack sword = new ItemStack(Material.STONE_SWORD);
		ItemStack bow = new ItemStack(Material.BOW);
		ItemStack arrows = new ItemStack(Material.ARROW);
		
	}

}
