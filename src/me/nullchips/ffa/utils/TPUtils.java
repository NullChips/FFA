package me.nullchips.ffa.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TPUtils {
	
	public static void tpPlayer(Player p, Location l) {
		p.teleport(l);
	}

}
