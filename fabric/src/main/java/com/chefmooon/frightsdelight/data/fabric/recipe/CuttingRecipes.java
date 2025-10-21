package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.data.fabric.builder.CuttingBoardRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class CuttingRecipes {
    public static void register(Consumer<FinishedRecipe> exporter) {
//        CuttingBoardRecipeBuilder.create(Items.CLAY, Ingredient.of(CommonTags.C_TOOLS_KNIVES), FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD)
//                .save(exporter, suffix(RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD))); // run once then change common knife tag
        CuttingBoardRecipeBuilder.create(Items.CLAY, Ingredient.of(Items.GLASS_BOTTLE), FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD)
                .save(exporter, suffix(RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
