package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.handlers.Kit;
import me.nullchips.ffa.utils.ChatUtils;

public class KitCommnad implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(args.length == 0) {
				ChatUtils.message(p, "Kits:");
				for (Kit k : Kit.allKits) {
					ChatUtils.message(p, k.getDisplayName());
				}
				return false;
			}
			
			String id = args[0];
			
			Kit k = new Kit(id);
			
			k.giveKit(p, k);
			ChatUtils.message(p, "You have been given the kit: " + ChatColor.AQUA + k.getId());
			
		}
		
		return false;
	}

}
