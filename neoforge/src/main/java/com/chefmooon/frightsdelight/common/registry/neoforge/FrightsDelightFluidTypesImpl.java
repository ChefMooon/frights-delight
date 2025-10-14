package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.common.fluid.fabric.FrDFluidType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class FrightsDelightFluidTypesImpl {
    public static final FluidType ROTTEN_FLESH_SYRUP = new FrDFluidType();
    public static final FluidType SLIMEAPPLE_SYRUP = new FrDFluidType();
    public static final FluidType SPIDEREYE_SYRUP = new FrDFluidType();
    public static final FluidType GHASTTEAR_SYRUP = new FrDFluidType();
    public static final FluidType SOUL_BERRY_SYRUP = new FrDFluidType();
    public static final FluidType WITHER_BERRY_SYRUP = new FrDFluidType();
    public static final FluidType COBWEB_SYRUP = new FrDFluidType();

    public static void registerAll() {
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.ROTTEN_FLESH_SYRUP_LOCATION, ROTTEN_FLESH_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.SLIMEAPPLE_SYRUP_LOCATION, SLIMEAPPLE_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.SPIDEREYE_SYRUP_LOCATION, SPIDEREYE_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.GHASTTEAR_SYRUP_LOCATION, GHASTTEAR_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.SOUL_BERRY_SYRUP_LOCATION, SOUL_BERRY_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.WITHER_BERRY_SYRUP_LOCATION, WITHER_BERRY_SYRUP);
        Registry.register(NeoForgeRegistries.FLUID_TYPES, FrightsDelightFluids.COBWEB_SYRUP_LOCATION, COBWEB_SYRUP);
    }
}
