package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.threads.ArenaCreation;
import me.nullchips.ffa.utils.ChatUtils;

public class CreateArena implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("createffaarena")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "The console cannot use this command.");
				return false;
			}
			
			Player p = (Player) sender;
			
			if(!p.hasPermission("ffa.create")) {
				ChatUtils.noPermission(p);
				return false;
			}
			
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "Command usage: /createffaarena <id>");
				return false;
			}
			
			String createdArenaId = args[0];
			if(FFA.getPlugin().getConfig().contains("Arenas." + createdArenaId)) {
				ChatUtils.message(p, ChatColor.RED + "That arena already exists! In order to get rid of it, delete it from the config!");
				return true;
			}
			Location createdArenaSpawn = p.getLocation();
			int createdArenaSpawnHeight = p.getLocation().getBlockX()-10;
			
			ArenaCreation.createArena(createdArenaId.trim(), createdArenaSpawnHeight, createdArenaSpawn);
			ChatUtils.message(p, "Arena created! Be sure to go into the config file and change the default display item and the default arena name!");
			
			
			return true;
		}
		return false;
	}

}
