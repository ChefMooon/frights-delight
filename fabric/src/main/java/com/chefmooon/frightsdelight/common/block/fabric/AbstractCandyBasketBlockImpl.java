package com.chefmooon.frightsdelight.common.block.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.AbstractCandyBasketBlock;
import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class AbstractCandyBasketBlockImpl extends AbstractCandyBasketBlock {
    public AbstractCandyBasketBlockImpl(Properties properties, CandyBasketType type) {
        super(properties, type);
    }

    public static void init() {
        UseBlockCallback.EVENT.register(AbstractCandyBasketBlockImpl.ShuffleEvent::onSneak);
    }

    public static class ShuffleEvent {
        public static InteractionResult onSneak(Player player, Level level, InteractionHand hand, BlockHitResult hit) {
            BlockPos pos = hit.getBlockPos();
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (player.isSecondaryUseActive() && blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
                if (!candyBasketBlockEntity.isEmpty()) {
                    boolean shuffled = shuffleInventory(level, pos);
                    if (shuffled) {
                        if (!level.isClientSide) FrightsDelight.loggerInfo("Shuffle Event");
                        Supplier<SoundEvent> shuffleSound = level.getBlockState(pos).getBlock() instanceof AbstractCandyBasketBlockImpl candyBasketBlock ? candyBasketBlock.getCandyBasketType().getShuffleSound() : null;
                        if (shuffleSound != null)
                            level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, shuffleSound.get(), SoundSource.PLAYERS, Math.min(0.3f + 0.04f * candyBasketBlockEntity.getFilledSlotsCount(), 1.0f), 1.0f, false);
                        return InteractionResult.SUCCESS;
                    }
                } else {
                    level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, FrightsDelightSounds.BLOCK_CANDY_BASKET_EMPTY.get(), SoundSource.BLOCKS, 0.4f, 0.6f, false);
                }
            }

            return InteractionResult.PASS;
        }
    }
}
