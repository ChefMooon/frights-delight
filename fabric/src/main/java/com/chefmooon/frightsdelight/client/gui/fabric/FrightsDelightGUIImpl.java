package com.chefmooon.frightsdelight.client.gui.fabric;

import com.chefmooon.frightsdelight.client.gui.FrightsDelightGUI;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class FrightsDelightGUIImpl {

    public static int getFoodIconOffset() {
        return 39;
    }

    public static void register() {
        registerOverlay(null, FrightsDelightGUI.ChillsOverlay.ID, FrightsDelightGUI.ChillsOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.ChillsOverlay.ID, FrightsDelightGUI.CobwebbedOverlay.ID, FrightsDelightGUI.CobwebbedOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.CobwebbedOverlay.ID, FrightsDelightGUI.HysteriaOverlay.ID, FrightsDelightGUI.HysteriaOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.HysteriaOverlay.ID, FrightsDelightGUI.InfectedOverlay.ID, FrightsDelightGUI.InfectedOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.InfectedOverlay.ID, FrightsDelightGUI.SlimedOverlay.ID, FrightsDelightGUI.SlimedOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.SlimedOverlay.ID, FrightsDelightGUI.UndeadHungerOverlay.ID, FrightsDelightGUI.UndeadHungerOverlay.INSTANCE);
        registerOverlay(FrightsDelightGUI.UndeadHungerOverlay.ID, FrightsDelightGUI.FortifiedMindOverlay.ID, FrightsDelightGUI.FortifiedMindOverlay.INSTANCE);
    }

    private static void registerOverlay(@Nullable ResourceLocation attachAfterLocation, ResourceLocation location, HudElement hudElement) {
        HudElementRegistry.attachElementAfter(attachAfterLocation == null ? VanillaHudElements.FOOD_BAR : attachAfterLocation, location, hudElement);
    }
}
