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

            String id = BuiltInRegistries.ITEM
                    .getKey(item)
                    .toString();


            if (id.startsWith("cobblemon:")) {

                NORMAL_ITEMS.add(item);

                // placeholder rare pool
                // will be customized later
                RARE_ITEMS.add(item);

            }

        });


        System.out.println(
                "Loaded Cobblemon items: "
                + NORMAL_ITEMS.size()
        );

    }


    public static Item randomNormalItem() {

        if (NORMAL_ITEMS.isEmpty()) {
            return null;
        }

        return NORMAL_ITEMS.get(
                RANDOM.nextInt(NORMAL_ITEMS.size())
        );

    }


    public static Item randomRareItem() {

        if (RARE_ITEMS.isEmpty()) {
            return null;
        }

        return RARE_ITEMS.get(
                RANDOM.nextInt(RARE_ITEMS.size())
        );

    }
}
