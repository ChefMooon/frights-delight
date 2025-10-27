package com.chefmooon.frightsdelight.client.event.fabric;

import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.client.renderer.fabric.LollipopMoldBlockEntityRendererImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlockEntitiesImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightEntityTypesImpl;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ClientSetupEventsImpl {

    public static void registerBlockRenderLayerMap() {
        BlockEntityRenderers.register(FrightsDelightBlockEntitiesImpl.LOLLIPOP_MOLD, LollipopMoldBlockEntityRendererImpl::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(),
                FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(),
                FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(),

                FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get(),
                FrightsDelightBlocksImpl.RING_CANDY_MOLD.get(),

                FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get(),
                FrightsDelightBlocksImpl.JACK_O_LANTERN_CANDY_BASKET.get(),
                FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get()
                );
    }

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
    }

    public static void onEntityRendererRegister() {
        EntityRendererRegistry.register(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), ThrownItemRenderer::new);
    }
}
