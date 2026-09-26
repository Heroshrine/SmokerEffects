package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;
import org.jspecify.annotations.NullMarked;

import java.util.Arrays;
import java.util.List;

@NullMarked
@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public class DataMaps {
    //TODO: move effect and seasoning out of here?
    public static class SeasoningEffect {
        public SeasoningEffect(Holder<MobEffect> effect, int duration) {
            this.effect = effect;
            this.duration = duration;
            amplifier = 0;
        }

        public SeasoningEffect(Holder<MobEffect> effect, int duration, int amplifier) {
            this.effect = effect;
            this.duration = duration;
            this.amplifier = amplifier;
        }

        private final Holder<MobEffect> effect;
        private final int duration;
        private final int amplifier;
    }

    public record Seasoning(List<MobEffectInstance> effects) {
        public static final Codec<Seasoning> CODEC = RecordCodecBuilder.create(i -> i.group(
                        MobEffectInstance.CODEC.listOf().fieldOf("effects").forGetter(Seasoning::effects))
                .apply(i, Seasoning::new));

        public static Seasoning from(MobEffectInstance... effects) {
            return new Seasoning(List.of(effects));
        }

        public static Seasoning from(SeasoningEffect... effects) {
            return new Seasoning(Arrays.stream(effects).map(e ->
                    new MobEffectInstance(e.effect, e.duration, e.amplifier)).toList()
            );
        }
    }

    public static final DataMapType<Item, Seasoning> SEASONINGS = DataMapType.builder(
            Identifier.fromNamespaceAndPath(SmokerEffects.MOD_ID, "seasonings"),
            Registries.ITEM, Seasoning.CODEC
    ).synced(Seasoning.CODEC, false).build();

    @SubscribeEvent
    static void registerDataMaps(RegisterDataMapTypesEvent event) {
        event.register(SEASONINGS);
    }
}