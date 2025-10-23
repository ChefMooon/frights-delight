package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        HolderGetter<Item> itemGetter = this.registries.lookupOrThrow(Registries.ITEM);

        this.createCandyBasketDrops(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get());
        this.createCandyBasketDrops(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get());

        this.dropSelf(FrightsDelightBlocksImpl.FLESH_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.BONE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.PHANTOM_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.WEB_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get());

        this.dropSelf(FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get());
        this.dropSelf(FrightsDelightBlocksImpl.RING_CANDY_MOLD.get());

        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH.get(), FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE.get(), FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE.get(), FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR.get(), FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY.get(), FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY.get(), FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get());
        createGlassCupDrops(FrightsDelightBlocksImpl.PUNCH_COBWEB.get(), FrightsDelightItemsImpl.PUNCH_COBWEB.get());

        createPunchbowlDrops(itemGetter, FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get());
        createPunchbowlDrops(itemGetter, FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get());
        createPunchbowlDrops(itemGetter, FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get());
        createPunchbowlDrops(itemGetter, FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get());
        createPunchbowlDrops(itemGetter, FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get());

        createBushDrops(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get());
        createBushDrops(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get());

        createPieDrops(itemGetter, FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE.get(), FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.SLIMEAPPLE_PIE.get(), FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.SPIDEREYE_PIE.get(), FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.GHASTTEAR_PIE.get(), FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE.get(), FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get());
        createPieDrops(itemGetter, FrightsDelightBlocksImpl.COBWEB_PIE.get(), FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get());

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

    private void createPunchbowlDrops(HolderGetter<Item> itemGetter, Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        ));
    }

    private void createBushDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 2))))
        ).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
    }

    private void createPieDrops(HolderGetter<Item> itemGetter, Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 0))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PieBlock.BITES, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        ));
    }

    private void createCandyBasketDrops(Block block) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY).include(DataComponents.CONTAINER).include(DataComponents.CUSTOM_NAME)))))
        );
    }
}
