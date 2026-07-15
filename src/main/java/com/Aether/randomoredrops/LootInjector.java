package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;

public class LootInjector {

    public static void register() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            Identifier id = key.getValue();

            // Only modify block loot tables
            if (!id.getPath().startsWith("blocks/")) {
                return;
            }

            String blockName = id.getPath()
                    .replace("blocks/", "");


            // Temporary test: detect ores
            if (blockName.contains("ore")) {

                System.out.println(
                        "Ore loot detected: " + blockName
                );

            }

        });
    }
}
