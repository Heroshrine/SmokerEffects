package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.effect.SatedMobEffect;
import com.heroshrine.smokereffects.world.effect.SeasoningMobEffect;
import com.heroshrine.smokereffects.world.effect.VigorMobEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL;

public class MobEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECT =
            DeferredRegister.create(Registries.MOB_EFFECT, SmokerEffects.MOD_ID);

    // attribute modifiers only
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> BRISK
            = MOB_EFFECT.register("brisk", () ->
            new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x7FD4FF)
                    .withModifier(Attributes.MOVEMENT_SPEED, "brisk", 0.08f, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> HARDENING =
            MOB_EFFECT.register("hardening", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xA0785A)
                            .withModifier(Attributes.ARMOR_TOUGHNESS, "hardening", 2, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> FERVOR =
            MOB_EFFECT.register("fervor", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xD1BF66)
                            .withModifier(Attributes.BLOCK_BREAK_SPEED, "fervor", 2, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> MIGHT =
            MOB_EFFECT.register("might", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xEDB51C)
                            .withModifier(Attributes.ATTACK_DAMAGE, "might", 1, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> HEARTY =
            MOB_EFFECT.register("hearty", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xF59047)
                            .withModifier(Attributes.MAX_HEALTH, "hearty", 2, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> STEADFAST =
            MOB_EFFECT.register("steadfast", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x574A44)
                            .withModifier(Attributes.KNOCKBACK_RESISTANCE, "steadfast", 0.15f, ADD_MULTIPLIED_BASE)
                            .withModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, "steadfast", 0.2f, ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> BREATH =
            MOB_EFFECT.register("breath", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x5499B0)
                            .withModifier(Attributes.OXYGEN_BONUS, "breath", 1, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> AQUANE =
            MOB_EFFECT.register("aquane", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x275DA1)
                            .withModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, "aquane", 0.33f, ADD_MULTIPLIED_TOTAL)
                            .withModifier(Attributes.SUBMERGED_MINING_SPEED, "aquane", 1f, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> FEATHERWEIGHT =
            MOB_EFFECT.register("featherweight", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xC5A6E8)
                            .withModifier(Attributes.GRAVITY, "featherweight", -0.11f, ADD_MULTIPLIED_TOTAL)
                            .withModifier(Attributes.SAFE_FALL_DISTANCE, "featherweight", 2f, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> SURE_FOOTED =
            MOB_EFFECT.register("sure_footed", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x7EA35A)
                            .withModifier(Attributes.STEP_HEIGHT, "sure_footed", 0.4f, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> LONG_REACH =
            MOB_EFFECT.register("long_reach", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x916E8A)
                            .withModifier(Attributes.STEP_HEIGHT, "long_reach", 1, ADD_VALUE));

    // effects that aren't just an attribute modifier
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> HEAT_TOLERANCE = // has event in MobEffectEvents
            MOB_EFFECT.register("heat_tolerance", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xE8743A)
                            .withModifier(Attributes.BURNING_TIME, "heat_tolerance", -0.3, ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> ENDERSTEP = // has event in MobEffectEvents
            MOB_EFFECT.register("enderstep", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x301442));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> IRON_STOMACH = // has event in MobEffectEvents
            MOB_EFFECT.register("iron_stomach", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x736570));

    public static final DeferredHolder<MobEffect, VigorMobEffect> VIGOR =
            MOB_EFFECT.register("vigor", () ->
                    new VigorMobEffect(MobEffectCategory.BENEFICIAL, 0x72A85A));
    public static final DeferredHolder<MobEffect, SatedMobEffect> SATED =
            MOB_EFFECT.register("sated", () ->
                    new SatedMobEffect(MobEffectCategory.BENEFICIAL, 0xD6A83D));
    public static final DeferredHolder<MobEffect, SatedMobEffect> ENDERSTEP_UNSTABLE =
            MOB_EFFECT.register("enderstep_unstable", () ->
                    new SatedMobEffect(MobEffectCategory.BENEFICIAL, 0x6C4E80));
}