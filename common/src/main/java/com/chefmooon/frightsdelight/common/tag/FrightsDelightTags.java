package com.chefmooon.frightsdelight.common.tag;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class FrightsDelightTags {
    public static final TagKey<Block> SOUL_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("soul_berry_bush_grow_condition");
    public static final TagKey<Block> WITHER_BERRY_BUSH_GROW_CONDITIION = getFrightsDelightBlockTagKey("wither_berry_bush_grow_condition");

    public static TagKey<Item> getFrightsDelightItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(FrightsDelight.MOD_ID, path));
    }
    public static TagKey<Block> getFrightsDelightBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(FrightsDelight.MOD_ID, path));
    }

    public static final TagKey<Biome> WILD_SOUL_BERRY_BUSH_WHITELIST = getFrightsDelightBiomeTag("wild_soul_berry_bush_whitelist");
    public static final TagKey<Biome> WILD_SOUL_BERRY_BUSH_BLACKLIST = getFrightsDelightBiomeTag("wild_soul_berry_bush_blacklist");

    private static TagKey<Biome> getFrightsDelightBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, FrightsDelight.res(path));
    }

    public static class Fluids {
        public static final TagKey<Fluid> ROTTEN_FLESH_SYRUP = fluidTag("soul_berry_syrup");
        public static final TagKey<Fluid> SLIMEAPPLE_SYRUP = fluidTag("slimeapple_syrup");
        public static final TagKey<Fluid> SPIDEREYE_SYRUP = fluidTag("spidereye_syrup");
        public static final TagKey<Fluid> GHASTTEAR_SYRUP = fluidTag("ghasttear_syrup");
        public static final TagKey<Fluid> SOUL_BERRY_SYRUP = fluidTag("soul_berry_syrup");
        public static final TagKey<Fluid> WITHER_BERRY_SYRUP = fluidTag("wither_berry_syrup");
        public static final TagKey<Fluid> COBWEB_SYRUP = fluidTag("cobweb_syrup");

        private static TagKey<Fluid> fluidTag(String path) {
            return TagKey.create(Registries.FLUID, TextUtils.res(path));
        }
    }
}
