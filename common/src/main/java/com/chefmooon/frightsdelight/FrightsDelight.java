package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsDelight {
    public static final String MOD_ID = "frightsdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        Configuration.init();

        FrightsDelightSounds.init();
        FrightsDelightBlocks.init();
        FrightsDelightEffects.init();
        FrightsDelightParticleTypes.init();
        FrightsDelightItems.init();
        FrightsDelightEntityTypes.init();
        FrightsDelightBiomeFeatures.init();
        FrightsDelightPlacementModifiers.init();
    }
}
