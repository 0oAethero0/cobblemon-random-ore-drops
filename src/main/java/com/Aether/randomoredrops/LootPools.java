package com.Aether.randomoredrops;

public class LootPools {

    public enum OreTier {

        BASIC,

        MID,

        HIGH

    }


    public static OreTier getTier(String blockName) {


        // HIGH TIER
        if (
                blockName.equals("diamond_ore")
                || blockName.equals("deepslate_diamond_ore")
                || blockName.equals("emerald_ore")
                || blockName.equals("deepslate_emerald_ore")
        ) {

            return OreTier.HIGH;

        }


        // MID TIER
        if (
                blockName.equals("gold_ore")
                || blockName.equals("deepslate_gold_ore")
                || blockName.equals("redstone_ore")
                || blockName.equals("deepslate_redstone_ore")
        ) {

            return OreTier.MID;

        }


        // BASIC TIER
        return OreTier.BASIC;

    }

}
