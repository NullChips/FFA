package me.nullchips.ffa.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.nullchips.ffa.FFA;

public class PlayerStatsFileUtils {

	public void createFile(Player p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p.getUniqueId().toString() + ".yml");
		if (!pFile.exists())
			try {
				pFile.createNewFile();
				FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
				pConfig.set("User", p.getUniqueId().toString());
				pConfig.set("Kills", Integer.valueOf(0));
				pConfig.set("Deaths", Integer.valueOf(0));
				pConfig.set("Points", Integer.valueOf(0));
				pConfig.save(pFile);
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//****************************//

	public String getPlayerName(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		String name = pConfig.getString("User");
		return name;
	}

	//****************************//

	public boolean fileExists(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(),  p + ".yml");
		if (pFile.exists()) {
			return true;
		}
		return false;
	}

	//****************************//

	public Integer getKills(String p)
	{
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		int kills = pConfig.getInt("Kills");
		return Integer.valueOf(kills);
	}

	//****************************//

	public void addKill(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		pConfig.set("Kills", Integer.valueOf(pConfig.getInt("Kills") + 1));
		try {
			pConfig.save(pFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//****************************//

	public Integer getDeaths(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		int deaths = pConfig.getInt("Deaths");
		return Integer.valueOf(deaths);
	}

	//****************************//

	public void addDeath(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		pConfig.set("Deaths", Integer.valueOf(pConfig.getInt("Deaths") + 1));
		try {
			pConfig.save(pFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//****************************//

	public Integer getPoints(String p) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		int Points = pConfig.getInt("Points");
		return Integer.valueOf(Points);
	}

	//****************************//

	public void setPoints(String p, int newAmount) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		pConfig.set("Points", Integer.valueOf(newAmount));
		try {
			pConfig.save(pFile);
		} catch (Exception e) {
		}
	}

	//****************************//

	public void addPoints(String p, int amountAdded) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		pConfig.set("Points", Integer.valueOf(pConfig.getInt("Points") + amountAdded));
		try {
			pConfig.save(pFile);
		} catch (Exception e) {
		}
	}

	//****************************//

	public void takePoints(String p, int amountTaken) {
		File pFile = new File(FFA.getPlugin().getDataFolder(), p + ".yml");
		FileConfiguration pConfig = YamlConfiguration.loadConfiguration(pFile);
		int PointsCurrent = pConfig.getInt("Points");
		if (PointsCurrent - amountTaken >= 0) {
			int newAmount = PointsCurrent - amountTaken;
			pConfig.set("Points", Integer.valueOf(newAmount));
		}
		try {
			pConfig.save(pFile);
		} catch (Exception e) {
		}

	}
}


