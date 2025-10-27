package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class FrightsDelightAdvancementsImpl {
    public static <T extends CriterionTrigger<?>> Supplier<T> registerTrigger(String name, Supplier<T> triggerSupplier) {
        return RegistrationUtilsImpl.register(name, triggerSupplier, BuiltInRegistries.TRIGGER_TYPES);
    }

    public static void register() {
    }
}
