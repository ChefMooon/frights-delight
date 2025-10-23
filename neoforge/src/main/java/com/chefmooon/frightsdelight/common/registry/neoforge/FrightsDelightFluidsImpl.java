package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class FrightsDelightFluidsImpl {

    public static final BaseFlowingFluid.Properties ROTTEN_FLESH_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.ROTTEN_FLESH_SYRUP,
            () -> FrightsDelightFluids.ROTTEN_FLESH_SYRUP,
            () -> FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP);
    public static final BaseFlowingFluid.Properties SLIMEAPPLE_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.SLIMEAPPLE_SYRUP,
            () -> FrightsDelightFluids.SLIMEAPPLE_SYRUP,
            () -> FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP);
    public static final BaseFlowingFluid.Properties SPIDEREYE_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.SPIDEREYE_SYRUP,
            () -> FrightsDelightFluids.SPIDEREYE_SYRUP,
            () -> FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP);
    public static final BaseFlowingFluid.Properties GHASTTEAR_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.GHASTTEAR_SYRUP,
            () -> FrightsDelightFluids.GHASTTEAR_SYRUP,
            () -> FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP);
    public static final BaseFlowingFluid.Properties SOUL_BERRY_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.SOUL_BERRY_SYRUP,
            () -> FrightsDelightFluids.SOUL_BERRY_SYRUP,
            () -> FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP);
    public static final BaseFlowingFluid.Properties WITHER_BERRY_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.WITHER_BERRY_SYRUP,
            () -> FrightsDelightFluids.WITHER_BERRY_SYRUP,
            () -> FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP);
    public static final BaseFlowingFluid.Properties COBWEB_SYRUP_PROPERTIES = new BaseFlowingFluid.Properties(
            () -> FrightsDelightFluidTypesImpl.COBWEB_SYRUP,
            () -> FrightsDelightFluids.COBWEB_SYRUP,
            () -> FrightsDelightFluids.FLOWING_COBWEB_SYRUP);


    public static void register() {
        FrightsDelightFluids.ROTTEN_FLESH_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.ROTTEN_FLESH_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.ROTTEN_FLESH_SYRUP_PROPERTIES);

        FrightsDelightFluids.SLIMEAPPLE_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.SLIMEAPPLE_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.SLIMEAPPLE_SYRUP_PROPERTIES);

        FrightsDelightFluids.SPIDEREYE_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.SPIDEREYE_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.SPIDEREYE_SYRUP_PROPERTIES);

        FrightsDelightFluids.GHASTTEAR_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.GHASTTEAR_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.GHASTTEAR_SYRUP_PROPERTIES);

        FrightsDelightFluids.SOUL_BERRY_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.SOUL_BERRY_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.SOUL_BERRY_SYRUP_PROPERTIES);

        FrightsDelightFluids.WITHER_BERRY_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.WITHER_BERRY_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.WITHER_BERRY_SYRUP_PROPERTIES);

        FrightsDelightFluids.COBWEB_SYRUP = new BaseFlowingFluid.Source(FrightsDelightFluidsImpl.COBWEB_SYRUP_PROPERTIES);
        FrightsDelightFluids.FLOWING_COBWEB_SYRUP = new BaseFlowingFluid.Flowing(FrightsDelightFluidsImpl.COBWEB_SYRUP_PROPERTIES);
    }

}
