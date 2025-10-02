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
}
