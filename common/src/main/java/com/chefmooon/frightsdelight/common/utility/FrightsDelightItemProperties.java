package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.resources.Identifier;

public class FrightsDelightItemProperties {

    public static Identifier THROWING = property("throwing");

    private static Identifier property(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }
}
