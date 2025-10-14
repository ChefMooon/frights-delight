package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.*;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class FrightsDelight {
    public static final String MOD_ID = "frightsdelight";

    public static void init() {
        Configuration.init();

        FrightsDelightSounds.init();
        FrightsDelightBlocks.init();
        FrightsDelightEffects.init();
        FrightsDelightParticleTypes.init();
        FrightsDelightItems.init();
        FrightsDelightBlockEntities.init();
        FrightsDelightEntityTypes.init();
        FrightsDelightBiomeFeatures.init();
        FrightsDelightPlacementModifiers.init();
    }
    @ExpectPlatform
    public static void loggerInfo(String s) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String findVersion() {
        throw new AssertionError();
    }

}
