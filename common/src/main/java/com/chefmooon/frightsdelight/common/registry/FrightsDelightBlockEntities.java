package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.block.entity.RingCandyMoldBlockEntity;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class FrightsDelightBlockEntities {
    public static final ResourceLocation LOLLIPOP_MOLD = blockEntity("lollipop_mold");
    public static final ResourceLocation RING_CANDY_MOLD = blockEntity("ring_candy_mold");
    public static final ResourceLocation CANDY_BASKET = blockEntity("candy_basket");
    private static ResourceLocation blockEntity(String string) {
        return TextUtils.res(string);
    }

    @ExpectPlatform
    public static BlockEntityType<LollipopMoldBlockEntity> getLollipopMoldBlockEntity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static BlockEntityType<RingCandyMoldBlockEntity> getRingCandyMoldBlockEntity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static BlockEntityType<CandyBasketBlockEntity> getCandyBasketBlockEntity() {
        throw new AssertionError();
    }

    public static void init() {
    }
}
