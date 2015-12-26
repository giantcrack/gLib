package me.giantcrack.glib.invs;

import com.google.common.collect.ImmutableSet;
import me.giantcrack.glib.GLib;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public class Gui implements Listener {

    private String name;

    private int size;

    private Set<Button> buttons;

    public Gui(String name, int size) {
        this.name = name;
        this.size = size;
        this.buttons = new HashSet<>();
        Bukkit.getPluginManager().registerEvents(this, GLib.getInstance());
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (!e.getInventory().getName().equals(name)) return;

        e.setCancelled(true);

        Player p = (Player)e.getWhoClicked();
        Button button = getButton(e.getRawSlot());

        if (button == null) {
            return;
        }

        button.onClick(p);
    }

    public void add(Button button) {
        buttons.add(button);
    }

    public Button getButton(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                return button;
            }
        }
        return null;
    }

    public void remove(int id) {
        for (Button button : buttons) {
            if (button.getId() == id) {
                buttons.remove(button);
            }
        }
    }

    public void updateInventory(Player p, boolean perplayer) {
        open(p,perplayer);
        p.updateInventory();
    }

    public void open(Player p, boolean perplayer) {
        if (perplayer) {
            Inventory inv = Bukkit.createInventory(p,this.size,this.name);

            int count = 0;
            for (Button button : buttons) {
                inv.addItem(button.getItem());
                button.setId(count);
                count++;
            }

            p.openInventory(inv);

        } else {
            Inventory inv = Bukkit.createInventory(null,this.size,this.name);

            int count = 0;
            for (Button button : buttons) {
                inv.addItem(button.getItem());
                button.setId(count);
                count++;
            }

            p.openInventory(inv);
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Button> getButtons() {
        return ImmutableSet.copyOf(this.buttons);
    }

    public void setButtons(Set<Button> buttons) {
        this.buttons = buttons;
    }
}

