package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightShapes;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.utility.VoxelShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class GlassCupBlock extends Block {
    public static final int MAX_SERVINGS = 3;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, MAX_SERVINGS);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public Supplier<Item> servingItem;
    public ParticleOptions particleData;
    protected final ConcurrentHashMap<Integer, VoxelShape[]> CUP_SHAPES;

    public GlassCupBlock(Supplier<Item> servingItem, Properties properties) {
        this(servingItem, null, properties);
    }

    public GlassCupBlock(Supplier<Item> servingItem, ParticleOptions particleData, Properties properties) {
        super(properties);
        this.servingItem = servingItem;
        this.particleData = particleData;
        CUP_SHAPES = buildShapes();
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 0));
    }

    private static ConcurrentHashMap<Integer, VoxelShape[]> buildShapes() {
        ConcurrentHashMap<Integer, VoxelShape[]> result = new ConcurrentHashMap<>();

        result.put(0, VoxelShapeUtil.getRotatedShapes(FrightsDelightShapes.CUP_NORTH_SERVINGS_1));
        result.put(1, VoxelShapeUtil.getRotatedShapes(FrightsDelightShapes.CUP_NORTH_SERVINGS_2));
        result.put(2, VoxelShapeUtil.getRotatedShapes(FrightsDelightShapes.CUP_NORTH_SERVINGS_3));
        result.put(3, VoxelShapeUtil.getRotatedShapes(FrightsDelightShapes.CUP_NORTH_SERVINGS_4));

        return result;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (level.isClientSide()) {
            if (heldStack.is(CommonTags.C_TOOLS)) {
                return rotate(level, pos, state, player);
            } else if (heldStack.is(servingItem.get())) {
                return addServingFromHand(level, pos, state, player, hand);
            } else if (heldStack.isEmpty()) {
                return removeServingToHand(level, pos, state, player, hand);
            }
        }

        if (heldStack.is(CommonTags.C_TOOLS)) {
            return rotate(level, pos, state, player);
        } else if (heldStack.is(servingItem.get())) {
            return addServingFromHand(level, pos, state, player, hand);
        } else if (heldStack.isEmpty()) {
            return removeServingToHand(level, pos, state, player, hand);
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, SERVINGS);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = state.getValue(SERVINGS);
        return CUP_SHAPES.containsKey(servings) ? CUP_SHAPES.get(servings)[state.getValue(FACING).get2DDataValue()] : Shapes.empty();
    }

    @Override
    public String getDescriptionId() {
        return this.servingItem.get().getDescriptionId();
    }

    protected ItemInteractionResult rotate(Level level, BlockPos pos, BlockState state, Player player) {
        if (player.getBoundingBox().distanceToSqr(pos.getBottomCenter()) < 0.5) return ItemInteractionResult.CONSUME;

        if (level.setBlock(pos, state.setValue(FACING, state.getValue(FACING).getClockWise()), 3)) return ItemInteractionResult.SUCCESS;

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public ItemInteractionResult addServingFromHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getItemInHand(hand);
            level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.6F);
            if (!player.isCreative()) {
                heldItem.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ItemInteractionResult removeServingToHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);
        ItemStack servingItem = new ItemStack(this.servingItem.get());

        if (servings == 0) {
            level.removeBlock(pos, false);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        } else if (servings > 0) {
            level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public void animate(BlockState state, Level level, BlockPos pos, SoundEvent soundEvent, RandomSource random) {
        if (Configuration.drinkableFeastParticles() && particleData != null) {
            int servings = state.getValue(getServingsProperty()) + 1;

            Direction facing = state.getValue(FACING);
            double baseX = pos.getX() + 0.5D;
            double baseY = pos.getY() + 0.5D;
            double baseZ = pos.getZ() + 0.5D;

            for (int i = 0; i < servings; i++) {
                if (random.nextInt(4) == 0) {
                    double spread = 0.3D; // Define spread amount

                    double xOffset = 0, zOffset = 0;

                    // Map the serving index (0-3) to corner positions
                    zOffset = switch (i) {
                        case 0 -> {
                            xOffset = -spread;
                            yield -spread;
                        }
                        case 1 -> {
                            xOffset = spread;
                            yield -spread;
                        }
                        case 2 -> {
                            xOffset = spread;
                            yield spread;
                        }
                        case 3 -> {
                            xOffset = -spread;
                            yield spread;
                        }
                        default -> zOffset;
                    };

                    // Rotate the offsets based on facing direction
                    double rotatedX = 0, rotatedZ = 0;
                    rotatedZ = switch (facing) {
                        case NORTH -> {
                            rotatedX = xOffset;
                            yield zOffset;
                        }
                        case SOUTH -> {
                            rotatedX = -xOffset;
                            yield -zOffset;
                        }
                        case EAST -> {
                            rotatedX = -zOffset;
                            yield xOffset;
                        }
                        case WEST -> {
                            rotatedX = zOffset;
                            yield -xOffset;
                        }
                        default -> rotatedZ;
                    };

                    // Add small random variation
                    double smallVariation = 0.05D;
                    rotatedX += (random.nextDouble() - 0.5D) * smallVariation;
                    rotatedZ += (random.nextDouble() - 0.5D) * smallVariation;

                    level.addParticle(particleData, baseX + rotatedX, baseY + ((1.0 - random.nextDouble()) / 20.0), baseZ + rotatedZ, 0.0, 0.0, 0.0);
                    if (level.random.nextInt(10) == 0) level.playLocalSound(pos, soundEvent, SoundSource.BLOCKS, 0.2F, 0.8F, false);
                }
            }
        }
    }
}
