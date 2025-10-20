package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;

public class FrightsDelightBlockEntities {
    public static final ResourceLocation LOLLIPOP_MOLD = blockEntity("lollipop_mold");
    public static final ResourceLocation RING_CANDY_MOLD = blockEntity("ring_candy_mold");
    public static final ResourceLocation CANDY_BASKET = blockEntity("candy_basket");
    private static ResourceLocation blockEntity(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }
}
