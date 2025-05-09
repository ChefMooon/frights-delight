package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
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

public class LootTableGenerator extends FabricBlockLootTableProvider {


    protected LootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {

        dropSelf(FrightsDelightBlocksImpl.FLESH_CRATE);
        dropSelf(FrightsDelightBlocksImpl.BONE_CRATE);
        dropSelf(FrightsDelightBlocksImpl.PHANTOM_CRATE);
        dropSelf(FrightsDelightBlocksImpl.WEB_CRATE);
        dropSelf(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE);
        dropSelf(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE);
        dropSelf(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE);
        dropSelf(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE);

        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH, FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_COBWEB, FrightsDelightItemsImpl.PUNCH_COBWEB);

        // can be used to regen, must change c:tools/knives -> forge:tools/kives
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH, FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);
//        createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB, FrightsDelightItemsImpl.PUNCHBOWL_COBWEB);

        createBushDrops(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH);
        createBushDrops(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH);

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
        // this is without the tool match property(see below from 1.20.1). must research to see if this is possible to generate in 1.19.2. also not needed right now.
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))))
        ));

//        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
//                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
//                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
//                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
//                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
//                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
//                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
//                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
//                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
//                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
//                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
//                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
//                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
//                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
//        ));
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
        ));
    }
}
