package com.chefmooon.frightsdelight.client;

import com.chefmooon.frightsdelight.client.gui.*;
import com.chefmooon.frightsdelight.common.utility.FrightsDelightItemProperties;

public class FrightsDelightClient {
    public static void init() {
        FrightsDelightItemProperties.init();

        FortifiedMindOverlay.init();
        UndeadHungerOverlay.init();
        CobwebbedOverlay.init();
        InfectedOverlay.init();
        SlimedOverlay.init();
        HysteriaOverlay.init();
        ChillsOverlay.init();
    }

    // Temporary until custom texture is solved
    public static class FluidColors {
        public static final int ROTTEN_FLESH_SYRUP = 0xBD5533;
        public static final int SLIMEAPPLE_SYRUP = 0x8CD782;
        public static final int SPIDEREYE_SYRUP = 0x9D1E2D;
        public static final int GHASTTEAR_SYRUP = 0x9FC3C3;
        public static final int SOUL_BERRY_SYRUP = 0x3FCDCD;
        public static final int WITHER_BERRY_SYRUP = 0x342823;
        public static final int COBWEB_SYRUP = 0xF2F4F5;
    }
}
