package com.chefmooon.frightsdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

public class LollipopMoldBlockEntityRenderer {
    public void transformShard1(PoseStack poseStack, boolean facingAxisX) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
        if (facingAxisX) {
            poseStack.translate(0.625f, 0.315f, 1.9f);
            poseStack.mulPose(Axis.YN.rotationDegrees(90));
        } else {
            poseStack.translate(0f, 0.315f, 0.625f);
            poseStack.mulPose(Axis.YN.rotationDegrees(180));
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees(45));
    }

    public void transformShard2(PoseStack poseStack, boolean facingAxisX) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
        if (facingAxisX) {
            poseStack.translate(1.375f, 0.315f, 1.9f);
            poseStack.mulPose(Axis.YN.rotationDegrees(90));
        } else {
            poseStack.translate(0f, 0.315f, 1.375f);
            poseStack.mulPose(Axis.YN.rotationDegrees(180));
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees(45));
    }

    public void transformShard3(PoseStack poseStack, boolean facingAxisX) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
        if (facingAxisX) {
            poseStack.translate(0.625f, 0.315f, 0.1f);
            poseStack.mulPose(Axis.YN.rotationDegrees(-90));
        } else {
            poseStack.translate(1.9f, 0.315f, 0.625f);
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees(45));
    }

    public void transformShard4(PoseStack poseStack, boolean facingAxisX) {
        poseStack.scale(0.5f, 0.5f, 0.5f);
        if (facingAxisX) {
            poseStack.translate(1.375f, 0.315f, 0.1f);
            poseStack.mulPose(Axis.YN.rotationDegrees(-90));
        } else {
            poseStack.translate(1.9f, 0.315f, 1.375f);
        }
        poseStack.mulPose(Axis.ZP.rotationDegrees(45));
    }
}
