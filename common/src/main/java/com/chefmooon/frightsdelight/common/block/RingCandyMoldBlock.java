package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RingCandyMoldBlock extends AbstractMoldBlock{
    public RingCandyMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof RingCandyMoldBlockEntity) {
            ItemStack mainHandItem = player.getItemInHand(hand);
            Syrups syrup = state.getValue(SYRUP_TYPE);
            if (!state.getValue(HARDENED)) {
                if (syrup == Syrups.EMPTY && ITEM_TO_SYRUP.containsKey(BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()))) {
                    Syrups newSyrup = ITEM_TO_SYRUP.get(BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()));
                    level.setBlock(pos, state.setValue(SYRUP_TYPE, newSyrup), Block.UPDATE_ALL);
                    level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_FILL.get(), SoundSource.BLOCKS, 0.8f, 1.0f, false);
                    if (!player.getAbilities().instabuild) {
                        mainHandItem.shrink(1);
                        ItemStack dropStack = new ItemStack(Items.GLASS_BOTTLE);
                        if (!player.addItem(dropStack)) {
                            player.drop(dropStack, false);
                        }
                    }
                    return InteractionResult.SUCCESS;
                } else if (mainHandItem.is(Items.GLASS_BOTTLE)) {
                    if (syrup != Syrups.EMPTY && !state.getValue(HARDENED)) {
                        ItemStack dropStack = BuiltInRegistries.ITEM.get(syrup.getSyrupBottleItem())
                                .map(Holder::value).map(ItemStack::new).orElse(ItemStack.EMPTY);
                        if (!player.getAbilities().instabuild) {
                            mainHandItem.shrink(1);
                            if (!player.addItem(dropStack)) {
                                player.drop(dropStack, false);
                            }
                        }
                        level.setBlock(pos, state.setValue(SYRUP_TYPE, Syrups.EMPTY), Block.UPDATE_ALL);
                        level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_DRAIN.get(), SoundSource.BLOCKS, 0.8f, 1.0f, false);
                        return InteractionResult.SUCCESS;
                    }
                }
            } else {
                if (syrup != Syrups.EMPTY) {
                    ItemStack dropStack = BuiltInRegistries.ITEM.get(syrup.getRingCandyItem())
                            .map(Holder::value).map(item -> new ItemStack(item, 4)).orElse(ItemStack.EMPTY);
                    if (!player.getAbilities().instabuild) {
                        if (!player.addItem(dropStack)) {
                            player.drop(dropStack, false);
                        }
                    }
                    level.setBlock(pos, state.setValue(SYRUP_TYPE, Syrups.EMPTY).setValue(HARDENED, false), Block.UPDATE_ALL);
                    level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_COLLECT.get(), SoundSource.BLOCKS, 1.0f, 0.75f, false);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntity) {
        return createTickerHelper(blockEntity, FrightsDelightBlockEntities.getRingCandyMoldBlockEntity(), RingCandyMoldBlockEntity::hardenTick);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return FrightsDelightBlockEntities.getRingCandyMoldBlockEntity().create(pos, state);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        int signal = 0;
        if (state.getValue(SYRUP_TYPE) != Syrups.EMPTY) signal += 6;
        if (state.getValue(HARDENED)) signal += 4;
        return signal;
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        super.affectNeighborsAfterRemoval(state, level, pos, movedByPiston);
    }
}
