package me.giantcrack.glib.io.json;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class GJSONFile implements GJSONFileTemplate {

    private String name;

    private Plugin p;

    private File file;

    public GJSONFile(String name, Plugin p) {
        this.name = name;
        this.p = p;
    }


    //TODO: Reading and writing

    @Override
    public void setup() {
        if (!this.p.getDataFolder().exists()) {
            this.p.getDataFolder().mkdir();
        }
        this.file = new File(this.p.getDataFolder(), this.name + ".json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public Plugin getP() {
        return p;
    }
}
