package de.emptyWorld.main.sellShop;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigUtil {
    public ConfigUtil() {
    }

    public static FileConfiguration loadYaml(JavaPlugin instance, String path) {
        if(instance == null) {
            throw new IllegalArgumentException("Instance of the plugin is null!");
        } else if(path != null && !path.equals("")) {
            if(!path.endsWith(".yml")) {
                path = path + ".yml";
            }

            boolean tab = path.toLowerCase().contains("tabs" + File.separator);
            File file = new File(instance.getDataFolder(), path);
            if(file.isDirectory()) {
                file.delete();
            }

            if(!file.exists()) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Can't find file \"" + path + "\"");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Creating some one for you...");

                try {
                    instance.saveResource(path, true);
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Completed!");
                } catch (Exception var7) {
                    if(!tab) {
                        instance.getLogger().log(Level.SEVERE, "Failed to load resourse " + path);
                        return null;
                    }

                    try {
                        file.createNewFile();
                        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Completed!");
                        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "File will be empty Fill it yourself!");
                        return YamlConfiguration.loadConfiguration(file);
                    } catch (IOException var6) {
                        return null;
                    }
                }
            }

            return YamlConfiguration.loadConfiguration(file);
        } else {
            throw new IllegalArgumentException("Path can not be null or empty!");
        }
    }
}
