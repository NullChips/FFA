package me.nullchips.ffa;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.nullchips.ffa.commands.CreateArena;
import me.nullchips.ffa.commands.FFACommand;
import me.nullchips.ffa.listeners.PlayerDeath;
import me.nullchips.ffa.listeners.PlayerJoin;
import me.nullchips.ffa.utils.ArenaManager;
import me.nullchips.ffa.utils.KitManager;
import me.nullchips.ffa.utils.SettingsManager;

public class FFA extends JavaPlugin {
	
	private static SettingsManager settings;
	private static Plugin pl;
	
	public static ArenaManager arenaManager;
	public static KitManager kitManager;
	
	public static SettingsManager getSettings() {
		return settings;
	}

	public void onEnable() {
		pl = this;
	    settings = new SettingsManager(pl);
		
		settings.setup(pl);
		
		arenaManager = new ArenaManager();
		kitManager = new KitManager();
		
		getCommand("createffaarena").setExecutor(new CreateArena());
		getCommand("ffa").setExecutor(new FFACommand());
		
		registerEvents(this, new PlayerJoin());
		registerEvents(this, new PlayerDeath());
	}

	public void onDisable() {
		pl = null;
	}

	public static Plugin getPlugin() {
		return pl;
	}

	public static ArrayList<String> allArenas = new ArrayList<String>();	

	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}

	}
}

//TODO Change name of plugin in plugin.yml file.
