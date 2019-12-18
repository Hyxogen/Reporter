package com.hyxogen.reporter.io;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class YamlConfig extends Config {

    public YamlConfig(File file) {
        super(file);
    }

    @Override
    public void load() {
        FileConfiguration configuration = new YamlConfiguration();
        try {
            configuration.load(FILE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        Iterator<String> iterator = configuration.getKeys(false).iterator();
        String current = null;
        while(iterator.hasNext() && (current = iterator.next()) != null) {
            put(current.hashCode(), configuration.get(current));
        }
    }
}
