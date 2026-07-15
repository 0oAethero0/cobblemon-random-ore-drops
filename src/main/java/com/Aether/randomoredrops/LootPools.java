package com.Aether.randomoredrops;

public class LootPools {

    public enum OreTier {

        NORMAL,

        RARE

    }


    public static OreTier getTier(String blockName) {


        if (blockName.equals("diamond_ore")
                || blockName.equals("deepslate_diamond_ore")
                || blockName.equals("emerald_ore")
                || blockName.equals("deepslate_emerald_ore")) {

            return OreTier.RARE;

        }


        return OreTier.NORMAL;

    }
}
