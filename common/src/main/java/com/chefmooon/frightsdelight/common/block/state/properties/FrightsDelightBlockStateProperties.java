package com.chefmooon.frightsdelight.common.block.state.properties;

import com.chefmooon.frightsdelight.common.data.types.Syrups;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class FrightsDelightBlockStateProperties {
    public static final EnumProperty<Syrups> SYRUP_TYPE = EnumProperty.create("syrup_type", Syrups.class);
    public static final BooleanProperty HARDENED = BooleanProperty.create("hardened");
}
