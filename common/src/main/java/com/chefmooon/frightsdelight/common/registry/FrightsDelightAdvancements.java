package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.advancement.CandyBasketShuffleTrigger;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.advancements.CriterionTrigger;

import java.util.function.Supplier;

public class FrightsDelightAdvancements {

    public static final Supplier<CandyBasketShuffleTrigger> CANDY_BASKET_SHUFFLE_TRIGGER = registerTrigger("use_baking_mat", CandyBasketShuffleTrigger::new);

    @ExpectPlatform
    public static <T extends CriterionTrigger<?>> Supplier<T> registerTrigger(String name, Supplier<T> triggerSupplier) {
        throw new AssertionError();
    }

    public static void init() {
    }
}
