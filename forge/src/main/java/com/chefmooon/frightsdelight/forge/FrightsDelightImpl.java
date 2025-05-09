package com.chefmooon.frightsdelight.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.forge.FrightsDelightClientImpl;
import com.chefmooon.frightsdelight.common.forge.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.registry.forge.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(FrightsDelight.MOD_ID)
public class FrightsDelightImpl {
    public FrightsDelightImpl() {
        FrightsDelight.init();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetupImpl::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(FrightsDelightClientImpl::init);
            modEventBus.addListener(FrightsDelightClientImpl::onBuiltinPackRegistration);
        }

        FrightsDelightSoundsImpl.register(modEventBus);
        FrightsDelightBlocksImpl.register(modEventBus);
        FrightsDelightEffectsImpl.register(modEventBus);
        FrightsDelightParticleTypesImpl.register(modEventBus);
        FrightsDelightItemsImpl.register(modEventBus);
        FrightsDelightEntityTypesImpl.register(modEventBus);
        FrightsDelightBiomeFeaturesImpl.register(modEventBus);
        FrightsDelightBiomeModifiersImpl.init(); // does nothing, remove?
        FrightsDelightCreativeTabsImpl.register();
        FrightsDelightPlacementModifiersImpl.register(modEventBus);
        FrightsDelightLootModifiersImpl.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
