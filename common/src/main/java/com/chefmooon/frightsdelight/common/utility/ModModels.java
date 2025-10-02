package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class ModModels {
    public static final ModelTemplate FLAT_HANDHELD_ITEM_FLIPPED = item("flat_handheld_item_flipped", TextureSlot.LAYER0);
    public static final ModelTemplate FLAT_HANDHELD_ITEM_FLIPPED_THROWING = item("flat_handheld_item_flipped_throwing", TextureSlot.LAYER0);

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(TextUtils.res("block/" + parent)), Optional.empty(), textureSlots);
    }

    private static ModelTemplate item(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(TextUtils.res("item/" + parent)), Optional.empty(), textureSlots);
    }
}
