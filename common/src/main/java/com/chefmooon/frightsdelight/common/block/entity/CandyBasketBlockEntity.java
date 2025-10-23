package com.chefmooon.frightsdelight.common.block.entity;

import com.chefmooon.frightsdelight.common.block.entity.base.BaseBlockEntity;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CandyBasketBlockEntity extends BaseBlockEntity implements Container, Nameable {
    public static final int CONTAINER_SIZE = 9;
    private NonNullList<ItemStack> itemStacks;
    @Nullable
    private Component name;
    public CandyBasketBlockEntity(BlockPos pos, BlockState blockState) {
        // TODO: .isPresent check?
        super(FrightsDelightBlockEntities.getCandyBasketBlockEntity(), pos, blockState);
        this.itemStacks = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        ContainerHelper.loadAllItems(tag, this.itemStacks, registries);
        this.name = parseCustomNameSafe(tag.get("CustomName"), registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, this.itemStacks, false, registries);
        if (this.name != null) {
            tag.put("CustomName", ComponentSerialization.CODEC.encodeStart(registries.createSerializationContext(NbtOps.INSTANCE), this.name).getOrThrow());
        }
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter componentGetter) {
        super.applyImplicitComponents(componentGetter);
        componentGetter.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
        this.name = componentGetter.get(DataComponents.CUSTOM_NAME);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
        components.set(DataComponents.CUSTOM_NAME, this.name);
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("CustomName");
        tag.remove("Items");
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        // do not drop contents
    }

    public NonNullList<ItemStack> getItems() {
        return itemStacks;
    }

    @Override
    public int getContainerSize() {
        return itemStacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : getItems()) {
            if (!itemStack.isEmpty()) {
                return false;
            }
        }
         return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.getItems().get(slot);
    }


    public boolean addItem(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) return false;

        for (int i = 0; i < CONTAINER_SIZE; i++) {
            if (itemStacks.get(i).isEmpty()) {
                itemStacks.set(i, itemStack.copyWithCount(1));
                this.setChanged();
                return true;
            }
        }

        return false;
    }

    public ItemStack removeItem() {
        if (!isEmpty()) {
            for (int i = CONTAINER_SIZE - 1; i >= 0; i--) {
                ItemStack stack = ContainerHelper.takeItem(itemStacks, i);
                if (!stack.isEmpty()) {
                    this.setChanged();
                    return stack;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public void setItems(ItemContainerContents items) {
        if (items == null) return;
        int slot = 0;
        for (ItemStack itemStack : items.nonEmptyItems()) {
            itemStacks.set(slot, itemStack);
            slot++;
        }
        this.setChanged();
    }

    public int getFilledSlotsCount() {
        int count = 0;
        for (ItemStack itemStack : itemStacks) {
            if (!itemStack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public boolean shuffleInventory() {
        // Simple shuffle algorithm, improve?
        if (!isEmpty()) {
            int filledSlots = 0;
            for (int i = 0; i < CONTAINER_SIZE; i++) {
                if (!itemStacks.get(i).isEmpty()) {
                    filledSlots++;
                } else {
                    break;
                }
            }
            if (filledSlots > 1) {
                for (int j = 0; j < filledSlots; j++) {
                    int randomIndex = (int) (Math.random() * filledSlots);
                    ItemStack temp = itemStacks.get(j);
                    itemStacks.set(j, itemStacks.get(randomIndex));
                    itemStacks.set(randomIndex, temp);
                }
                this.setChanged();
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack itemStack = ContainerHelper.removeItem(this.getItems(), slot, amount);
        if (!itemStack.isEmpty()) {
            this.setChanged();
        }

        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.getItems(), slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.getItems().set(slot, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        this.setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        this.getItems().clear();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (level != null) level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
    }

    @Override
    public Component getName() {
        return this.name != null ? this.name : this.getDefaultName();
    }

    protected Component getDefaultName() {
        return Component.translatable("container.candy_basket");
    }

    @Nullable
    @Override
    public Component getCustomName() {
        return this.name;
    }
}
