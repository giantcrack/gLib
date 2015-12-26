package me.giantcrack.glib.io.yml;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class GYMLFile implements GYMLFileTemplate {

    private String name;

    private Plugin p;

    private File file;

    private FileConfiguration fileConfiguration;

    public GYMLFile(String name, Plugin p) {
        this.name = name;
        this.p = p;
    }

    @Override
    public void setup() {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        this.file = new File(p.getDataFolder() , name + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void set(String path, Object value) {
        fileConfiguration.set(path, value);
        save();
    }

    @Override
    public <T> T get(String path) {
        return (T) fileConfiguration.get(path);
    }

    @Override
    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean contains(String path) {
        return fileConfiguration.contains(path);
    }

    @Override
    public ConfigurationSection createConfigurationSection(String path) {
        ConfigurationSection cs = fileConfiguration.createSection(path);
        save();
        return cs;
    }

    @Override
    public Set<String> getConfigurationWithKeys(String path, boolean keys) {
        return fileConfiguration.getConfigurationSection(path).getKeys(keys);
    }

    @Override
    public ConfigurationSection getConfigurationSection(String path) {
        return fileConfiguration.getConfigurationSection(path);
    }

    public String getName() {
        return name;
    }

    public Plugin getP() {
        return p;
    }


    public File getFile() {
        return file;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }
}
