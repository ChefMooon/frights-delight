package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.data.fabric.builder.CuttingBoardRecipeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CuttingRecipes {

    public static void register(RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.create(Items.BONE, Ingredient.of(CommonTags.C_TOOLS_KNIFE), FrightsDelightItemsImpl.BONE_SHARD, 2)
                .output(FrightsDelightItemsImpl.BONE_SHARD, 0.5F)
                .save(exporter, suffix(RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_SHARD)));

        CuttingBoardRecipeBuilder.create(Items.CLAY, Ingredient.of(CommonTags.C_TOOLS_KNIFE), FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD)
                        .save(exporter, suffix(RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD)));
        CuttingBoardRecipeBuilder.create(Items.CLAY, Ingredient.of(Items.GLASS_BOTTLE), FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD)
                .save(exporter, suffix(RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD)));

        CuttingBoardRecipeBuilder.create(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET, Ingredient.of(CommonTags.C_TOOLS_KNIFE), Items.PUMPKIN)
                .output(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "rope")))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.PUMPKIN, FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET)));
        CuttingBoardRecipeBuilder.create(FrightsDelightItemsImpl.MELON_CANDY_BASKET, Ingredient.of(CommonTags.C_TOOLS_KNIFE), Items.MELON)
                .output(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "rope")))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.MELON, FrightsDelightItemsImpl.MELON_CANDY_BASKET)));

        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE, FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE, exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SLIMEAPPLE_PIE, FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE, exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SPIDEREYE_PIE, FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE, exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.GHASTTEAR_PIE, FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE, exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE, FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE,  exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE, FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE,  exporter);
        pieCuttingRecipeBuilder(FrightsDelightItemsImpl.COBWEB_PIE, FrightsDelightItemsImpl.COBWEB_PIE_SLICE,  exporter);
    }

    private static void pieCuttingRecipeBuilder(Item input, Item output, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.create(input, Ingredient.of(CommonTags.C_TOOLS_KNIFE), output, 4, 1.0F)
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static void basicCuttingRecipeBuilder(Item input, Item output, int outputCount, float chance, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.create(input, Ingredient.of(CommonTags.C_TOOLS_KNIFE), output, outputCount, chance)
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
