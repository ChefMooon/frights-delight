package com.chefmooon.frightsdelight.common.advancement;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightAdvancements;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class CandyBasketShuffleTrigger extends SimpleCriterionTrigger<CandyBasketShuffleTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return CandyBasketShuffleTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance
    {
        public static final Codec<CandyBasketShuffleTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(CandyBasketShuffleTrigger.TriggerInstance::player))
                        .apply(builder, CandyBasketShuffleTrigger.TriggerInstance::new)
        );
        public static Criterion<TriggerInstance> simple() {
            return FrightsDelightAdvancements.CANDY_BASKET_SHUFFLE_TRIGGER.get().createCriterion(
                    new CandyBasketShuffleTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
