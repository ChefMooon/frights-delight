package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class FluidTagGenerator extends FabricTagProvider.FluidTagProvider {
    public FluidTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        registerModTags();
    }

    private void registerModTags() {
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.ROTTEN_FLESH_SYRUP)
                .add(FrightsDelightFluids.ROTTEN_FLESH_SYRUP, FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.SLIMEAPPLE_SYRUP)
                .add(FrightsDelightFluids.SLIMEAPPLE_SYRUP, FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.SPIDEREYE_SYRUP)
                .add(FrightsDelightFluids.SPIDEREYE_SYRUP, FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.GHASTTEAR_SYRUP)
                .add(FrightsDelightFluids.GHASTTEAR_SYRUP, FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.SOUL_BERRY_SYRUP)
                .add(FrightsDelightFluids.SOUL_BERRY_SYRUP, FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.WITHER_BERRY_SYRUP)
                .add(FrightsDelightFluids.WITHER_BERRY_SYRUP, FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP);
        getOrCreateTagBuilder(FrightsDelightTags.Fluids.COBWEB_SYRUP)
                .add(FrightsDelightFluids.COBWEB_SYRUP, FrightsDelightFluids.FLOWING_COBWEB_SYRUP);
    }
}
