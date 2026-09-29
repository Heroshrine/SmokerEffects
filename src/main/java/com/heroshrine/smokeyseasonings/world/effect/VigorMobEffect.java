package com.heroshrine.smokeyseasonings.world.effect;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class VigorMobEffect extends AcceleratedTickSeasoningMobEffect {
    public VigorMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    protected int baseInterval() {
        return SmokeySeasonings.secondsToTicks(6.5f);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        if (mob.getHealth() < mob.getMaxHealth())
            mob.heal(1.0f);

        return true;
    }
}