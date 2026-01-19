package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.FlowingFluid;

public class FrightsDelightFluids {
    public static Identifier ROTTEN_FLESH_SYRUP_LOCATION = fluid("rotten_flesh_syrup");
    public static Identifier FLOWING_ROTTEN_FLESH_SYRUP_LOCATION = fluid("flowing_rotten_flesh_syrup");
    public static Identifier SLIMEAPPLE_SYRUP_LOCATION = fluid("slimeapple_syrup");
    public static Identifier FLOWING_SLIMEAPPLE_SYRUP_LOCATION = fluid("flowing_slimeapple_syrup");
    public static Identifier SPIDEREYE_SYRUP_LOCATION = fluid("spidereye_syrup");
    public static Identifier FLOWING_SPIDEREYE_SYRUP_LOCATION = fluid("flowing_spidereye_syrup");
    public static Identifier GHASTTEAR_SYRUP_LOCATION = fluid("ghasttear_syrup");
    public static Identifier FLOWING_GHASTTEAR_SYRUP_LOCATION = fluid("flowing_ghasttear_syrup");
    public static Identifier SOUL_BERRY_SYRUP_LOCATION = fluid("soul_berry_syrup");
    public static Identifier FLOWING_SOUL_BERRY_SYRUP_LOCATION = fluid("flowing_soul_berry_syrup");
    public static Identifier WITHER_BERRY_SYRUP_LOCATION = fluid("wither_berry_syrup");
    public static Identifier FLOWING_WITHER_BERRY_SYRUP_LOCATION = fluid("flowing_wither_berry_syrup");
    public static Identifier COBWEB_SYRUP_LOCATION = fluid("cobweb_syrup");
    public static Identifier FLOWING_COBWEB_SYRUP_LOCATION = fluid("flowing_cobweb_syrup");

    public static FlowingFluid ROTTEN_FLESH_SYRUP;
    public static FlowingFluid FLOWING_ROTTEN_FLESH_SYRUP;
    public static FlowingFluid SLIMEAPPLE_SYRUP;
    public static FlowingFluid FLOWING_SLIMEAPPLE_SYRUP;
    public static FlowingFluid SPIDEREYE_SYRUP;
    public static FlowingFluid FLOWING_SPIDEREYE_SYRUP;
    public static FlowingFluid GHASTTEAR_SYRUP;
    public static FlowingFluid FLOWING_GHASTTEAR_SYRUP;
    public static FlowingFluid SOUL_BERRY_SYRUP;
    public static FlowingFluid FLOWING_SOUL_BERRY_SYRUP;
    public static FlowingFluid WITHER_BERRY_SYRUP;
    public static FlowingFluid FLOWING_WITHER_BERRY_SYRUP;
    public static FlowingFluid COBWEB_SYRUP;
    public static FlowingFluid FLOWING_COBWEB_SYRUP;

    private static Identifier fluid(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
        register();

        Registry.register(BuiltInRegistries.FLUID, ROTTEN_FLESH_SYRUP_LOCATION, ROTTEN_FLESH_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_ROTTEN_FLESH_SYRUP_LOCATION, FLOWING_ROTTEN_FLESH_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, SLIMEAPPLE_SYRUP_LOCATION, SLIMEAPPLE_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_SLIMEAPPLE_SYRUP_LOCATION, FLOWING_SLIMEAPPLE_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, SPIDEREYE_SYRUP_LOCATION, SPIDEREYE_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_SPIDEREYE_SYRUP_LOCATION, FLOWING_SPIDEREYE_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, GHASTTEAR_SYRUP_LOCATION, GHASTTEAR_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_GHASTTEAR_SYRUP_LOCATION, FLOWING_GHASTTEAR_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, SOUL_BERRY_SYRUP_LOCATION, SOUL_BERRY_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_SOUL_BERRY_SYRUP_LOCATION, FLOWING_SOUL_BERRY_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, WITHER_BERRY_SYRUP_LOCATION, WITHER_BERRY_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_WITHER_BERRY_SYRUP_LOCATION, FLOWING_WITHER_BERRY_SYRUP);

        Registry.register(BuiltInRegistries.FLUID, COBWEB_SYRUP_LOCATION, COBWEB_SYRUP);
        Registry.register(BuiltInRegistries.FLUID, FLOWING_COBWEB_SYRUP_LOCATION, FLOWING_COBWEB_SYRUP);
    }

    @ExpectPlatform
    public static void register() {
        throw new AssertionError();
    }
}
