package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerModTags();
        registerCommonBlockTags();
        registerConventionalBlockTags();
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
    }

    private void registerCommonBlockTags() {
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.JACK_O_LANTERN_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB.get())
                .add(FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE.get())
                .add(FrightsDelightBlocksImpl.SLIMEAPPLE_PIE.get())
                .add(FrightsDelightBlocksImpl.SPIDEREYE_PIE.get())
                .add(FrightsDelightBlocksImpl.GHASTTEAR_PIE.get())
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE.get())
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE.get())
                .add(FrightsDelightBlocksImpl.COBWEB_PIE.get());

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ROTTEN_FLESH).add(FrightsDelightBlocksImpl.FLESH_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_BONE).add(FrightsDelightBlocksImpl.BONE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_PHANTOM_MEMBRANE).add(FrightsDelightBlocksImpl.PHANTOM_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_COBWEB).add(FrightsDelightBlocksImpl.WEB_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_SPIDER_EYE).add(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_FERMENTED_SPIDER_EYE).add(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_POISONOUS_POTATO).add(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ROTTEN_TOMATO).add(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get());
    }

    private void registerConventionalBlockTags() {
        getOrCreateTagBuilder(ConventionalBlockTags.STORAGE_BLOCKS).addTags(
                CommonTags.C_STORAGE_BLOCKS_ROTTEN_FLESH,
                CommonTags.C_STORAGE_BLOCKS_BONE,
                CommonTags.C_STORAGE_BLOCKS_PHANTOM_MEMBRANE,
                CommonTags.C_STORAGE_BLOCKS_COBWEB,
                CommonTags.C_STORAGE_BLOCKS_SPIDER_EYE,
                CommonTags.C_STORAGE_BLOCKS_FERMENTED_SPIDER_EYE,
                CommonTags.C_STORAGE_BLOCKS_POISONOUS_POTATO,
                CommonTags.C_STORAGE_BLOCKS_ROTTEN_TOMATO
        );
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get())
                .add(FrightsDelightBlocksImpl.RING_CANDY_MOLD.get());

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.JACK_O_LANTERN_CANDY_BASKET.get())
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get())
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get())
                .add(FrightsDelightBlocksImpl.FLESH_CRATE.get())
                .add(FrightsDelightBlocksImpl.BONE_CRATE.get())
                .add(FrightsDelightBlocksImpl.PHANTOM_CRATE.get())
                .add(FrightsDelightBlocksImpl.WEB_CRATE.get())
                .add(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get())
                .add(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get())
                .add(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get())
                .add(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get());

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get())
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get());

        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING)
                .add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get())
                .add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get());
    }
}
