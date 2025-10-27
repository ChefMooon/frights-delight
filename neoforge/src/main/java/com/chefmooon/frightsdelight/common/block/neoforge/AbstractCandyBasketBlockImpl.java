package com.chefmooon.frightsdelight.common.block.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.AbstractCandyBasketBlock;
import com.chefmooon.frightsdelight.common.block.entity.CandyBasketBlockEntity;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightAdvancements;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.function.Supplier;

public class AbstractCandyBasketBlockImpl extends AbstractCandyBasketBlock {
    public AbstractCandyBasketBlockImpl(Properties properties, CandyBasketType type) {
        super(properties, type);
    }

    @EventBusSubscriber(modid = FrightsDelight.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    public static class ShuffleEvent {
        @SubscribeEvent
        @SuppressWarnings("unused")
        public static InteractionResult onSneak(PlayerInteractEvent.RightClickBlock event) {

            Level level = event.getLevel();
            BlockPos pos = event.getPos();
            Player player = event.getEntity();
            ItemStack heldStack = player.getMainHandItem();
            BlockEntity blockEntity = level.getBlockEntity(pos);

            if (player.isSecondaryUseActive() && blockEntity instanceof CandyBasketBlockEntity candyBasketBlockEntity) {
                if (!candyBasketBlockEntity.isEmpty()) {
                    boolean shuffled = shuffleInventory(level, pos);
                    if (shuffled) {
                        Supplier<SoundEvent> shuffleSound = level.getBlockState(pos).getBlock() instanceof AbstractCandyBasketBlockImpl candyBasketBlock ? candyBasketBlock.getCandyBasketType().getShuffleSound() : null;
                        if (shuffleSound != null)
                            level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, shuffleSound.get(), SoundSource.PLAYERS, Math.min(0.3f + 0.04f * candyBasketBlockEntity.getFilledSlotsCount(), 1.0f), 1.0f, false);
                        if (player instanceof ServerPlayer serverPlayer) FrightsDelightAdvancements.CANDY_BASKET_SHUFFLE_TRIGGER.get().trigger(serverPlayer);
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
