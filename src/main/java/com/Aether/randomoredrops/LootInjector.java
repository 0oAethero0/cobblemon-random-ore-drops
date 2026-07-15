package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

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


            tableBuilder.pool(
                    net.minecraft.world.level.storage.loot.LootPool.lootPool()
                            .add(
                                    LootItem.lootTableItem(randomItem)
                            )
                            .apply(
                                    SetItemCountFunction.setCount(
                                            ConstantValue.exactly(1)
                                    )
                            )
                            .build()
            );

        });
    }
}
