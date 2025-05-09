package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.ModModels;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightModels;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightTextureSlots;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        registerCrateBlock(FrightsDelightBlocksImpl.FLESH_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.BONE_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.PHANTOM_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.WEB_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE, blockStateModelGenerator);
        registerCrateBlock(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE, blockStateModelGenerator);

        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY, blockStateModelGenerator);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_COBWEB, blockStateModelGenerator);

        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, blockStateModelGenerator);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB, blockStateModelGenerator);

        ResourceLocation SOUL_BERRY_BUSH_STAGE0 = registerBushModel("_stage0", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation SOUL_BERRY_BUSH_STAGE1 = registerBushModel("_stage1", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation SOUL_BERRY_BUSH_STAGE2 = registerBushModel("_stage2", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation SOUL_BERRY_BUSH_STAGE2_GROW = registerBushModel("_stage2_grow", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation SOUL_BERRY_BUSH_STAGE3 = registerBushModel("_stage3", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation SOUL_BERRY_BUSH_STAGE3_GROW = registerBushModel("_stage3_grow", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, blockStateModelGenerator);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH)
                .with(PropertyDispatch.properties(BlockStateProperties.AGE_3, FrightsDelightBushBlock.GROW_CONDITION)
                        .select(0, false, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE0))
                        .select(0, true, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE0))
                        .select(1, false, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE1))
                        .select(1, true, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE1))
                        .select(2, false, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE2))
                        .select(2, true, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE2_GROW))
                        .select(3, false, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE3))
                        .select(3, true, Variant.variant().with(VariantProperties.MODEL, SOUL_BERRY_BUSH_STAGE3_GROW))
                ));

        ResourceLocation WITHER_BERRY_BUSH_STAGE0 = registerBushModel("_stage0", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation WITHER_BERRY_BUSH_STAGE1 = registerBushModel("_stage1", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation WITHER_BERRY_BUSH_STAGE2 = registerBushModel("_stage2", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation WITHER_BERRY_BUSH_STAGE2_GROW = registerBushModel("_stage2_grow", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation WITHER_BERRY_BUSH_STAGE3 = registerBushModel("_stage3", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        ResourceLocation WITHER_BERRY_BUSH_STAGE3_GROW = registerBushModel("_stage3_grow", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, blockStateModelGenerator);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH)
                .with(PropertyDispatch.properties(BlockStateProperties.AGE_3, FrightsDelightBushBlock.GROW_CONDITION)
                        .select(0,false, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE0))
                        .select(0,true, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE0))
                        .select(1,false, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE1))
                        .select(1,true, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE1))
                        .select(2,false, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE2))
                        .select(2,true, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE2_GROW))
                        .select(3,false, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE3))
                        .select(3,true, Variant.variant().with(VariantProperties.MODEL, WITHER_BERRY_BUSH_STAGE3_GROW))
                ));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_SHARD, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUL_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.WITHER_BERRY, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.APPLE_SLIME, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.UNDEAD_KEBAB, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SLIME, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.WEB_ON_STICK, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY, ModModels.FLAT_HANDHELD_ITEM_FLIPPED);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.MONSTER_MASH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_SPIDER_EYE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_SLIME, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_COBWEB, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_GHAST_TEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_SOUL_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.SOUP_WITHER_BERRY, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SLIME, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_COBWEB, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCH_COBWEB, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB, ModelTemplates.FLAT_ITEM);

    }

    private static void registerCrateBlock(Block block, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(block,
                (new TextureMapping())
                        .put(TextureSlot.SIDE, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_side"))
                        .put(TextureSlot.TOP, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_top"))
                        .put(TextureSlot.BOTTOM, new ResourceLocation("farmersdelight", "block/crate_bottom")),
                ModelTemplates.CUBE_BOTTOM_TOP);
    }

    private static void registerDrinkFeast(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation punchBowl = TextUtils.res("block/punch_bowl");
        TextureMapping textureMapping = TextureMapping.particle(punchBowl)
                .put(FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                .put(FrightsDelightTextureSlots.PUNCH_BOWL, punchBowl);
        FrightsDelightModels.TEMPLATE_DRINK_FEAST_LEFTOVER.create(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_leftover"),
                textureMapping, blockStateModelGenerator.modelOutput);

        List<ModelTemplate> stages = List.of(
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE0,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE1,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE2,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE3);
        for (int i = 0; i < stages.size(); i++) {
            TextureMapping textureMappingstage = TextureMapping.particle(punchBowl)
                    .put(FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                    .put(FrightsDelightTextureSlots.PUNCH_BOWL, punchBowl);
            stages.get(i).create(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage" + i),
                    textureMappingstage, blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(DrinkableFeastBlock.SERVINGS)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_leftover")))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage3")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage2")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage1")))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage0")))
                ));
    }

    private static ResourceLocation registerBushModel(String stage, Block block, BlockModelGenerators blockStateModelGenerator) {
        return FrightsDelightModels.TEMPLATE_CROP_CROSS.create(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + stage),
                TextureMapping.cross(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + stage)), blockStateModelGenerator.modelOutput);
    }

    private static void registerGlassCup(Block block, BlockModelGenerators blockModelGenerators) {
        ResourceLocation blockLocation = ModelLocationUtils.getModelLocation(block);
        ResourceLocation cupLocation = TextUtils.res("block/glass_cup");
        TextureMapping textureMapping = TextureMapping.singleSlot(FrightsDelightTextureSlots.CUP, cupLocation)
                .put(FrightsDelightTextureSlots.INSIDE, blockLocation);
        ResourceLocation TEMPLATE_GLASS_CUP_1_LOCATION = TextUtils.res(blockLocation.getPath() + "_servings1");
        FrightsDelightModels.TEMPLATE_GLASS_CUP_1.create(TEMPLATE_GLASS_CUP_1_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_2_LOCATION = TextUtils.res(blockLocation.getPath() + "_servings2");
        FrightsDelightModels.TEMPLATE_GLASS_CUP_2.create(TEMPLATE_GLASS_CUP_2_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_3_LOCATION = TextUtils.res(blockLocation.getPath() + "_servings3");
        FrightsDelightModels.TEMPLATE_GLASS_CUP_3.create(TEMPLATE_GLASS_CUP_3_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_4_LOCATION = TextUtils.res(blockLocation.getPath() + "_servings4");
        FrightsDelightModels.TEMPLATE_GLASS_CUP_4.create(TEMPLATE_GLASS_CUP_4_LOCATION, textureMapping, blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(GlassCupBlock.SERVINGS)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_1_LOCATION))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_2_LOCATION))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_3_LOCATION))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_4_LOCATION))

                ));
    }

}
