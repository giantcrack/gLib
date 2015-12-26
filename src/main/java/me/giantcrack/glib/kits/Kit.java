package me.giantcrack.glib.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;
import java.util.UUID;

public interface Kit {

    String getName();

    ItemStack getIcon();

    void apply(Player p);

    Set<UUID> getKitUsers();

    String getPermission();

    boolean hasAccess(Player p);
}
