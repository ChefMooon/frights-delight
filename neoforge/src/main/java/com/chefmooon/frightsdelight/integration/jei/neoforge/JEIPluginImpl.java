package com.chefmooon.frightsdelight.integration.jei.neoforge;

import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.integration.jei.JEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class JEIPluginImpl implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return JEIPlugin.ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(new ItemStack(FrightsDelightItemsImpl.SOUL_BERRY.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.soul_berry"));
        registration.addIngredientInfo(new ItemStack(FrightsDelightItemsImpl.WITHER_BERRY.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.wither_berry"));

        List<ItemStack> lollipopMoldStacks = List.of(
                FrightsDelightItemsImpl.LOLLIPOP_MOLD.get().getDefaultInstance(),
                FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP.get().getDefaultInstance(),
                FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get().getDefaultInstance()
        );
        registration.addIngredientInfo(lollipopMoldStacks, VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.lollipop_mold"));

        List<ItemStack> ringCandyMoldStacks = List.of(
                FrightsDelightItemsImpl.RING_CANDY_MOLD.get().getDefaultInstance(),
                FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY.get().getDefaultInstance(),
                FrightsDelightItemsImpl.COBWEB_RING_CANDY.get().getDefaultInstance()
        );
        registration.addIngredientInfo(ringCandyMoldStacks, VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.ring_candy_mold"));

        List<ItemStack> candyBasketStack = List.of(
                FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET.get().getDefaultInstance(),
                FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET.get().getDefaultInstance(),
                FrightsDelightItemsImpl.MELON_CANDY_BASKET.get().getDefaultInstance()
        );
        registration.addIngredientInfo(candyBasketStack, VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.candy_basket"));
    }
}
