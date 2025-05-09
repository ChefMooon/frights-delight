package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HolderLookupHelper {

    public static <T> T get(HolderLookup<T> lookup, ResourceKey<T> resourceKey) {
        return lookup.get(resourceKey).get().value();
    }

    public static Item getItem(ResourceLocation resourceLocation) {
        return getItem(ResourceKey.create(Registry.ITEM.key(), resourceLocation));
    }

    public static Item getItem(ResourceKey<Item> resourceKey) {
        return get(HolderLookup.forRegistry(Registry.ITEM), resourceKey);
    }

    public static Block getBlock(ResourceLocation resourceLocation) {
        return getBlock(ResourceKey.create(Registry.BLOCK.key(), resourceLocation));
    }
    public static Block getBlock(ResourceKey<Block> resourceKey) {
        return get(HolderLookup.forRegistry(Registry.BLOCK), resourceKey);
    }

    public static MobEffect getMobEffect(ResourceLocation resourceLocation) {
        return getMobEffect(ResourceKey.create(Registry.MOB_EFFECT.key(), resourceLocation));
    }
    public static MobEffect getMobEffect(ResourceKey<MobEffect> resourceKey) {
        return get(HolderLookup.forRegistry(Registry.MOB_EFFECT), resourceKey);
    }
}
