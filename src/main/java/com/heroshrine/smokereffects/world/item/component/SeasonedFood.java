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

import java.util.*;
import java.util.function.Consumer;

@NullMarked
public record SeasonedFood(List<MobEffectInstance> effects) implements ConsumableListener, TooltipProvider {
    public static final Codec<SeasonedFood> CODEC =
            MobEffectInstance.CODEC.listOf().xmap(SeasonedFood::new, SeasonedFood::effects);

    public static final StreamCodec<RegistryFriendlyByteBuf, SeasonedFood> STREAM_CODEC =
            MobEffectInstance.STREAM_CODEC.apply(ByteBufCodecs.list()).map(SeasonedFood::new, SeasonedFood::effects);

    public static SeasonedFood from(ItemContainerContents seasonings) {
        var effects = new HashMap<MobEffect, MobEffectInstance>();
        var effectsStream = seasonings.nonEmptyItemCopyStream().map(s -> s.typeHolder().getData(DataMaps.SEASONINGS))
                .filter(Objects::nonNull)
                .flatMap(s -> s.effects().stream())
                .toList();

        for (var effect : effectsStream) {
            var holder = effect.getEffect();
            var existing = effects.get(holder.value());
            if (existing != null) {
                effect = new MobEffectInstance(holder, effect.getDuration() + existing.getDuration(),
                        Math.max(effect.getAmplifier(), existing.getAmplifier()));
            }

            effects.put(holder.value(), effect);
        }

        return new SeasonedFood(effects.values().stream().toList());
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