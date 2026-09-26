package com.heroshrine.smokereffects.datagen;

import com.heroshrine.smokereffects.registry.DataMaps;
import com.heroshrine.smokereffects.registry.DataMaps.Seasoning;
import com.heroshrine.smokereffects.registry.DataMaps.SeasoningEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class SmokerEffectsDataMapProvider extends DataMapProvider {
    protected SmokerEffectsDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    //TODO: create 'weak' versions of effects so they can last for longer. Use those instead.
    //TODO: conditional entry API
    @Override
    protected void gather(HolderLookup.Provider provider) {
        quickAdd(Items.BROWN_MUSHROOM, MobEffects.NIGHT_VISION, 5);
        quickAdd(Items.RED_MUSHROOM, new SeasoningEffect(MobEffects.STRENGTH, 5),
                new SeasoningEffect(MobEffects.NAUSEA, 8));
        quickAdd(Items.SUGAR_CANE, MobEffects.SPEED, 5);
        quickAdd(Items.HONEYCOMB, MobEffects.ABSORPTION, 10);
        quickAdd(Items.GLISTERING_MELON_SLICE, MobEffects.INSTANT_HEALTH, 0);
        quickAdd(Items.GOLDEN_CARROT, MobEffects.NIGHT_VISION, 16);
        quickAdd(Items.COCOA_BEANS, MobEffects.HASTE, 5);
        quickAdd(Items.SWEET_BERRIES, MobEffects.REGENERATION, 3);
        quickAdd(Items.GLOW_BERRIES, new SeasoningEffect(MobEffects.GLOWING, 3),
                new SeasoningEffect(MobEffects.NIGHT_VISION, 5));
        quickAdd(Items.SPORE_BLOSSOM, new SeasoningEffect(MobEffects.REGENERATION, 5),
                new SeasoningEffect(MobEffects.NAUSEA, 3),
                new SeasoningEffect(MobEffects.NIGHT_VISION, 3));
        quickAdd(Items.PITCHER_POD, MobEffects.HEALTH_BOOST, 8);
        quickAdd(Items.KELP, MobEffects.WATER_BREATHING, 6);
        quickAdd(Items.DRIED_KELP, MobEffects.WATER_BREATHING, 16);
        quickAdd(Items.SEA_PICKLE, MobEffects.CONDUIT_POWER, 3);
        quickAdd(Items.BLAZE_POWDER, MobEffects.FIRE_RESISTANCE, 3);
        quickAdd(Items.MAGMA_CREAM, MobEffects.FIRE_RESISTANCE, 8);
        quickAdd(Items.NETHER_WART, MobEffects.RESISTANCE, 8);
        quickAdd(Items.WARPED_FUNGUS, MobEffects.LUCK, 8);
        quickAdd(Items.CRIMSON_FUNGUS, new SeasoningEffect(MobEffects.STRENGTH, 6),
                new SeasoningEffect(MobEffects.MINING_FATIGUE, 3));
        quickAdd(Items.RABBIT_FOOT, new SeasoningEffect(MobEffects.JUMP_BOOST, 5, 1),
                new SeasoningEffect(MobEffects.LUCK, 5));
        quickAdd(Items.FERMENTED_SPIDER_EYE, new SeasoningEffect(MobEffects.DARKNESS, 8),
                new SeasoningEffect(MobEffects.SPEED, 5, 1));
        //TODO: random teleport effect, makes you randomly TP while in effect. Use for chorus fruit
        quickAdd(Items.TORCHFLOWER_SEEDS, new SeasoningEffect(MobEffects.GLOWING, 8),
                new SeasoningEffect(MobEffects.HASTE, 6));
    }

    private void quickAdd(Item item, SeasoningEffect... effects) {
        this.builder(DataMaps.SEASONINGS).add(key(item), Seasoning.from(effects), false);
    }

    private void quickAdd(Item item, Holder<MobEffect> effect, int duration) {
        quickAdd(item, effect, duration, 0);
    }

    private void quickAdd(Item item, Holder<MobEffect> effect, int duration, int amplifier) {
        this.builder(DataMaps.SEASONINGS)
                .add(key(item), Seasoning.from(new MobEffectInstance(effect, duration, amplifier)), false);
    }

    private static ResourceKey<Item> key(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
}