package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.effect.UnstableMobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import org.jspecify.annotations.NullMarked;

import java.io.IOException;

@NullMarked
@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public class MobEffectEvents {
    private static final float HEAT_TOLERANCE_REDUCTION = 0.2F;

    @SubscribeEvent
    private static void reduceFireDamage(LivingIncomingDamageEvent event) {
        if (!event.getSource().is(DamageTypeTags.IS_FIRE)) return;

        var effect = event.getEntity().getEffect(MobEffects.HEAT_TOLERANCE);
        if (effect == null) return;

        float reduction = HEAT_TOLERANCE_REDUCTION * (effect.getAmplifier() + 1);
        event.setAmount(event.getAmount() * (1.0F - reduction));
    }

    @SubscribeEvent
    private static void enderstepOnDamage(LivingIncomingDamageEvent event) {

        var mob = event.getEntity();
        ServerLevel serverLevel;
        var effect = mob.getEffect(MobEffects.ENDERSTEP);
        if (effect == null) return;

        try (var level = mob.level()) {
            if (!(level instanceof ServerLevel sl))
                return;
            serverLevel = sl;
        } catch (IOException _) {
            // ignore????
            return;
        }

        UnstableMobEffect.randomTeleport(serverLevel, mob, UnstableMobEffect.BASE_RANGE, UnstableMobEffect.TRIES, effect.getAmplifier());
    }

    @SubscribeEvent
    private static void stopEatenPoison(MobEffectEvent.Applicable event) {
        var mob = event.getEntity();
        var effect = mob.getEffect(MobEffects.IRON_STOMACH);
        if (effect == null) return;

        event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
    }
}
