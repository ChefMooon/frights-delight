package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.BONE), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), FrightsDelightItemsImpl.BONE_SHARD.get(), 2)
                .addResultWithChance(FrightsDelightItemsImpl.BONE_SHARD.get(), 0.5F)
                .build(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_SHARD.get()));

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.CLAY), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get())
                .build(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.CLAY), Ingredient.of(Items.GLASS_BOTTLE), FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get())
                .build(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get()));

        Item rope = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "rope")).get().value();
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), Items.PUMPKIN)
                .addResult(rope)
                .build(recipeOutput, RecipeProvider.getConversionRecipeName(Items.PUMPKIN, FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), Items.JACK_O_LANTERN)
                .addResult(rope)
                .build(recipeOutput, RecipeProvider.getConversionRecipeName(Items.JACK_O_LANTERN, FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET.get()));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FrightsDelightItemsImpl.MELON_CANDY_BASKET.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), Items.MELON)
                .addResult(rope)
                .build(recipeOutput, RecipeProvider.getConversionRecipeName(Items.MELON, FrightsDelightItemsImpl.MELON_CANDY_BASKET.get()));

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
                .build(exporter, RecipeProvider.getConversionRecipeName(output, input));
    }
}
