package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import vectorwing.farmersdelight.common.block.PieBlock;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        this.dropSelf(FrightsDelightBlocksImpl.FLESH_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.BONE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.PHANTOM_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.WEB_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE);

        this.dropSelf(FrightsDelightBlocksImpl.LOLLIPOP_MOLD);
        this.dropSelf(FrightsDelightBlocksImpl.RING_CANDY_MOLD);

        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH, FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_COBWEB, FrightsDelightItemsImpl.PUNCH_COBWEB);

        // can be used to regen, must change c:tools/knives -> forge:tools/kives
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);

        // can be used to regen, must change c:tools/knives -> forge:tools/kives
//        this.createPieDrops(FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE, FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.SLIMEAPPLE_PIE, FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.SPIDEREYE_PIE, FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.GHASTTEAR_PIE, FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE, FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE, FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE);
//        this.createPieDrops(FrightsDelightBlocksImpl.COBWEB_PIE, FrightsDelightItemsImpl.COBWEB_PIE_SLICE);

        this.createBushDrops(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH);
        this.createBushDrops(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH);

    }

    private void createGlassCupDrops(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 1))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 0))))
        ));
    }

    private void createPunchbowlDrops(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
        ));
    }

    private void createBushDrops(Block block) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 2))))
        ).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
    }

    private void createPieDrops(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 0))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
        ));
    }
}
