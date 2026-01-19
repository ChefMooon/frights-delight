package com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class SoulBerryDrinkableFeastBlock extends DrinkableFeastBlock {
    public SoulBerryDrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get();
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SOUL_BERRY_BUBBLE.get(), random);
    }
}
