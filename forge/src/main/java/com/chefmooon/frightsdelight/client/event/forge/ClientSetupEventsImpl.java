package com.chefmooon.frightsdelight.client.event.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.client.renderer.forge.LollipopMoldBlockEntityRendererImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightBlockEntitiesImpl;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightEntityTypesImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventsImpl {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
    }

    @SubscribeEvent
    public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(FrightsDelightBlockEntitiesImpl.LOLLIPOP_MOLD.get(), LollipopMoldBlockEntityRendererImpl::new);
    }
}
