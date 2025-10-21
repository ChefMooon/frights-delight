package com.chefmooon.frightsdelight.common.block.state.properties;

import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SyrupTypeProperty extends EnumProperty<Syrups> {
    protected SyrupTypeProperty(String name, Collection<Syrups> values) {
        super(name, Syrups.class, values);
    }

    public static SyrupTypeProperty create(String name, Predicate<Syrups> filter) {
        return create(name, (Collection<Syrups>) Arrays.stream(Syrups.values()).filter(filter).collect(Collectors.toList()));
    }

    public static SyrupTypeProperty create(String name, Syrups... values) {
        return create(name, Lists.<Syrups>newArrayList(values));
    }

    public static SyrupTypeProperty create(String name, Collection<Syrups> values) {
        return new SyrupTypeProperty(name, values);
    }
}
