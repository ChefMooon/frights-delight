package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.data.fabric.builder.CuttingBoardRecipeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
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

        // run once then change common knife tag
//        CuttingBoardRecipeBuilder.create(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET, Ingredient.of(CommonTags.C_TOOLS_KNIVES), Items.PUMPKIN)
//                .output(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "rope")))
//                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.PUMPKIN, FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET)));
//        CuttingBoardRecipeBuilder.create(FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET, Ingredient.of(CommonTags.C_TOOLS_KNIVES), Items.JACK_O_LANTERN)
//                .output(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "rope")))
//                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.JACK_O_LANTERN, FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET)));
//        CuttingBoardRecipeBuilder.create(FrightsDelightItemsImpl.MELON_CANDY_BASKET, Ingredient.of(CommonTags.C_TOOLS_KNIVES), Items.MELON)
//                .output(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "rope")))
//                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.MELON, FrightsDelightItemsImpl.MELON_CANDY_BASKET)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
