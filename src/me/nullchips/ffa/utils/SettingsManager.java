package me.nullchips.ffa.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {
   
    Plugin p;
    FileConfiguration config;
    File cfile;
    
    public SettingsManager (Plugin pl) {
        this.p = pl;
    }
   
    public void setup(Plugin p) {
            config = p.getConfig();
            p.saveDefaultConfig();
            saveConfig();
    }
   
    public FileConfiguration getConfig() {
            return config;
    }
   
    public void saveConfig() {
    	p.saveConfig();
    }
   
    public void reloadConfig() {
            config = YamlConfiguration.loadConfiguration(cfile);
    }
   
    public PluginDescriptionFile getDesc() {
            return p.getDescription();
    }

}
