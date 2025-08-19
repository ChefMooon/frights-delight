package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class FrightsDelightDamageTypes {
    public static final ResourceKey<DamageType> SOUL_BERRY_BUSH = ResourceKey.create(Registries.DAMAGE_TYPE, TextUtils.res("soul_berry_bush"));
    public static final ResourceKey<DamageType> WITHER_BERRY_BUSH = ResourceKey.create(Registries.DAMAGE_TYPE, TextUtils.res("wither_berry_bush"));

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(type));
    }
}
