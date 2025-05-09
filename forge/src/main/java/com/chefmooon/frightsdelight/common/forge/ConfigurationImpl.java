package com.chefmooon.frightsdelight.common.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import eu.midnightdust.lib.config.MidnightConfig;

public class ConfigurationImpl extends MidnightConfig{

    @Entry() public static boolean enableFrDCrates = true;
    @Entry() public static boolean farmersBuyFrDCrops = true;
    @Entry() public static boolean wanderingTraderSellsFrdDItems = true;

    @Comment(centered = true) public static Comment worldGenerationSettings;
    @Entry() public static boolean generateSoulBerryLoot = true;
    @Entry() public static boolean generateWildSoulBerry = true;

    @Entry() public static boolean fortifiedMindOverlay = true;
    @Entry() public static boolean undeadHungerOverlay = true;
    @Entry() public static boolean slimedOverlay = true;
    @Entry() public static boolean cobwebbedOverlay = true;
    @Entry() public static boolean infectedOverlay = true;
    @Entry() public static boolean hysteriaOverlay = true;
    @Entry() public static boolean chillsOverlay = true;
    @Entry() public static boolean foodEffectTooltip = true;
    @Entry() public static boolean foodEffectChanceTooltip = true;

    @Entry() public static boolean drinkableFeastParticles = true;
    @Entry() public static boolean punchConsumeSound = true;
    @Entry(isSlider = true,min=0,max=10) public static int punchConsumeChance = 4;

    public static boolean isEnableFrDCrates() {
        return enableFrDCrates;
    }

    public static boolean farmersBuyFrDCrops() {
        return farmersBuyFrDCrops;
    }

    public static boolean wanderingTraderSellsFrdDItems() {
        return wanderingTraderSellsFrdDItems;
    }

    public static boolean generateSoulBerryLoot() {
        return generateSoulBerryLoot;
    }

    public static boolean generateWildSoulBerry() {
        return generateWildSoulBerry;
    }


    public static boolean fortifiedMindOverlay() {
        return fortifiedMindOverlay;
    }

    public static boolean undeadHungerOverlay() {
        return undeadHungerOverlay;
    }

    public static boolean slimedOverlay() {
        return slimedOverlay;
    }

    public static boolean cobwebbedOverlay() {
        return cobwebbedOverlay;
    }

    public static boolean infectedOverlay() {
        return infectedOverlay;
    }

    public static boolean hysteriaOverlay() {
        return hysteriaOverlay;
    }

    public static boolean chillsOverlay() {
        return chillsOverlay;
    }


    public static boolean foodEffectTooltip() {
        return foodEffectTooltip;
    }

    public static boolean foodEffectChanceTooltip() {
        return foodEffectChanceTooltip;
    }


    public static boolean drinkableFeastParticles() {
        return drinkableFeastParticles;
    }

    public static boolean punchConsumeSound() {
        return punchConsumeSound;
    }

    public static int punchConsumeChance() {
        return punchConsumeChance;
    }

    public static void init() {
        MidnightConfig.init(FrightsDelight.MOD_ID, ConfigurationImpl.class);
    }
}
