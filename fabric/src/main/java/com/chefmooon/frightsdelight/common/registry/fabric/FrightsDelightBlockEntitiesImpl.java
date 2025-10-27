package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FrightsDelightBlockEntitiesImpl {

    public static final BlockEntityType<LollipopMoldBlockEntity> LOLLIPOP_MOLD = registerBlockEntity(FrightsDelightBlockEntities.LOLLIPOP_MOLD,
            BlockEntityType.Builder.of(LollipopMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.LOLLIPOP_MOLD
            ));

    public static final BlockEntityType<RingCandyMoldBlockEntity> RING_CANDY_MOLD = registerBlockEntity(FrightsDelightBlockEntities.RING_CANDY_MOLD,
            BlockEntityType.Builder.of(RingCandyMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.RING_CANDY_MOLD
            ));

    public static final BlockEntityType<CandyBasketBlockEntity> CANDY_BASKET = registerBlockEntity(FrightsDelightBlockEntities.CANDY_BASKET,
            BlockEntityType.Builder.of(CandyBasketBlockEntity::new,
                    FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET,
                    FrightsDelightBlocksImpl.JACK_O_LANTERN_CANDY_BASKET,
                    FrightsDelightBlocksImpl.MELON_CANDY_BASKET
//                    FrightsDelightBlocksImpl.CREEPER_CANDY_BASKET,
//                    FrightsDelightBlocksImpl.SKELETON_CANDY_BASKET,
//                    FrightsDelightBlocksImpl.WITHER_SKELETON_CANDY_BASKET,
//                    FrightsDelightBlocksImpl.ZOMBIE_CANDY_BASKET
            ));


    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation location, BlockEntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, location, builder.build(null));
    }

    public static void register() {
    }
}
