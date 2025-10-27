package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.advancement.CandyBasketShuffleTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class FrightsDelightAdvancements {

    public static CandyBasketShuffleTrigger CANDY_BASKET_SHUFFLE_TRIGGER = new CandyBasketShuffleTrigger();

    public static void register() {
        CriteriaTriggers.register(CANDY_BASKET_SHUFFLE_TRIGGER);
    }
}
