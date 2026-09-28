package com.heroshrine.smokereffects.world.effect;

import com.heroshrine.smokereffects.SmokerEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class UnstableMobEffect extends SeasoningMobEffect {
    public UnstableMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public static final int BASE_RANGE = 16; // chorus fruit uses ±8
    public static final int TRIES = 16;
    private static final int BASE_INTERVAL = SmokerEffects.secondsToTicks(20f);

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity mob, int amplification) {
        return randomTeleport(level, mob, BASE_RANGE, TRIES, amplification);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplification) {
        return tickCount % BASE_INTERVAL == 0;
    }

    public static boolean randomTeleport(ServerLevel level, LivingEntity mob, int range, int tries, int amplification) {
        var random = mob.getRandom();
        double finalRange = range << Math.min(amplification, 2);
        int minY = level.getMinY();
        int maxY = minY + level.getLogicalHeight() - 1;

        if (mob.isPassenger())
            mob.stopRiding();

        for (int i = 0; i < tries; i++) {
            double x = mob.getX() + (random.nextDouble() * 2 - 1) * finalRange;
            double y = Mth.clamp(mob.getY() + (random.nextDouble() * 2 - 1) * finalRange, minY, maxY);
            double z = mob.getZ() + (random.nextDouble() * 2 - 1) * finalRange;

            var oldPos = mob.position();
            if (mob.randomTeleport(x, y, z, true)) {

                var tpEvent = new EntityTeleportEvent(mob, level, x, y, z);
                if (NeoForge.EVENT_BUS.post(tpEvent).isCanceled())
                    continue;

                if (mob.isPassenger())
                    mob.stopRiding();

                level.gameEvent(GameEvent.TELEPORT, oldPos, GameEvent.Context.of(mob));
                level.playSound(null, mob.getX(), mob.getY(), mob.getZ(),
                        SoundEvents.CHORUS_FRUIT_TELEPORT, mob.getSoundSource());
                mob.resetFallDistance();
                mob.resetCurrentImpulseContext();
                return true;
            }
        }

        return false;
    }

}