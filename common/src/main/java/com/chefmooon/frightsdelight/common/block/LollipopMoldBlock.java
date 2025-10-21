package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class LollipopMoldBlock extends AbstractMoldBlock {
    public static final IntegerProperty SHARDS = IntegerProperty.create("shards", 0, 4);
    public LollipopMoldBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(SHARDS, 0)
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(SYRUP_TYPE, Syrups.EMPTY)
                .setValue(HARDENED, Boolean.FALSE)
        );
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SHARDS);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LollipopMoldBlockEntity) {
            ItemStack mainHandItem = player.getItemInHand(hand);
            Syrups syrup = state.getValue(SYRUP_TYPE);
            if (!state.getValue(HARDENED)) {
                if (mainHandItem.is(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD))) {
                    int currentShards = state.getValue(SHARDS);
                    if (currentShards < 4) {
                        level.setBlock(pos, state.setValue(SHARDS, currentShards + 1), Block.UPDATE_ALL);
                        level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_ADD.get(), SoundSource.BLOCKS, 0.2f, 1.6f + 0.2f * currentShards, false);
                        if (!player.getAbilities().instabuild) {
                            mainHandItem.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    }
                } else if (ITEM_TO_SYRUP.containsKey(BuiltInRegistries.ITEM.getKey(mainHandItem.getItem()))) {
                    if (state.getValue(SHARDS) == 4 && syrup == Syrups.EMPTY) {
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
                    } else {
                        if (player.level().isClientSide) {
                            player.displayClientMessage(Component.translatable(this.getDescriptionId() + ".bone_shard_requirement"), true);
                        }
                    }
                    return InteractionResult.SUCCESS;
                } else if (mainHandItem.is(Items.GLASS_BOTTLE)) {
                    if (syrup != Syrups.EMPTY && !state.getValue(HARDENED)) {
                        ItemStack dropStack = new ItemStack(BuiltInRegistries.ITEM.get(syrup.getSyrupBottleItem()));
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
                } else if (mainHandItem.isEmpty()) {
                    int currentShards = state.getValue(SHARDS);
                    if (currentShards > 0) {
                        ItemStack dropStack = new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD), currentShards);
                        if (!player.getAbilities().instabuild) {
                            if (!player.addItem(dropStack)) {
                                player.drop(dropStack, false);
                            }
                        }
                        level.setBlock(pos, state.setValue(SHARDS, 0), Block.UPDATE_ALL);
                        level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_MOLD_REMOVE.get(), SoundSource.BLOCKS, 0.2f + 0.1f * currentShards, 1.6f, false);
                        return InteractionResult.SUCCESS;
                    }
                }
            } else {
                if (state.getValue(SHARDS) == 4 && syrup != Syrups.EMPTY) {
                    ItemStack dropStack = new ItemStack(BuiltInRegistries.ITEM.get(syrup.getLollipopItem()), 4);
                    if (!player.getAbilities().instabuild) {
                        if (!player.addItem(dropStack)) {
                            player.drop(dropStack, false);
                        }
                    }
                    level.setBlock(pos, state.setValue(SYRUP_TYPE, Syrups.EMPTY).setValue(SHARDS, 0).setValue(HARDENED, false), Block.UPDATE_ALL);
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
        BlockEntityType<LollipopMoldBlockEntity> blockEntityType =
                (BlockEntityType<LollipopMoldBlockEntity>) Objects.requireNonNull(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.LOLLIPOP_MOLD));
        return createTickerHelper(blockEntity, blockEntityType, LollipopMoldBlockEntity::hardenTick);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return Objects.requireNonNull(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.LOLLIPOP_MOLD)).create(pos, state);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        int signal = 0;
        int shards = state.getValue(SHARDS);
        if (shards > 0) signal += shards;
        if (state.getValue(SYRUP_TYPE) != Syrups.EMPTY) signal += 2;
        if (state.getValue(HARDENED)) signal += 4;
        return signal;
    }
}
