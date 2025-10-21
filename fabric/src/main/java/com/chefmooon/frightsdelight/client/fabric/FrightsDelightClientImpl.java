package com.chefmooon.frightsdelight.client.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.client.event.fabric.ClientSetupEventsImpl;
import com.chefmooon.frightsdelight.client.gui.fabric.FrightsDelightGUIImpl;
import com.chefmooon.frightsdelight.common.fluid.FrDFluidConstants;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightItemPropertiesImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;

public class FrightsDelightClientImpl implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FrightsDelightClient.init();

        ClientSetupEventsImpl.registerBlockRenderLayerMap();
        ClientSetupEventsImpl.registerParticles();
        ClientSetupEventsImpl.onEntityRendererRegister();

        FrightsDelightItemPropertiesImpl.addCustomItemProperties();

        FrightsDelightGUIImpl.register();

        registerFluidRenderers();

        onBuiltinPackRegistration();
    }

    public static void registerFluidRenderers() {
        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.ROTTEN_FLESH_SYRUP, FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.ROTTEN_FLESH_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.ROTTEN_FLESH_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.SLIMEAPPLE_SYRUP, FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.SLIMEAPPLE_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.SLIMEAPPLE_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.SPIDEREYE_SYRUP, FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.SPIDEREYE_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.SPIDEREYE_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.GHASTTEAR_SYRUP, FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.GHASTTEAR_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.GHASTTEAR_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.SOUL_BERRY_SYRUP, FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.SOUL_BERRY_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.SOUL_BERRY_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.WITHER_BERRY_SYRUP, FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.WITHER_BERRY_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.WITHER_BERRY_SYRUP_FLOWING_TEXTURE));

        FluidRenderHandlerRegistry.INSTANCE.register(FrightsDelightFluids.COBWEB_SYRUP, FrightsDelightFluids.FLOWING_COBWEB_SYRUP,
                new SimpleFluidRenderHandler(
                        FrDFluidConstants.Textures.COBWEB_SYRUP_STILL_TEXTURE,
                        FrDFluidConstants.Textures.COBWEB_SYRUP_FLOWING_TEXTURE));
    }

    public static void onBuiltinPackRegistration() {
        if (isModLoaded("presencefootsteps")) {
            FabricLoader.getInstance().getModContainer(FrightsDelight.MOD_ID).ifPresent(frdpresencefootsteps ->
                    ResourceManagerHelper.registerBuiltinResourcePack(ResourceLocation.parse("frdpresencefootsteps"), frdpresencefootsteps, ResourcePackActivationType.DEFAULT_ENABLED));
        }
    }

    public static boolean isModLoaded(String modId) {
        for (ModContainer modContainer : FabricLoader.getInstance().getAllMods()) {
            if (modContainer.getMetadata().getId().equals(modId)) {
                return true;
            }
        }
        return false;
    }
}
