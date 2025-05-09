package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FrightsDelightCreativeTabsImpl {
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.create(TextUtils.res(FrightsDelight.MOD_ID))
            .icon(() -> new ItemStack(FrightsDelightItemsImpl.APPLE_SLIME))
            .build();

    public static CreativeModeTab getCreativeTab() {
        return ITEM_GROUP;
    }

    public static void register() {
    }
}
