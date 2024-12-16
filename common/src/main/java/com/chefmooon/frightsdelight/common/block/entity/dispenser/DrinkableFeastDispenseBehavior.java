package com.chefmooon.frightsdelight.common.block.entity.dispenser;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DrinkableFeastDispenseBehavior extends OptionalDispenseItemBehavior {

    public DrinkableFeastDispenseBehavior() {
    }

    protected ItemStack execute(BlockSource source, ItemStack stack) {
        ServerLevel serverLevel = source.level();
        if (!serverLevel.isClientSide()) {
            Direction direction = source.state().getValue(DispenserBlock.FACING);
            Position position = DispenserBlock.getDispensePosition(source);
            BlockPos blockPos = source.pos().relative(direction);
            this.setSuccess(tryAddDrinkableFeast(serverLevel, stack, blockPos));
            ItemStack itemStack = stack.split(1);
            playSound(source);
            if (this.isSuccess()) {
                spawnItem(source.level(), new ItemStack(Items.GLASS_BOTTLE), 6, direction, position);
            } else {
                spawnItem(source.level(), itemStack, 6, direction, position);
            }
        }
        return stack;
    }
    public static boolean tryAddDrinkableFeast(ServerLevel level, ItemStack item, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof DrinkableFeastBlock drinkableFeastBlock) {
            if (item.is(drinkableFeastBlock.servingItem.get())) {
                if (state.getValue(DrinkableFeastBlock.SERVINGS) < DrinkableFeastBlock.MAX_SERVINGS) {
                    return drinkableFeastBlock.addDrinkFromDispenser(level, pos, state);
                }
            }
        }
        return false;
    }
}
