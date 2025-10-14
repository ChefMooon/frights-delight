package com.chefmooon.frightsdelight.client.event.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.client.gui.neoforge.FrightsDelightGUIImpl;
import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.client.renderer.neoforge.LollipopMoldBlockEntityRendererImpl;
import com.chefmooon.frightsdelight.common.fluid.FrDFluidConstants;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightBlockEntityImpl;
import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightEntityTypesImpl;
import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightFluidTypesImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        FrightsDelightGUIImpl.register(event);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(FrightsDelightBlockEntityImpl.LOLLIPOP_MOLD.get(), LollipopMoldBlockEntityRendererImpl::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.ROTTEN_FLESH_SYRUP), FrightsDelightFluidTypesImpl.ROTTEN_FLESH_SYRUP);
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.SLIMEAPPLE_SYRUP), FrightsDelightFluidTypesImpl.SLIMEAPPLE_SYRUP);
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.SPIDEREYE_SYRUP), FrightsDelightFluidTypesImpl.SPIDEREYE_SYRUP);
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.GHASTTEAR_SYRUP), FrightsDelightFluidTypesImpl.GHASTTEAR_SYRUP);
//        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.SOUL_BERRY_SYRUP), FrightsDelightFluidTypesImpl.SOUL_BERRY_SYRUP);
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.WITHER_BERRY_SYRUP), FrightsDelightFluidTypesImpl.WITHER_BERRY_SYRUP);
        event.registerFluidType(createSyrupExtension(FrightsDelightClient.FluidColors.COBWEB_SYRUP), FrightsDelightFluidTypesImpl.COBWEB_SYRUP);

        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return FrDFluidConstants.SOUL_BERRY_STILL_TEXTURE;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return FrDFluidConstants.SOUL_BERRY_FLOWING_TEXTURE;
            }
        }, FrightsDelightFluidTypesImpl.SOUL_BERRY_SYRUP);
    }

    private static IClientFluidTypeExtensions createSyrupExtension(int color) {
        return new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return ResourceLocation.withDefaultNamespace("block/water_still");
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return ResourceLocation.withDefaultNamespace("block/water_flow");
            }

            @Override
            public int getTintColor() {
                return color;
            }
        };
    }
}
