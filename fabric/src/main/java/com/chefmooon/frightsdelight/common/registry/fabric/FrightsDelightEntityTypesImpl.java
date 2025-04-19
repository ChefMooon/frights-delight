package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.entity.fabric.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEntityTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class FrightsDelightEntityTypesImpl {

    public static final Supplier<EntityType<BoneShardEntityImpl>> BONE_SHARD = registerEntityType(FrightsDelightEntityTypes.BONE_SHARD, BuiltInRegistries.ENTITY_TYPE,
            () -> (EntityType.Builder.<BoneShardEntityImpl>of(BoneShardEntityImpl::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(FrightsDelightEntityTypes.BONE_SHARD.getPath()))
    );

    public static <R, T extends R> Supplier<T> registerEntityType(ResourceLocation resourceLocation, Registry<R> registry, Supplier<T> supplier) {
        T object = supplier.get();
        Registry.register(registry, resourceLocation, object);
        return () -> object;
    }

    public static void register() {
    }
}
