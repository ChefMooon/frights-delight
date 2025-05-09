package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FrightsDelightCreativeTabsImpl {

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(FrightsDelight.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FrightsDelightItemsImpl.APPLE_SLIME.get());
        }
    };

    public static CreativeModeTab getCreativeTab() {
        return ITEM_GROUP;
    }

    public static void register() {
    }
}
