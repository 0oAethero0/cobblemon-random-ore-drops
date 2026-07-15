package com.Aether.randomoredrops;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;


public class LootInjector {


    public static void register() {


        LootTableEvents.MODIFY.register(
                (key, tableBuilder, source, registries) -> {


                    if (!Config.enabled) {
                        return;
                    }


                    ResourceLocation id =
                            key.location();


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



                    List<Item> items;


                    int minDrops;

                    int maxDrops;



                    switch (tier) {


                        case HIGH -> {

                            items =
                                    CobblemonItemPicker.getHighItems();

                            minDrops =
                                    Config.rareMinDrops;

                            maxDrops =
                                    Config.rareMaxDrops;

                        }



                        case MID -> {

                            items =
                                    CobblemonItemPicker.getMidItems();

                            minDrops =
                                    Config.normalMinDrops;

                            maxDrops =
                                    Config.normalMaxDrops;

                        }



                        default -> {

                            items =
                                    CobblemonItemPicker.getBasicItems();

                            minDrops =
                                    Config.normalMinDrops;

                            maxDrops =
                                    Config.normalMaxDrops;

                        }

                    }



                    if (items.isEmpty()) {
                        return;
                    }




                    LootPool.Builder pool =
                            LootPool.lootPool();



                    for (Item item : items) {


                        pool.add(

                                LootItem.lootTableItem(item)
                                        .setWeight(
                                                CobblemonItemPicker.getWeight(item)
                                        )

                        );

                    }




                    pool.setRolls(

                            UniformGenerator.between(
                                    minDrops,
                                    maxDrops
                            )

                    );



                    tableBuilder.pool(
                            pool.build()
                    );


                }
        );

    }

}
