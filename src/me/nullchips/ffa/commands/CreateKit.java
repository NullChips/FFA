package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.utils.ChatUtils;

public class CreateKit implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("createkit")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command!");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(!p.hasPermission("ffa.createkit")) {
				ChatUtils.noPermission(p);
				return false;
			}
			
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "Command usage: /createkit <id>");
				return false;
			}
			
			String id = args[0].trim();
			
			if(FFA.getPlugin().getConfig().contains("Kits." + id)) {
				ChatUtils.message(p, ChatColor.RED + "That kit already exists! In order to get rid of it, delete it from the config!");
				return false;
			}
			
			FFA.getPlugin().getConfig().set("Kits." + id + ".DisplayName", id);
			FFA.getPlugin().getConfig().set //TODO Find out how to set integer list.
			
		}
		return false;
	}

}
