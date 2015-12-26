package me.giantcrack.glib.utils;

import com.avaje.ebean.text.json.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import me.giantcrack.glib.GLib;
import me.giantcrack.glib.serializers.ItemSerializer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Type;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder setName(String s) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(s);
        item.setItemMeta(meta);
        return this;
    }


    public ItemBuilder addToLore(String s) {
        ItemMeta meta = item.getItemMeta();
        List<String> currentLore = meta.getLore();
        currentLore.add(s);
        meta.setLore(currentLore);
        return this;
    }

    public String serialize() {
        return GLib.getInstance().getGson().toJson(this.item);
    }

    public ItemBuilder addToLore(String... s) {
        ItemMeta meta = item.getItemMeta();
        List<String> currentLore = meta.getLore();
        for (String toAdd : s) {
            currentLore.add(toAdd);
        }
        meta.setLore(currentLore);
        return this;
    }

    public ItemBuilder addToLore(List<String> listOfStrings) {
        ItemMeta meta = item.getItemMeta();
        List<String> currentLore = meta.getLore();
        currentLore.addAll(listOfStrings);
        meta.setLore(currentLore);
        return this;
    }

    public ItemStack getItem() {
        return item;
    }

    public ItemBuilder setItem(ItemStack item) {
        this.item.setType(item.getType());
        item.setAmount(item.getAmount());
        return this;
    }
}
