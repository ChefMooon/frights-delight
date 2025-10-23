package com.chefmooon.frightsdelight.common.block.entity;

import com.chefmooon.frightsdelight.common.block.RingCandyMoldBlock;
import com.chefmooon.frightsdelight.common.block.entity.base.BaseCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RingCandyMoldBlockEntity extends BaseCandyMoldBlockEntity {
    public RingCandyMoldBlockEntity(BlockPos pos, BlockState blockState) {
        // TODO: .isPresent check?
        super(FrightsDelightBlockEntities.getRingCandyMoldBlockEntity(), pos, blockState);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        // do not drop contents
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof RingCandyMoldBlockEntity) {
            if (state.getValue(RingCandyMoldBlock.HARDENED)) {
                NonNullList<ItemStack> contents = NonNullList.create();
                Syrups syrup = state.getValue(RingCandyMoldBlock.SYRUP_TYPE);
                if (syrup != Syrups.EMPTY)
                    BuiltInRegistries.ITEM.get(syrup.getRingCandyItem()).ifPresent(item -> contents.add(new ItemStack(item, 4)));
                Containers.dropContents(level, pos, contents);
            }
        }
        super.preRemoveSideEffects(pos, state);
    }
}
