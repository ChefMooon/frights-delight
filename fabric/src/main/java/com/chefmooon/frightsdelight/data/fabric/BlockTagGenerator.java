package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.tag.CompatibilityTags;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public BlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        registerModTags();
        registerCommonBlockTags();
        registerMinecraftBlockTags();
    }

    private void registerModTags() {
        getOrCreateTagBuilder(FrightsDelightTags.SOUL_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.SOUL_FIRE)
                .add(Blocks.SOUL_LANTERN)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.SOUL_CAMPFIRE);

        getOrCreateTagBuilder(FrightsDelightTags.WITHER_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.WITHER_SKELETON_SKULL)
                .add(Blocks.WITHER_SKELETON_WALL_SKULL);

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_MINEABLE_KNIFE)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB);
    }

    private void registerCommonBlockTags() {
//        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY)
//                .add(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB);
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH)
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH)
                .add(FrightsDelightBlocksImpl.FLESH_CRATE)
                .add(FrightsDelightBlocksImpl.BONE_CRATE)
                .add(FrightsDelightBlocksImpl.PHANTOM_CRATE)
                .add(FrightsDelightBlocksImpl.WEB_CRATE)
                .add(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE)
                .add(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE)
                .add(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE)
                .add(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE);

        // this does not exist in 1.19.2, added in 1.20.5
//        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
//                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH)
//                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH);

        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH)
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH);
    }


}
