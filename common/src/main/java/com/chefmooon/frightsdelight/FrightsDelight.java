package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsDelight {
    public static final String MOD_ID = "frightsdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

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
        FrightsDelightAdvancements.register();
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
