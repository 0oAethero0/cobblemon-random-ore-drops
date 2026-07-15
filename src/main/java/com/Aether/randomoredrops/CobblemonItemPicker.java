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
             * HIGH TIER
             *
             * Diamond / Emerald rewards
             */

            if (

                    id.contains("master_ball")

                    || id.contains("ability_patch")

                    || id.contains("ability_capsule")

                    || id.contains("gold_bottle_cap")

                    || id.equals("cobblemon:bottle_cap")

                    // Mega Stones
                    || id.endsWith("ite")
                    || id.contains("ite_")

            ) {

                HIGH_ITEMS.add(item);

                return;

            }





            /*
             * MID TIER
             *
             * Gold / Redstone rewards
             */

            if (

                    id.contains("ultra_ball")

                    || id.contains("great_ball")

                    || id.contains("rare_candy")

                    || id.contains("evolution")

                    || id.contains("tm")

                    || id.contains("vitamin")

                    || id.contains("exp")

            ) {

                MID_ITEMS.add(item);

                return;

            }





            /*
             * BASIC TIER
             *
             * Coal / Copper / Iron rewards
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



        /*
         * Debug HIGH tier rewards
         * Remove later after testing
         */

        for (Item item : HIGH_ITEMS) {

            System.out.println(
                    "HIGH REWARD: "
                            + BuiltInRegistries.ITEM.getKey(item)
            );

        }

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
         * Extremely rare
         */

        if (

                id.contains("master_ball")

                || id.contains("ability_patch")

                || id.endsWith("ite")
                || id.contains("ite_")

        ) {

            return 1;

        }




        /*
         * Rare
         */

        if (

                id.contains("ability_capsule")

                || id.contains("bottle_cap")

                || id.contains("gold_bottle_cap")

        ) {

            return 3;

        }




        /*
         * Normal
         */

        return 20;

    }

}
