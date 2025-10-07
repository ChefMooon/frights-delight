package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get(), FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get(), FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SPIDEREYE_PIE.get(), FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.GHASTTEAR_PIE.get(), FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get(), holderGetter, recipeOutput);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.COBWEB_PIE.get(), FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get(), holderGetter, recipeOutput);
    }

    private static void pieCuttingRecipeBuilder(Item input, Item output, HolderGetter<Item> holderGetter, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), output, 4)
                .build(exporter);
    }
}
