package com.chefmooon.frightsdelight.client.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

import java.util.ArrayList;
import java.util.List;

public class FrightsDelightClientImpl {
    public static void init(final FMLClientSetupEvent event) {
        FrightsDelightClient.init();
    }

    public static void onBuiltinPackRegistration(AddPackFindersEvent event) {
        if (isModLoaded("presencefootsteps")) {
            registerBuiltinResourcePack(event, "FrD Presence Footsteps", "frdpresencefootsteps");
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, String name, String folder) {
        IModFileInfo modFileInfo = ModList.get().getModFileById(FrightsDelight.MOD_ID);
        if (modFileInfo == null) {
            return;
        }
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        IModFile modFile = modFileInfo.getFile();

        event.addRepositorySource(((packConsumer, packConstructor) -> packConsumer.accept(
                Pack.create(TextUtils.res(FrightsDelight.MOD_ID).toString(),
                        false,
                        () -> new PathPackResources(name, modFile.findResource("resourcepacks/" + folder)),
                        packConstructor,
                        Pack.Position.TOP,
                        PackSource.DEFAULT
                )
        )));
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
