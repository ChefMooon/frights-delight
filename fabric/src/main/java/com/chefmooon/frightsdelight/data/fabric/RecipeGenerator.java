package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.data.fabric.recipe.CookingRecipes;
import com.chefmooon.frightsdelight.data.fabric.recipe.CuttingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
                CuttingRecipes.register(holderGetter, provider, exporter);

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

                pieRecipe(holderGetter, FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get(), FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get(), Items.ROTTEN_FLESH, exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get(), FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get(), FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get(), exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.SPIDEREYE_PIE.get(), FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get(), Items.SPIDER_EYE, exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.GHASTTEAR_PIE.get(), FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get(), Items.GHAST_TEAR, exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get(), FrightsDelightItemsImpl.WITHER_BERRY.get(), exporter);
                pieRecipe(holderGetter, FrightsDelightItemsImpl.COBWEB_PIE.get(), FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get(), Items.COBWEB, exporter);

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get()), RecipeCategory.MISC, FrightsDelightItemsImpl.LOLLIPOP_MOLD.get(), 2.0f, 200)
                        .unlockedBy(RecipeProvider.getHasName(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get()))
                        .save(exporter, RecipeProvider.getSmeltingRecipeName(FrightsDelightItemsImpl.LOLLIPOP_MOLD.get()));
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get()), RecipeCategory.MISC, FrightsDelightItemsImpl.RING_CANDY_MOLD.get(), 2.0f, 200)
                        .unlockedBy(RecipeProvider.getHasName(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get()))
                        .save(exporter, RecipeProvider.getSmeltingRecipeName(FrightsDelightItemsImpl.RING_CANDY_MOLD.get()));
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

    private static void pieRecipe(HolderGetter<Item> holderGetter, Item pie, Item pieSlice, Item mainIngredient, RecipeOutput exporter) {
        Item crust = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "pie_crust")).get().value();
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, pie)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("BCB")
                .define('A', mainIngredient)
                .define('B', CommonTags.C_FOODS_MILK)
                .define('C', crust)
                .unlockedBy("has_pie_crust", InventoryChangeTrigger.TriggerInstance.hasItems(crust))
                .group("frd_" + pie.getDescriptionId().replace("block.frightsdelight.", ""))
                .save(exporter, RecipeProvider.getSimpleRecipeName(pie));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, pie)
                .pattern("AA")
                .pattern("AA")
                .define('A', pieSlice)
                .unlockedBy(RecipeProvider.getHasName(pieSlice), InventoryChangeTrigger.TriggerInstance.hasItems(pieSlice))
                .group("frd_" + pie.getDescriptionId().replace("block.frightsdelight.", ""))
                .save(exporter, RecipeProvider.getSimpleRecipeName(pie) + "_from_slices");

    }

    @Override
    public String getName() {
        return "Fright's Delight Recipes";
    }
}
