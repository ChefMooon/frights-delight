package com.chefmooon.frightsdelight.common.block.entity;

import com.chefmooon.frightsdelight.common.block.entity.base.BaseCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockState;

public class RingCandyMoldBlockEntity extends BaseCandyMoldBlockEntity {
    public RingCandyMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.RING_CANDY_MOLD).get().value(), pos, blockState);
    }
}
