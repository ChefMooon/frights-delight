package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.advancement.CandyBasketShuffleTrigger;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightEntityTypesImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {
    protected AdvancementGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(FrightsDelightItemsImpl.APPLE_SLIME,
                        TextUtils.getTranslatable("advancement.root"),
                        TextUtils.getTranslatable("advancement.root.desc"),
                        ResourceLocation.withDefaultNamespace("textures/block/soul_sand.png"),
                        AdvancementType.TASK, true, false, false)
                .addCriterion("has_monster_drop", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT))
                .save(consumer, getAdvancementName("root"));

        AdvancementHolder getMonsterDrop = getAdvancement(root, Items.COBWEB, "get_monster_drop", AdvancementType.TASK, true, true, false)
                .addCriterion("has_monster_drop", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBWEB))
                .addCriterion("has_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ROTTEN_FLESH))
                .addCriterion("has_spdier_eye", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SPIDER_EYE))
                .addCriterion("has_phantom_membrane", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PHANTOM_MEMBRANE))
                .addCriterion("has_slime_ball", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SLIME_BALL))
                .addCriterion("has_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COBWEB))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("get_monster_drop"));

        AdvancementHolder craftCookie = getAdvancement(getMonsterDrop, FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, "craft_cookie", AdvancementType.TASK, true, true, false)
                .addCriterion("has_cookie_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH))
                .addCriterion("has_cookie_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE))
                .addCriterion("has_cookie_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_COBWEB))
                .addCriterion("has_cookie_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR))
                .addCriterion("has_cookie_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE))
                .addCriterion("has_cookie_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIME))
                .addCriterion("has_cookie_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY))
                .addCriterion("has_cookie_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_cookie"));

        AdvancementHolder craftBest = getAdvancement(craftCookie, FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, "craft_best", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.MONSTER_MASH), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.MONSTER_MASH))

                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_SPIDER_EYE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SPIDER_EYE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_SLIME), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIME))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_COBWEB), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_COBWEB))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_GHAST_TEAR), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_GHAST_TEAR))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_SOUL_BERRY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SOUL_BERRY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUP_WITHER_BERRY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_WITHER_BERRY))

                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_SPIDEREYE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SPIDEREYE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_GHASTTEAR), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_GHASTTEAR))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUNCH_COBWEB), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_COBWEB))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_best"));

        AdvancementHolder craftBoneShard = getAdvancement(root, FrightsDelightItemsImpl.BONE_SHARD, "craft_bone_shard", AdvancementType.TASK, true, true, false)
                .addCriterion("has_bone_shard", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_SHARD))
                .save(consumer, getAdvancementName("craft_bone_shard"));

        AdvancementHolder hitSkeletonWithBoneShard = getAdvancement(craftBoneShard, FrightsDelightItemsImpl.BONE_SHARD, "hit_skeleton_with_bone_shard", AdvancementType.TASK, true, true, false)
                .addCriterion("hit_skelton_with_bone_shard", PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntity(
                        Optional.of(DamagePredicate.Builder.damageInstance()
                                .type(DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                                        .direct(EntityPredicate.Builder.entity().of(FrightsDelightEntityTypesImpl.BONE_SHARD.get()))).build()),
                        Optional.of(EntityPredicate.Builder.entity().of(EntityType.SKELETON).build())))
                .save(consumer, getAdvancementName("hit_skeleton_with_bone_shard"));

        AdvancementHolder getSoulBerry = getAdvancement(root, FrightsDelightItemsImpl.SOUL_BERRY, "get_soul_berry", AdvancementType.TASK, true, true, false)
                .addCriterion("has_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY))
                .save(consumer, getAdvancementName("get_soul_berry"));

        AdvancementHolder getWitherBerry = getAdvancement(getSoulBerry, FrightsDelightItemsImpl.WITHER_BERRY, "get_wither_berry", AdvancementType.TASK, true, true, false)
                .addCriterion("has_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY))
                .save(consumer, getAdvancementName("get_wither_berry"));

        AdvancementHolder craftPunchBowl = getAdvancement(root, FrightsDelightItemsImpl.PUNCH_SPIDEREYE, "craft_punchbowl", AdvancementType.TASK, true, true, false)
                .addCriterion("has_punchbowl_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH))
                .addCriterion("has_punchbowl_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE))
                .addCriterion("has_punchbowl_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE))
                .addCriterion("has_punchbowl_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB))
                .addCriterion("has_punchbowl_ghasttear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR))
                .addCriterion("has_punchbowl_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY))
                .addCriterion("has_punchbowl_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_punchbowl"));

        AdvancementHolder candySyrup = getAdvancement(root, FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE, "craft_candy_syrup", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_candy_syrup"));

        AdvancementHolder lollipopMold = getAdvancement(candySyrup, FrightsDelightItemsImpl.LOLLIPOP_MOLD, "craft_lollipop_mold", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.LOLLIPOP_MOLD), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightBlocksImpl.LOLLIPOP_MOLD))
                .save(consumer, getAdvancementName("craft_lollipop_mold"));

        AdvancementHolder lollipopLollipop = getAdvancement( lollipopMold, FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP, "craft_lollipop_lollipop", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_LOLLIPOP))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_lollipop_lollipop"));

        AdvancementHolder ringCandyMold = getAdvancement(candySyrup, FrightsDelightItemsImpl.RING_CANDY_MOLD, "craft_ring_candy_mold", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.RING_CANDY_MOLD), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightBlocksImpl.RING_CANDY_MOLD))
                .save(consumer, getAdvancementName("craft_ring_candy_mold"));

        AdvancementHolder ringCandy = getAdvancement(ringCandyMold, FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY, "craft_ring_candy", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_RING_CANDY))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_ring_candy"));

        AdvancementHolder trickOrTreat = getAdvancement(root, FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET, "trick_or_treat", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUMPKIN_CANDY_BASKET))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.MELON_CANDY_BASKET), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.MELON_CANDY_BASKET))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("trick_or_treat"));

        AdvancementHolder mysteryCandy = getAdvancement(trickOrTreat, FrightsDelightItemsImpl.JACK_O_LANTERN_CANDY_BASKET, "mystery_candy", AdvancementType.TASK, true, true, false)
                .addCriterion("shuffle_candy_basket", CandyBasketShuffleTrigger.TriggerInstance.simple())
                .save(consumer, getAdvancementName("mystery_candy"));

        AdvancementHolder frdMaster = getAdvancement(craftPunchBowl, FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, "frd_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_apple_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.APPLE_SLIME))
                .addCriterion("has_undead_kebab", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.UNDEAD_KEBAB))
                .addCriterion("has_bone_kebab_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH))
                .addCriterion("has_bone_kebab_spider_eye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE))
                .addCriterion("has_bone_kebab_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE))
                .addCriterion("has_bone_kebab_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SLIME))
                .addCriterion("has_web_on_stick", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WEB_ON_STICK))
                .addCriterion("has_bone_kebab_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR))
                .addCriterion("has_bone_kebab_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY))
                .addCriterion("has_bone_kebab_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY))
                .addCriterion("has_monster_mash", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.MONSTER_MASH))
                .addCriterion("has_pasta_with_slimeballs", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS))
                .addCriterion("has_soup_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH))
                .addCriterion("has_soup_spider_eye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SPIDER_EYE))
                .addCriterion("has_soup_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE))
                .addCriterion("has_soup_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIME))
                .addCriterion("has_soup_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_COBWEB))
                .addCriterion("has_soup_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_GHAST_TEAR))
                .addCriterion("has_soup_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SOUL_BERRY))
                .addCriterion("has_soup_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_WITHER_BERRY))
                .addCriterion("has_cookie_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH))
                .addCriterion("has_cookie_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE))
                .addCriterion("has_cookie_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE))
                .addCriterion("has_cookie_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIME))
                .addCriterion("has_cookie_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_COBWEB))
                .addCriterion("has_cookie_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR))
                .addCriterion("has_cookie_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY))
                .addCriterion("has_cookie_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY))
                .addCriterion("has_punch_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH))
                .addCriterion("has_punch_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SPIDEREYE))
                .addCriterion("has_punch_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE))
                .addCriterion("has_punch_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_COBWEB))
                .addCriterion("has_punch_ghasttear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_GHASTTEAR))
                .addCriterion("has_punch_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY))
                .addCriterion("has_punch_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_PIE_SLICE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_PIE_SLICE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_LOLLIPOP), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_LOLLIPOP))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY))
                .addCriterion(RecipeGenerator.getHasName(FrightsDelightItemsImpl.COBWEB_RING_CANDY), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COBWEB_RING_CANDY))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, getAdvancementName("frd_master"));
    }

    private static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike icon, String name, AdvancementType type, boolean showToast, boolean announceChat, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(new ItemStack(icon),
                        TextUtils.getTranslatable("advancement." + name),
                        TextUtils.getTranslatable("advancement." + name + ".desc"),
                        null, type, showToast, announceChat, hidden);
    }

    private static String getAdvancementName(String string) {
        return TextUtils.res("main/" + string).toString();
    }
}
