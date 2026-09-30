package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.world.effect.SatedMobEffect;
import com.heroshrine.smokeyseasonings.world.effect.SeasoningMobEffect;
import com.heroshrine.smokeyseasonings.world.effect.UnstableMobEffect;
import com.heroshrine.smokeyseasonings.world.effect.VigorMobEffect;
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
            DeferredRegister.create(Registries.MOB_EFFECT, SmokeySeasonings.MOD_ID);

    // attribute modifiers only
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> BRISK
            = MOB_EFFECT.register("brisk", () ->
            new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x7FD4FF)
                    .withModifier(Attributes.MOVEMENT_SPEED, "brisk", 0.08f, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> HARDENED =
            MOB_EFFECT.register("hardened", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xA0785A)
                            .withModifier(Attributes.ARMOR_TOUGHNESS, "hardened", 2, ADD_VALUE)
                            .withModifier(Attributes.ARMOR, "hardened", 2, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> FERVOR =
            MOB_EFFECT.register("fervor", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xD1BF66)
                            .withModifier(Attributes.BLOCK_BREAK_SPEED, "fervor", 0.08725f, ADD_MULTIPLIED_TOTAL));
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
                            .withModifier(Attributes.KNOCKBACK_RESISTANCE, "steadfast", 0.15f, ADD_VALUE)
                            .withModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, "steadfast", 0.2f, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> BREATH =
            MOB_EFFECT.register("breath", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x5499B0)
                            .withModifier(Attributes.OXYGEN_BONUS, "breath", 1, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> AQUANE =
            MOB_EFFECT.register("aquane", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x275DA1)
                            .withModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, "aquane", 0.33f, ADD_VALUE)
                            .withModifier(Attributes.SUBMERGED_MINING_SPEED, "aquane", 1f, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> FEATHERWEIGHT =
            MOB_EFFECT.register("featherweight", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xC5A6E8)
                            .withModifier(Attributes.GRAVITY, "featherweight", -0.11f, ADD_MULTIPLIED_TOTAL)
                            .withModifier(Attributes.SAFE_FALL_DISTANCE, "featherweight", 2.5f, ADD_VALUE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> SURE_FOOTED =
            MOB_EFFECT.register("sure_footed", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x7EA35A)
                            .withModifier(Attributes.STEP_HEIGHT, "sure_footed", 1, ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> LONG_REACH =
            MOB_EFFECT.register("long_reach", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0x916E8A)
                            .withModifier(Attributes.BLOCK_INTERACTION_RANGE, "long_reach", 1, ADD_VALUE)
                            .withModifier(Attributes.ENTITY_INTERACTION_RANGE, "long_reach", 1, ADD_VALUE));

    public static final DeferredHolder<MobEffect, SeasoningMobEffect> HEAVY =
            MOB_EFFECT.register("heavy", () ->
                    new SeasoningMobEffect(MobEffectCategory.NEUTRAL, 0x434147)
                            .withModifier(Attributes.GRAVITY, "heavy", 0.18f, ADD_MULTIPLIED_TOTAL)
                            .withModifier(Attributes.KNOCKBACK_RESISTANCE, "heavy", 0.3f, ADD_VALUE)
                            .withModifier(Attributes.MOVEMENT_SPEED, "heavy", -0.05f, ADD_MULTIPLIED_BASE));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> RECKLESS =
            MOB_EFFECT.register("reckless", () ->
                    new SeasoningMobEffect(MobEffectCategory.NEUTRAL, 0x6E1C12)
                            .withModifier(Attributes.ATTACK_DAMAGE, "reckless", 2, ADD_VALUE)
                            .withModifier(Attributes.ARMOR, "reckless", -4, ADD_VALUE));

    public static final DeferredHolder<MobEffect, SeasoningMobEffect> SLUGGISH =
            MOB_EFFECT.register("sluggish", () ->
                    new SeasoningMobEffect(MobEffectCategory.HARMFUL, 0x7686AD)
                            .withModifier(Attributes.MOVEMENT_SPEED, "sluggish", -0.08f, ADD_MULTIPLIED_TOTAL));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> BRITTLE =
            MOB_EFFECT.register("brittle", () ->
                    new SeasoningMobEffect(MobEffectCategory.HARMFUL, 0xA08D5A)
                            .withModifier(Attributes.ARMOR_TOUGHNESS, "brittle", -2, ADD_VALUE)
                            .withModifier(Attributes.ARMOR, "brittle", -2f, ADD_VALUE));

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
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> KEEN_EYES = // has lightmap mixin
            MOB_EFFECT.register("keen_eyes", () ->
                    new SeasoningMobEffect(MobEffectCategory.BENEFICIAL, 0xE6BC4A));
    public static final DeferredHolder<MobEffect, VigorMobEffect> VIGOR =
            MOB_EFFECT.register("vigor", () ->
                    new VigorMobEffect(MobEffectCategory.BENEFICIAL, 0x72A85A));
    public static final DeferredHolder<MobEffect, SatedMobEffect> SATED =
            MOB_EFFECT.register("sated", () ->
                    new SatedMobEffect(MobEffectCategory.BENEFICIAL, 0xD6A83D));

    public static final DeferredHolder<MobEffect, UnstableMobEffect> ENDERSTEP_UNSTABLE =
            MOB_EFFECT.register("enderstep_unstable", () ->
                    new UnstableMobEffect(MobEffectCategory.HARMFUL, 0x6C4E80));
    public static final DeferredHolder<MobEffect, SeasoningMobEffect> AFFLICTION = // has event in MobEffectEvents
            MOB_EFFECT.register("affliction", () ->
                    new SeasoningMobEffect(MobEffectCategory.HARMFUL, 0x663131));
}