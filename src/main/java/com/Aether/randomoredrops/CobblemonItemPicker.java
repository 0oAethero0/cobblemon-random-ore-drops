package com.Aether.randomoredrops;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CobblemonItemPicker {

    private static final List<Item> NORMAL_ITEMS =
            new ArrayList<>();

    private static final List<Item> RARE_ITEMS =
            new ArrayList<>();

    private static final Random RANDOM =
            new Random();


    public static void loadItems() {

        NORMAL_ITEMS.clear();
        RARE_ITEMS.clear();


        BuiltInRegistries.ITEM.forEach(item -> {

            String id =
                    BuiltInRegistries.ITEM
                            .getKey(item)
                            .toString();


            if (!id.startsWith("cobblemon:")) {
                return;
            }


            if (Config.blacklist.contains(id)) {
                return;
            }


            NORMAL_ITEMS.add(item);


            if (
                    id.contains("master")
                    || id.contains("ability")
                    || id.contains("patch")
                    || id.contains("capsule")
                    || id.contains("legend")
            ) {

                RARE_ITEMS.add(item);

            }

        });


        System.out.println(
                "Normal Cobblemon items loaded: "
                + NORMAL_ITEMS.size()
        );


        System.out.println(
                "Rare Cobblemon items loaded: "
                + RARE_ITEMS.size()
        );

    }


    public static Item randomNormalItem() {

        if (NORMAL_ITEMS.isEmpty()) {
            return null;
        }


        return NORMAL_ITEMS.get(
                RANDOM.nextInt(
                        NORMAL_ITEMS.size()
                )
        );

    }


    public static Item randomRareItem() {

        if (RARE_ITEMS.isEmpty()) {

            return randomNormalItem();

        }


        return RARE_ITEMS.get(
                RANDOM.nextInt(
                        RARE_ITEMS.size()
                )
        );

    }
}
