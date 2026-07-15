package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Optional;

public class LootInjector {

    public static void register() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {


            ResourceLocation id = key.location();


            if (!id.getPath().startsWith("blocks/")) {
                return;
            }


            String blockName = id.getPath()
                    .replace("blocks/", "");


            if (!blockName.contains("ore")) {
                return;
            }


            Item randomItem =
                    CobblemonItemPicker.randomItem();


            if (randomItem == null) {
                return;
            }


            System.out.println(
                    "Would drop: "
                    + BuiltInRegistries.ITEM
                    .getKey(randomItem)
            );

        });
    }
}
