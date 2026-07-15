package com.Aether.randomoredrops;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CobblemonItemPicker {

    private static final List<Item> COBBLEMON_ITEMS =
            new ArrayList<>();

    private static final Random RANDOM =
            new Random();


    public static void loadItems() {

        COBBLEMON_ITEMS.clear();


        BuiltInRegistries.ITEM.forEach(item -> {

            String id = BuiltInRegistries.ITEM
                    .getKey(item)
                    .toString();


            if (id.startsWith("cobblemon:")) {

                COBBLEMON_ITEMS.add(item);

            }

        });


        System.out.println(
                "Loaded "
                + COBBLEMON_ITEMS.size()
                + " Cobblemon items!"
        );

    }


    public static Item randomItem() {

        if (COBBLEMON_ITEMS.isEmpty()) {

            return null;

        }


        return COBBLEMON_ITEMS.get(
                RANDOM.nextInt(COBBLEMON_ITEMS.size())
        );

    }
}
