package com.chefmooon.frightsdelight.common.utility.forge;

import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.FrightsDelightItemProperties;
import net.minecraft.client.renderer.item.ItemProperties;

public class FrightsDelightItemPropertiesImpl {
    public static void addCustomItemProperties() {
        ItemProperties.register(FrightsDelightItemsImpl.BONE_SHARD.get(), FrightsDelightItemProperties.THROWING,
                (stack, level, entity, seed) -> entity == null ? 0.0F : entity.getItemInHand(entity.getUsedItemHand()) == stack && entity.isUsingItem() ? 1.0F : 0.0F);
    }
}
