package com.chefmooon.frightsdelight.common.item.neoforge;

import com.chefmooon.frightsdelight.common.entity.neoforge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class BoneShardItemImpl extends Item implements ProjectileItem {
    public static final int THROW_THRESHOLD_TIME = 8;

    public BoneShardItemImpl(Properties properties) {
        super(properties);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.TRIDENT;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 23000;
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player) {
            ItemStack heldStack = player.getItemInHand(player.getUsedItemHand());
            int i = this.getUseDuration(stack, livingEntity) - timeCharged;
            if (i >= THROW_THRESHOLD_TIME) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (level instanceof ServerLevel serverLevel) {
                    BoneShardEntityImpl thrownBoneShard = Projectile.spawnProjectileFromRotation(BoneShardEntityImpl::new, serverLevel, heldStack, player, 0.2F, 1.5F, 1.0F);

                    level.playSound(null,thrownBoneShard, FrightsDelightSounds.ENTITY_BONE_SHARD_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
                    if (!player.hasInfiniteMaterials()) {
                        heldStack.shrink(1);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);

        return InteractionResult.CONSUME;
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        BoneShardEntityImpl boneShard = new BoneShardEntityImpl(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1));
        boneShard.setItem(stack);
        return boneShard;
    }
}
