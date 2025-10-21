package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightBlockEntitiesImpl {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FrightsDelight.MOD_ID);

    public static final Supplier<BlockEntityType<LollipopMoldBlockEntity>> LOLLIPOP_MOLD = BLOCK_ENTITIES.register(FrightsDelightBlockEntities.LOLLIPOP_MOLD.getPath(),
            () -> BlockEntityType.Builder.of(LollipopMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get()
            ).build(null));

    public static final Supplier<BlockEntityType<RingCandyMoldBlockEntity>> RING_CANDY_MOLD = BLOCK_ENTITIES.register(FrightsDelightBlockEntities.RING_CANDY_MOLD.getPath(),
            () -> BlockEntityType.Builder.of(RingCandyMoldBlockEntity::new,
                    FrightsDelightBlocksImpl.RING_CANDY_MOLD.get()
            ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
