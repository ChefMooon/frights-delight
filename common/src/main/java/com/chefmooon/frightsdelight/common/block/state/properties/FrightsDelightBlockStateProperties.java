package com.chefmooon.frightsdelight.common.block.state.properties;

import com.chefmooon.frightsdelight.common.data.types.Syrups;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Arrays;

public class FrightsDelightBlockStateProperties {
    public static final SyrupTypeProperty SYRUP_TYPE = SyrupTypeProperty.create("syrup_type", Arrays.asList(Syrups.values()));
    public static final BooleanProperty HARDENED = BooleanProperty.create("hardened");
}
