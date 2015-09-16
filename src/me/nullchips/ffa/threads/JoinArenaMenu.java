package me.nullchips.ffa.threads;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.utils.ArenaManager;

public class JoinArenaMenu implements Listener {
	
	ArenaManager arenaManager = ArenaManager.getArenaManager();

	private Inventory menu;
	private ItemStack a1,c;
	private String a1DisplayName = FFA.getPlugin().getConfig().getString("Arenas.1.Name");
	private int a1DisplayItem = FFA.getPlugin().getConfig().getInt("Arenas.1.DisplayItem");

	@SuppressWarnings("deprecation")
	public JoinArenaMenu(Plugin p) {
		if(FFA.getPlugin().getConfig().contains("Arenas.1")) {
		
		menu = Bukkit.getServer().createInventory(null, 9, "Join an FFA arena:");

		c=(createItem(Material.REDSTONE_BLOCK, "Close menu", null));
		a1=(createItem(Material.getMaterial(a1DisplayItem), this.a1DisplayName, null));

		menu.setItem(8, c);
		menu.setItem(4, a1);

		Bukkit.getServer().getPluginManager().registerEvents(this, p);
		}

	}

	private ItemStack createItem(Material mat, String name, String lore) {
		ItemStack i = new ItemStack(mat,1);
		ItemMeta im =  i.getItemMeta();
		im.setDisplayName(name);
		if(lore != null) {
			im.setLore(Arrays.asList(lore));
		}
		i.setItemMeta(im);
		return i;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(!(e.getInventory().equals(menu))) {
			return;
		}

		if(e.getCurrentItem().getItemMeta().getDisplayName().contains(a1DisplayName)) {
			Player p = (Player) e.getWhoClicked();
			Location l = (Location) FFA.getPlugin().getConfig().get("Arenas.1.SpawnLocation");
			arenaManager.addArena1Player(p);
			p.teleport(l);
			return;
		}

		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Close menu")) {
			e.getWhoClicked().closeInventory();
		}
	}

	public void show(Player p) {
		p.openInventory(menu);
	}

	public ItemStack getA1() {
		return a1;
	}

	public void setA1(ItemStack a1) {
		this.a1 = a1;
	}

	public ItemStack getC() {
		return c;
	}

	public void setC(ItemStack c) {
		this.c = c;
	}

}
