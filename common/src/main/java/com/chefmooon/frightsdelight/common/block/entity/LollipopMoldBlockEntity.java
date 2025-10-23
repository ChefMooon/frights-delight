package com.chefmooon.frightsdelight.common.block.entity;

import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.block.entity.base.BaseCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LollipopMoldBlockEntity extends BaseCandyMoldBlockEntity {
    public LollipopMoldBlockEntity(BlockPos pos, BlockState blockState) {
        // TODO: .isPresent check?
        super(FrightsDelightBlockEntities.getLollipopMoldBlockEntity(), pos, blockState);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LollipopMoldBlockEntity) {
            NonNullList<ItemStack> contents = NonNullList.create();
            if (!state.getValue(LollipopMoldBlock.HARDENED)) {
                int shards = state.getValue(LollipopMoldBlock.SHARDS);
                ItemStack boneShardStack = BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD)
                        .map(Holder::value).map(item -> new ItemStack(item, shards)).orElse(ItemStack.EMPTY);
                if (shards > 0) contents.add(boneShardStack);
            } else {
                Syrups syrup = state.getValue(LollipopMoldBlock.SYRUP_TYPE);
                if (syrup != Syrups.EMPTY) {
                    BuiltInRegistries.ITEM.get(syrup.getLollipopItem()).ifPresent(item -> contents.add(new ItemStack(item, 4)));
                }

            }
            Containers.dropContents(level, pos, contents);
        }
        super.preRemoveSideEffects(pos, state);
    }
}
