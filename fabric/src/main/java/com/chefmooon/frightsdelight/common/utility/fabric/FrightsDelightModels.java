package com.chefmooon.frightsdelight.common.utility.fabric;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class FrightsDelightModels {
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_LEFTOVER = block("template_drink_feast_leftover",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE0 = block("template_drink_feast_stage0",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE1 = block("template_drink_feast_stage1",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE2 = block("template_drink_feast_stage2",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_DRINK_FEAST_STAGE3 = block("template_drink_feast_stage3",
            FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, FrightsDelightTextureSlots.PUNCH_BOWL, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_GLASS_CUP_1 = block("template_glass_cup_1", FrightsDelightTextureSlots.INSIDE, FrightsDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_2 = block("template_glass_cup_2", FrightsDelightTextureSlots.INSIDE, FrightsDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_3 = block("template_glass_cup_3", FrightsDelightTextureSlots.INSIDE, FrightsDelightTextureSlots.CUP);
    public static final ModelTemplate TEMPLATE_GLASS_CUP_4 = block("template_glass_cup_4", FrightsDelightTextureSlots.INSIDE, FrightsDelightTextureSlots.CUP);

    public static final ModelTemplate TEMPLATE_SYRUP = block("template_syrup", TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LOLLIPOP_MOLD = block("template_lollipop_mold", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_LOLLIPOP_MOLD_SYRUP = block("template_lollipop_mold_syrup", FrightsDelightTextureSlots.SYRUP, TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_RING_CANDY_MOLD = block("template_ring_candy_mold", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_RING_CANDY_MOLD_SYRUP = block("template_ring_candy_mold_syrup", FrightsDelightTextureSlots.SYRUP, TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_BLOCK_CANDY_BASKET = block("template_block_candy_basket", FrightsDelightTextureSlots.HANDLE, FrightsDelightTextureSlots.BASKET, TextureSlot.PARTICLE);
    public static final ModelTemplate TEMPLATE_ENTITY_CANDY_BASKET = block("template_entity_candy_basket", FrightsDelightTextureSlots.HANDLE, FrightsDelightTextureSlots.BASKET, TextureSlot.PARTICLE);

    public static final ModelTemplate TEMPLATE_CROP_CROSS = block("template_crop_cross", TextureSlot.CROSS);

    private static ModelTemplate block(String parent, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(TextUtils.res("block/" + parent)), Optional.empty(), textureSlots);
    }
}
