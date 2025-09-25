package com.chefmooon.frightsdelight.data.fabric;

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
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
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
                .display(FrightsDelightItemsImpl.APPLE_SLIME.get(),
                        TextUtils.getTranslatable("advancement.root"),
                        TextUtils.getTranslatable("advancement.root.desc"),
                        ResourceLocation.parse("minecraft:block/soul_sand"),
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

        AdvancementHolder craftCookie = getAdvancement(getMonsterDrop, FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get(), "craft_cookie", AdvancementType.TASK, true, true, false)
                .addCriterion("has_cookie_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get()))
                .addCriterion("has_cookie_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get()))
                .addCriterion("has_cookie_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_COBWEB.get()))
                .addCriterion("has_cookie_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get()))
                .addCriterion("has_cookie_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get()))
                .addCriterion("has_cookie_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIME.get()))
                .addCriterion("has_cookie_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get()))
                .addCriterion("has_cookie_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_cookie"));

        AdvancementHolder craftBest = getAdvancement(craftCookie, FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get(), "craft_best", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.MONSTER_MASH.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.MONSTER_MASH.get()))

                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_SLIME.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIME.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_COBWEB.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_COBWEB.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get()))

                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get()))
                .addCriterion(RecipeProvider.getHasName(FrightsDelightItemsImpl.PUNCH_COBWEB.get()), InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_COBWEB.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_best"));

        AdvancementHolder craftBoneShard = getAdvancement(root, FrightsDelightItemsImpl.BONE_SHARD.get(), "craft_bone_shard", AdvancementType.TASK, true, true, false)
                .addCriterion("has_bone_shard", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_SHARD.get()))
                .save(consumer, getAdvancementName("craft_bone_shard"));

        AdvancementHolder hitSkeletonWithBoneShard = getAdvancement(craftBoneShard, FrightsDelightItemsImpl.BONE_SHARD.get(), "hit_skeleton_with_bone_shard", AdvancementType.TASK, true, true, false)
                .addCriterion("hit_skelton_with_bone_shard", PlayerHurtEntityTrigger.TriggerInstance.playerHurtEntity(
                        Optional.of(DamagePredicate.Builder.damageInstance()
                                .type(DamageSourcePredicate.Builder.damageType().tag(TagPredicate.is(DamageTypeTags.IS_PROJECTILE))
                                        .direct(EntityPredicate.Builder.entity().of(provider.lookupOrThrow(Registries.ENTITY_TYPE), FrightsDelightEntityTypesImpl.BONE_SHARD.get()))).build()),
                        Optional.of(EntityPredicate.Builder.entity().of(provider.lookupOrThrow(Registries.ENTITY_TYPE), EntityType.SKELETON).build())))
                .save(consumer, getAdvancementName("hit_skeleton_with_bone_shard"));

        AdvancementHolder getSoulBerry = getAdvancement(root, FrightsDelightItemsImpl.SOUL_BERRY.get(), "get_soul_berry", AdvancementType.TASK, true, true, false)
                .addCriterion("has_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUL_BERRY.get()))
                .save(consumer, getAdvancementName("get_soul_berry"));

        AdvancementHolder getWitherBerry = getAdvancement(getSoulBerry, FrightsDelightItemsImpl.WITHER_BERRY.get(), "get_wither_berry", AdvancementType.TASK, true, true, false)
                .addCriterion("has_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WITHER_BERRY.get()))
                .save(consumer, getAdvancementName("get_wither_berry"));

        AdvancementHolder craftPunchBowl = getAdvancement(root, FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), "craft_punchbowl", AdvancementType.TASK, true, true, false)
                .addCriterion("has_punch_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get()))
                .addCriterion("has_punch_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get()))
                .addCriterion("has_punch_ghasttear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get()))
                .addCriterion("has_punch_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get()))
                .addCriterion("has_punch_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, getAdvancementName("craft_punchbowl"));

        AdvancementHolder frdMaster = getAdvancement(craftPunchBowl, FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get(), "frd_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion("has_apple_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.APPLE_SLIME.get()))
                .addCriterion("has_undead_kebab", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.UNDEAD_KEBAB.get()))
                .addCriterion("has_bone_kebab_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get()))
                .addCriterion("has_bone_kebab_spider_eye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get()))
                .addCriterion("has_bone_kebab_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get()))
                .addCriterion("has_bone_kebab_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get()))
                .addCriterion("has_web_on_stick", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.WEB_ON_STICK.get()))
                .addCriterion("has_bone_kebab_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get()))
                .addCriterion("has_bone_kebab_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get()))
                .addCriterion("has_bone_kebab_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get()))
                .addCriterion("has_monster_mash", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.MONSTER_MASH.get()))
                .addCriterion("has_pasta_with_slimeballs", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get()))
                .addCriterion("has_soup_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get()))
                .addCriterion("has_soup_spider_eye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get()))
                .addCriterion("has_soup_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get()))
                .addCriterion("has_soup_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SLIME.get()))
                .addCriterion("has_soup_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_COBWEB.get()))
                .addCriterion("has_soup_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get()))
                .addCriterion("has_soup_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get()))
                .addCriterion("has_soup_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get()))
                .addCriterion("has_cookie_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get()))
                .addCriterion("has_cookie_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get()))
                .addCriterion("has_cookie_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get()))
                .addCriterion("has_cookie_slime", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SLIME.get()))
                .addCriterion("has_cookie_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_COBWEB.get()))
                .addCriterion("has_cookie_ghast_tear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get()))
                .addCriterion("has_cookie_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get()))
                .addCriterion("has_cookie_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get()))
                .addCriterion("has_punch_rotten_flesh", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get()))
                .addCriterion("has_punch_spidereye", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get()))
                .addCriterion("has_punch_slimeapple", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get()))
                .addCriterion("has_punch_cobweb", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_COBWEB.get()))
                .addCriterion("has_punch_ghasttear", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get()))
                .addCriterion("has_punch_soul_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get()))
                .addCriterion("has_punch_wither_berry", InventoryChangeTrigger.TriggerInstance.hasItems(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get()))
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
