package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerMinecraftItemTags();
        registerCommonItemTags();
        registerCompatibilityItemTags();
    }

    private void registerMinecraftItemTags() {
        // Save for Fox harvesting implementation
        //getOrCreateTagBuilder(ItemTags.FOX_FOOD)
        //        .add(FrightsDelightItemsImpl.SOUL_BERRY);
    }

    private void registerCommonItemTags() {
        // Run once then comment, move to fabric project only
//        getOrCreateTagBuilder(CommonTags.C_FOODS)
//                .add(FrightsDelightItemsImpl.SOUL_BERRY)
//                .add(FrightsDelightItemsImpl.WITHER_BERRY)
//                .add(FrightsDelightItemsImpl.APPLE_SLIME)
//                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME)
//                .add(FrightsDelightItemsImpl.WEB_ON_STICK)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY)
//                .add(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY)
//                .add(FrightsDelightItemsImpl.MONSTER_MASH)
//                .add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS)
//                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
//                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
//                .add(FrightsDelightItemsImpl.SOUP_SLIME)
//                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
//                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
//                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
//                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY)
//                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY)
//                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
//                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE)
//                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE)
//                .add(FrightsDelightItemsImpl.COOKIE_SLIME)
//                .add(FrightsDelightItemsImpl.COOKIE_COBWEB)
//                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR)
//                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY)
//                .add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY)
//                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE)
//                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE)
//                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE)
//                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE)
//                .add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE)
//                .add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE);
//                .add(FrightsDelightItemsImpl.COBWEB_PIE)
//                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.COBWEB_LOLLIPOP)
//                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY)
//                .add(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY)
//                .add(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY)
//                .add(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY)
//                .add(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY)
//                .add(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY)
//                .add(FrightsDelightItemsImpl.COBWEB_RING_CANDY)
//                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE)
//                .add(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE)
        //TODO: add new ones manually to fabric
    }

    private void registerCompatibilityItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE)
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE)
                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE)
                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE)
                .add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE)
                .add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE)
                .add(FrightsDelightItemsImpl.COBWEB_PIE)
                .add(FrightsDelightItemsImpl.MONSTER_MASH)
                .add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS)
        ;

        // Create: Craft's and Additions
        getOrCreateTagBuilder(CompatibilityTags.CREATE_ADDITION_PLANT_FOODS)
                .add(FrightsDelightItemsImpl.SOUL_BERRY)
                .add(FrightsDelightItemsImpl.WITHER_BERRY);

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIME)
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB)
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY);

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB);

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY);

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB)
                .add(FrightsDelightItemsImpl.MONSTER_MASH)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIME)
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE)
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE)
                .add(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP)
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP)
                .add(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP)
                .add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY)
                .add(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY)
                .add(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY)
        ;

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.WEB_ON_STICK)
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB)
                .add(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE)
                .add(FrightsDelightItemsImpl.COBWEB_PIE_SLICE)
                .add(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP)
                .add(FrightsDelightItemsImpl.COBWEB_LOLLIPOP)
                .add(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY)
                .add(FrightsDelightItemsImpl.COBWEB_RING_CANDY)
        ;
    }
}
