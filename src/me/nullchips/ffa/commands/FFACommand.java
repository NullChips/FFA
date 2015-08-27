package me.nullchips.ffa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;
import me.nullchips.ffa.utils.ChatUtils;

public class FFACommand implements CommandExecutor {
	
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
			
			if (args.length == 0) {
				ChatUtils.message(p, "Please specify an arena to join!");
				return false;
			}
			
			String id = args[0];
			
			if(!FFA.getPlugin().getConfig().contains("Arenas." + id)) {
				ChatUtils.message(p, "That arena does not exist.");
				return false;
			}
			
			Location l = (Location) FFA.getPlugin().getConfig().get("Arenas."+id+".SpawnLocation");
			
			p.teleport(l);
			
			//TODO Finish this command and create function for multiple arenas with HashMap. - Check color from ChatUtils as well!
			
			ChatUtils.message(p, "You have joined the arena: " + ChatColor.AQUA + id + ChatColor.GOLD + "." );
		}
		return true;
	}

}
