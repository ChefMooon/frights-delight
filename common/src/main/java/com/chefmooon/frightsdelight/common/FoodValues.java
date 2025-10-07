package com.chefmooon.frightsdelight.common;


import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.MobEffectInfo;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class FoodValues {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    private static final Holder<MobEffect> COMFORT = getComfort();
    private static final Holder<MobEffect> NOURISHMENT = getNourishment();

    private static final Holder<MobEffect> FORTIFIED_MIND = FrightsDelightEffects.FORTIFIED_MIND;
    private static final Holder<MobEffect> CHILLS = FrightsDelightEffects.CHILLS;
    private static final Holder<MobEffect> INFECTED = FrightsDelightEffects.INFECTED;
    private static final Holder<MobEffect> UNDEAD_HUNGER = FrightsDelightEffects.UNDEAD_HUNGER;
    private static final Holder<MobEffect> HYSTERIA = FrightsDelightEffects.HYSTERIA;
    private static final Holder<MobEffect> COBWEBBED = FrightsDelightEffects.COBWEBBED;
    private static final Holder<MobEffect> SLIMED = FrightsDelightEffects.SLIMED;

    public static ApplyStatusEffectsConsumeEffect comfort(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(COMFORT, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect nourishment(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(NOURISHMENT, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect fortifiedMind(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(FORTIFIED_MIND, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect chills(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(CHILLS, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect infected(int duration, float probability) {
            return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(INFECTED, duration, 0), probability);
    }
    public static ApplyStatusEffectsConsumeEffect undeadHunger(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(UNDEAD_HUNGER, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect hysteria(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(HYSTERIA, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect cobwebbed(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(COBWEBBED, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect slimed(int duration, float probability) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(SLIMED, duration, 0), probability);
    }

    public static ApplyStatusEffectsConsumeEffect comfort(int duration) {
        return comfort(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect nourishment(int duration) {
        return nourishment(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect fortifiedMind(int duration) {
        return fortifiedMind(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect chills(int duration) {
        return chills(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect infected(int duration) {
        return infected(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect undeadHunger(int duration) {
        return undeadHunger(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect hysteria(int duration) {
        return hysteria(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect cobwebbed(int duration) {
        return cobwebbed(duration, 1.0f);
    }

    public static ApplyStatusEffectsConsumeEffect slimed(int duration) {
        return slimed(duration, 1.0f);
    }


    public static final FoodProperties SOUL_BERRY = foodProperty(2, 0.4f);

    public static final FoodProperties WITHER_BERRY = foodProperty(2, 0.4f);

    public static final FoodProperties APPLE_SLIME = foodProperty(5, 0.4f);

    // *** KEBABS *** //

    public static final FoodProperties UNDEAD_KEBAB = foodProperty(7, 0.6f, false);

    public static final FoodProperties BONE_KEBAB_ROTTEN_FLESH = foodProperty(6, 0.5f);
    public static final FoodProperties BONE_KEBAB_SPIDER_EYE = foodProperty(7, 0.6f);
    public static final FoodProperties BONE_KEBAB_SLIMEAPPLE = foodProperty(8, 0.6f);
    public static final FoodProperties BONE_KEBAB_SLIME = foodProperty(7, 0.6f);
    public static final FoodProperties WEB_ON_STICK = foodProperty(6, 0.5f);
    public static final FoodProperties BONE_KEBAB_GHAST_TEAR = foodProperty(7, 0.6f);

    public static final FoodProperties BONE_KEBAB_SOUL_BERRY = foodProperty(6, 0.5f);
    public static final FoodProperties BONE_KEBAB_WITHER_BERRY = foodProperty(6, 0.5f);

    // *** PLATES N' STUFF *** //

    public static final FoodProperties MONSTER_MASH = foodProperty(10, 0.6f, false);
    public static final FoodProperties PASTA_WITH_SLIMEBALLS = foodProperty(10, 0.6f);

    // *** SOUP *** //

    public static final FoodProperties SOUP_ROTTEN_FLESH = foodProperty(8, 0.7f, false);
    public static final FoodProperties SOUP_SPIDER_EYE = foodProperty(8, 0.7f, false);
    public static final FoodProperties SOUP_SLIME = foodProperty(8, 0.7f);
    public static final FoodProperties SOUP_COBWEB = foodProperty(8, 0.7f);
    public static final FoodProperties SOUP_GHAST_TEAR = foodProperty(8, 0.7f);

    public static final FoodProperties SOUP_SOUL_BERRY = foodProperty(8, 0.7f);
    public static final FoodProperties SOUP_WITHER_BERRY = foodProperty(8, 0.7f);

    // *** COOKIES *** //

    public static final FoodProperties COOKIE_ROTTEN_FLESH = foodProperty(2, 0.1f, false);
    public static final FoodProperties COOKIE_SPIDER_EYE = foodProperty(2, 0.1f, false);
    public static final FoodProperties COOKIE_SLIMEAPPLE = foodProperty(2, 0.2f, false);
    public static final FoodProperties COOKIE_SLIME = foodProperty(2, 0.1f, false);
    public static final FoodProperties COOKIE_COBWEB = foodProperty(2, 0.1f, false);
    public static final FoodProperties COOKIE_GHAST_TEAR = foodProperty(2, 0.1f, false);

    public static final FoodProperties COOKIE_SOUL_BERRY = foodProperty(2, 0.1f, false);
    public static final FoodProperties COOKIE_WITHER_BERRY = foodProperty(2, 0.1f, false);

    // *** PUNCH *** //

    public static final FoodProperties PUNCH_ROTTEN_FLESH = foodProperty(4, 0.4f, false);
    public static final FoodProperties PUNCH_SPIDER_EYE = foodProperty(4, 0.4f);
    public static final FoodProperties PUNCH_SLIME_APPLE = foodProperty(4, 0.4f);
    public static final FoodProperties PUNCH_COBWEB = foodProperty(4, 0.4f);
    public static final FoodProperties PUNCH_GHAST_TEAR = foodProperty(4, 0.4f);

    public static final FoodProperties PUNCH_SOUL_BERRY = foodProperty(4, 0.4f, true);

    public static final FoodProperties PUNCH_WITHER_BERRY = foodProperty(4, 0.4f, true);

    public static final FoodProperties ROTTEN_FLESH_PIE_SLICE = foodProperty(4, 0.3f);
    public static final FoodProperties SLIMEAPPLE_PIE_SLICE = foodProperty(4, 0.3f);
    public static final FoodProperties SPIDEREYE_PIE_SLICE = foodProperty(4, 0.3f);
    public static final FoodProperties GHASTTEAR_PIE_SLICE = foodProperty(4, 0.3f);
    public static final FoodProperties SOUL_BERRY_CHEESECAKE_SLICE = foodProperty(4, 0.3f, true);
    public static final FoodProperties WITHER_BERRY_CHEESECAKE_SLICE = foodProperty(4, 0.3f, true);
    public static final FoodProperties COBWEB_PIE_SLICE = foodProperty(4, 0.3f);

    public static FoodProperties foodProperty(int nutrition, float saturation) {
        return foodProperty(nutrition, saturation, false);
    }
    @ExpectPlatform
    public static FoodProperties foodProperty(int nutrition, float saturation, boolean alwaysEat) {
        throw new AssertionError();
    }

    public static class ConsumableValues {

        public static final Consumable FORTIFIED_MIND_BRIEF_DURATION = Consumables.defaultFood()
                .onConsume(fortifiedMind(BRIEF_DURATION))
                .build();

        public static final Consumable SOUL_BERRY = Consumables.defaultFood().
                onConsume(fortifiedMind(SHORT_DURATION))
                .build();

        public static final Consumable WITHER_BERRY = Consumables.defaultFood()
                .onConsume(undeadHunger(SHORT_DURATION))
                .onConsume(hysteria(SHORT_DURATION))
                .build();

        public static final Consumable APPLE_SLIME = Consumables.defaultFood()
                .onConsume(slimed(SHORT_DURATION, 0.75f))
                .build();

        public static final Consumable UNDEAD_KEBAB = Consumables.defaultFood()
                .onConsume(infected(SHORT_DURATION, 0.65f))
                .onConsume(chills(SHORT_DURATION, 0.65f))
                .onConsume(hysteria(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_ROTTEN_FLESH = Consumables.defaultFood()
                .onConsume(infected(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_SPIDER_EYE = Consumables.defaultFood()
                .onConsume(hysteria(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_SLIMEAPPLE = Consumables.defaultFood()
                .onConsume(slimed(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_SLIME = Consumables.defaultFood()
                .onConsume(slimed(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable WEB_ON_STICK = Consumables.defaultFood()
                .onConsume(cobwebbed(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_GHAST_TEAR = Consumables.defaultFood()
                .onConsume(chills(SHORT_DURATION, 0.65f))
                .build();

        public static final Consumable BONE_KEBAB_SOUL_BERRY = Consumables.defaultFood()
                .onConsume(fortifiedMind(SHORT_DURATION))
                .build();

        public static final Consumable BONE_KEBAB_WITHER_BERRY = Consumables.defaultFood()
                .onConsume(undeadHunger(SHORT_DURATION))
                .build();

        public static final Consumable MONSTER_MASH = Consumables.defaultFood()
                .onConsume(chills(MEDIUM_DURATION, 0.5f))
                .onConsume(infected(MEDIUM_DURATION, 0.5f))
                .onConsume(hysteria(MEDIUM_DURATION, 0.5f))
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable PASTA_WITH_SLIMEBALLS = Consumables.defaultFood()
                .onConsume(slimed(MEDIUM_DURATION, 0.5f))
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable SOUP_ROTTEN_FLESH = Consumables.defaultFood()
                .onConsume(infected(MEDIUM_DURATION, 0.5f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_SPIDER_EYE = Consumables.defaultFood()
                .onConsume(hysteria(MEDIUM_DURATION, 0.5f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_SLIME = Consumables.defaultFood()
                .onConsume(slimed(MEDIUM_DURATION, 0.5f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_COBWEB = Consumables.defaultFood()
                .onConsume(cobwebbed(MEDIUM_DURATION, 0.5f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_GHAST_TEAR = Consumables.defaultFood()
                .onConsume(chills(MEDIUM_DURATION, 0.5f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_SOUL_BERRY = Consumables.defaultFood()
                .onConsume(fortifiedMind(MEDIUM_DURATION, 1.0f))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable SOUP_WITHER_BERRY = Consumables.defaultFood()
                .onConsume(undeadHunger(MEDIUM_DURATION))
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable COOKIE_ROTTEN_FLESH = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(infected(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_SPIDER_EYE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(hysteria(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_SLIMEAPPLE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(slimed(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_SLIME = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(slimed(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_COBWEB = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(cobwebbed(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_GHAST_TEAR = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(chills(BRIEF_DURATION, 0.75f))
                .build();

        public static final Consumable COOKIE_SOUL_BERRY = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(fortifiedMind(SHORT_DURATION))
                .build();

        public static final Consumable COOKIE_WITHER_BERRY = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(undeadHunger(SHORT_DURATION))
                .build();

        public static final Consumable PUNCH_ROTTEN_FLESH = Consumables.defaultDrink()
                .onConsume(infected(BRIEF_DURATION, 0.5f))
                .build();

        public static final Consumable PUNCH_SPIDER_EYE = Consumables.defaultDrink()
                .onConsume(hysteria(BRIEF_DURATION, 0.5f))
                .build();

        public static final Consumable PUNCH_SLIME_APPLE = Consumables.defaultDrink()
                .onConsume(slimed(BRIEF_DURATION, 0.75f))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, MEDIUM_DURATION)))
                .build();

        public static final Consumable PUNCH_COBWEB = Consumables.defaultDrink()
                .onConsume(cobwebbed(BRIEF_DURATION, 0.5f))
                .build();

        public static final Consumable PUNCH_GHAST_TEAR = Consumables.defaultDrink()
                .onConsume(chills(BRIEF_DURATION, 0.5f))
                .build();

        public static final Consumable PUNCH_SOUL_BERRY = Consumables.defaultDrink()
                .onConsume(fortifiedMind(MEDIUM_DURATION))
                .build();

        public static final Consumable PUNCH_WITHER_BERRY = Consumables.defaultDrink()
                .onConsume(undeadHunger(MEDIUM_DURATION))
                .build();

        public static final Consumable ROTTEN_FLESH_PIE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(infected(SHORT_DURATION, 0.5f))
                .build();
        public static final Consumable SLIMEAPPLE_PIE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(slimed(SHORT_DURATION, 0.5f))
                .build();
        public static final Consumable SPIDEREYE_PIE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(hysteria(SHORT_DURATION, 0.5f))
                .build();
        public static final Consumable GHASTTEAR_PIE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(chills(SHORT_DURATION, 0.5f))
                .build();
        public static final Consumable SOUL_BERRY_CHEESECAKE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(fortifiedMind(SHORT_DURATION))
                .build();
        public static final Consumable WITHER_BERRY_CHEESECAKE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(undeadHunger(SHORT_DURATION))
                .build();
        public static final Consumable COBWEB_PIE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(cobwebbed(SHORT_DURATION, 0.5f))
                .build();
    }

    @ExpectPlatform
    public static Holder<MobEffect> getComfort() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Holder<MobEffect> getNourishment() {
        throw new AssertionError();
    }
}
