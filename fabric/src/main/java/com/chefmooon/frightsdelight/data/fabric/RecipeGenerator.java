package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {

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

        pieRecipe(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE, FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE, Items.ROTTEN_FLESH, exporter);
        pieRecipe(FrightsDelightItemsImpl.SLIMEAPPLE_PIE, FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE, FrightsDelightItemsImpl.SLIMEAPPLE_PIE, exporter);
        pieRecipe(FrightsDelightItemsImpl.SPIDEREYE_PIE, FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE, Items.SPIDER_EYE, exporter);
        pieRecipe(FrightsDelightItemsImpl.GHASTTEAR_PIE, FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE, Items.GHAST_TEAR, exporter);
        pieRecipe(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE, FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE, FrightsDelightItemsImpl.SOUL_BERRY, exporter);
        pieRecipe(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE, FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE, FrightsDelightItemsImpl.WITHER_BERRY, exporter);
        pieRecipe(FrightsDelightItemsImpl.COBWEB_PIE, FrightsDelightItemsImpl.COBWEB_PIE_SLICE, Items.COBWEB, exporter);
    }

    private static void crateToIngredient(Item crate, Item ingredient, Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingredient, 9)
                .requires(crate)
                .unlockedBy(RecipeProvider.getHasName(crate), RecipeProvider.has(crate))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ingredient) + "_from_" + RecipeProvider.getSimpleRecipeName(crate));
    }

    private static void cookie(Item cookie, Item ingredient, Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, cookie, 8)
                .requires(ingredient)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeProvider.getHasName(ingredient), RecipeProvider.has(ingredient))
                .unlockedBy(RecipeProvider.getHasName(Items.WHEAT), RecipeProvider.has(Items.WHEAT))
                .save(exporter, RecipeProvider.getSimpleRecipeName(cookie));
    }

    private static void punchbowlFromPunch(Item punchbowl, Item punch, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, punchbowl)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', punch)
                .unlockedBy(RecipeProvider.getHasName(punch), RecipeProvider.has(punch))
                .showNotification(false)
                .save(exporter, RecipeProvider.getSimpleRecipeName(punchbowl));
    }

    private static void pieRecipe(Item pie, Item pieSlice, Item mainIngredient, Consumer<FinishedRecipe> exporter) {
        Item crust = BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "pie_crust"));
        // This must be made manually due to milk tag difference fabric -> c:milks | forge -> forge:milk
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pie)
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("BCB")
//                .define('A', mainIngredient)
//                .define('B', CommonTags.C_FOODS_MILK)
//                .define('C', crust)
//                .unlockedBy("has_pie_crust", RecipeProvider.has(crust))
//                .group("frd_" + pie.getDescriptionId().replace("block.frightsdelight.", ""))
//                .save(exporter, RecipeProvider.getSimpleRecipeName(pie));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, pie)
                .pattern("AA")
                .pattern("AA")
                .define('A', pieSlice)
                .unlockedBy(RecipeProvider.getHasName(pieSlice), RecipeProvider.has(pieSlice))
                .group("frd_" + pie.getDescriptionId().replace("block.frightsdelight.", ""))
                .save(exporter, RecipeProvider.getSimpleRecipeName(pie) + "_from_slices");

    }
}
