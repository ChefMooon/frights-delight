package com.chefmooon.frightsdelight.common.block.entity.base;

import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BaseCandyMoldBlockEntity extends BaseBlockEntity {
    private int hardenTime;
    private int hardenTimeTotal = 900;
    public BaseCandyMoldBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        this.hardenTime = tag.getIntOr("HardenTime", 0);
        this.hardenTimeTotal = tag.getIntOr("HardenTimeTotal", 0);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt("HardenTime", this.hardenTime);
        tag.putInt("HardenTimeTotal", this.hardenTimeTotal);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compound = new CompoundTag();
        super.saveAdditional(compound, provider);
        compound.putInt("HardenTime", this.hardenTime);
        compound.putInt("HardenTimeTotal", this.hardenTimeTotal);

        return compound;
    }

    public static void hardenTick(Level level, BlockPos pos, BlockState state, BaseCandyMoldBlockEntity baseCandyMoldBlockEntity) {
        boolean changed = false;

        Syrups syrup = state.getValue(LollipopMoldBlock.SYRUP_TYPE);
        if (syrup != Syrups.EMPTY && !state.getValue(LollipopMoldBlock.HARDENED)) {
            changed = baseCandyMoldBlockEntity.processHardening(level, pos, state, baseCandyMoldBlockEntity);
        }
        if (syrup == Syrups.EMPTY) {
            if (baseCandyMoldBlockEntity.hardenTime != 0) {
                baseCandyMoldBlockEntity.hardenTime = 0;
                changed = true;
            }
        }

        if (changed) {
            baseCandyMoldBlockEntity.setChanged();
        }
    }

    private boolean processHardening(Level level, BlockPos pos, BlockState state, BaseCandyMoldBlockEntity blockEntity) {
        if (blockEntity.hardenTimeTotal == 0) {
            blockEntity.hardenTimeTotal = 200;
        }

        blockEntity.hardenTime++;
        if (blockEntity.hardenTime < blockEntity.hardenTimeTotal) {
            setChanged();
            return false;
        } else {
            level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_HARDEN.get(), SoundSource.BLOCKS, 0.5f, 0.75f, false);
            level.setBlockAndUpdate(pos, state.setValue(LollipopMoldBlock.HARDENED, Boolean.TRUE));
            blockEntity.hardenTime = 0;
            blockEntity.hardenTimeTotal = 0;
            return true;
        }
    }
}
