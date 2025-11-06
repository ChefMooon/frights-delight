package com.chefmooon.frightsdelight.client.renderer.fabric;

import com.chefmooon.frightsdelight.client.renderer.LollipopMoldBlockEntityRenderer;
import com.chefmooon.frightsdelight.client.renderer.state.fabric.LollipopMoldRenderState;
import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class LollipopMoldBlockEntityRendererImpl extends LollipopMoldBlockEntityRenderer implements BlockEntityRenderer<LollipopMoldBlockEntity, LollipopMoldRenderState> {
    private final ItemModelResolver itemModelResolver;
    public LollipopMoldBlockEntityRendererImpl(BlockEntityRendererProvider.Context context) {
        itemModelResolver = context.itemModelResolver();
    }

    @Override
    public void extractRenderState(LollipopMoldBlockEntity blockEntity, LollipopMoldRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, renderState, partialTick, cameraPosition, breakProgress);
        renderState.direction = blockEntity.getBlockState().getValue(LollipopMoldBlock.FACING);
        int posLong = (int) blockEntity.getBlockPos().asLong();

        renderState.shards = blockEntity.getBlockState().getValue(LollipopMoldBlock.SHARDS);
        renderState.boneShards = new ItemStackRenderState[renderState.shards];
        ItemStack boneShard = new ItemStack(FrightsDelightItemsImpl.BONE_SHARD.get());
        for (int i = 0; i < renderState.shards; i++) {
            renderState.boneShards[i] = new ItemStackRenderState();
            this.itemModelResolver.updateForTopItem(renderState.boneShards[i], boneShard, ItemDisplayContext.FIXED, blockEntity.getLevel(), null, posLong + i);
        }
    }

    @Override
    public LollipopMoldRenderState createRenderState() {
        return new LollipopMoldRenderState();
    }

    @Override
    public void submit(LollipopMoldRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        Direction facing = renderState.direction;
        boolean facingAxisX = facing.getAxis() == Direction.Axis.X;

        if (renderState.shards >= 1) {
            poseStack.pushPose();
            transformShard1(poseStack, facingAxisX);

            renderState.boneShards[0].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }

        if (renderState.shards >= 2) {
            poseStack.pushPose();
            transformShard2(poseStack, facingAxisX);

            renderState.boneShards[1].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }

        if (renderState.shards >= 3) {
            poseStack.pushPose();
            transformShard3(poseStack, facingAxisX);

            renderState.boneShards[2].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }

        if (renderState.shards >= 4) {
            poseStack.pushPose();
            transformShard4(poseStack, facingAxisX);

            renderState.boneShards[3].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }

        // TODO: solve fluid rendering
//        minecraft.getBlockRenderer().renderLiquid(blockEntity.getBlockPos(), level, bufferSource.getBuffer(RenderType.translucent()), blockEntity.getBlockState(), FrightsDelightFluids.SOUL_BERRY_SYRUP.defaultFluidState());
    }
}
