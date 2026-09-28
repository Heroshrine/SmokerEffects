package com.heroshrine.smokereffects.world.effect;

import com.heroshrine.smokereffects.SmokerEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SatedMobEffect extends AcceleratedTickSeasoningMobEffect {
    public SatedMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    protected int baseInterval() {
        return SmokerEffects.secondsToTicks(8f);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        if (mob instanceof Player player) {
            var food = player.getFoodData();
            food.setSaturation(Math.min(food.getSaturationLevel() + 0.5f, food.getFoodLevel()));
            return true;
        }

        return false;
    }
}