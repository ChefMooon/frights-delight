package com.chefmooon.frightsdelight.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.event.fabric.FrightsDelightLootTableEvents;
import com.chefmooon.frightsdelight.common.event.fabric.VillagerEventsImpl;
import com.chefmooon.frightsdelight.common.fabric.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.*;
import net.fabricmc.api.ModInitializer;

public class FrightsDelightImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        FrightsDelight.init();

        FrightsDelightSoundsImpl.register();
        FrightsDelightBlocksImpl.register();
        FrightsDelightEffectsImpl.register();
        FrightsDelightParticleTypesImpl.register();
        FrightsDelightItemsImpl.register();
        FrightsDelightEntityTypesImpl.register();
        FrightsDelightBiomeFeaturesImpl.register();
        FrightsDelightCreativeTabsImpl.register();
        FrightsDelightPlacementModifiersImpl.register();
        FrightsDelightLootTableEvents.registerLootTable();

        VillagerEventsImpl.init();

        CommonSetupImpl.init();

        FrightsDelightBiomeModifiersImpl.init();
    }
}
