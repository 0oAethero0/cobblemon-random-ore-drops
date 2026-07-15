package com.Aether.randomoredrops;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class CobblemonItemPicker {

    private static final List<Item> BASIC_ITEMS =
            new ArrayList<>();

    private static final List<Item> MID_ITEMS =
            new ArrayList<>();

    private static final List<Item> HIGH_ITEMS =
            new ArrayList<>();


    public static void loadItems() {

        BASIC_ITEMS.clear();
        MID_ITEMS.clear();
        HIGH_ITEMS.clear();


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


            /*
             * HIGH TIER ITEMS
             * Mega Stones and special rewards
             */

            if (
                    id.contains("master_ball")
                    || id.contains("ability_patch")
                    || id.contains("ability_capsule")
                    || id.contains("gold_bottle_cap")
                    || id.contains("bottle_cap")
                    || id.contains("keystone")
                    || id.contains("legend")
                    || id.endsWith("ite")
                    || id.contains("ite_")
            ) {

                HIGH_ITEMS.add(item);

                return;
            }



            /*
             * MID TIER ITEMS
             */

            if (
                    id.contains("ultra")
                    || id.contains("rare")
                    || id.contains("evolution")
                    || id.contains("stone")
                    || id.contains("tm")
                    || id.contains("held")
            ) {

                MID_ITEMS.add(item);

                return;
            }



            /*
             * BASIC ITEMS
             */

            BASIC_ITEMS.add(item);


        });



        System.out.println(
                "Basic Cobblemon items loaded: "
                        + BASIC_ITEMS.size()
        );


        System.out.println(
                "Mid Cobblemon items loaded: "
                        + MID_ITEMS.size()
        );


        System.out.println(
                "High Cobblemon items loaded: "
                        + HIGH_ITEMS.size()
        );

    }



    public static List<Item> getBasicItems() {

        return BASIC_ITEMS;

    }



    public static List<Item> getMidItems() {

        return MID_ITEMS;

    }



    public static List<Item> getHighItems() {

        return HIGH_ITEMS;

    }



    public static int getWeight(Item item) {


        String id =
                BuiltInRegistries.ITEM
                        .getKey(item)
                        .toString();



        /*
         * Jackpot items
         */

        if (
                id.endsWith("ite")
                || id.contains("ite_")
                || id.contains("ability_patch")
                || id.contains("master_ball")
                || id.contains("gold_bottle_cap")
        ) {

            return 1;

        }



        if (
                id.contains("ability_capsule")
                || id.contains("bottle_cap")
                || id.contains("keystone")
        ) {

            return 2;

        }



        return 20;

    }

}
