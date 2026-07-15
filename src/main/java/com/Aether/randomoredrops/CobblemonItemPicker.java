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

                    id.equals("cobblemon:master_ball")

                    || id.equals("cobblemon:ability_patch")

                    || id.equals("cobblemon:ability_capsule")

                    || id.equals("cobblemon:bottle_cap")

                    || id.equals("cobblemon:gold_bottle_cap")

                    || id.equals("cobblemon:eviolite")

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

                    || id.contains("vitamin")

                    || id.contains("exp")

                    || id.contains("tm")

                    || id.contains("held")

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
         * TEMPORARY DEBUG
         *
         * Finds possible Mega Stone names
         */

        BuiltInRegistries.ITEM.forEach(item -> {


            String id =
                    BuiltInRegistries.ITEM
                            .getKey(item)
                            .toString();



            if (

                    id.contains("mega")

                    || id.contains("stone")

                    || id.contains("charizard")

                    || id.contains("lucario")

                    || id.contains("gengar")

                    || id.contains("venusaur")

                    || id.contains("blastoise")

            ) {

                System.out.println(
                        "POSSIBLE SPECIAL ITEM: "
                                + id
                );

            }


        });



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



        if (

                id.equals("cobblemon:master_ball")

                || id.equals("cobblemon:ability_patch")

        ) {

            return 1;

        }



        if (

                id.equals("cobblemon:ability_capsule")

                || id.contains("bottle_cap")

        ) {

            return 3;

        }



        return 20;

    }

}
