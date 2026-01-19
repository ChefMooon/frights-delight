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

public class RottenFleshDrinkableFeastBlock extends DrinkableFeastBlock {
    public RottenFleshDrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get();
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_ROTTEN_FLESH_BUBBLE.get(), random);
    }
}
