package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerMinecraftItemTags();
        registerCommonTags();
        registerCompatibilityItemTags();
    }

    private void registerMinecraftItemTags() {
        // Save for Fox harvesting implementation
        //getOrCreateTagBuilder(ItemTags.FOX_FOOD)
        //        .add(FrightsDelightItemsImpl.SOUL_BERRY);

        getOrCreateTagBuilder(ItemTags.MEAT)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get())
        ;

        getOrCreateTagBuilder(ItemTags.WOLF_FOOD)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get())
        ;
    }

    private void registerCommonTags() {
        getOrCreateTagBuilder(CommonTags.C_FOODS_BERRY)
                .add(FrightsDelightItemsImpl.SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_SOUP)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.SOUP_COBWEB.get())
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_COOKIE)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIME.get())
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB.get())
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get());

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_FLESH)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_BONE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_PHANTOM_MEMBRANE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_COBWEB)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_SPIDER_EYE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_FERMENTED_SPIDER_EYE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_POISONOUS_POTATO)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_TOMATO);

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_FLESH).add(FrightsDelightItemsImpl.FLESH_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_BONE).add(FrightsDelightItemsImpl.BONE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_PHANTOM_MEMBRANE).add(FrightsDelightItemsImpl.PHANTOM_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_COBWEB).add(FrightsDelightItemsImpl.WEB_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_SPIDER_EYE).add(FrightsDelightItemsImpl.SPIDER_EYE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_FERMENTED_SPIDER_EYE).add(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_POISONOUS_POTATO).add(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_TOMATO).add(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS)
                .add(FrightsDelightItemsImpl.APPLE_SLIME.get())
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get())
                .add(FrightsDelightItemsImpl.WEB_ON_STICK.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.MONSTER_MASH.get())
                .add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE.get())
                .add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get())
                .add(FrightsDelightItemsImpl.COBWEB_PIE.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.COBWEB_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE.get())
                .add(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE.get())
        ;
    }

    private void registerCompatibilityItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB.get())
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get())
                .add(FrightsDelightItemsImpl.SOUP_COBWEB.get())
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE.get())
                .add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get())
                .add(FrightsDelightItemsImpl.COBWEB_PIE.get());

        // Create: Craft's and Additions
        getOrCreateTagBuilder(CompatibilityTags.CREATE_ADDITION_PLANT_FOODS)
                .add(FrightsDelightItemsImpl.SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.WITHER_BERRY.get());

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIME.get())
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB.get())
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get());

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB.get());

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get())
                .add(FrightsDelightItemsImpl.SOUP_COBWEB.get())
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get());

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB.get())
                .add(FrightsDelightItemsImpl.MONSTER_MASH.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get())
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.COOKIE_SLIME.get())
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get())
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get())
        ;

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.WEB_ON_STICK.get())
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB.get())
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get())
                .add(FrightsDelightItemsImpl.SOUP_COBWEB.get())
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get())
                .add(FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get())
                .add(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get())
                .add(FrightsDelightItemsImpl.COBWEB_RING_CANDY.get())
        ;
    }
}
