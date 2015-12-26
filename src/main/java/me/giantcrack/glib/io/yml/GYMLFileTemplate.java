package me.giantcrack.glib.io.yml;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public interface GYMLFileTemplate {

    void setup();

    void set(String path, Object value);

    <T> T get(String path);

    void save();

    boolean contains(String path);

    ConfigurationSection createConfigurationSection(String path);

    ConfigurationSection getConfigurationSection(String path);

    Set<String> getConfigurationWithKeys(String path, boolean keys);

}
