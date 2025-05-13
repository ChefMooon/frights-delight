package com.chefmooon.frightsdelight.common.registry;

import net.minecraft.world.damagesource.DamageSource;

public class FrightsDelightDamageTypes extends DamageSource {
    public static final DamageSource SOUL_BERRY_BUSH = new FrightsDelightDamageTypes("soul_berry_bush");
    public static final DamageSource WITHER_BERRY_BUSH = new FrightsDelightDamageTypes("wither_berry_bush");

    protected FrightsDelightDamageTypes(String messageId) {
        super(messageId);
    }
}
