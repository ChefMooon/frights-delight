package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FrightsDelightBlockEntityImpl {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FrightsDelight.MOD_ID);

    public static final Supplier<BlockEntityType<LollipopMoldBlockEntity>> LOLLIPOP_MOLD = BLOCK_ENTITIES.register(FrightsDelightBlockEntities.LOLLIPOP_MOLD.getPath(),
            () -> BlockEntityType.Builder.of(LollipopMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get()
            ).build(null));

    public static final Supplier<BlockEntityType<RingCandyMoldBlockEntity>> RING_CANDY_MOLD = BLOCK_ENTITIES.register(FrightsDelightBlockEntities.RING_CANDY_MOLD.getPath(),
            () -> BlockEntityType.Builder.of(RingCandyMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.RING_CANDY_MOLD.get()
            ).build(null));

    public static final Supplier<BlockEntityType<CandyBasketBlockEntity>> CANDY_BASKET = BLOCK_ENTITIES.register(FrightsDelightBlockEntities.CANDY_BASKET.getPath(),
            () -> BlockEntityType.Builder.of(CandyBasketBlockEntity::new,
                    FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get(),
                    FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get()
//                    FrightsDelightBlocksImpl.CREEPER_CANDY_BASKET.get(),
//                    FrightsDelightBlocksImpl.SKELETON_CANDY_BASKET.get(),
//                    FrightsDelightBlocksImpl.WITHER_SKELETON_CANDY_BASKET.get(),
//                    FrightsDelightBlocksImpl.ZOMBIE_CANDY_BASKET.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
