package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightEntityTypesImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class TranslationGenerator extends FabricLanguageProvider {
    public TranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {

        String MOD_ID = FrightsDelight.MOD_ID;
        String SUBTITLE = MOD_ID + ".subtitles";
        String EFFECT = "effect." + MOD_ID;
        String ADVANCEMENT = MOD_ID + ".advancement";
        String CONFIG = MOD_ID + ".midnightconfig.";
        String REI = MOD_ID + ".rei.";
        String WAILA = MOD_ID + ".tooltip.waila";
        String WAILA_CONFIG = "config.waila.plugin_" + MOD_ID;
        String FORMATTED_MOD_ID = "Fright's Delight";
        String DEATH = "death.attack." + MOD_ID;
        String FLUID = "fluid_type." + MOD_ID + ".";

        translationBuilder.add("itemGroup." + MOD_ID, FORMATTED_MOD_ID);

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");

        translationBuilder.add(MOD_ID + ".tooltip.glass_cup", "Shift-right-click to place. Right-click with a tool to rotate.");

        translationBuilder.add(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), "Bone Shard");

        translationBuilder.add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), "Wither Berry Bush");
        translationBuilder.add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), "Soul Berry Bush");

        translationBuilder.add(FrightsDelightItemsImpl.BONE_SHARD.get(), "Bone Shard");

        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY.get(), "Wither Berries");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY.get(), "Soul Berries");

        translationBuilder.add(FrightsDelightItemsImpl.FLESH_CRATE.get(), "Flesh Crate");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_CRATE.get(), "Bone Crate");
        translationBuilder.add(FrightsDelightItemsImpl.PHANTOM_CRATE.get(), "Phantom Membrane Crate");
        translationBuilder.add(FrightsDelightItemsImpl.WEB_CRATE.get(), "Cobweb Crate");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDER_EYE_CRATE.get(), "Spider Eye Crate");
        translationBuilder.add(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE.get(), "Fermented Spider Eye Crate");
        translationBuilder.add(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE.get(), "Poisonous Potato Crate");
        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE.get(), "Rotten Tomato Crate");

        translationBuilder.add(FrightsDelightItemsImpl.APPLE_SLIME.get(), "Slime-Apple");
        translationBuilder.add(FrightsDelightItemsImpl.UNDEAD_KEBAB.get(), "Undead Kebab");

        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH.get(), "Rotten Flesh Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE.get(), "Spider Eye Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE.get(), "Slime-Apple Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME.get(), "Slimeball Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.WEB_ON_STICK.get(), "Cobweb Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR.get(), "Ghast Tear Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY.get(), "Soul Berry Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY.get(), "Wither Berry Kebab");

        translationBuilder.add(FrightsDelightItemsImpl.MONSTER_MASH.get(), "Monster Mash");
        translationBuilder.add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS.get(), "Slimeball Spaghetti");

        translationBuilder.add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get(), "Rotten Flesh Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get(), "Spider Eye Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE.get(), "Slime-Apple Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SLIME.get(), "Slimeball Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_COBWEB.get(), "Cobweb Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR.get(), "Ghast Tear Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY.get(), "Soul Berry Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY.get(), "Wither Berry Soup");

        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get(), "Rotten Flesh Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get(), "Spider Eye Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE.get(), "Slime-Apple Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SLIME.get(), "Slimeball Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_COBWEB.get(), "Cobweb Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR.get(), "Ghast Tear Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get(), "Soul Berry Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY.get(), "Wither Berry Cookie");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), "Rotten Flesh Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), "Slime-Apple Cider");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), "Spider Eye Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), "Ghast Tear Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), "Soul Berry Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), "Wither Berry Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_COBWEB.get(), "Cobweb Punch");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH.get(), "Rotten Flesh Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get(), "Slime-Apple Cider Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get(), "Spider Eye Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get(), "Ghast Tear Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get(), "Soul Berry Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get(), "Wither Berry Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB.get(), "Cobweb Punch Bowl");

        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE.get(), "Rotten Flesh Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE.get(), "Slime-Apple Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDEREYE_PIE.get(), "Spider Eye Pie");
        translationBuilder.add(FrightsDelightItemsImpl.GHASTTEAR_PIE.get(), "Ghast Tear Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE.get(), "Soul Berry Cheesecake");
        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE.get(), "Wither Berry Cheesecake");
        translationBuilder.add(FrightsDelightItemsImpl.COBWEB_PIE.get(), "Cobweb Pie");

        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get(), "Slice of Rotten Flesh Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get(), "Slice of Slime-Apple Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get(), "Slice of Spider Eye Pie");
        translationBuilder.add(FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get(), "Slice of Ghast Tear Pie");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get(), "Slice of Soul Berry Cheesecake");
        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get(), "Slice of Wither Berry Cheesecake");
        translationBuilder.add(FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get(), "Slice of Cobweb Pie");

        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_FLESH_SYRUP_BOTTLE.get(), "Bottle of Rotten Flesh Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.SLIMEAPPLE_SYRUP_BOTTLE.get(), "Bottle of Slime-Apple Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDEREYE_SYRUP_BOTTLE.get(), "Bottle of Spider Eye Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.GHASTTEAR_SYRUP_BOTTLE.get(), "Bottle of Ghast Tear Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY_SYRUP_BOTTLE.get(), "Bottle of Soul Berry Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY_SYRUP_BOTTLE.get(), "Bottle of Wither Berry Syrup");
        translationBuilder.add(FrightsDelightItemsImpl.COBWEB_SYRUP_BOTTLE.get(), "Bottle of Cobweb Syrup");

        translationBuilder.add(FrightsDelightItemsImpl.UNFIRED_LOLLIPOP_MOLD.get(), "Unfired Lollipop Mold");
        translationBuilder.add(FrightsDelightItemsImpl.LOLLIPOP_MOLD.get(), "Lollipop Mold");
        translationBuilder.add(FrightsDelightItemsImpl.UNFIRED_RING_CANDY_MOLD.get(), "Unfired Ring Candy Mold");
        translationBuilder.add(FrightsDelightItemsImpl.RING_CANDY_MOLD.get(), "Ring Candy Mold");

        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_FLESH_LOLLIPOP.get(), "Rotten Flesh Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDEREYE_LOLLIPOP.get(), "Spider Eye Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.SLIMEAPPLE_LOLLIPOP.get(), "Slime-Apple Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.GHASTTEAR_LOLLIPOP.get(), "Ghast Tear Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY_LOLLIPOP.get(), "Soul Berry Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY_LOLLIPOP.get(), "Wither Berry Lollipop");
        translationBuilder.add(FrightsDelightItemsImpl.COBWEB_LOLLIPOP.get(), "Cobweb Lollipop");

        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_FLESH_RING_CANDY.get(), "Rotten Flesh Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDEREYE_RING_CANDY.get(), "Spider Eye Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.SLIMEAPPLE_RING_CANDY.get(), "Slime-Apple Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.GHASTTEAR_RING_CANDY.get(), "Ghast Tear Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY_RING_CANDY.get(), "Soul Berry Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY_RING_CANDY.get(), "Wither Berry Ring Candy");
        translationBuilder.add(FrightsDelightItemsImpl.COBWEB_RING_CANDY.get(), "Cobweb Ring Candy");

        translationBuilder.add(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get(), "Pumpkin Candy Basket");
        translationBuilder.add(FrightsDelightBlocksImpl.JACK_O_LANTERN_CANDY_BASKET.get(), "Jack o'Lantern Candy Basket");
        translationBuilder.add(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get(), "Melon Candy Basket");

        translationBuilder.add(FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get().getDescriptionId() + ".bone_shard_requirement", "Requires 4 Bone Shards");

        translationBuilder.add("container.candy_basket", "Candy Basket");

        translationBuilder.add(FLUID + FrightsDelightFluids.ROTTEN_FLESH_SYRUP_LOCATION.getPath(), "Rotten Flesh Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.SPIDEREYE_SYRUP_LOCATION.getPath(), "Spider Eye Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.SLIMEAPPLE_SYRUP_LOCATION.getPath(), "Slime-Apple Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.GHASTTEAR_SYRUP_LOCATION.getPath(), "Ghast Tear Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.SOUL_BERRY_SYRUP_LOCATION.getPath(), "Soul Berry Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.WITHER_BERRY_SYRUP_LOCATION.getPath(), "Wither Berry Syrup");
        translationBuilder.add(FLUID + FrightsDelightFluids.COBWEB_SYRUP_LOCATION.getPath(), "Cobweb Syrup");

        translationBuilder.add(EFFECT + ".chills", "Chills");
        translationBuilder.add(EFFECT + ".cobwebbed", "Cobwebbed");
        translationBuilder.add(EFFECT + ".fortified_mind", "Fortified Mind");
        translationBuilder.add(EFFECT + ".hysteria", "Hysteria");
        translationBuilder.add(EFFECT + ".infected", "Infected");
        translationBuilder.add(EFFECT + ".slimed", "Slimed");
        translationBuilder.add(EFFECT + ".undead_hunger", "Undead Hunger");

        translationBuilder.add(EFFECT + ".chills.description", "You feel a spectral presence nearby, you may feel a chill if they pass through you.");
        translationBuilder.add(EFFECT + ".cobwebbed.description", "Slightly decreases walking speed.");
        translationBuilder.add(EFFECT + ".fortified_mind.description", "Removes and grants immunity to Hysteria and Chills.");
        translationBuilder.add(EFFECT + ".hysteria.description", "Your mind may play tricks on you... Monsters can be hear near and far.");
        translationBuilder.add(EFFECT + ".infected.description", "Greatly increases food exhaustion.");
        translationBuilder.add(EFFECT + ".slimed.description", "Slightly decreases walking speed; you may also hear the occasional slimy sound.");
        translationBuilder.add(EFFECT + ".undead_hunger.description", "Removes and grants immunity to Food Poisoning and Infected.");

        translationBuilder.add(MOD_ID + ".effect.chills.start", "You feel a chill in the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.end", "A warmth returns to the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.chance", "You feel like you are being watched ...");
        translationBuilder.add(MOD_ID + ".effect.chills.encounter", "You feel a chill run down your spine ...");

        translationBuilder.add(SUBTITLE + ".effect_hysteria.close", "Close Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.mid", "Mid Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.far", "Distant Hysteria");

        translationBuilder.add(SUBTITLE + ".effect_slimed.walk", "Slimy Feet");

        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.add", "Drink Added");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.remove", "Drink Removed");

        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_rotten_flesh.bubble", "Fleshy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_spider_eye.bubble", "Creepy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_slimeapple.bubble", "Slimy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_cobweb.bubble", "Sticky Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_ghast_tear.bubble", "Ghastly Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_soul_berry.bubble", "Shimmering Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_wither_berry.bubble", "Withered Bubble");

        translationBuilder.add(SUBTITLE + ".entity.bone_shard.throw", "Bone Shard flies");
        translationBuilder.add(SUBTITLE + ".entity.bone_shard.hit", "Bone Shard shatters");

        translationBuilder.add(SUBTITLE + ".block.candy_mold.add", "Bone Shard Added");
        translationBuilder.add(SUBTITLE + ".block.candy_mold.fill", "Mold Filled");
        translationBuilder.add(SUBTITLE + ".block.candy_mold.drain", "Mold Drained");
        translationBuilder.add(SUBTITLE + ".block.candy_mold.remove", "Bone Shard(s) Removed");
        translationBuilder.add(SUBTITLE + ".block.candy_mold.collect", "Candy Taken");
        translationBuilder.add(SUBTITLE + ".block.candy_mold.harden", "Candy Hardened");

        translationBuilder.add(SUBTITLE + ".block.candy_basket.add", "Candy Added");
        translationBuilder.add(SUBTITLE + ".block.candy_basket.remove", "Candy Removed");
        translationBuilder.add(SUBTITLE + ".block.candy_basket.shuffle", "Candy Shuffled");
        translationBuilder.add(SUBTITLE + ".block.candy_basket.empty", "Candy Basket Empty");

        translationBuilder.add(DEATH + ".soul_berry_bush", "%1$s was pricked to death by a Soul Berry Bush");
        translationBuilder.add(DEATH + ".soul_berry_bush.player", "%1$s was sent to a prickly grave by %2$s");

        translationBuilder.add(DEATH + ".wither_berry_bush", "%1$s was pricked to death by a Wither Berry Bush");
        translationBuilder.add(DEATH + ".wither_berry_bush.player", "%1$s was sent to a prickly grave by %2$s");

        translationBuilder.add(ADVANCEMENT + ".root", FORMATTED_MOD_ID);
        translationBuilder.add(ADVANCEMENT + ".root.desc", "Welcome to a world of unusual delights. Consume with caution.");
        translationBuilder.add(ADVANCEMENT + ".get_soul_berry", "Soul Berry Bush");
        translationBuilder.add(ADVANCEMENT + ".get_soul_berry.desc", "These can be found in Bastion chests in the Nether and require a Soul Flame source nearby to grow. Berries will shimmer if growing");
        translationBuilder.add(ADVANCEMENT + ".get_wither_berry", "Wither Berry Bush");
        translationBuilder.add(ADVANCEMENT + ".get_wither_berry.desc", "Soul Berry Bush can be turned into this in the dark with a Wither Essence source very close. Berries will smoke if growing");
        translationBuilder.add(ADVANCEMENT + ".get_monster_drop", "Unusual Effects");
        translationBuilder.add(ADVANCEMENT + ".get_monster_drop.desc", "Food made with monster drops may not look good ... but some say it tastes like chicken. Beware of adverse effects.");
        translationBuilder.add(ADVANCEMENT + ".craft_cookie", "Cooked Monster");
        translationBuilder.add(ADVANCEMENT + ".craft_cookie.desc", "Cooking the food in different ways seems to make the effect less common");
        translationBuilder.add(ADVANCEMENT + ".craft_best", "Almost Edible");
        translationBuilder.add(ADVANCEMENT + ".craft_best.desc", "Food in plates, bowls, and drinks seem to be the \"safest\" to consume");
        translationBuilder.add(ADVANCEMENT + ".craft_punchbowl", "Something's in my Punch");
        translationBuilder.add(ADVANCEMENT + ".craft_punchbowl.desc", "Drinks can be combined and placed. Grab a bottle and have a sip!");
        translationBuilder.add(ADVANCEMENT + ".craft_bone_shard", "Bone Kebab");
        translationBuilder.add(ADVANCEMENT + ".craft_bone_shard.desc", "Cut a Bone with a Knife on a Cutting Board. Can be used to protect, attack, or to make a light snack.");
        translationBuilder.add(ADVANCEMENT + ".hit_skeleton_with_bone_shard", "Bone Shattering");
        translationBuilder.add(ADVANCEMENT + ".hit_skeleton_with_bone_shard.desc", "Throw a Bone Shard at a skeleton!");
        translationBuilder.add(ADVANCEMENT + ".craft_candy_syrup", "Candy Syrup");
        translationBuilder.add(ADVANCEMENT + ".craft_candy_syrup.desc", "Cook a concentrated syrup in the cooking pot");
        translationBuilder.add(ADVANCEMENT + ".craft_lollipop_mold", "Lollipop Mold");
        translationBuilder.add(ADVANCEMENT + ".craft_lollipop_mold.desc", "Use a Knife to cut a clay block into a mold on the cutting board, then cook it");
        translationBuilder.add(ADVANCEMENT + ".craft_lollipop_lollipop", "Lollipop Lollipop");
        translationBuilder.add(ADVANCEMENT + ".craft_lollipop_lollipop.desc", "Add 4 bone shards and any syrup to a Lollipop Mold and wait for it to harden");
        translationBuilder.add(ADVANCEMENT + ".craft_ring_candy_mold", "Ring Candy Mold");
        translationBuilder.add(ADVANCEMENT + ".craft_ring_candy_mold.desc", "Use a Glass Bottle to turn a clay block into a mold on the cutting board, then cook it");
        translationBuilder.add(ADVANCEMENT + ".craft_ring_candy", "Life Saver");
        translationBuilder.add(ADVANCEMENT + ".craft_ring_candy.desc", "Add any syrup to a Ring Candy Mold and wait for it to harden");
        translationBuilder.add(ADVANCEMENT + ".trick_or_treat", "Trick or Treat");
        translationBuilder.add(ADVANCEMENT + ".trick_or_treat.desc", "Craft a Candy Basket to hold your most valuable treats!");
        translationBuilder.add(ADVANCEMENT + ".mystery_candy", "Mystery Candy");
        translationBuilder.add(ADVANCEMENT + ".mystery_candy.desc", "When there is more than one item in the basket they can be shuffled for a surprise");
        translationBuilder.add(ADVANCEMENT + ".frd_master", "Master of Fright");
        translationBuilder.add(ADVANCEMENT + ".frd_master.desc", "Conquer all food and drink items in " + FORMATTED_MOD_ID);

        translationBuilder.add(CONFIG + "title", FORMATTED_MOD_ID + " Settings");
        translationBuilder.add(CONFIG + "category.common", "Common Settings");
        translationBuilder.add(CONFIG + "category.client", "Client Settings");

        translationBuilder.add(CONFIG + "enableFrDCrates", "Enable FrD Crop Crates?");
        translationBuilder.add(CONFIG + "farmersBuyFrDCrops", "Farmer's Buy FrD Berries");
        translationBuilder.add(CONFIG + "wanderingTraderSellsFrdDItems", "Wandering Trader Sells FrD items");

        translationBuilder.add(CONFIG + "worldGenerationSettings", "World Generation");
        translationBuilder.add(CONFIG + "generateSoulBerryLoot", "Should Soul Berries spawn in Bastion chests?");
        translationBuilder.add(CONFIG + "generateWildSoulBerry", "Should Soul Berry Bushes naturally spawn in the Nether?");

        translationBuilder.add(CONFIG + "fortifiedMindOverlay", "Enable/Disable Fortified Mind Effect Overlay");
        translationBuilder.add(CONFIG + "undeadHungerOverlay", "Enable/Disable Undead Hunger Effect Overlay");
        translationBuilder.add(CONFIG + "slimedOverlay", "Enable/Disable Slime Walk Effect Overlay");
        translationBuilder.add(CONFIG + "cobwebbedOverlay", "Enable/Disable Cobwebbed Effect Overlay");
        translationBuilder.add(CONFIG + "infectedOverlay", "Enable/Disable Infected Effect Overlay");
        translationBuilder.add(CONFIG + "hysteriaOverlay", "Enable/Disable Hysteria Effect Overlay");
        translationBuilder.add(CONFIG + "chillsOverlay", "Enable/Disable Chills Effect Overlay");
        translationBuilder.add(CONFIG + "foodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");
        translationBuilder.add(CONFIG + "foodEffectChanceTooltip", "Should meal and drink tooltips display the chance the effect will be applied?");
        translationBuilder.add(CONFIG + "drinkableFeastParticles", "Should Punch Bowl blocks emit bubble particles?");
        translationBuilder.add(CONFIG + "glassCupParticles", "Should Glass Cup blocks emit bubble particles?");
        translationBuilder.add(CONFIG + "candyMoldParticles", "Should Candy Mold blocks emit particles when hardening candy?");
        translationBuilder.add(CONFIG + "punchConsumeSound", "Should Punch have a chance to play a sound when consumed?");
        translationBuilder.add(CONFIG + "punchConsumeChance", "The chance a sound will be played while consuming a drink? (4 = 25%)");

        translationBuilder.add(REI + "info.soul_berry", "Found spawning naturally in the Nether or in Bastion chests. Growth requirement: Soul Essence source");
        translationBuilder.add(REI + "info.wither_berry", "Can be transformed from a Soul Berry Bush. Chance to transform on growth when: Soul Berry Bush at Max Growth, Wither Essence source very close, low light level.");

        translationBuilder.add(REI + "info.lollipop_mold", "Add four bone shards and any syrup to a lollipop mold, wait for the syrup to harden, then right-click the mold to collect the lollipops.");
        translationBuilder.add(REI + "info.ring_candy_mold", "Add any syrup to a ring candy mold, wait for it to harden, then right-click the mold to collect the candies.");
        translationBuilder.add(REI + "info.candy_basket", "This can store up to nine edible items. Right-click either the item in-hand or the placed block to add/remove items; shift-right-click to shuffle them.");

        translationBuilder.add(WAILA + ".bush_growth_condition", "Growth Condition");
        translationBuilder.add(WAILA + ".bush_transform", "Can Transform");
        translationBuilder.add(WAILA + ".punchbowl_servings", "Servings");

        translationBuilder.add(WAILA_CONFIG, FORMATTED_MOD_ID);
        translationBuilder.add(WAILA_CONFIG + ".bush_growth_condition", "Bush Growth Condition");
        translationBuilder.add(WAILA_CONFIG + ".bush_transform_condition", "Bush Transform Condition");
        translationBuilder.add(WAILA_CONFIG + ".punchbowl_servings", "Punch Bowl Servings");

        translationBuilder.add(CommonTags.PUNCH_DRINKS, "Punches");
        translationBuilder.add(CommonTags.SYRUP_DRINKS, "Syrups");

        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_FLESH, "Rotten Flesh Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_BONE, "Bone Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_PHANTOM_MEMBRANE, "Phantom Membrane Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_COBWEB, "Cobweb Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_SPIDER_EYE, "Spider Eye Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_FERMENTED_SPIDER_EYE, "Fermented Spider Eye Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_POISONOUS_POTATO, "Poisonous Potato Storage Blocks");
        translationBuilder.add(CommonTags.C_STORAGE_BLOCKS_ITEM_ROTTEN_TOMATO, "Rotten Tomato Storage Blocks");
    }
}
