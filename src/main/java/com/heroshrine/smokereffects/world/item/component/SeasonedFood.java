package com.heroshrine.smokereffects.world.item.component;

import com.heroshrine.smokereffects.registry.DataMaps;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

@NullMarked
public record SeasonedFood(List<MobEffectInstance> effects) implements ConsumableListener, TooltipProvider {
    public static final Codec<SeasonedFood> CODEC =
            MobEffectInstance.CODEC.listOf().xmap(SeasonedFood::new, SeasonedFood::effects);

    public static final StreamCodec<RegistryFriendlyByteBuf, SeasonedFood> STREAM_CODEC =
            MobEffectInstance.STREAM_CODEC.apply(ByteBufCodecs.list()).map(SeasonedFood::new, SeasonedFood::effects);

    public static final float FULL_MEAL = 20.8f;

    public static SeasonedFood from(ItemContainerContents seasonings, @Nullable FoodProperties food) {
        var effects = new HashMap<MobEffect, MobEffectInstance>();
        var effectsStream = seasonings.nonEmptyItemCopyStream().map(s -> s.typeHolder().getData(DataMaps.SEASONINGS))
                .filter(Objects::nonNull)
                .flatMap(s -> s.effects().stream())
                .toList();

        float scale = food == null ? 1f : Math.min(1f, (food.nutrition() + food.saturation()) / FULL_MEAL);

        for (var effect : effectsStream) {
            var holder = effect.getEffect();
            var existing = effects.get(holder.value());
            if (existing != null) {
                int duration = getDuration(effect, existing);
                effect = new MobEffectInstance(holder, duration,
                        Math.min(effect.getAmplifier(), existing.getAmplifier()),
                        true, true, true);
            }

            effects.put(holder.value(), effect);
        }

        return new SeasonedFood(effects.values().stream().map(e -> new MobEffectInstance(e.getEffect(),
                scaleDuration(e.getDuration(), scale), e.getAmplifier(),
                true, true, true)).toList());
    }

    private static int getDuration(MobEffectInstance effect, MobEffectInstance existing) {
        int duration = effect.getDuration() + existing.getDuration();
        if (existing.getAmplifier() != effect.getAmplifier()) {
            var highest = existing.getAmplifier() > effect.getAmplifier() ? existing : effect;
            var lowest = existing.getAmplifier() > effect.getAmplifier() ? effect : existing;
            var diff = highest.getAmplifier() - lowest.getAmplifier() + 1;
            duration = highest.getDuration() * diff + lowest.getDuration();
        }
        return duration;
    }

    private static int scaleDuration(int duration, float scale) {
        return duration < 0 ? duration : Math.max(1, Math.round(duration * scale));
    }

    @Override
    public void onConsume(Level level, LivingEntity entity, ItemStack itemStack, Consumable consumable) {
        if (level.isClientSide()) return;
        for (var effect : effects)
            entity.addEffect(effect);
    }

    @Override
    public void addToTooltip(Item.TooltipContext tooltip, Consumer<Component> lines, TooltipFlag flag, DataComponentGetter components) {
        PotionContents.addPotionTooltip(effects, lines, 1.0f, tooltip.tickRate());
    }
}