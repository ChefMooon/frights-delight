package com.chefmooon.frightsdelight.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.CreativeModeTab;

public class FrightsDelightCreativeTabs {

    @ExpectPlatform
    public static CreativeModeTab getCreativeTab() {
        throw new AssertionError();
    }
}
