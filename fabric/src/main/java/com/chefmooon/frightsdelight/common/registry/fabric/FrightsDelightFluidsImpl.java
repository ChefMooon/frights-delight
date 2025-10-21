package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.fluid.fabric.FrDFluidImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;

public class FrightsDelightFluidsImpl {

    public static void register() {
        FrightsDelightFluids.ROTTEN_FLESH_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP);
        FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.ROTTEN_FLESH_SYRUP);

        FrightsDelightFluids.SLIMEAPPLE_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP);
        FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.SLIMEAPPLE_SYRUP);

        FrightsDelightFluids.SPIDEREYE_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP);
        FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.SPIDEREYE_SYRUP);

        FrightsDelightFluids.GHASTTEAR_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP);
        FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.GHASTTEAR_SYRUP);

        FrightsDelightFluids.SOUL_BERRY_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP);
        FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.SOUL_BERRY_SYRUP);

        FrightsDelightFluids.WITHER_BERRY_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP);
        FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.WITHER_BERRY_SYRUP);

        FrightsDelightFluids.COBWEB_SYRUP = new FrDFluidImpl.Source(() -> FrightsDelightFluids.FLOWING_COBWEB_SYRUP);
        FrightsDelightFluids.FLOWING_COBWEB_SYRUP = new FrDFluidImpl.Flowing(() -> FrightsDelightFluids.COBWEB_SYRUP);
    }
}
