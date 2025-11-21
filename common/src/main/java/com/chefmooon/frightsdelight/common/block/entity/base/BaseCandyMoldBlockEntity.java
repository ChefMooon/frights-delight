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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class BaseCandyMoldBlockEntity extends BaseBlockEntity {
    private final int MAX_HARDEN_TIME = 900;
    private int hardenTime;
    private int hardenTimeTotal = MAX_HARDEN_TIME;
    public BaseCandyMoldBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.hardenTime = input.getIntOr("HardenTime", 0);
        this.hardenTimeTotal = input.getIntOr("HardenTimeTotal", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("HardenTime", this.hardenTime);
        output.putInt("HardenTimeTotal", this.hardenTimeTotal);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag compound = new CompoundTag();
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
            blockEntity.hardenTimeTotal = MAX_HARDEN_TIME;
        }

        blockEntity.hardenTime++;
        if (blockEntity.hardenTime < blockEntity.hardenTimeTotal) {
            setChanged();
            return false;
        } else {
            level.playSound(null, pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_HARDEN.get(), SoundSource.BLOCKS, 0.5f, 0.75f);
            level.setBlockAndUpdate(pos, state.setValue(LollipopMoldBlock.HARDENED, Boolean.TRUE));
            blockEntity.hardenTime = 0;
            blockEntity.hardenTimeTotal = 0;
            return true;
        }
    }
}
