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
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(FrightsDelightItemsImpl.SOUL_BERRY.get())), Component.translatable("item.frightsdelight.soul_berry")).lines(TextUtils.getTranslatable("rei.info.soul_berry")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(FrightsDelightItemsImpl.WITHER_BERRY.get())), Component.translatable("item.frightsdelight.wither_berry")).lines(TextUtils.getTranslatable("rei.info.wither_berry")));

        List<ItemLike> lollipopMoldStacks = List.of(
                FrightsDelightItemsImpl.LOLLIPOP_MOLD.get(),
                FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get(),
                FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get(),
                FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get(),
                FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get(),
                FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP.get(),
                FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP.get(),
                FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get()
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(lollipopMoldStacks), Component.translatable("block.frightsdelight.lollipop_mold")).lines(TextUtils.getTranslatable("rei.info.lollipop_mold")));

        List<ItemLike> ringCandyMoldStacks = List.of(
                FrightsDelightItemsImpl.RING_CANDY_MOLD.get(),
                FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get(),
                FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get(),
                FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get(),
                FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get(),
                FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY.get(),
                FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY.get(),
                FrightsDelightItemsImpl.COBWEB_RING_CANDY.get()
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(ringCandyMoldStacks), Component.translatable("block.frightsdelight.ring_candy_mold")).lines(TextUtils.getTranslatable("rei.info.ring_candy_mold")));

        List<ItemLike> candyBasketStack = List.of(
                FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET.get(),
                FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET.get(),
                FrightsDelightItemsImpl.MELON_CANDY_BASKET.get()
        );
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(candyBasketStack), Component.translatable("block.frightsdelight.pumpkin_candy_basket")).lines(TextUtils.getTranslatable("rei.info.candy_basket")));
    }
}
