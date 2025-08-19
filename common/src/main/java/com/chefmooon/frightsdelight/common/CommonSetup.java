package com.chefmooon.frightsdelight.common;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.ComposterBlock;

public class CommonSetup {

    public static void init() {
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY).get().value(), 0.3F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY).get().value(), 0.3F);

        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.APPLE_SLIME).get().value(), 0.65F);

        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SOUL_BERRY).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_WITHER_BERRY).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_ROTTEN_FLESH).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SPIDER_EYE).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIMEAPPLE).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIME).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_COBWEB).get().value(), 0.85F);
        CompostingChanceRegistry.INSTANCE.add(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_GHAST_TEAR).get().value(), 0.85F);
    }
}
