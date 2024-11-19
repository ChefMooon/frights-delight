package com.chefmooon.frightsdelight.common;


import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.MobEffectInfo;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

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


    public static final FoodProperties SOUL_BERRY = foodProperty(2, 0.4f,
            List.of(new MobEffectInfo(FORTIFIED_MIND, BRIEF_DURATION, 1.f)));

    public static final FoodProperties WITHER_BERRY = foodProperty(2, 0.4f,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, BRIEF_DURATION, 1.f),
                    new MobEffectInfo(HYSTERIA, BRIEF_DURATION,  1.f)));

    public static final FoodProperties APPLE_SLIME = foodProperty(5, 0.4f,
            List.of(new MobEffectInfo(SLIMED, SHORT_DURATION, .75f)));

    // *** KEBABS *** //

    public static final FoodProperties UNDEAD_KEBAB = foodProperty(7, 0.6f, false, false,
            List.of(new MobEffectInfo(INFECTED, SHORT_DURATION, .65f),
                    new MobEffectInfo(CHILLS, SHORT_DURATION, .65f),
                    new MobEffectInfo(HYSTERIA, SHORT_DURATION, .65f)));

    public static final FoodProperties BONE_KEBAB_ROTTEN_FLESH = foodProperty(6, 0.5f,
            List.of(new MobEffectInfo(INFECTED, SHORT_DURATION, .65f)));
    public static final FoodProperties BONE_KEBAB_SPIDER_EYE = foodProperty(7, 0.6f,
            List.of(new MobEffectInfo(HYSTERIA, SHORT_DURATION, .65f)));
    public static final FoodProperties BONE_KEBAB_SLIMEAPPLE = foodProperty(8, 0.6f,
            List.of(new MobEffectInfo(SLIMED, SHORT_DURATION, .65f)));
    public static final FoodProperties BONE_KEBAB_SLIME = foodProperty(7, 0.6f,
            List.of(new MobEffectInfo(SLIMED, SHORT_DURATION, .65f)));
    public static final FoodProperties WEB_ON_STICK = foodProperty(6, 0.5f,
            List.of(new MobEffectInfo(COBWEBBED, SHORT_DURATION, .65f)));
    public static final FoodProperties BONE_KEBAB_GHAST_TEAR = foodProperty(7, 0.6f,
            List.of(new MobEffectInfo(CHILLS, SHORT_DURATION, .65f)));

    public static final FoodProperties BONE_KEBAB_SOUL_BERRY = foodProperty(6, 0.5f,
            List.of(new MobEffectInfo(FORTIFIED_MIND, SHORT_DURATION, 1.f)));
    public static final FoodProperties BONE_KEBAB_WITHER_BERRY = foodProperty(6, 0.5f,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, SHORT_DURATION, 1.f)));

    // *** PLATES N' STUFF *** //

    public static final FoodProperties MONSTER_MASH = foodProperty(10, 0.6f, false, false,
            List.of(new MobEffectInfo(CHILLS, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(INFECTED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(HYSTERIA, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(NOURISHMENT, LONG_DURATION, 1.f)));
    public static final FoodProperties PASTA_WITH_SLIMEBALLS = foodProperty(10, 0.6f,
            List.of(new MobEffectInfo(SLIMED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(NOURISHMENT, LONG_DURATION, 1.f)));

    // *** SOUP *** //

    public static final FoodProperties SOUP_ROTTEN_FLESH = foodProperty(8, 0.7f, false, false,
            List.of(new MobEffectInfo(INFECTED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_SPIDER_EYE = foodProperty(8, 0.7f, false, false,
            List.of(new MobEffectInfo(HYSTERIA, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_SLIME = foodProperty(8, 0.7f,
            List.of(new MobEffectInfo(SLIMED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_COBWEB = foodProperty(8, 0.7f,
            List.of(new MobEffectInfo(COBWEBBED, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_GHAST_TEAR = foodProperty(8, 0.7f,
            List.of(new MobEffectInfo(CHILLS, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));

    public static final FoodProperties SOUP_SOUL_BERRY = foodProperty(8, 0.7f,
            List.of(new MobEffectInfo(FORTIFIED_MIND, MEDIUM_DURATION, 1.f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));
    public static final FoodProperties SOUP_WITHER_BERRY = foodProperty(8, 0.7f,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, MEDIUM_DURATION, 1.f),
                    new MobEffectInfo(COMFORT, LONG_DURATION, 1.f)));

    // *** COOKIES *** //

    public static final FoodProperties COOKIE_ROTTEN_FLESH = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(INFECTED, BRIEF_DURATION, .75f)));
    public static final FoodProperties COOKIE_SPIDER_EYE = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(HYSTERIA, BRIEF_DURATION, .75f)));
    public static final FoodProperties COOKIE_SLIMEAPPLE = foodProperty(2, 0.2f, true, false,
            List.of(new MobEffectInfo(SLIMED, BRIEF_DURATION, .75f)));
    public static final FoodProperties COOKIE_SLIME = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(SLIMED, BRIEF_DURATION, .75f)));
    public static final FoodProperties COOKIE_COBWEB = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(COBWEBBED, BRIEF_DURATION, .75f)));
    public static final FoodProperties COOKIE_GHAST_TEAR = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(CHILLS, BRIEF_DURATION, .75f)));

    public static final FoodProperties COOKIE_SOUL_BERRY = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(FORTIFIED_MIND, SHORT_DURATION, 1.f)));
    public static final FoodProperties COOKIE_WITHER_BERRY = foodProperty(2, 0.1f, true, false,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, SHORT_DURATION, 1.f)));

    // *** PUNCH *** //

    public static final FoodProperties PUNCH_ROTTEN_FLESH = foodProperty(4, 0.4f, false, false,
            List.of(new MobEffectInfo(INFECTED, BRIEF_DURATION, .5f)));
    public static final FoodProperties PUNCH_SPIDER_EYE = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(HYSTERIA, BRIEF_DURATION, .5f)));
    public static final FoodProperties PUNCH_SLIME_APPLE = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(MobEffects.GLOWING, MEDIUM_DURATION, .5f),
                    new MobEffectInfo(SLIMED, BRIEF_DURATION, .75f)));
    public static final FoodProperties PUNCH_COBWEB = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(COBWEBBED, BRIEF_DURATION, .5f)));
    public static final FoodProperties PUNCH_GHAST_TEAR = foodProperty(4, 0.4f,
            List.of(new MobEffectInfo(CHILLS, BRIEF_DURATION, .5f)));

    public static final FoodProperties PUNCH_SOUL_BERRY = foodProperty(4, 0.4f, false, true,
            List.of(new MobEffectInfo(FORTIFIED_MIND, MEDIUM_DURATION, 1.0f)));

    public static final FoodProperties PUNCH_WITHER_BERRY = foodProperty(4, 0.4f, false, true,
            List.of(new MobEffectInfo(UNDEAD_HUNGER, MEDIUM_DURATION, 1.0f)));

    public static FoodProperties foodProperty(int nutrition, float saturation, List<MobEffectInfo> effects) {
        return foodProperty(nutrition, saturation, false, false, effects);
    }
    @ExpectPlatform
    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isFast, boolean alwaysEat, List<MobEffectInfo> effects) {
        throw new AssertionError();
    }

    // In Dev only? stops null pointer before effects are fully registered, I think.
    // The below methods[getComfort()/getNourishment()] may fix this
    // TODO: continue testing, keep an eye on for bug
    public static Holder<MobEffect> nonNullEffect(Holder<MobEffect> effect) {
        return effect != null ? effect : MobEffects.HEAL;
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