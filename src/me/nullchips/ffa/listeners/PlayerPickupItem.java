package me.nullchips.ffa.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.nullchips.ffa.utils.ArenaManager;

public class PlayerPickupItem implements Listener {
	
	ArenaManager arenaManager = ArenaManager.getArenaManager();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		
		if(!arenaManager.isArena1Player(p)) return;
		
		if(e.getItem().getItemStack().getItemMeta().getDisplayName().equals("Regeneration Apple")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5, 0));

			ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE);

			if(p.getInventory().contains(goldenApple) && goldenApple.getItemMeta().getDisplayName().equals("Regeneration Apple")) {
				p.getInventory().removeItem(goldenApple);
				p.updateInventory();
			}
		}
	}
}
