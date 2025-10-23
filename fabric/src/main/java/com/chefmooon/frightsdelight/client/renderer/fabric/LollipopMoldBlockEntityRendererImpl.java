package com.chefmooon.frightsdelight.client.renderer.fabric;

import com.chefmooon.frightsdelight.client.renderer.LollipopMoldBlockEntityRenderer;
import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.block.entity.LollipopMoldBlockEntity;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class LollipopMoldBlockEntityRendererImpl<T extends LollipopMoldBlockEntity> extends LollipopMoldBlockEntityRenderer implements BlockEntityRenderer<T> {
    public LollipopMoldBlockEntityRendererImpl(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, Vec3 cameraPos) {
        Level level = blockEntity.getLevel();
        Minecraft minecraft = Minecraft.getInstance();
        if (level == null) return;

        BlockState state = level.getBlockState(blockEntity.getBlockPos());
        if (!(state.getBlock() instanceof LollipopMoldBlock)) return;

        Direction facing = state.getValue(LollipopMoldBlock.FACING);
        Direction.Axis axis = facing.getAxis();
        boolean facingAxisX = axis == Direction.Axis.X;
        int shards = state.getValue(LollipopMoldBlock.SHARDS);
        ItemStack boneShard = new ItemStack(FrightsDelightItemsImpl.BONE_SHARD.get());

        if (shards >= 1) {
            poseStack.pushPose();
            transformShard1(poseStack, facingAxisX);
            minecraft.getItemRenderer().renderStatic(boneShard, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), (int) blockEntity.getBlockPos().asLong());
            poseStack.popPose();
        }

        if (shards >= 2) {
            poseStack.pushPose();
            transformShard2(poseStack, facingAxisX);
            minecraft.getItemRenderer().renderStatic(boneShard, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), (int) blockEntity.getBlockPos().asLong());
            poseStack.popPose();
        }

        if (shards >= 3) {
            poseStack.pushPose();
            transformShard3(poseStack, facingAxisX);
            minecraft.getItemRenderer().renderStatic(boneShard, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), (int) blockEntity.getBlockPos().asLong());
            poseStack.popPose();
        }

        if (shards >= 4) {
            poseStack.pushPose();
            transformShard4(poseStack, facingAxisX);
            minecraft.getItemRenderer().renderStatic(boneShard, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), (int) blockEntity.getBlockPos().asLong());
            poseStack.popPose();
        }

        // TODO: solve fluid rendering
//        minecraft.getBlockRenderer().renderLiquid(blockEntity.getBlockPos(), level, bufferSource.getBuffer(RenderType.translucent()), blockEntity.getBlockState(), FrightsDelightFluids.SOUL_BERRY_SYRUP.defaultFluidState());
    }
}
