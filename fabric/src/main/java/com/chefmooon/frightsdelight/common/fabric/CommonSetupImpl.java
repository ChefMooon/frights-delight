package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.frightsdelight.common.crafting.condition.FrDVanillaCrateEnabledCondition;
import com.chefmooon.frightsdelight.common.entity.fabric.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.fluid.fabric.FrDFluidVariantAttributeHandler;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class CommonSetupImpl {

    public static void init() {
        CommonSetup.init();
        registerDispenserBehaviors();
        registerFluidAttributeHandlers();

        ResourceConditions.register(FrDVanillaCrateEnabledCondition.ID, jsonObject -> Configuration.isEnableFrDCrates());
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD), new AbstractProjectileDispenseBehavior() {
                    @Override
                    protected Projectile getProjectile(Level level, Position position, ItemStack stack) {
                        return new BoneShardEntityImpl(level, position.x(), position.y(), position.z());
                    }
                }
        );

        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(FrightsDelightItemsImpl.PUNCH_COBWEB, new DrinkableFeastDispenseBehavior());
    }

    public static void registerFluidAttributeHandlers() {
        FluidVariantAttributes.register(FrightsDelightFluids.ROTTEN_FLESH_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_ROTTEN_FLESH_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.SLIMEAPPLE_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_SLIMEAPPLE_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.SPIDEREYE_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_SPIDEREYE_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.GHASTTEAR_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_GHASTTEAR_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.SOUL_BERRY_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_SOUL_BERRY_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.WITHER_BERRY_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_WITHER_BERRY_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);

        FluidVariantAttributes.register(FrightsDelightFluids.COBWEB_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
        FluidVariantAttributes.register(FrightsDelightFluids.FLOWING_COBWEB_SYRUP, FrDFluidVariantAttributeHandler.INSTANCE);
    }
}
