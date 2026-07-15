package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;

public class LootInjector {

    public static void register() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            ResourceLocation id = key.location();

            if (!id.getPath().startsWith("blocks/")) {
                return;
            }

            String blockName = id.getPath()
                    .replace("blocks/", "");

            if (blockName.contains("ore")) {

                System.out.println(
                        "Ore loot detected: " + blockName
                );

            }

        });
    }
}
