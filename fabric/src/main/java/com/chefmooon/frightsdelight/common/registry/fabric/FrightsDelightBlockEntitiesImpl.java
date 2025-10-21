package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FrightsDelightBlockEntitiesImpl {

    public static final BlockEntityType<LollipopMoldBlockEntity> LOLLIPOP_MOLD = registerBlockEntityType(FrightsDelightBlockEntities.LOLLIPOP_MOLD, LollipopMoldBlockEntity::new,
            FrightsDelightBlocksImpl.LOLLIPOP_MOLD);

    public static final BlockEntityType<RingCandyMoldBlockEntity> RING_CANDY_MOLD = registerBlockEntityType(FrightsDelightBlockEntities.RING_CANDY_MOLD, RingCandyMoldBlockEntity::new,
            FrightsDelightBlocksImpl.RING_CANDY_MOLD);

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(ResourceLocation location, FabricBlockEntityTypeBuilder.Factory<T> blockEntitySupplier, Block... blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, location, FabricBlockEntityTypeBuilder.create(blockEntitySupplier, blocks).build(null));
    }

    public static void register() {
    }
}
