package me.giantcrack.glib.invs;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Button {

    private ItemStack item;

    private int id;

    public Button(int id, ItemStack item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void onClick(Player p);
}
