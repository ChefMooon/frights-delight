package com.chefmooon.frightsdelight.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.neoforge.FrightsDelightClientImpl;
import com.chefmooon.frightsdelight.common.neoforge.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import com.chefmooon.frightsdelight.common.registry.neoforge.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FrightsDelight.MOD_ID)
public class FrightsDelightImpl {
    public static final Logger LOGGER = LogManager.getLogger();

    public FrightsDelightImpl(IEventBus modEventBus, ModContainer modContainer) {
        FrightsDelight.init();

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
        FrightsDelightBlockEntitiesImpl.register(modEventBus);
        FrightsDelightEntityTypesImpl.register(modEventBus);
        FrightsDelightBiomeFeaturesImpl.register(modEventBus);
        FrightsDelightCreativeTabs.register(modEventBus);
        FrightsDelightPlacementModifiersImpl.register(modEventBus);
        FrightsDelightLootModifiersImpl.register(modEventBus);
        FrightsDelightConditionCodecsImpl.register(modEventBus);

        //FrightsDelightBiomeModifiersImpl.init();

    }

    public static void loggerInfo(String s) {
        LOGGER.warn(s);
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

//        List<IModInfo> infoList = ModList.get().getModFileById(FrightsDelight.MOD_ID).getMods();
//        if (infoList.size() > 1) {
//            FrightsDelight.LOGGER.error("Multiple mods for MOD_ID: " + FrightsDelight.MOD_ID);
//        }
//        for (IModInfo info : infoList) {
//            if (info.getModId().equals(FrightsDelight.MOD_ID)) {
//                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
//                break;
//            }
//        }
        return versionString;
    }

    @EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerContent(RegisterEvent event) {
            register(event, Registries.FLUID, FrightsDelightFluids::init);
            register(event, NeoForgeRegistries.Keys.FLUID_TYPES, FrightsDelightFluidTypesImpl::registerAll);
        }
    }

    public static <T> void register(RegisterEvent event, ResourceKey<Registry<T>> registry, Runnable registerMethod) {
        if (event.getRegistryKey() == registry)
            registerMethod.run();
    }
}
