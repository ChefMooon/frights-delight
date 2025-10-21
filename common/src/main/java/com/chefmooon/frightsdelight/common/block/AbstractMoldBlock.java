package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.block.entity.base.BaseCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.state.properties.FrightsDelightBlockStateProperties;
import com.chefmooon.frightsdelight.common.block.state.properties.SyrupTypeProperty;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class AbstractMoldBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    protected static Map<ResourceLocation, Syrups> ITEM_TO_SYRUP = Map.of(
            Syrups.ROTTEN_FLESH.getSyrupBottleItem(), Syrups.ROTTEN_FLESH,
            Syrups.SLIMEAPPLE.getSyrupBottleItem(), Syrups.SLIMEAPPLE,
            Syrups.SPIDEREYE.getSyrupBottleItem(), Syrups.SPIDEREYE,
            Syrups.GHASTTEAR.getSyrupBottleItem(), Syrups.GHASTTEAR,
            Syrups.SOUL_BERRY.getSyrupBottleItem(), Syrups.SOUL_BERRY,
            Syrups.WITHER_BERRY.getSyrupBottleItem(), Syrups.WITHER_BERRY,
            Syrups.COBWEB.getSyrupBottleItem(), Syrups.COBWEB
    );
//    public static final MapCodec<AbstractMoldBlock> CODEC = simpleCodec(AbstractMoldBlock::new);

    public static final SyrupTypeProperty SYRUP_TYPE = FrightsDelightBlockStateProperties.SYRUP_TYPE;
    public static final BooleanProperty HARDENED = FrightsDelightBlockStateProperties.HARDENED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.box(1.d, .0d, 1.d, 15.d, 3.d, 15.d);
    protected AbstractMoldBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(SYRUP_TYPE, Syrups.EMPTY)
                .setValue(HARDENED, Boolean.FALSE));
    }

//    @Override
//    protected MapCodec<? extends BaseEntityBlock> codec() {
//        return CODEC;
//    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return stateIn;
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SYRUP_TYPE, HARDENED, FACING, WATERLOGGED);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection())
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
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
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BaseCandyMoldBlockEntity) {
                level.updateNeighbourForOutputSignal(pos, state.getBlock());
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (Configuration.candyMoldParticles()) {
            Syrups syrup = state.getValue(SYRUP_TYPE);
            if (syrup != Syrups.EMPTY && !state.getValue(HARDENED)) {
                double d = (double)pos.getX() + 0.5D;
                double e = (double)pos.getY() + 0.2D;
                double f = (double)pos.getZ() + 0.5D;

                if (random.nextInt(4) == 0) {
                    SimpleParticleType particleData = syrup.getParticle() != null ? syrup.getParticle().get() : null;
                    if (particleData != null) {
                        level.addParticle(particleData, d + (random.nextDouble() - 0.5) / 2.0, e + ((1.0 - random.nextDouble()) / 20.0), f + (random.nextDouble() - 0.5) / 2.0, 0.0, 0.0, 0.0);
                        if (syrup.getAnimateSound() != null && level.random.nextInt(10) == 0) level.playLocalSound(pos, syrup.getAnimateSound().get(), SoundSource.BLOCKS, 0.2F, 0.8F, false);
                    }
                }
            }
        }
    }
}
