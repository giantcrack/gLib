package me.giantcrack.glib.utils;

import me.giantcrack.glib.GLib;
import me.giantcrack.glib.io.yml.GYMLFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationUtility {

	private GYMLFile file;

	private FileConfiguration cfg;

	public LocationUtility(GYMLFile file) {
		this.file = file;
		this.cfg = file.getFileConfiguration();
	}
	
	public void saveLocation(String path, Location l) {
		cfg.set(path + ".world", l.getWorld().getName());
		cfg.set(path + ".x", l.getX());
		cfg.set(path + ".y", l.getY());
		cfg.set(path + ".z", l.getZ());
		cfg.set(path + ".pitch", l.getPitch());
		cfg.set(path + ".yaw", l.getYaw());
		GLib.getInstance().saveConfig();
	}
	
	public Location getLocation(String path) {
		String world = cfg.getString(path + ".world");
		double x = cfg.getDouble(path + ".x");
		double y = cfg.getDouble(path + ".y");
		double z = cfg.getDouble(path + ".z");
		float pitch = (float) cfg.getDouble(path + ".pitch");
		float yaw = (float) cfg.getDouble(path + ".yaw");
		Location loc = new Location(Bukkit.getWorld(world), x,y,z);
		loc.setPitch(Float.valueOf(pitch).floatValue());
		loc.setYaw(Float.valueOf(yaw).floatValue());
		return loc;
	}

	public void delLocation(String path) {
		cfg.set(path + ".world", null);
		cfg.set(path + ".x", null);
		cfg.set(path + ".y", null);
		cfg.set(path + ".z", null);
		cfg.set(path + ".pitch", null);
		cfg.set(path + ".yaw", null);
		GLib.getInstance().saveConfig();
	}

}
