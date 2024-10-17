package com.chefmooon.frightsdelight.common.entity.forge;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightEntityTypesImpl;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightItemsImpl;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BoneShardEntityImpl extends ThrowableItemProjectile {
    public BoneShardEntityImpl(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public BoneShardEntityImpl(Level level, LivingEntity entity) {
        super(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), entity, level);
    }

    public BoneShardEntityImpl(Level level, double x, double y, double z) {
        super(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return FrightsDelightItemsImpl.BONE_SHARD.get();
    }

    @Override
    public void handleEntityEvent(byte id) {
        ItemStack entityStack = new ItemStack(this.getDefaultItem());
        if (id == 3) {
            ParticleOptions iparticledata = new ItemParticleOption(ParticleTypes.ITEM, entityStack);

            for (int i = 0; i < 12; ++i) {
                this.level().addParticle(iparticledata, this.getX(), this.getY(), this.getZ(),
                        ((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F,
                        ((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F + 0.1F,
                        ((double) this.random.nextFloat() * 2.0D - 1.0D) * 0.1F);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 0);
        this.playSound(FrightsDelightSounds.ENTITY_BONE_SHARD_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(FrightsDelightSounds.ENTITY_BONE_SHARD_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.discard();
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
