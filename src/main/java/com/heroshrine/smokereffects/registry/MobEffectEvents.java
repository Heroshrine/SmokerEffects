package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.effect.UnstableMobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import org.jspecify.annotations.NullMarked;

@NullMarked
@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public class MobEffectEvents {
    private static final float HEAT_TOLERANCE_REDUCTION = 0.2F;

    @SubscribeEvent
    private static void heatTolerance(LivingIncomingDamageEvent event) {
        if (!event.getSource().is(DamageTypeTags.IS_FIRE)) return;

        var effect = event.getEntity().getEffect(MobEffects.HEAT_TOLERANCE);
        if (effect == null) return;

        float reduction = HEAT_TOLERANCE_REDUCTION * (effect.getAmplifier() + 1);
        event.setAmount(event.getAmount() * (1.0F - reduction));
    }

    @SubscribeEvent
    private static void enderstep(LivingIncomingDamageEvent event) {

        var mob = event.getEntity();
        var effect = mob.getEffect(MobEffects.ENDERSTEP);
        if (effect == null) return;

        if (!(mob.level() instanceof ServerLevel serverLevel))
            return;

        UnstableMobEffect.randomTeleport(serverLevel, mob, UnstableMobEffect.BASE_RANGE, UnstableMobEffect.TRIES, effect.getAmplifier());
    }

    @SubscribeEvent
    private static void ironStomach(MobEffectEvent.Applicable event) {
        var mob = event.getEntity();
        var effect = mob.getEffect(MobEffects.IRON_STOMACH);
        if (effect == null) return;

        if (event.getEffectSource() != null || event.getEffectInstance().getEffect().value().isBeneficial())
            return;

        event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
    }

    @SubscribeEvent
    private static void affliction(LivingHealEvent event) {
        var mob = event.getEntity();
        var effect = mob.getEffect(MobEffects.AFFLICTION);
        if (effect == null) return;

        event.setAmount(event.getAmount() * (float) Math.pow(0.6, effect.getAmplifier() + 1));
    }
}