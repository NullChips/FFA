package me.nullchips.ffa.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.nullchips.ffa.utils.ArenaManager;
import me.nullchips.ffa.utils.ChatUtils;
import me.nullchips.ffa.utils.PlayerStatsFileUtils;

public class PlayerDeath implements Listener {

	PlayerStatsFileUtils stats = new PlayerStatsFileUtils();

	ArenaManager arenaManager = ArenaManager.getArenaManager();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if(!(e.getEntity() instanceof Player)) {
			return;
		}

		Player victim = (Player) e.getEntity();
		if(!(victim.getKiller() instanceof Player)) {
			stats.addDeath(victim.getUniqueId().toString());
			for(Player p : arenaManager.arena1Players) {
				ChatUtils.ffaMessage(victim + " has died.", p);
			}
			return;
		}
		
		Player damager = victim.getKiller();
		
		e.getDrops().clear();
		
		ItemStack ga = new ItemStack(Material.GOLDEN_APPLE);
		ItemMeta im = ga.getItemMeta();
		im.setDisplayName("Regeneration Apple");
		
		victim.getWorld().dropItem(victim.getLocation(), ga);
		
		victim.setExp(0);
		
		if (damager instanceof Player && victim instanceof Player) {
			if(arenaManager.isArena1Player(victim) && arenaManager.isArena1Player(damager)) {
				stats.addDeath(victim.getUniqueId().toString());
				stats.addKill(damager.getUniqueId().toString());
				stats.addPoints(damager.getUniqueId().toString(), 2);
				damager.setExp(damager.getExp() + 1);
				for(Player p : arenaManager.arena1Players) {
					ChatUtils.ffaMessage(victim + " has been killed by " + damager + ".", p);
				}
				return;
			}
		}
	}

}
