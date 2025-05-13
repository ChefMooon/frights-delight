package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FrightsDelightDrinkableBlockItem extends FrightsDelightConsumableItemNameBlockItem {
    protected final boolean hasCustomTooltip;
    private final SoundEvent consumeSound;
    public FrightsDelightDrinkableBlockItem(Block block, Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        this(block, properties, null, hasFoodEffectTooltip, hasCustomTooltip);
    }
    public FrightsDelightDrinkableBlockItem(Block block, Item.Properties properties, SoundEvent consumeSound, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, properties, hasFoodEffectTooltip);
        this.consumeSound = consumeSound;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        FoodProperties foodData = heldStack.get(DataComponents.FOOD);
        if (foodData != null) {
            if (player.canEat(foodData.canAlwaysEat())) {
                player.startUsingItem(hand);
                if (Configuration.punchConsumeSound() && consumeSound != null) {
                    if (new Random().nextInt(Configuration.punchConsumeChance()) == 0) { // 4 = 25% chance of sound on consume
                        BlockPos pos = new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ());
                        level.playSound((Player)null, pos, consumeSound, SoundSource.HOSTILE, 0.5F, 0.8F + level.random.nextFloat() * 0.4F);
                    }
                }
                return InteractionResultHolder.consume(heldStack);
            } else {
                return InteractionResultHolder.fail(heldStack);
            }
        }
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = new ItemStack(Objects.requireNonNull(stack.getItem().getCraftingRemainingItem()));
        Player player;
        if (stack.get(DataComponents.FOOD) != null) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            player = consumer instanceof Player ? (Player)consumer : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof Player) {
                player = (Player)consumer;
                if (!((Player)consumer).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
    }

    @Override
    public InteractionResult place(BlockPlaceContext context) {
        Player player = context.getPlayer();
        if (player != null && player.isShiftKeyDown()) {
            BlockPlaceContext blockPlaceContext = this.updatePlacementContext(context);
            if (blockPlaceContext == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockState = this.getPlacementState(blockPlaceContext);
                if (blockState == null) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockPos = blockPlaceContext.getClickedPos();
                    Level level = blockPlaceContext.getLevel();
                    ItemStack itemStack = blockPlaceContext.getItemInHand();
                    BlockState blockState2 = level.getBlockState(blockPos);
                    if (blockState2.getBlock() instanceof GlassCupBlock glassCupBlock && itemStack.is(glassCupBlock.servingItem.get())) {
                        glassCupBlock.addServingFromHand(level, blockPos, blockState2, player, player.getUsedItemHand());
                    } else {
                        return super.place(context);
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.foodEffectTooltip()) { // todo - add new config BlockItem tooltips?
            if (hasCustomTooltip) {
                tooltip.add(TextUtils.getTranslatable("tooltip.glass_cup").withStyle(ChatFormatting.DARK_GRAY));
            }

            if (hasFoodEffectTooltip) {
                if (Configuration.foodEffectChanceTooltip()) {
                    TextUtils.addFoodEffectTooltipWithDetail(stack, tooltip::add, 1.0F, context.tickRate());
                } else {
                    TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
                }
            }
        }
    }
}
