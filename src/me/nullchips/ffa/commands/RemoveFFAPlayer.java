package me.nullchips.ffa.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.utils.ArenaManager;
import me.nullchips.ffa.utils.ChatUtils;

public class RemoveFFAPlayer implements CommandExecutor {

	ArenaManager arenaManager = ArenaManager.getArenaManager();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("removeffaplayer")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				ChatUtils.noPermission(p);
				return false;
			}

			Player p = (Player) sender;

			if(arenaManager.isArena1Player(p)) {
				arenaManager.removeArena1Player(p);
				return true;
			}

			return false;
		}
		return false;
	}

}
