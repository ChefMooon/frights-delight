package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.crafting.CookingPotBookCategory;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput recipeOutput) {

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.APPLE_SLIME.get(), 1, 100, 1.0F)
                .addIngredient(Items.SLIME_BALL)
                .addIngredient(Items.APPLE)
                .unlockedByAnyIngredient(Items.SLIME_BALL, Items.APPLE)
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.APPLE_SLIME.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.UNDEAD_KEBAB.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.ROTTEN_FLESH)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(Items.SPIDER_EYE)
                .unlockedByAnyIngredient(Items.ROTTEN_FLESH, Items.GHAST_TEAR, Items.SPIDER_EYE, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNDEAD_KEBAB.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.ROTTEN_FLESH, 2)
                .unlockedByAnyIngredient(Items.ROTTEN_FLESH, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.SPIDER_EYE, 3)
                .unlockedByAnyIngredient(Items.SPIDER_EYE, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.SLIME_BALL, 3)
                .unlockedByAnyIngredient(Items.SLIME_BALL, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(FrightsDelightItemsImpl.APPLE_SLIME.get(), 2)
                .unlockedByAnyIngredient(FrightsDelightItemsImpl.APPLE_SLIME.get(), FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.WEB_ON_STICK.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.COBWEB, 2)
                .unlockedByAnyIngredient(Items.COBWEB, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.WEB_ON_STICK.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(Items.GHAST_TEAR, 3)
                .unlockedByAnyIngredient(Items.GHAST_TEAR, FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(FrightsDelightItemsImpl.SOUL_BERRY.get(), 2)
                .unlockedByAnyIngredient(FrightsDelightItemsImpl.SOUL_BERRY.get(), FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get(), 1, 100, 1.0F, FrightsDelightItemsImpl.BONE_SHARD.get())
                .addIngredient(FrightsDelightItemsImpl.WITHER_BERRY.get(), 2)
                .unlockedByAnyIngredient(FrightsDelightItemsImpl.WITHER_BERRY.get(), FrightsDelightItemsImpl.BONE_SHARD.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.MONSTER_MASH.get(), 1, 100, 1.0F, Items.BOWL)
                .addIngredient(Items.GHAST_TEAR)
                .addIngredient(Items.SPIDER_EYE, 2)
                .addIngredient(Items.ROTTEN_FLESH)
                .unlockedByAnyIngredient(Items.SPIDER_EYE, Items.SPIDER_EYE, Items.ROTTEN_FLESH)
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.MONSTER_MASH.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get(), 1, 75, 2.0F, Items.BOWL)
                .addIngredient(Items.SLIME_BALL, 2)
                .addIngredient(ModItems.RAW_PASTA.get())
                .unlockedByAnyIngredient(FrightsDelightItemsImpl.SOUL_BERRY.get())
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get()));

        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), Items.ROTTEN_FLESH, recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), Items.SPIDER_EYE, recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), FrightsDelightItemsImpl.APPLE_SLIME.get(), recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_COBWEB.get(), Items.COBWEB, recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), Items.GHAST_TEAR, recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), recipeOutput);
        punchRecipe(holderGetter, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), FrightsDelightItemsImpl.WITHER_BERRY.get(), recipeOutput);

        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get(), Items.ROTTEN_FLESH, recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get(), Items.SPIDER_EYE, recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get(), FrightsDelightItemsImpl.APPLE_SLIME.get(), recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_SLIME.get(), Items.SLIME_BALL, recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_COBWEB.get(), Items.COBWEB, recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get(), Items.GHAST_TEAR, recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), recipeOutput);
        soupRecipe(holderGetter, FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get(), FrightsDelightItemsImpl.WITHER_BERRY.get(), recipeOutput);

        syrupRecipe(holderGetter, FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE.get(), Items.ROTTEN_FLESH, recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE.get(), FrightsDelightItemsImpl.APPLE_SLIME.get(), recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE.get(), Items.SPIDER_EYE, recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE.get(), Items.GHAST_TEAR, recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE.get(), FrightsDelightItemsImpl.WITHER_BERRY.get(), recipeOutput);
        syrupRecipe(holderGetter, FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE.get(), Items.COBWEB, recipeOutput);

    }

    private static void punchRecipe(HolderGetter<Item> holderGetter, Item output, Item mainIngredient, RecipeOutput recipeOutput) {
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, output, 4, 200, 1.0F, Items.GLASS_BOTTLE)
                .addIngredient(mainIngredient, 2)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedByAnyIngredient(mainIngredient, Items.SUGAR, Items.WATER_BUCKET)
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void soupRecipe(HolderGetter<Item> holderGetter, Item output, Item mainIngredient, RecipeOutput recipeOutput) {
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, output, 1, 200, 2.0F, Items.BOWL)
                .addIngredient(CommonTags.C_FOODS_VEGETABLE)
                .addIngredient(mainIngredient)
                .unlockedByAnyIngredient(mainIngredient)
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void syrupRecipe(HolderGetter<Item> holderGetter, Item output, Item mainIngredient, RecipeOutput recipeOutput) {
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, output, 1, 400, 1.0F, Items.GLASS_BOTTLE)
                .addIngredient(mainIngredient, 3)
                .addIngredient(Items.SUGAR, 2)
                .addIngredient(Items.WATER_BUCKET, 1)
                .unlockedByAnyIngredient(mainIngredient, Items.SUGAR, Items.WATER_BUCKET)
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }
}
