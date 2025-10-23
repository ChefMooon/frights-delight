package com.chefmooon.frightsdelight.common.fluid.fabric;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.material.FlowingFluid;


public class FrDFluidVariantAttributeHandler implements FluidVariantAttributeHandler {
    public static final FrDFluidVariantAttributeHandler INSTANCE = new FrDFluidVariantAttributeHandler();

    protected FrDFluidVariantAttributeHandler() {}

    public Component getName(FluidVariant fluidVariant) {
        return Component.translatable("fluid_type." + BuiltInRegistries.FLUID.getKey(fluidVariant.getFluid() instanceof FlowingFluid flowing ? flowing.getSource() : fluidVariant.getFluid()).toShortLanguageKey());
    }
}
