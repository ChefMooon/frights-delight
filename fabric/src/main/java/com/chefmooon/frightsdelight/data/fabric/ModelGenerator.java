package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.ModModels;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightModels;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightTextureSlots;
import com.mojang.math.Quadrant;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.List;
import java.util.Optional;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        registerCrateBlock(FrightsDelightBlocksImpl.FLESH_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.BONE_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.WEB_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), blockModelGenerators);
        registerCrateBlock(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(), blockModelGenerators);

        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY.get(), blockModelGenerators);
        registerGlassCup(FrightsDelightBlocksImpl.PUNCH_COBWEB.get(), blockModelGenerators);

        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), blockModelGenerators);
        registerDrinkFeast(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB.get(), blockModelGenerators);

        registerPieBlock(FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.SLIMEAPPLE_PIE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.SPIDEREYE_PIE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.GHASTTEAR_PIE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE.get(), blockModelGenerators);
        registerPieBlock(FrightsDelightBlocksImpl.COBWEB_PIE.get(), blockModelGenerators);

        ResourceLocation SOUL_BERRY_BUSH_STAGE0 = registerBushModel("_stage0", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation SOUL_BERRY_BUSH_STAGE1 = registerBushModel("_stage1", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation SOUL_BERRY_BUSH_STAGE2 = registerBushModel("_stage2", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation SOUL_BERRY_BUSH_STAGE2_GROW = registerBushModel("_stage2_grow", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation SOUL_BERRY_BUSH_STAGE3 = registerBushModel("_stage3", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation SOUL_BERRY_BUSH_STAGE3_GROW = registerBushModel("_stage3_grow", FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), blockModelGenerators);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get())
                        .with(PropertyDispatch.initial(BlockStateProperties.AGE_3, FrightsDelightBushBlock.GROW_CONDITION)
                        .select(0, false,  BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE0))
                        .select(0, true, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE0))
                        .select(1, false, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE1))
                        .select(1, true, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE1))
                        .select(2, false, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE2))
                        .select(2, true, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE2_GROW))
                        .select(3, false, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE3))
                        .select(3, true, BlockModelGenerators.plainVariant(SOUL_BERRY_BUSH_STAGE3_GROW))
                        ));

        ResourceLocation WITHER_BERRY_BUSH_STAGE0 = registerBushModel("_stage0", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation WITHER_BERRY_BUSH_STAGE1 = registerBushModel("_stage1", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation WITHER_BERRY_BUSH_STAGE2 = registerBushModel("_stage2", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation WITHER_BERRY_BUSH_STAGE2_GROW = registerBushModel("_stage2_grow", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation WITHER_BERRY_BUSH_STAGE3 = registerBushModel("_stage3", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        ResourceLocation WITHER_BERRY_BUSH_STAGE3_GROW = registerBushModel("_stage3_grow", FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), blockModelGenerators);
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get())
                .with(PropertyDispatch.initial(BlockStateProperties.AGE_3, FrightsDelightBushBlock.GROW_CONDITION)
                        .select(0,false, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE0))
                        .select(0,true, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE0))
                        .select(1,false, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE1))
                        .select(1,true, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE1))
                        .select(2,false, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE2))
                        .select(2,true, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE2_GROW))
                        .select(3,false, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE3))
                        .select(3,true, BlockModelGenerators.plainVariant(WITHER_BERRY_BUSH_STAGE3_GROW))
                ));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        Item boneShardItem = FrightsDelightItemsImpl.BONE_SHARD.get();
        ItemModel.Unbaked boneShardUnbaked = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(boneShardItem, ModModels.FLAT_HANDHELD_ITEM_FLIPPED));

        ItemModel.Unbaked boneShardUnbakedInHand = ItemModelUtils.plainModel(
                ModModels.FLAT_HANDHELD_ITEM_FLIPPED.create(ModelLocationUtils.getModelLocation(boneShardItem, "_in_hand"),
                new TextureMapping().put(TextureSlot.LAYER0, TextUtils.res("item/bone_shard")),
                itemModelGenerators.modelOutput));

        ItemModel.Unbaked boneShardUnbakedThrowing = ItemModelUtils.plainModel(
                ModModels.FLAT_HANDHELD_ITEM_FLIPPED_THROWING.create(ModelLocationUtils.getModelLocation(boneShardItem, "_throwing"),
                new TextureMapping().put(TextureSlot.LAYER0, TextUtils.res("item/bone_shard")),
                itemModelGenerators.modelOutput));

        ItemModel.Unbaked boneShardConditionalUnbaked = ItemModelUtils.conditional(ItemModelUtils.isUsingItem(), boneShardUnbakedThrowing, boneShardUnbakedInHand);

        itemModelGenerators.itemModelOutput.accept(boneShardItem, ItemModelGenerators.createFlatModelDispatch(boneShardUnbaked, boneShardConditionalUnbaked));

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUL_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.WITHER_BERRY.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.APPLE_SLIME.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.UNDEAD_KEBAB.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.WEB_ON_STICK.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get(), ModModels.FLAT_HANDHELD_ITEM_FLIPPED);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.MONSTER_MASH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_SLIME.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_COBWEB.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SLIME.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_COBWEB.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCH_COBWEB.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SPIDEREYE_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.GHASTTEAR_PIE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COBWEB_PIE.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get(), ModelTemplates.FLAT_ITEM);
    }

    private static void registerCrateBlock(Block block, BlockModelGenerators blockStateModelGenerator) {
        TexturedModel.Provider texturedModelProvider = TexturedModel.createDefault(ModelGenerator::crateBlock, ModelTemplates.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.createTrivialBlock(block, texturedModelProvider);
    }

    private static void registerDrinkFeast(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation punchBowl = TextUtils.res("block/punch_bowl");

        FrightsDelightModels.TEMPLATE_DRINK_FEAST_LEFTOVER.createWithSuffix(block, "_leftover",
                ModelGenerator.punchBowl(block), blockStateModelGenerator.modelOutput);

        List<ModelTemplate> stages = List.of(
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE0,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE1,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE2,
                FrightsDelightModels.TEMPLATE_DRINK_FEAST_STAGE3);
        for (int i = 0; i < stages.size(); i++) {
            stages.get(i).create(ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_stage" + i),
                    ModelGenerator.punchBowl(block), blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(DrinkableFeastBlock.SERVINGS)
                        .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_leftover")))
                        .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage3")))
                        .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage2")))
                        .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage1")))
                        .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage0")))
                ).with(createHorizontalFacingDispatch()));
    }

    private static ResourceLocation registerBushModel(String stage, Block block, BlockModelGenerators blockModelGenerators) {
        return FrightsDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(block, stage,
                (TextureMapping)TextureMapping.cross(TextureMapping.getBlockTexture(block, stage)), blockModelGenerators.modelOutput);
    }

    private static void registerGlassCup(Block block, BlockModelGenerators blockModelGenerators) {
        ResourceLocation TEMPLATE_GLASS_CUP_1_LOCATION = FrightsDelightModels.TEMPLATE_GLASS_CUP_1.createWithSuffix(block, "_servings1",
                ModelGenerator.cupBlock(block), blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_2_LOCATION = FrightsDelightModels.TEMPLATE_GLASS_CUP_2.createWithSuffix(block, "_servings2",
                ModelGenerator.cupBlock(block), blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_3_LOCATION = FrightsDelightModels.TEMPLATE_GLASS_CUP_3.createWithSuffix(block, "_servings3",
                ModelGenerator.cupBlock(block), blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_4_LOCATION = FrightsDelightModels.TEMPLATE_GLASS_CUP_4.createWithSuffix(block, "_servings4",
                ModelGenerator.cupBlock(block), blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(GlassCupBlock.SERVINGS)
                        .select(0, plainVariant(TEMPLATE_GLASS_CUP_1_LOCATION))
                        .select(1, plainVariant(TEMPLATE_GLASS_CUP_2_LOCATION))
                        .select(2, plainVariant(TEMPLATE_GLASS_CUP_3_LOCATION))
                        .select(3, plainVariant(TEMPLATE_GLASS_CUP_4_LOCATION))
                ).with(createHorizontalFacingDispatch()));
    }

    private static TextureMapping crateBlock(Block block) {
        return (new TextureMapping())
                .put(TextureSlot.SIDE, ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_side"))
                .put(TextureSlot.TOP, ResourceLocation.parse(ModelLocationUtils.getModelLocation(block) + "_top"))
                .put(TextureSlot.BOTTOM, ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/crate_bottom"));
    }

    private static TextureMapping punchBowl(Block block) {
        ResourceLocation punchBowl = TextUtils.res("block/punch_bowl");
        return (new TextureMapping())
                .put(FrightsDelightTextureSlots.PUNCH_BOWL, punchBowl)
                .put(FrightsDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                .put(TextureSlot.PARTICLE, punchBowl);
    }

    private static TextureMapping cupBlock(Block block) {
        return (new TextureMapping())
                .put(FrightsDelightTextureSlots.CUP, TextUtils.res("block/glass_cup"))
                .put(FrightsDelightTextureSlots.INSIDE, ModelLocationUtils.getModelLocation(block));
    }

    private static PropertyDispatch<VariantMutator> createHorizontalFacingDispatch() {
        return PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.EAST, VariantMutator.Y_ROT.withValue(Quadrant.R90))
                .select(Direction.SOUTH, VariantMutator.Y_ROT.withValue(Quadrant.R180))
                .select(Direction.WEST, VariantMutator.Y_ROT.withValue(Quadrant.R270))
                .select(Direction.NORTH, (variant) -> variant);
    }

    private static void registerPieBlock(Block block, BlockModelGenerators blockModelGenerators) {
        ResourceLocation blockLocation = ModelLocationUtils.getModelLocation(block);
        TextureSlot INNER = TextureSlot.create("inner");
        ModelTemplate PIE_MODEL = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie")), Optional.empty(),
                TextureSlot.PARTICLE, TextureSlot.BOTTOM, INNER, TextureSlot.SIDE, TextureSlot.TOP);
        ModelTemplate PIE_SLICE_1_MODEL = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie_slice1")), Optional.empty(),
                TextureSlot.PARTICLE, TextureSlot.BOTTOM, INNER, TextureSlot.SIDE, TextureSlot.TOP);
        ModelTemplate PIE_SLICE_2_MODEL = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie_slice2")), Optional.empty(),
                TextureSlot.PARTICLE, TextureSlot.BOTTOM, INNER, TextureSlot.SIDE, TextureSlot.TOP);
        ModelTemplate PIE_SLICE_3_MODEL = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie_slice3")), Optional.empty(),
                TextureSlot.PARTICLE, TextureSlot.BOTTOM, INNER, TextureSlot.SIDE, TextureSlot.TOP);

        ResourceLocation pie_bottom = ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie_bottom");
        ResourceLocation pide_side = ResourceLocation.fromNamespaceAndPath("farmersdelight", "block/pie_side");

        TextureMapping textureMapping = TextureMapping.particle(blockLocation.withSuffix("_top"))
                .put(TextureSlot.BOTTOM, pie_bottom)
                .put(INNER, blockLocation.withSuffix("_inner"))
                .put(TextureSlot.SIDE, pide_side)
                .put(TextureSlot.TOP, blockLocation.withSuffix("_top"));

        ResourceLocation PIE = PIE_MODEL.create(blockLocation, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation PIE_SLICE_1 = PIE_SLICE_1_MODEL.create(blockLocation.withSuffix("_slice1"), textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation PIE_SLICE_2 = PIE_SLICE_2_MODEL.create(blockLocation.withSuffix("_slice2"), textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation PIE_SLICE_3 = PIE_SLICE_3_MODEL.create(blockLocation.withSuffix("_slice3"), textureMapping, blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(PieBlock.BITES)
                        .select(0, plainVariant(PIE))
                        .select(1, plainVariant(PIE_SLICE_1))
                        .select(2, plainVariant(PIE_SLICE_2))
                        .select(3, plainVariant(PIE_SLICE_3))
                ).with(createHorizontalFacingDispatch()));
    }

}
