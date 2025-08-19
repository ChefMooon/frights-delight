package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.data.fabric.recipe.CookingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
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
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput exporter) {
        return new RecipeProvider(provider, exporter) {
            @Override
            public void buildRecipes() {
                HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);

                CookingRecipes.register(holderGetter, provider, exporter);

                crateToIngredient(holderGetter, FrightsDelightItemsImpl.FLESH_CRATE.get(), Items.ROTTEN_FLESH, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.BONE_CRATE.get(), Items.BONE, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.PHANTOM_CRATE.get(), Items.PHANTOM_MEMBRANE, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.WEB_CRATE.get(), Items.COBWEB, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.SPIDER_EYE_CRATE.get(), Items.SPIDER_EYE, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE.get(), Items.FERMENTED_SPIDER_EYE, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE.get(), Items.POISONOUS_POTATO, exporter);
                crateToIngredient(holderGetter, FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE.get(), ModItems.ROTTEN_TOMATO.get(), exporter);

                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get(), Items.ROTTEN_FLESH, exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get(), FrightsDelightItemsImpl.APPLE_SLIME.get(), exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_SLIME.get(), Items.SLIME_BALL, exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get(), Items.SPIDER_EYE, exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get(), Items.GHAST_TEAR, exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_COBWEB.get(), Items.COBWEB, exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), exporter);
                cookie(holderGetter, FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get(), FrightsDelightItemsImpl.WITHER_BERRY.get(), exporter);

                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH.get(), FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get(), FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get(), FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get(), FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get(), FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get(), FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), exporter);
                punchbowlFromPunch(holderGetter, FrightsDelightItemsImpl.PUNCHBOWL_COBWEB.get(), FrightsDelightItemsImpl.PUNCH_COBWEB.get(), exporter);
            }
        };
    }

    private static void crateToIngredient(HolderGetter<Item> holderGetter, Item crate, Item ingredient, RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, ingredient, 9)
                .requires(crate)
                .unlockedBy(RecipeProvider.getHasName(crate), InventoryChangeTrigger.TriggerInstance.hasItems(crate))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ingredient) + "_from_" + RecipeProvider.getSimpleRecipeName(crate));
    }

    private static void cookie(HolderGetter<Item> holderGetter, Item cookie, Item ingredient, RecipeOutput exporter) {
        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, cookie, 8)
                .requires(ingredient)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeProvider.getHasName(ingredient), InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .unlockedBy(RecipeProvider.getHasName(Items.WHEAT), InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                .save(exporter, RecipeProvider.getSimpleRecipeName(cookie));
    }

    private static void punchbowlFromPunch(HolderGetter<Item> holderGetter, Item punchbowl, Item punch, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, punchbowl)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', punch)
                .unlockedBy(RecipeProvider.getHasName(punch), InventoryChangeTrigger.TriggerInstance.hasItems(punch))
                .showNotification(false)
                .save(exporter, RecipeProvider.getSimpleRecipeName(punchbowl));
    }

    @Override
    public String getName() {
        return "Fright's Delight Recipes";
    }
}
