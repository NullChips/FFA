package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.threads.JoinArenaMenu;
import me.nullchips.ffa.utils.ArenaManager;
import me.nullchips.ffa.utils.ChatUtils;

public class FFACommand implements CommandExecutor {

	ArenaManager arenaManager = ArenaManager.getArenaManager();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ffa")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
				return false;
			}

			Player p = (Player) sender;

			if(!p.hasPermission("ffa.join")) {
				ChatUtils.noPermission(p);
				return false;
			}
			
			if(arenaManager.isArena1Player(p)) {
				ChatUtils.message(p, "You are already in an FFA arena. If you believe you are seeing this message in error, then please relog.");
			}

			if (args.length == 0) {
				JoinArenaMenu arenaMenu = new JoinArenaMenu(FFA.getPlugin());
				arenaMenu.show(p);
				return true;
			}
		}
		return false;
	}
}
