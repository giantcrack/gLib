package me.giantcrack.glib.kits;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class KitManager {

    private static KitManager ourInstance = new KitManager();

    public static KitManager getInstance() {
        return ourInstance;
    }

    private KitManager() {
    }

    private Map<String, Kit> kits = new HashMap<>();


    public Kit getKit(String name) {
        Kit kit = kits.get(name);

        if (kit == null) {
            return null;
        }

        return kit;
    }

    public Kit getKit(Player p) {
        for (Kit kit : kits.values()) {
            if (kit.getKitUsers().contains(p.getUniqueId())) {
                return kit;
            }
        }
        return null;
    }

    public void registerKit(String name, Kit kit) {
        kits.put(name,kit);
    }
}
