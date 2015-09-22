package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.utils.ArenaManager;

public class RemoveFFAPlayer implements CommandExecutor {

	ArenaManager arenaManager = ArenaManager.getArenaManager();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("removeffaplayer")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
				return false;
			}

			Player p = (Player) sender;
			
			if(!p.isOp()) {
				return false;
			}

			if(arenaManager.isArena1Player(p)) {
				arenaManager.removeArena1Player(p);
				return true;
			}

			return false;
		}
		return false;
	}

}
