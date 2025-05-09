package com.chefmooon.frightsdelight.common;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.utility.HolderLookupHelper;
import net.minecraft.world.level.block.ComposterBlock;

public class CommonSetup {

    public static void init() {
        registerCompostables();
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.SOUL_BERRY), 0.3F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.WITHER_BERRY), 0.3F);

        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.APPLE_SLIME), 0.65F);

        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_SOUL_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_WITHER_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_ROTTEN_FLESH), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_SPIDER_EYE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_SLIMEAPPLE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_SLIME), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_COBWEB), 0.85F);
        ComposterBlock.COMPOSTABLES.put(HolderLookupHelper.getItem(FrightsDelightItems.COOKIE_GHAST_TEAR), 0.85F);
    }
}
