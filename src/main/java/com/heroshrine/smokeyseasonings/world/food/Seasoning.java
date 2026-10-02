package com.heroshrine.smokeyseasonings.world.food;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.effect.MobEffectInstance;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public record Seasoning(List<MobEffectInstance> effects) {
    public static final Codec<Seasoning> CODEC = RecordCodecBuilder.create(i -> i.group(
                    MobEffectInstance.CODEC.listOf().fieldOf("effects").forGetter(Seasoning::effects))
            .apply(i, Seasoning::new));

    public static Seasoning from(MobEffectInstance... effects) {
        return new Seasoning(List.of(effects));
    }
}
