package com.chefmooon.frightsdelight.client.gui.fabric;

import com.chefmooon.frightsdelight.client.gui.FrightsDelightGUI;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class FrightsDelightGUIImpl {

    public static int getFoodIconOffset() {
        return 39;
    }

    public static void register() {
        registerOverlay(FrightsDelightGUI.ChillsOverlay.ID, FrightsDelightGUI.ChillsOverlay.INSTANCE, null);
        registerOverlay(FrightsDelightGUI.CobwebbedOverlay.ID, FrightsDelightGUI.CobwebbedOverlay.INSTANCE, FrightsDelightGUI.ChillsOverlay.ID);
        registerOverlay(FrightsDelightGUI.HysteriaOverlay.ID, FrightsDelightGUI.HysteriaOverlay.INSTANCE, FrightsDelightGUI.CobwebbedOverlay.ID);
        registerOverlay(FrightsDelightGUI.InfectedOverlay.ID, FrightsDelightGUI.InfectedOverlay.INSTANCE, FrightsDelightGUI.HysteriaOverlay.ID);
        registerOverlay(FrightsDelightGUI.SlimedOverlay.ID, FrightsDelightGUI.SlimedOverlay.INSTANCE, FrightsDelightGUI.InfectedOverlay.ID);
        registerOverlay(FrightsDelightGUI.UndeadHungerOverlay.ID, FrightsDelightGUI.UndeadHungerOverlay.INSTANCE, FrightsDelightGUI.SlimedOverlay.ID);
        registerOverlay(FrightsDelightGUI.FortifiedMindOverlay.ID, FrightsDelightGUI.FortifiedMindOverlay.INSTANCE, FrightsDelightGUI.UndeadHungerOverlay.ID);

    }

    private static void registerOverlay(ResourceLocation location, FrightsDelightGUI.BaseOverlay baseOverlay, @Nullable ResourceLocation attachAfterLocation) {
        HudLayerRegistrationCallback.EVENT.register(layeredDrawer ->
                layeredDrawer.attachLayerAfter(attachAfterLocation == null ? IdentifiedLayer.HOTBAR_AND_BARS : attachAfterLocation, location, baseOverlay));
    }
}
