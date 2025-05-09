package com.chefmooon.frightsdelight.common.world.forge;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeModifiers;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightBiomeFeaturesImpl;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightBiomeModifiersImpl;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.common.world.configuration.WildBushConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

import java.util.List;

public class FrightsDelightWildBushGeneration {
    public static Holder<ConfiguredFeature<WildBushConfiguration, ?>> FEATURE_PATCH_WILD_SOUL_BERRY_BUSH;
    public static Holder<PlacedFeature> PATCH_WILD_SOUL_BERRY_BUSH;

    public static void registerWildBushGeneration() {
        FEATURE_PATCH_WILD_SOUL_BERRY_BUSH = register(FrightsDelightBiomeModifiers.PATCH_WILD_SOUL_BERRY_BUSHES,
                FrightsDelightBiomeFeaturesImpl.WILD_BUSH.get(), wildBushConfiguration(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), Blocks.SOUL_LANTERN, BlockPredicate.matchesTag(new BlockPos(0, -1, 0), BlockTags.SOUL_SPEED_BLOCKS)));

        PATCH_WILD_SOUL_BERRY_BUSH = registerPlacement(FrightsDelightBiomeModifiers.PATCH_WILD_SOUL_BERRY_BUSHES,
                FEATURE_PATCH_WILD_SOUL_BERRY_BUSH, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    }

    public static WildBushConfiguration wildBushConfiguration(Block primaryBlock, Block secondaryBlock, BlockPredicate plantedOn) {
        return new WildBushConfiguration(64, 6, 3, WildCropGeneration.plantBlockConfig(primaryBlock, plantedOn),
                WildCropGeneration.plantBlockConfig(secondaryBlock, plantedOn), null);
    }

    static Holder<PlacedFeature> registerPlacement(ResourceLocation id, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(Holder.hackyErase(feature), List.of(modifiers)));
    }

    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(ResourceLocation id, F feature, FC featureConfig) {
        return register(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, featureConfig));
    }

    private static <V extends T, T> Holder<V> register(Registry<T> registry, ResourceLocation id, V value) {
        return (Holder<V>) BuiltinRegistries.<T>register(registry, id, value);
    }
}
