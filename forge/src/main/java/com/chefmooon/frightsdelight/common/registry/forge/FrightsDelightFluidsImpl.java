package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.fluid.FrDFluidConstants;
import com.chefmooon.frightsdelight.common.fluid.forge.FrDFluidType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FrightsDelightFluidsImpl {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, FrightsDelight.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, FrightsDelight.MOD_ID);

    public static final RegistryObject<FluidType> ROTTEN_FLESH_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.ROTTEN_FLESH_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.ROTTEN_FLESH_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.ROTTEN_FLESH_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> ROTTEN_FLESH_SYRUP = FLUIDS.register(FrightsDelightFluids.ROTTEN_FLESH_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.ROTTEN_FLESH_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ROTTEN_FLESH_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.ROTTEN_FLESH_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties ROTTEN_FLESH_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            ROTTEN_FLESH_SYRUP_TYPE,
            ROTTEN_FLESH_SYRUP,
            FLOWING_ROTTEN_FLESH_SYRUP);

    public static final RegistryObject<FluidType> SLIMEAPPLE_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.SLIMEAPPLE_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.SLIMEAPPLE_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.SLIMEAPPLE_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> SLIMEAPPLE_SYRUP = FLUIDS.register(FrightsDelightFluids.SLIMEAPPLE_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.SLIMEAPPLE_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SLIMEAPPLE_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.SLIMEAPPLE_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SLIMEAPPLE_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            SLIMEAPPLE_SYRUP_TYPE,
            SLIMEAPPLE_SYRUP,
            FLOWING_SLIMEAPPLE_SYRUP);

    public static final RegistryObject<FluidType> SPIDEREYE_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.SPIDEREYE_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.SPIDEREYE_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.SPIDEREYE_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> SPIDEREYE_SYRUP = FLUIDS.register(FrightsDelightFluids.SPIDEREYE_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.SPIDEREYE_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SPIDEREYE_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.SPIDEREYE_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SPIDEREYE_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            SPIDEREYE_SYRUP_TYPE,
            SPIDEREYE_SYRUP,
            FLOWING_SPIDEREYE_SYRUP);

    public static final RegistryObject<FluidType> GHASTTEAR_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.GHASTTEAR_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.GHASTTEAR_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.GHASTTEAR_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> GHASTTEAR_SYRUP = FLUIDS.register(FrightsDelightFluids.GHASTTEAR_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.GHASTTEAR_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GHASTTEAR_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.GHASTTEAR_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties GHASTTEAR_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            GHASTTEAR_SYRUP_TYPE,
            GHASTTEAR_SYRUP,
            FLOWING_GHASTTEAR_SYRUP);

    public static final RegistryObject<FluidType> SOUL_BERRY_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.SOUL_BERRY_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.SOUL_BERRY_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.SOUL_BERRY_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> SOUL_BERRY_SYRUP = FLUIDS.register(FrightsDelightFluids.SOUL_BERRY_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.SOUL_BERRY_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SOUL_BERRY_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.SOUL_BERRY_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties SOUL_BERRY_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            SOUL_BERRY_SYRUP_TYPE,
            SOUL_BERRY_SYRUP,
            FLOWING_SOUL_BERRY_SYRUP);

    public static final RegistryObject<FluidType> WITHER_BERRY_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.WITHER_BERRY_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.WITHER_BERRY_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.WITHER_BERRY_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> WITHER_BERRY_SYRUP = FLUIDS.register(FrightsDelightFluids.WITHER_BERRY_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.WITHER_BERRY_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_WITHER_BERRY_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.WITHER_BERRY_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties WITHER_BERRY_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            WITHER_BERRY_SYRUP_TYPE,
            WITHER_BERRY_SYRUP,
            FLOWING_WITHER_BERRY_SYRUP);

    public static final RegistryObject<FluidType> COBWEB_SYRUP_TYPE = FLUID_TYPES.register(FrightsDelightFluids.COBWEB_SYRUP_LOCATION.getPath(),
            () -> new FrDFluidType(FrDFluidConstants.Textures.COBWEB_SYRUP_STILL_TEXTURE, FrDFluidConstants.Textures.COBWEB_SYRUP_FLOWING_TEXTURE));
    public static final RegistryObject<FlowingFluid> COBWEB_SYRUP = FLUIDS.register(FrightsDelightFluids.COBWEB_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Source(FrightsDelightFluidsImpl.COBWEB_SYRUP_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_COBWEB_SYRUP = FLUIDS.register(FrightsDelightFluids.FLOWING_COBWEB_SYRUP_LOCATION.getPath(),
            () -> new ForgeFlowingFluid.Flowing(FrightsDelightFluidsImpl.COBWEB_SYRUP_PROPERTIES));
    public static final ForgeFlowingFluid.Properties COBWEB_SYRUP_PROPERTIES = new ForgeFlowingFluid.Properties(
            COBWEB_SYRUP_TYPE,
            COBWEB_SYRUP,
            FLOWING_COBWEB_SYRUP);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }

    public static void register() {
    }

}
