package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.data.fabric.recipe.CookingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        CookingRecipes.register(exporter);

        crateToIngredient(FrightsDelightItemsImpl.FLESH_CRATE, Items.ROTTEN_FLESH, exporter);
        crateToIngredient(FrightsDelightItemsImpl.BONE_CRATE, Items.BONE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.PHANTOM_CRATE, Items.PHANTOM_MEMBRANE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.WEB_CRATE, Items.COBWEB, exporter);
        crateToIngredient(FrightsDelightItemsImpl.SPIDER_EYE_CRATE, Items.SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE, Items.FERMENTED_SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE, Items.POISONOUS_POTATO, exporter);
        crateToIngredient(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE, ModItems.ROTTEN_TOMATO.get(), exporter);

        cookie(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, Items.ROTTEN_FLESH, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE, FrightsDelightItemsImpl.APPLE_SLIME, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SLIME, Items.SLIME_BALL, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE, Items.SPIDER_EYE, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR, Items.GHAST_TEAR, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_COBWEB, Items.COBWEB, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY, FrightsDelightItemsImpl.SOUL_BERRY, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY, FrightsDelightItemsImpl.WITHER_BERRY, exporter);

        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH, FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB, FrightsDelightItemsImpl.PUNCH_COBWEB, exporter);
    }

    private static void crateToIngredient(Item crate, Item ingredient, RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingredient, 9)
                .requires(crate)
                .unlockedBy(RecipeProvider.getHasName(crate), RecipeProvider.has(crate))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ingredient) + "_from_" + RecipeProvider.getSimpleRecipeName(crate));
    }

    private static void cookie(Item cookie, Item ingredient, RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, cookie, 8)
                .requires(ingredient)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeProvider.getHasName(ingredient), RecipeProvider.has(ingredient))
                .unlockedBy(RecipeProvider.getHasName(Items.WHEAT), RecipeProvider.has(Items.WHEAT))
                .save(exporter, RecipeProvider.getSimpleRecipeName(cookie));
    }

    private static void punchbowlFromPunch(Item punchbowl, Item punch, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, punchbowl)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', punch)
                .unlockedBy(RecipeProvider.getHasName(punch), RecipeProvider.has(punch))
                .showNotification(false)
                .save(exporter, RecipeProvider.getSimpleRecipeName(punchbowl));
    }
}