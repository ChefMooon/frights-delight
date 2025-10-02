package com.chefmooon.frightsdelight.common.item.fabric;

import com.chefmooon.frightsdelight.common.entity.fabric.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BoneShardItemImpl extends Item {
    public static final int THROW_THRESHOLD_TIME = 8;

    public BoneShardItemImpl(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 23000;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player) {
            ItemStack heldStack = player.getItemInHand(player.getUsedItemHand());
            int i = this.getUseDuration(stack) - timeCharged;
            if (i >= THROW_THRESHOLD_TIME) {
                if (!level.isClientSide) {
                    BoneShardEntityImpl projectile = new BoneShardEntityImpl(level, player);
                    projectile.setItem(heldStack);
                    projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.2F, 1.5F, 1.0F);
                    level.addFreshEntity(projectile);

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), FrightsDelightSounds.ENTITY_BONE_SHARD_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
                    if (!player.getAbilities().instabuild) {
                        heldStack.shrink(1);
                    }
                }

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);

        player.startUsingItem(hand);

        return InteractionResultHolder.consume(heldStack);
    }
}
