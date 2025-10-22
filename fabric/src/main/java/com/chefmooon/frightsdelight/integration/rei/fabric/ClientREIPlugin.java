package com.chefmooon.frightsdelight.integration.rei.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ClientREIPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(FrightsDelightItemsImpl.SOUL_BERRY), Component.translatable("item.frightsdelight.soul_berry")).lines(TextUtils.getTranslatable("rei.info.soul_berry")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(FrightsDelightItemsImpl.WITHER_BERRY), Component.translatable("item.frightsdelight.wither_berry")).lines(TextUtils.getTranslatable("rei.info.wither_berry")));

        List<ItemLike> lollipopMoldStacks = List.of(
                FrightsDelightItemsImpl.LOLLIPOP_MOLD,
                FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP,
                FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP,
                FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP,
                FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP,
                FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP,
                FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP,
                FrightsDelightItemsImpl.COBWEB_LOLLIPOP
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(lollipopMoldStacks), Component.translatable("block.frightsdelight.lollipop_mold")).lines(TextUtils.getTranslatable("rei.info.lollipop_mold")));

        List<ItemLike> ringCandyMoldStacks = List.of(
                FrightsDelightItemsImpl.RING_CANDY_MOLD,
                FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY,
                FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY,
                FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY,
                FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY,
                FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY,
                FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY,
                FrightsDelightItemsImpl.COBWEB_RING_CANDY
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(ringCandyMoldStacks), Component.translatable("block.frightsdelight.ring_candy_mold")).lines(TextUtils.getTranslatable("rei.info.ring_candy_mold")));

        List<ItemLike> candyBasketStack = List.of(
                FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET,
                FrightsDelightItemsImpl.MELON_CANDY_BASKET
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(candyBasketStack), Component.translatable("block.frightsdelight.pumpkin_candy_basket")).lines(TextUtils.getTranslatable("rei.info.candy_basket")));
    }
}
