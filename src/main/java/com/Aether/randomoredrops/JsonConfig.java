package com.Aether.randomoredrops;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonConfig {

    private static final File FILE =
            new File("config/cobblemon_random_ore_drops.json");


    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();


    public static void load() {

        try {

            if (!FILE.getParentFile().exists()) {
                FILE.getParentFile().mkdirs();
            }


            if (!FILE.exists()) {

                save();

                return;

            }


            FileReader reader =
                    new FileReader(FILE);


            ConfigData data =
                    GSON.fromJson(
                            reader,
                            ConfigData.class
                    );


            reader.close();


            Config.enabled =
                    data.enabled;


            Config.normalOreChance =
                    data.normalOreChance;


            Config.rareOreChance =
                    data.rareOreChance;


            Config.blacklist =
                    data.blacklist;


        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    private static void save() {

        try {

            FileWriter writer =
                    new FileWriter(FILE);


            writer.write(
                    GSON.toJson(
                            new ConfigData()
                    )
            );


            writer.close();


        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    private static class ConfigData {

        boolean enabled = true;


        double normalOreChance = 0.10;


        double rareOreChance = 0.50;


        List<String> blacklist =
                new ArrayList<>();

    }
}
