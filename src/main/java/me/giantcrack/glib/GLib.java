package me.giantcrack.glib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import me.giantcrack.glib.db.GSQLConnection;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GLib extends JavaPlugin {

    private static GLib instance;

    private GsonBuilder builder;

    private Gson gson;

    //Called before onEnabled
    public GLib() {

    }

    @Override
    public void onEnable() {
        instance = this;
        this.builder = new GsonBuilder();
        //Add type adapters
        this.gson = this.builder.create();
        getCommand("glib").setExecutor(this);
        //new GSQLConnection("localhost",27107,"admin","admin","cows").getConnection();


    }

    public Gson getGson() {
        return gson;
    }

    public GsonBuilder getBuilder() {
        return builder;
    }
    @Override
    public void onDisable() {
        instance = null;
    }

    public static GLib getInstance() {
        return instance;
    }


    //Test Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return true;
    }
}
