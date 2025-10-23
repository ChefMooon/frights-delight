package com.chefmooon.frightsdelight.common;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.ComposterBlock;

public class CommonSetup {

    public static void init() {
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY), 0.3F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY), 0.3F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.ROTTEN_FLESH_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SLIMEAPPLE_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SPIDEREYE_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.GHASTTEAR_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY_RING_CANDY), 0.5F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COBWEB_RING_CANDY), 0.5F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.APPLE_SLIME), 0.65F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SOUL_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_WITHER_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_ROTTEN_FLESH), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SPIDER_EYE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIMEAPPLE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIME), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_COBWEB), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_GHAST_TEAR), 0.85F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.ROTTEN_FLESH_PIE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SLIMEAPPLE_PIE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SPIDEREYE_PIE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.GHASTTEAR_PIE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY_CHEESECAKE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY_CHEESECAKE_SLICE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COBWEB_PIE_SLICE), 0.85F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.ROTTEN_FLESH_PIE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SLIMEAPPLE_PIE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SPIDEREYE_PIE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.GHASTTEAR_PIE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY_CHEESECAKE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY_CHEESECAKE), 1.0F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COBWEB_PIE), 1.0F);

    }
}
