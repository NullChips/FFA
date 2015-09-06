package me.nullchips.ffa.threads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.nullchips.ffa.handlers.kits.Kit;
import me.nullchips.ffa.utils.KitManager;

public class KitMenu implements Listener {

	public KitMenu(Plugin p) {
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}

	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null && e.getCurrentItem().hasItemMeta() )return;
		Player p = (Player) e.getWhoClicked();

		if (!e.getInventory().getName().equals(ChatColor.GOLD + "Kit Selector")) {
			return;
		}

		e.setCancelled(true);
		e.getWhoClicked().closeInventory();

		Kit kit = KitManager.getInstance().getKit(e.getCurrentItem().getItemMeta().getDisplayName());

		p.getInventory().clear();

		for (ItemStack item : kit.getItems()) {
			ItemStack[] armour = new ItemStack[] { kit.getHelmet(), kit.getChestplate(), kit.getLeggings(), kit.getBoots() };
			p.getInventory().setArmorContents(armour);
			p.getInventory().addItem(item);
		}

		p.sendMessage(ChatColor.GREEN + "You have chosen kit " + kit.getName() + ".");
	}
}


