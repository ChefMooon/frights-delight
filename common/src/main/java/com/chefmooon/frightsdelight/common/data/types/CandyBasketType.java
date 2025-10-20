package com.chefmooon.frightsdelight.common.data.types;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.StringRepresentable;

import java.util.Locale;
import java.util.function.Supplier;

public enum CandyBasketType implements StringRepresentable {
    NONE(null, null, null),
    PUMPKIN(FrightsDelightSounds.BLOCK_PUMPKIN_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_PUMPKIN_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_PUMPKIN_CANDY_BASKET_SHUFFLE),
    MELON(FrightsDelightSounds.BLOCK_MELON_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_MELON_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_MELON_CANDY_BASKET_SHUFFLE),
    CREEPER(FrightsDelightSounds.BLOCK_CREEPER_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_CREEPER_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_CREEPER_CANDY_BASKET_SHUFFLE),
    SKELETON(FrightsDelightSounds.BLOCK_SKELETON_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_SKELETON_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_SKELETON_CANDY_BASKET_SHUFFLE),
    ZOMBIE(FrightsDelightSounds.BLOCK_ZOMBIE_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_ZOMBIE_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_ZOMBIE_CANDY_BASKET_SHUFFLE),
    SPIDER(FrightsDelightSounds.BLOCK_SPIDER_CANDY_BASKET_ADD, FrightsDelightSounds.BLOCK_SPIDER_CANDY_BASKET_REMOVE, FrightsDelightSounds.BLOCK_SPIDER_CANDY_BASKET_SHUFFLE),
    ;

    private final Supplier<SoundEvent> addSound;
    private final Supplier<SoundEvent> removeSound;
    private final Supplier<SoundEvent> shuffleSound;

    CandyBasketType(Supplier<SoundEvent> addSound, Supplier<SoundEvent> removeSound, Supplier<SoundEvent> shuffleSound) {
        this.addSound = addSound;
        this.removeSound = removeSound;
        this.shuffleSound = shuffleSound;
    }

    public Supplier<SoundEvent> getAddSound() {
        return addSound;
    }

    public Supplier<SoundEvent> getRemoveSound() {
        return removeSound;
    }

    public Supplier<SoundEvent> getShuffleSound() {
        return shuffleSound;
    }

    @Override
    public String getSerializedName() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
