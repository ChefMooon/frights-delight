package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightAdvancements;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class CandyBasketItem extends BlockItem {
    private CandyBasketType candyBasketType;

    public CandyBasketItem(Block block, Properties properties) {
        super(block, properties);
    }

    public CandyBasketItem(Block block, Properties properties, CandyBasketType type) {
        this(block, properties);
        this.candyBasketType = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        InteractionHand offHand = usedHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        ItemStack basketStack = player.getItemInHand(usedHand);
        ItemStack offHandStack = player.getItemInHand(offHand);
        if (player.isCrouching()) {
            return shuffleItems(level, player, basketStack);
        } else {
            if (offHandStack.isEmpty()) {
                return removeItem(level, player, offHand, basketStack, offHandStack);
            } else {
                return addItem(level, player, basketStack, offHandStack);
            }
        }
    }

    public InteractionResultHolder<ItemStack> shuffleItems(Level level, Player player, ItemStack basketStack) {
        CompoundTag compoundTag = BlockItem.getBlockEntityData(basketStack);
        if (compoundTag != null) {
            if (compoundTag.contains("Items", 9)) {
                NonNullList<ItemStack> nonNullList = NonNullList.withSize(9, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundTag, nonNullList);

                List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
                if (!nonNullList.isEmpty()) {
                    for (ItemStack itemStack : nonNullList) {
                        if (!itemStack.isEmpty()) {
                            itemStackList.add(itemStack);
                        }
                    }
                    if (itemStackList.size() > 1) {
                        for (int i = 0; i < itemStackList.size(); i++) {
                            int randomIndex = (int) (Math.random() * itemStackList.size());
                            ItemStack temp = itemStackList.get(randomIndex);
                            itemStackList.set(randomIndex, itemStackList.get(i));
                            itemStackList.set(i, temp);
                        }

                        nonNullList.clear();
                        for (int i = 0; i < itemStackList.size(); i++) {
                            nonNullList.set(i, itemStackList.get(i));
                        }

                        ContainerHelper.saveAllItems(compoundTag, nonNullList);
                        basketStack.addTagElement("Items", compoundTag);

                        Supplier<SoundEvent> shuffleSound = candyBasketType.getShuffleSound();
                        if (shuffleSound != null)
                            level.playLocalSound(player.getX(), player.getY(), player.getZ(), shuffleSound.get(), SoundSource.PLAYERS, Math.min(0.3f + 0.04f * itemStackList.size(), 1.0f), 1.0f, false);
                        if (player instanceof ServerPlayer serverPlayer) FrightsDelightAdvancements.CANDY_BASKET_SHUFFLE_TRIGGER.trigger(serverPlayer);
                        return InteractionResultHolder.success(basketStack);
                    }
                }
            }
        }

        return InteractionResultHolder.pass(basketStack);
    }

    public InteractionResultHolder<ItemStack> removeItem(Level level, Player player, InteractionHand offHand, ItemStack basketStack, ItemStack offHandStack) {
        CompoundTag compoundTag = BlockItem.getBlockEntityData(basketStack);
        if (compoundTag != null) {
            if (compoundTag.contains("Items", 9)) {
                NonNullList<ItemStack> nonNullList = NonNullList.withSize(9, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundTag, nonNullList);

                List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
                if (!nonNullList.isEmpty()) {
                    for (ItemStack itemStack : nonNullList) {
                        if (!itemStack.isEmpty()) {
                            itemStackList.add(itemStack);
                        }
                    }

                    if (!itemStackList.isEmpty() && offHandStack.isEmpty()) {
                        ItemStack toRemove = ItemStack.EMPTY;
                        for (int i = itemStackList.size() - 1; i >= 0; i--) {
                            ItemStack candidate = itemStackList.get(i);
                            if (!candidate.isEmpty()) {
                                toRemove = candidate.copy();
                                itemStackList.remove(i);
                                break;
                            }
                        }

                        if (!toRemove.isEmpty()) {
                            if (!player.getAbilities().instabuild) player.setItemInHand(offHand, toRemove);

                            nonNullList.clear();
                            for (int i = 0; i < itemStackList.size(); i++) {
                                nonNullList.set(i, itemStackList.get(i));
                            }

                            ContainerHelper.saveAllItems(compoundTag, nonNullList);
                            basketStack.addTagElement("Items", compoundTag);

                            Supplier<SoundEvent> removeSound = candyBasketType.getRemoveSound();
                            if (removeSound != null) level.playLocalSound(player.getX(), player.getY(), player.getZ(), removeSound.get(), SoundSource.PLAYERS, 0.4f, 1.0f, false);
                            return InteractionResultHolder.success(basketStack);
                        }
                    }
                }
            }
        }

        return InteractionResultHolder.pass(basketStack);
    }

    public InteractionResultHolder<ItemStack> addItem(Level level, Player player, ItemStack basketStack, ItemStack offHandStack) {
        if (!offHandStack.isEdible()) return InteractionResultHolder.fail(offHandStack);

        CompoundTag compoundTag = BlockItem.getBlockEntityData(basketStack);
        if (compoundTag != null) {
            if (compoundTag.contains("Items", 9)) {
                NonNullList<ItemStack> nonNullList = NonNullList.withSize(9, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundTag, nonNullList);

                List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
                if (!nonNullList.isEmpty()) {
                    for (ItemStack itemStack : nonNullList) {
                        if (!itemStack.isEmpty()) {
                            itemStackList.add(itemStack);
                        }
                    }

                    if (itemStackList.size() < 9 && !offHandStack.isEmpty()) {
                        ItemStack toAdd = player.getAbilities().instabuild ? offHandStack.copyWithCount(1) : offHandStack.split(1);
                        itemStackList.add(toAdd);

                        nonNullList.clear();
                        for (int i = 0; i < itemStackList.size(); i++) {
                            nonNullList.set(i, itemStackList.get(i));
                        }

                        ContainerHelper.saveAllItems(compoundTag, nonNullList);
                        basketStack.addTagElement("Items", compoundTag);

                        Supplier<SoundEvent> addSound = candyBasketType.getAddSound();
                        if (addSound != null) level.playLocalSound(player.getX(), player.getY(), player.getZ(), addSound.get(), SoundSource.PLAYERS, 0.4f, 1.0f, false);
                        return InteractionResultHolder.success(basketStack);
                    }
                }
            }
        } else {
            CompoundTag newTag = new CompoundTag();
            NonNullList<ItemStack> nonNullList = NonNullList.withSize(9, ItemStack.EMPTY);

            if (!offHandStack.isEmpty()) {
                ItemStack toAdd = player.getAbilities().instabuild ? offHandStack.copyWithCount(1) : offHandStack.split(1);
                nonNullList.set(0, toAdd);

                ContainerHelper.saveAllItems(newTag, nonNullList);
                basketStack.addTagElement("Items", newTag);
                BlockItem.setBlockEntityData(basketStack, Objects.requireNonNull(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(FrightsDelightBlockEntities.CANDY_BASKET)), newTag);
            }

            Supplier<SoundEvent> addSound = candyBasketType.getAddSound();
            if (addSound != null) level.playLocalSound(player.getX(), player.getY(), player.getZ(), addSound.get(), SoundSource.PLAYERS, 0.4f, 1.0f, false);
            return InteractionResultHolder.success(basketStack);
        }

        return InteractionResultHolder.pass(basketStack);
    }
}
