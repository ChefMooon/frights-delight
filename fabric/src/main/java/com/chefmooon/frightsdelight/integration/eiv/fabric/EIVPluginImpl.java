package com.chefmooon.frightsdelight.integration.eiv.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import de.crafty.eiv.common.api.IExtendedItemViewIntegration;
import de.crafty.eiv.common.api.recipe.ItemView;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.integration.eiv.info.InfoServerRecipe;
import vectorwing.farmersdelight.integration.eiv.info.InfoViewRecipe;

import java.util.ArrayList;
import java.util.List;

public class EIVPluginImpl implements IExtendedItemViewIntegration {
    @Override
    public void onIntegrationInitialize() {
        ItemView.registerRecipeWrapper(InfoServerRecipe.TYPE, modRecipe -> {
            ArrayList<InfoViewRecipe> infoRecipes = new ArrayList<>();

            infoRecipes.add(new InfoViewRecipe((new ItemStack(FrightsDelightItemsImpl.SOUL_BERRY.get())), "frightsdelight.rei.info.soul_berry"));
            infoRecipes.add(new InfoViewRecipe((new ItemStack(FrightsDelightItemsImpl.WITHER_BERRY.get())), "frightsdelight.rei.info.wither_berry"));

            List<ItemStack> lollipopMoldStacks = List.of(
                    new ItemStack(FrightsDelightItemsImpl.LOLLIPOP_MOLD.get()),
                    new ItemStack(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP.get()),
                    new ItemStack(FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get())
            );
            infoRecipes.add(new InfoViewRecipe(lollipopMoldStacks, "frightsdelight.rei.info.lollipop_mold"));


            List<ItemStack> ringCandyMoldStacks = List.of(
                    new ItemStack(FrightsDelightItemsImpl.RING_CANDY_MOLD.get()),
                    new ItemStack(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY.get()),
                    new ItemStack(FrightsDelightItemsImpl.COBWEB_RING_CANDY.get())
            );
            infoRecipes.add(new InfoViewRecipe(ringCandyMoldStacks, "frightsdelight.rei.info.ring_candy_mold"));

            List<ItemStack> candyBasketStack = List.of(
                    new ItemStack(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET.get()),
                    new ItemStack(FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET.get()),
                    new ItemStack(FrightsDelightItemsImpl.MELON_CANDY_BASKET.get())
            );
            infoRecipes.add(new InfoViewRecipe(candyBasketStack, "frightsdelight.rei.info.candy_basket"));

            return  infoRecipes;
        });
    }
}
