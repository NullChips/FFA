package me.nullchips.ffa.threads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.nullchips.ffa.handlers.kits.ArcherKit;
import me.nullchips.ffa.handlers.kits.Kit;
import me.nullchips.ffa.handlers.kits.MCSGKit;
import me.nullchips.ffa.utils.KitManager;

public class KitMenu implements Listener {

	public KitMenu(Plugin p) {
		Bukkit.getServer().getPluginManager().registerEvents(this, p);
	}
	
	KitManager kitManager =  KitManager.getInstance();

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		
		ItemStack air = new ItemStack(Material.AIR);
		if (e.getCurrentItem() == null && e.getCurrentItem().hasItemMeta() )return;
		
		if(e.getCurrentItem() == air)  return;
		
		if(e.getCurrentItem() == null) return;
		
		if(!e.getCurrentItem().hasItemMeta()) return;
		
		Player p = (Player) e.getWhoClicked();

		if (!e.getInventory().getName().equals(ChatColor.GOLD + "Kit Selector")) {
			return;
		}

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


