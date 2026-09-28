package com.heroshrine.smokereffects.world.effect;

import net.minecraft.world.effect.MobEffectCategory;

public abstract class AcceleratedTickSeasoningMobEffect extends SeasoningMobEffect {
    public AcceleratedTickSeasoningMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    protected abstract int baseInterval();

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        int interval = baseInterval() >> amplification;
        return interval == 0 || tickCount % interval == 0;
    }
}
