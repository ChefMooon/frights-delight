package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.data.fabric.builder.CookingPotRecipeJsonBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;

import java.util.List;
import java.util.function.Consumer;

public class CookingRecipes {

    public static void register(Consumer<FinishedRecipe> recipeOutput) {
        syrupRecipe(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE, Items.ROTTEN_FLESH, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE, FrightsDelightItemsImpl.APPLE_SLIME, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE, Items.SPIDER_EYE, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE, Items.GHAST_TEAR, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE, FrightsDelightItemsImpl.SOUL_BERRY, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE, FrightsDelightItemsImpl.WITHER_BERRY, recipeOutput);
        syrupRecipe(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE, Items.COBWEB, recipeOutput);
    }

    private static void syrupRecipe(Item output, Item mainIngredient, Consumer<FinishedRecipe> recipeOutput) {
        CookingPotRecipeJsonBuilder.create(output, 1, 400, 1.0F, nonNullList())
                .input(mainIngredient, 3)
                .input(Items.SUGAR, 2)
                .input(Items.WATER_BUCKET, 1)
                .unlockedByAny(mainIngredient, Items.SUGAR, Items.WATER_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }

    public static NonNullList<Ingredient> nonNullList(Ingredient ... ingredients) {
        NonNullList<Ingredient> newList = NonNullList.create();
        newList.addAll(List.of(ingredients));
        return newList;
    }
}
