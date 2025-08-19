package com.chefmooon.frightsdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {

    public static final TagKey<Block> C_STORAGE_BLOCKS = getCommonBlockTagKey("storage_blocks");

    public static final TagKey<Block> C_STORAGE_BLOCKS_ROTTEN_FLESH = getCommonBlockTagKey("storage_blocks/rotten_flesh");
    public static final TagKey<Block> C_STORAGE_BLOCKS_BONE = getCommonBlockTagKey("storage_blocks/bone");
    public static final TagKey<Block> C_STORAGE_BLOCKS_PHANTOM_MEMBRANE = getCommonBlockTagKey("storage_blocks/phantom_membrane");
    public static final TagKey<Block> C_STORAGE_BLOCKS_COBWEB = getCommonBlockTagKey("storage_blocks/cobweb");
    public static final TagKey<Block> C_STORAGE_BLOCKS_SPIDER_EYE = getCommonBlockTagKey("storage_blocks/spider_eye");
    public static final TagKey<Block> C_STORAGE_BLOCKS_FERMENTED_SPIDER_EYE = getCommonBlockTagKey("storage_blocks/fermented_spider_eye");
    public static final TagKey<Block> C_STORAGE_BLOCKS_POISONOUS_POTATO = getCommonBlockTagKey("storage_blocks/poisonous_potato");
    public static final TagKey<Block> C_STORAGE_BLOCKS_ROTTEN_TOMATO = getCommonBlockTagKey("storage_blocks/rotten_tomato");

    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM = getCommonItemTagKey("storage_blocks");

    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_ROTTEN_FLESH = getCommonItemTagKey("storage_blocks/rotten_flesh");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_BONE = getCommonItemTagKey("storage_blocks/bone");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_PHANTOM_MEMBRANE = getCommonItemTagKey("storage_blocks/phantom_membrane");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_COBWEB = getCommonItemTagKey("storage_blocks/cobweb");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_SPIDER_EYE = getCommonItemTagKey("storage_blocks/spider_eye");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_FERMENTED_SPIDER_EYE = getCommonItemTagKey("storage_blocks/fermented_spider_eye");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_POISONOUS_POTATO = getCommonItemTagKey("storage_blocks/poisonous_potato");
    public static final TagKey<Item> C_STORAGE_BLOCKS_ITEM_ROTTEN_TOMATO = getCommonItemTagKey("storage_blocks/rotten_tomato");

    public static final TagKey<Item> C_FOODS = getCommonItemTagKey("foods");

    public static final TagKey<Item> C_FOODS_BERRY = getCommonItemTagKey("foods/berry");
    public static final TagKey<Item> C_FOODS_SOUP = getCommonItemTagKey("foods/soup");
    public static final TagKey<Item> C_FOODS_COOKIE = getCommonItemTagKey("foods/cookie");

    public static final TagKey<Item> C_TOOLS = getCommonItemTagKey("tools");
    public static final TagKey<Item> C_TOOLS_KNIFE = getCommonItemTagKey("tools/knife");
    public static final TagKey<Block> C_MINEABLE_KNIFE = getCommonBlockTagKey("mineable/knife");

    public static final TagKey<Item> C_FOODS_VEGETABLE = getCommonItemTagKey("foods/vegetable");

    public static TagKey<Item> getCommonItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }
    public static TagKey<Block> getCommonBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }

}
