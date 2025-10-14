package com.chefmooon.frightsdelight.common.data.types;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.function.Supplier;

public enum Syrups implements StringRepresentable {
    EMPTY(null, null, null, null, null),
    ROTTEN_FLESH(FrightsDelightItems.ROTTEN_FLESH_SYRUP_BOTTLE, FrightsDelightItems.ROTTEN_FLESH_LOLLIPOP, FrightsDelightItems.ROTTEN_FLESH_RING_CANDY,
            FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_ROTTEN_FLESH_BUBBLE),
    SLIMEAPPLE(FrightsDelightItems.SLIMEAPPLE_SYRUP_BOTTLE, FrightsDelightItems.SLIMEAPPLE_LOLLIPOP, FrightsDelightItems.SLIMEAPPLE_RING_CANDY,
            FrightsDelightParticleTypes.SLIME_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SLIMEAPPLE_BUBBLE),
    SPIDEREYE(FrightsDelightItems.SPIDEREYE_SYRUP_BOTTLE, FrightsDelightItems.SPIDEREYE_LOLLIPOP, FrightsDelightItems.SPIDEREYE_RING_CANDY,
            FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SPIDER_EYE_BUBBLE),
    GHASTTEAR(FrightsDelightItems.GHASTTEAR_SYRUP_BOTTLE, FrightsDelightItems.GHASTTEAR_LOLLIPOP, FrightsDelightItems.GHASTTEAR_RING_CANDY,
            FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_GHAST_TEAR_BUBBLE),
    SOUL_BERRY(FrightsDelightItems.SOUL_BERRY_SYRUP_BOTTLE, FrightsDelightItems.SOUL_BERRY_LOLLIPOP, FrightsDelightItems.SOUL_BERRY_RING_CANDY,
            FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SOUL_BERRY_BUBBLE),
    WITHER_BERRY(FrightsDelightItems.WITHER_BERRY_SYRUP_BOTTLE, FrightsDelightItems.WITHER_BERRY_LOLLIPOP, FrightsDelightItems.WITHER_BERRY_RING_CANDY,
            FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_WITHER_BERRY_BUBBLE),
    COBWEB(FrightsDelightItems.COBWEB_SYRUP_BOTTLE, FrightsDelightItems.COBWEB_LOLLIPOP, FrightsDelightItems.COBWEB_RING_CANDY,
            FrightsDelightParticleTypes.COBWEB_BUBBLE, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_COBWEB_BUBBLE)
    ;

    private final ResourceLocation syrupBottleItem;
    private final ResourceLocation lollipopItem;
    private final ResourceLocation ringCandyItem;
    private final Supplier<SimpleParticleType> particle;
    private final Supplier<SoundEvent> animateSound;

    Syrups(ResourceLocation syrupBottleItem, ResourceLocation lollipopItem, ResourceLocation ringCandyItem, Supplier<SimpleParticleType> particle, Supplier<SoundEvent> animateSound) {
        this.syrupBottleItem = syrupBottleItem;
        this.lollipopItem = lollipopItem;
        this.ringCandyItem = ringCandyItem;
        this.particle = particle;
        this.animateSound = animateSound;
    }

    public ResourceLocation getSyrupBottleItem() {
        return syrupBottleItem;
    }

    public ResourceLocation getLollipopItem() {
        return lollipopItem;
    }

    public ResourceLocation getRingCandyItem() {
        return ringCandyItem;
    }

    public Supplier<SimpleParticleType> getParticle() {
        return particle;
    }

    public Supplier<SoundEvent> getAnimateSound() {
        return animateSound;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
