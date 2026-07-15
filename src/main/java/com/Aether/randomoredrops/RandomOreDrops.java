package com.Aether.randomoredrops;

import net.fabricmc.api.ModInitializer;

public class RandomOreDrops implements ModInitializer {

    public static final String MOD_ID =
            "cobblemon_random_ore_drops";


    @Override
    public void onInitialize() {

        LootInjector.register();


        System.out.println(
                "Cobblemon Random Ore Drops loaded!"
        );

    }
}
