package com.chefmooon.frightsdelight.common.fluid.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class FrDFluidType extends FluidType {
    private final ResourceLocation FLUID_STILL_TEXTURE;
    private final ResourceLocation FLUID_FLOWING_TEXTURE;

    public FrDFluidType(ResourceLocation stillTexture, ResourceLocation flowingTexture) {
        super(FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH)
        );
        this.FLUID_STILL_TEXTURE = stillTexture;
        this.FLUID_FLOWING_TEXTURE = flowingTexture;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {

            @Override
            public ResourceLocation getStillTexture()
            {
                return FLUID_STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture()
            {
                return FLUID_FLOWING_TEXTURE;
            }
        });
    }
}
