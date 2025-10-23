package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class AbstractCandyBasketBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<AbstractCandyBasketBlock> CODEC = simpleCodec(AbstractCandyBasketBlock::new);
    public static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
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
    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return FrightsDelightBlockEntities.getCandyBasketBlockEntity().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof CandyBasketBlockEntity)) return InteractionResult.PASS;
        ItemStack mainHandItem = player.getItemInHand(hand);
        if (!player.isSecondaryUseActive()) {
            if (!mainHandItem.isEmpty() || (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty() && !player.getItemInHand(InteractionHand.OFF_HAND).isEmpty())) {
                if (!mainHandItem.has(DataComponents.FOOD)) return InteractionResult.FAIL;
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
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        ItemStack itemStack = context.getItemInHand();
        ItemContainerContents items =  itemStack.get(DataComponents.CONTAINER);
        if (context.getLevel().getBlockEntity(context.getClickedPos()) instanceof CandyBasketBlockEntity candyBasketBlockEntity && items != null) {
            candyBasketBlockEntity.setItems(items);
        }
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection())
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
    public @NotNull ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        ItemStack itemStack = super.getCloneItemStack(level, pos, state, includeData);
        Optional<?> candyBasket = level.getBlockEntity(pos, FrightsDelightBlockEntities.getCandyBasketBlockEntity());
        if (candyBasket.isPresent() && candyBasket.get() instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            itemStack.applyComponents(candyBasketBlockEntity.collectComponents());
        }
        return itemStack;
    }

    @Override
    public @NotNull BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !candyBasketBlockEntity.isEmpty()) {
                ItemStack itemStack = new ItemStack(this);
                itemStack.applyComponents(blockEntity.collectComponents());
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }
            level.updateNeighborsAt(pos, Blocks.AIR);
        }

        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (stack.get(DataComponents.CONTAINER) != null && level.getBlockEntity(pos) instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
            ItemContainerContents items = stack.get(DataComponents.CONTAINER);
            candyBasketBlockEntity.setItems(items);
        }
        super.setPlacedBy(level, pos, state, placer, stack);
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}
