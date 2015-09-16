package me.nullchips.ffa.threads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import me.nullchips.ffa.handlers.kits.ArcherKit;
import me.nullchips.ffa.handlers.kits.Kit;
import me.nullchips.ffa.handlers.kits.MCSGKit;
import me.nullchips.ffa.utils.KitManager;

public class KitMenu implements Listener {
	
	KitManager km = KitManager.getInstance();

	public KitMenu(Plugin p) {
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}
	
	KitManager kitManager =  KitManager.getInstance();

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		Player  p = (Player) e.getWhoClicked();
		
		if(!e.getInventory().equals(km.getKitMenu())) return;

		e.setCancelled(true);
		e.getWhoClicked().closeInventory();

		p.getInventory().clear();

		if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Archer")) {
			Kit k = new ArcherKit();
			k.giveKit(p, k);
			p.sendMessage(ChatColor.GREEN + "You have chosen kit " + k.getName() + ".");
			return;
		}
	
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals("MCSG")) {
			Kit k = new MCSGKit();
			k.giveKit(p, k);
			p.sendMessage(ChatColor.GREEN + "You have chosen kit " + k.getName() + ".");
			return;
		}
		
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Close menu")) {
			p.closeInventory();
		}
		
	}
}


