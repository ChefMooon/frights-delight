package com.chefmooon.frightsdelight.common.block.glassCupBlocks;

import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class WitherBerryGlassCupBlock extends GlassCupBlock {
    public WitherBerryGlassCupBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get();
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_WITHER_BERRY_BUBBLE.get(), random);
    }
}
