package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class AbstractCandyBasketBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
//    public static final MapCodec<AbstractCandyBasketBlock> CODEC = simpleCodec(AbstractCandyBasketBlock::new);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.box(4.d, .0d, 4.d, 12.d, 8.d, 12.d);
    private CandyBasketType candyBasketType;
    public AbstractCandyBasketBlock(Properties properties, CandyBasketType type) {
        this(properties);
        this.candyBasketType = type;
    }
    public AbstractCandyBasketBlock(Properties properties) {
        super(properties);
        this.candyBasketType = CandyBasketType.NONE;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE)
        );
    }
//    @Override
//    protected MapCodec<? extends BaseEntityBlock> codec() {
//        return CODEC;
//    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return Objects.requireNonNull(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.CANDY_BASKET)).create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof CandyBasketBlockEntity)) return InteractionResult.PASS;
        ItemStack mainHandItem = player.getItemInHand(hand);
        if (!player.isSecondaryUseActive()) {
            if (!mainHandItem.isEmpty() || (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && !player.getItemInHand(InteractionHand.OFF_HAND).isEmpty())) {
                if (!mainHandItem.isEdible()) return InteractionResult.FAIL; // 1.20.1 mainHandItem.isEdible()
                boolean addItem = addItem(mainHandItem, level, pos);
                if (addItem) {
                    if (!player.getAbilities().instabuild) mainHandItem.split(1);
                    Supplier<SoundEvent> addSound = candyBasketType.getAddSound();
                    if (addSound != null) level.playLocalSound(pos, addSound.get(), SoundSource.BLOCKS, 0.4f, 1.0f, false);
                    return InteractionResult.SUCCESS;
                }
            } else {
                ItemStack removeItem = removeItem(level, pos);
                if (!removeItem.isEmpty()) {
                    if (!player.getAbilities().instabuild) {
                        if (player.getInventory().add(removeItem)) {
                            player.drop(removeItem, false);
                        }
                    }
                    Supplier<SoundEvent> removeSound = candyBasketType.getRemoveSound();
                    if (removeSound != null)
                        level.playLocalSound(pos, removeSound.get(), SoundSource.BLOCKS, 0.4f, 0.6f, false);
                    return InteractionResult.SUCCESS;
                } else {
                    level.playLocalSound(pos, FrightsDelightSounds.BLOCK_CANDY_BASKET_EMPTY.get(), SoundSource.BLOCKS, 0.4f, 0.6f, false);
                }
            }
        }

        return InteractionResult.PASS;
    }

    public CandyBasketType getCandyBasketType() {
        return candyBasketType;
    }

    public static boolean addItem(ItemStack itemStack, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            return candyBasketBlockEntity.addItem(itemStack);
        }
        return false;
    }

    public static ItemStack removeItem(Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            return candyBasketBlockEntity.removeItem();
        }
        return ItemStack.EMPTY;
    }

    public static boolean shuffleInventory(Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            return candyBasketBlockEntity.shuffleInventory();
        }
        return false;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Container container) {
            int count = 0;
            for (int i = 0; i < container.getContainerSize(); i++) {
                if (!container.getItem(i).isEmpty()) count++;
            }
            if (count > 0) {
                return (count * 14) / container.getContainerSize() + 1;
            }
        }
        return 0;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        ItemStack itemStack = super.getCloneItemStack(level, pos, state);
        BlockEntityType<?> blockEntityType = BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.CANDY_BASKET);
        if (blockEntityType != null && level.getBlockEntity(pos) instanceof CandyBasketBlockEntity) { // is instance of check needed?
            level.getBlockEntity(pos, blockEntityType).ifPresent((blockEntity) -> blockEntity.saveToItem(itemStack));
        }
        return itemStack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        CompoundTag compoundTag = BlockItem.getBlockEntityData(stack);
        if (compoundTag != null) {
            if (compoundTag.contains("Items", 9)) {
                NonNullList<ItemStack> nonNullList = NonNullList.withSize(9, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundTag, nonNullList);

                for(ItemStack itemStack : nonNullList) {
                    if (!itemStack.isEmpty()) {
                        tooltip.add(itemStack.getHoverName().copy());
                    }
                }
            }
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !candyBasketBlockEntity.isEmpty()) {
                ItemStack itemStack = new ItemStack(this);
                candyBasketBlockEntity.saveToItem(itemStack);
                if (candyBasketBlockEntity.hasCustomName()) {
                    itemStack.setHoverName(candyBasketBlockEntity.getCustomName());
                }
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }
            level.updateNeighborsAt(pos, Blocks.AIR);
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
                candyBasketBlockEntity.setCustomName(stack.getHoverName());
            }
        }
        super.setPlacedBy(level, pos, state, placer, stack);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CandyBasketBlockEntity) {
                level.updateNeighbourForOutputSignal(pos, state.getBlock());
            }

            super.onRemove(state, level, pos, newState, movedByPiston);
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
