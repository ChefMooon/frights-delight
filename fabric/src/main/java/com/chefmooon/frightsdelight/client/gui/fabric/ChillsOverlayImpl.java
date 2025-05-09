package com.chefmooon.frightsdelight.client.gui.fabric;

import com.chefmooon.frightsdelight.client.gui.ChillsOverlay;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;

public class ChillsOverlayImpl {
    private static void onRenderGuiOverlayPost(PoseStack poseStack, float partialTicks) {
        Minecraft mc = Minecraft.getInstance();
        //var gui = mc.gui;
        if (!mc.options.hideGui && mc.gameMode != null && mc.gameMode.canHurtPlayer()) {
            ChillsOverlay.renderChillsOverlay(mc, poseStack, 49);
        }
    }

    public static void init() {
        HudRenderCallback.EVENT.register(ChillsOverlayImpl::onRenderGuiOverlayPost);
    }
}
