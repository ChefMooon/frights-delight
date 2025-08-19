package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class FrightsDelightConsumableItemNameBlockItem extends BlockItem {
    protected final boolean hasFoodEffectTooltip;
    public FrightsDelightConsumableItemNameBlockItem(Block block, Properties properties) {
        super(block, properties);
        this.hasFoodEffectTooltip = false;
    }
    public FrightsDelightConsumableItemNameBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip) {
        super(block, properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        if ((Boolean) Configuration.foodEffectTooltip()) {
            if (this.hasFoodEffectTooltip) {
                if ((Boolean) Configuration.foodEffectChanceTooltip()) {
                    TextUtils.addFoodEffectTooltipWithDetail(stack, tooltipAdder, 1.0F, context.tickRate());
                } else {
                    TextUtils.addFoodEffectTooltip(stack, tooltipAdder, 1.0F, context.tickRate());
                }
            }
        }
    }
}
