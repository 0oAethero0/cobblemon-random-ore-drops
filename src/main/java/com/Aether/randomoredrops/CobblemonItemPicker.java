package com.Aether.randomoredrops;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CobblemonItemPicker {


    private static final List<Item> BASIC_ITEMS =
            new ArrayList<>();

    private static final List<Item> MID_ITEMS =
            new ArrayList<>();

    private static final List<Item> HIGH_ITEMS =
            new ArrayList<>();


    /*
     * TRUE HIGH TIER REWARDS
     * Mega Stones will be added here once confirmed.
     */
    private static final Set<String> HIGH_ITEM_IDS = Set.of(

            "cobblemon:master_ball",

            "cobblemon:ability_patch",
            "cobblemon:ability_capsule",

            "cobblemon:bottle_cap",
            "cobblemon:gold_bottle_cap"

    );


    /*
     * MID TIER REWARDS
     */
    private static final Set<String> MID_ITEM_IDS = Set.of(

            "cobblemon:ultra_ball",
            "cobblemon:great_ball",

            "cobblemon:rare_candy"

    );



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
             */

            if (HIGH_ITEM_IDS.contains(id)) {


                HIGH_ITEMS.add(item);

                return;

            }





            /*
             * MID TIER
             */

            if (MID_ITEM_IDS.contains(id)) {


                MID_ITEMS.add(item);

                return;

            }





            /*
             * EVERYTHING ELSE
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
         * Jackpot rewards
         */

        if (
                id.equals("cobblemon:master_ball")
                || id.equals("cobblemon:ability_patch")
                || id.equals("cobblemon:gold_bottle_cap")
        ) {

            return 1;

        }



        /*
         * Rare but slightly more common
         */

        if (
                id.equals("cobblemon:ability_capsule")
                || id.equals("cobblemon:bottle_cap")
        ) {

            return 3;

        }



        /*
         * Normal rewards
         */

        return 20;

    }

}
