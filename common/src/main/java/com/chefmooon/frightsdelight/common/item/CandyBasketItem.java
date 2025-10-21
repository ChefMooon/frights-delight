package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
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
        ItemContainerContents items = basketStack.get(DataComponents.CONTAINER);

        List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
        if (items != null) {
            for (ItemStack itemStack : items.nonEmptyItems()) {
                itemStackList.add(itemStack);
            }
            if (itemStackList.size() > 1) {
                for (int i = 0; i < itemStackList.size(); i++) {
                    int randomIndex = (int) (Math.random() * itemStackList.size());
                    ItemStack temp = itemStackList.get(randomIndex);
                    itemStackList.set(randomIndex, itemStackList.get(i));
                    itemStackList.set(i, temp);
                }
                basketStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(itemStackList));
                Supplier<SoundEvent> shuffleSound = candyBasketType.getShuffleSound();
                if (shuffleSound != null) {
                    level.playLocalSound(player, shuffleSound.get(), SoundSource.PLAYERS, Math.min(0.3f + 0.04f * itemStackList.size(), 1.0f), 1.0f);
                }
                return InteractionResultHolder.success(basketStack);
            }
        }

        return InteractionResultHolder.pass(basketStack);
    }

    public InteractionResultHolder<ItemStack> removeItem(Level level, Player player, InteractionHand offHand, ItemStack basketStack, ItemStack offHandStack) {
        ItemContainerContents items = basketStack.get(DataComponents.CONTAINER);

        List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
        if (items != null) {
            for (ItemStack itemStack : items.nonEmptyItems()) {
                itemStackList.add(itemStack);
            }
            if (!itemStackList.isEmpty() && offHandStack.isEmpty()) {
                ItemStack toRemove = itemStackList.removeLast();
                if (!player.getAbilities().instabuild) player.setItemInHand(offHand, toRemove);
                basketStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(itemStackList));
                Supplier<SoundEvent> removeSound = candyBasketType.getRemoveSound();
                if (removeSound != null) level.playLocalSound(player, removeSound.get(), SoundSource.PLAYERS, 0.4f, 1.0f);
                return InteractionResultHolder.success(basketStack);
            }
        }

        return InteractionResultHolder.pass(basketStack);
    }

    public InteractionResultHolder<ItemStack> addItem(Level level, Player player, ItemStack basketStack, ItemStack offHandStack) {
        if (!offHandStack.has(DataComponents.FOOD)) return InteractionResultHolder.fail(offHandStack); // 1.20.1 offHandStack.isEdible()
        ItemContainerContents items = basketStack.get(DataComponents.CONTAINER);

        List<ItemStack> itemStackList = new java.util.ArrayList<>(List.of());
        if (items != null) {
            for (ItemStack itemStack : items.nonEmptyItems()) {
                itemStackList.add(itemStack);
            }
            if (itemStackList.size() < 9 && !offHandStack.isEmpty()) {
                ItemStack toAdd = player.getAbilities().instabuild ? offHandStack.copyWithCount(1) : offHandStack.split(1);
                itemStackList.add(toAdd);
                basketStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(itemStackList));
                Supplier<SoundEvent> addSound = candyBasketType.getAddSound();
                if (addSound != null) level.playLocalSound(player, addSound.get(), SoundSource.PLAYERS, 0.4f, 1.0f);
                return InteractionResultHolder.success(basketStack);
            }
        }

        return InteractionResultHolder.pass(basketStack);
    }
}
