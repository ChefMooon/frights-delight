package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.resources.ResourceLocation;

public class FrightsDelightItemProperties {

    public static ResourceLocation THROWING = property("throwing");

    private static ResourceLocation property(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }
}
