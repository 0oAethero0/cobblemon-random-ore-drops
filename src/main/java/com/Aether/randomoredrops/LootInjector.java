package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Random;

public class LootInjector {

    private static final Random RANDOM = new Random();


    public static void register() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {


            if (!Config.enabled) {
                return;
            }


            ResourceLocation id = key.location();


            if (!id.getPath().startsWith("blocks/")) {
                return;
            }


            String blockName =
                    id.getPath()
                            .replace("blocks/", "");


            if (!blockName.contains("ore")) {
                return;
            }


            LootPools.OreTier tier =
                    LootPools.getTier(blockName);


            double chance;


            if (tier == LootPools.OreTier.RARE) {

                chance = Config.rareOreChance;

            } else {

                chance = Config.normalOreChance;

            }


            if (RANDOM.nextDouble() > chance) {
                return;
            }


            int amount;


            if (tier == LootPools.OreTier.RARE) {

                amount =
                        Config.rareMinDrops
                                +
                        RANDOM.nextInt(
                                Config.rareMaxDrops
                                -
                                Config.rareMinDrops
                                + 1
                        );

            } else {

                amount =
                        Config.normalMinDrops
                                +
                        RANDOM.nextInt(
                                Config.normalMaxDrops
                                -
                                Config.normalMinDrops
                                + 1
                        );

            }


            for (int i = 0; i < amount; i++) {


                Item randomItem;


                if (tier == LootPools.OreTier.RARE) {

                    randomItem =
                            CobblemonItemPicker.randomRareItem();

                } else {

                    randomItem =
                            CobblemonItemPicker.randomNormalItem();

                }


                if (randomItem == null) {
                    continue;
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

            }


        });

    }
}
