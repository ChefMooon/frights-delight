package com.chefmooon.frightsdelight.common.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FrightsDelightShapes {

    public static final VoxelShape CUP_NORTH_SERVINGS_1 = Shapes.or(
            Block.box(.0d, 7.d, .0d, 7.d, 8.d, 7.d),
            Block.box(1.d, .0d, 1.d, 6.d, 7.d, 6.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_2 = Shapes.or(
            CUP_NORTH_SERVINGS_1,
            Block.box(9.d, 7.d, .0d, 16.d, 8.d, 7.d),
            Block.box(10.d, .0d, 1.d, 15.d, 7.d, 6.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_3 = Shapes.or(
            CUP_NORTH_SERVINGS_2,
            Block.box(9.d, 7.d, 9.d, 16.d, 8.d, 16.d),
            Block.box(10.d, .0d, 10.d, 15.d, 7.d, 15.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_4 = Shapes.or(
            CUP_NORTH_SERVINGS_3,
            Block.box(.0d, 7.d, 9.d, 7.d, 8.d, 16.d),
            Block.box(1.d, .0d, 10.d, 6.d, 7.d, 15.d)
    );
}
