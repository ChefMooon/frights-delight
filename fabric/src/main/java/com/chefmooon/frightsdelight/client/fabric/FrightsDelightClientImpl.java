package com.chefmooon.frightsdelight.client.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.client.event.fabric.ClientSetupEventsImpl;
import com.chefmooon.frightsdelight.common.utility.fabric.FrightsDelightItemPropertiesImpl;
import net.fabricmc.api.ClientModInitializer;
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

        onBuiltinPackRegistration();
    }

    public static void onBuiltinPackRegistration() {
        if (isModLoaded("presencefootsteps")) {
            FabricLoader.getInstance().getModContainer(FrightsDelight.MOD_ID).ifPresent(frdpresencefootsteps ->
                    ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation("frdpresencefootsteps"), frdpresencefootsteps, ResourcePackActivationType.DEFAULT_ENABLED));
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
