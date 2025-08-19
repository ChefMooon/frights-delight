package com.chefmooon.frightsdelight.common.crafting.condition.fabric;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.crafting.condition.FrDVanillaCrateEnabledCondition;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.RegistryOps;
import org.jetbrains.annotations.Nullable;

public class FrDVanillaCrateEnabledConditionImpl implements ResourceCondition {
    public static final MapCodec<FrDVanillaCrateEnabledConditionImpl> CODEC = MapCodec.unit(new FrDVanillaCrateEnabledConditionImpl());
    public static final ResourceConditionType<FrDVanillaCrateEnabledConditionImpl> TYPE = ResourceConditionType.create(FrDVanillaCrateEnabledCondition.ID, CODEC);

    @Override
    public ResourceConditionType<?> getType() {
        return TYPE;
    }

    @Override
    public boolean test(RegistryOps.@Nullable RegistryInfoLookup registryInfoLookup) {
        return Configuration.isEnableFrDCrates();
    }
}
