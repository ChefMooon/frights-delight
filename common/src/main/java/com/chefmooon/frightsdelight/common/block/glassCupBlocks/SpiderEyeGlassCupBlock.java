package com.chefmooon.frightsdelight.common.block.glassCupBlocks;

import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class SpiderEyeGlassCupBlock extends GlassCupBlock {
    public SpiderEyeGlassCupBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(TextUtils.res("spider_eye_bubble"));
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SPIDER_EYE_BUBBLE.get(), random);
    }
}
