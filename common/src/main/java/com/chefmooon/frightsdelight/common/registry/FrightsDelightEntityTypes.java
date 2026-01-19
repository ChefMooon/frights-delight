package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;

public class FrightsDelightEntityTypes {
    public static final Identifier BONE_SHARD = entityType("bone_shard");

    private static Identifier entityType(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }
}
