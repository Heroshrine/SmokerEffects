package com.heroshrine.smokeyseasonings.datagen;

import com.heroshrine.smokeyseasonings.registry.DataMaps;
import com.heroshrine.smokeyseasonings.registry.MobEffects;
import com.heroshrine.smokeyseasonings.world.food.Seasoning;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;
import org.jspecify.annotations.NullMarked;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static com.heroshrine.smokeyseasonings.SmokeySeasonings.secondsToTicks;
import static com.heroshrine.smokeyseasonings.SmokeySeasonings.minutesToTicks;

@NullMarked
public class SmokeySeasoningsDataMapProvider extends DataMapProvider {
    protected SmokeySeasoningsDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    //TODO: conditional entry API using item IDs
    @Override
    protected void gather(HolderLookup.Provider provider) {

        // 'early' game
        quickAdd(Items.SUGAR_CANE, MobEffects.BRISK, minutesToTicks(2));
        quickAdd(Items.COCOA_BEANS, MobEffects.FERVOR, minutesToTicks(2));
        quickAdd(Items.BEETROOT, MobEffects.MIGHT, minutesToTicks(2));
        quickAdd(Items.CARROT, MobEffects.SURE_FOOTED, minutesToTicks(2)); //TODO: find something other than carrot
        quickAdd(Items.CLAY_BALL, MobEffects.STEADFAST, minutesToTicks(3));
        quickAdd(ItemTags.EGGS, MobEffects.HEARTY, minutesToTicks(2));
        quickAdd(Items.BROWN_MUSHROOM, MobEffects.SATED, minutesToTicks(2));
        quickAdd(Items.SWEET_BERRIES, MobEffects.VIGOR, minutesToTicks(2)); //TODO: maybe make this harder?
        quickAdd(Items.DANDELION, net.minecraft.world.effect.MobEffects.SATURATION, 1); //TODO: maybe make this harder?
        quickAdd(Items.KELP, MobEffects.BREATH, minutesToTicks(2));
        quickAdd(Items.IRON_NUGGET, MobEffects.HEAVY, minutesToTicks(2));
        quickAdd(Items.FEATHER, MobEffects.FEATHERWEIGHT, minutesToTicks(1.5f));
        quickAdd(Items.RED_MUSHROOM, new SeasoningEffect(MobEffects.MIGHT, minutesToTicks(3)),
                new SeasoningEffect(MobEffects.AFFLICTION, minutesToTicks(3)));
        quickAdd(Items.BAMBOO, MobEffects.LONG_REACH, minutesToTicks(1));

        // 'mid' game
        quickAdd(Items.GLOW_BERRIES, new SeasoningEffect(MobEffects.KEEN_EYES, minutesToTicks(2)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.GLOWING, secondsToTicks(20)));
        quickAdd(Items.SEA_PICKLE, MobEffects.AQUANE, minutesToTicks(3));
        quickAdd(Items.PRISMARINE_CRYSTALS, new SeasoningEffect(MobEffects.AQUANE, minutesToTicks(3.25f), 1),
                new SeasoningEffect(MobEffects.BREATH, minutesToTicks(3.25f)));
        quickAdd(Items.PUFFERFISH, new SeasoningEffect(MobEffects.BREATH, minutesToTicks(5), 1),
                new SeasoningEffect(MobEffects.AFFLICTION, minutesToTicks(1.5f)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.NAUSEA, secondsToTicks(3)));
        quickAdd(Items.ARMADILLO_SCUTE, MobEffects.STEADFAST, minutesToTicks(2.5f));
        quickAdd(Items.TURTLE_SCUTE, new SeasoningEffect(MobEffects.STEADFAST, minutesToTicks(3)),
                new SeasoningEffect(MobEffects.HARDENED, minutesToTicks(2), 1));
        quickAdd(Items.HONEYCOMB, MobEffects.IRON_STOMACH, minutesToTicks(3));
        quickAdd(Items.RABBIT_FOOT, new SeasoningEffect(MobEffects.SURE_FOOTED, minutesToTicks(5), 1),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.JUMP_BOOST, minutesToTicks(5)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.LUCK, minutesToTicks(5)));
        quickAdd(Items.GLISTERING_MELON_SLICE, MobEffects.VIGOR, minutesToTicks(4));
        quickAdd(Items.GOLDEN_CARROT, MobEffects.KEEN_EYES, minutesToTicks(6));
        quickAdd(Items.PHANTOM_MEMBRANE, MobEffects.FEATHERWEIGHT, minutesToTicks(4), 1);
        quickAdd(Items.TORCHFLOWER_SEEDS, MobEffects.FERVOR, minutesToTicks(5), 1);
        quickAdd(Items.PITCHER_POD, MobEffects.LONG_REACH, minutesToTicks(5));
        quickAdd(Items.FERMENTED_SPIDER_EYE, new SeasoningEffect(MobEffects.AFFLICTION, secondsToTicks(30)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.SPEED, secondsToTicks(15), 2),
                new SeasoningEffect(MobEffects.BRITTLE, secondsToTicks(15)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.DARKNESS, secondsToTicks(5)));
        quickAdd(Items.BLAZE_POWDER, new SeasoningEffect(MobEffects.HEAT_TOLERANCE, minutesToTicks(3)),
                new SeasoningEffect(MobEffects.RECKLESS, minutesToTicks(3)));
        quickAdd(Items.RESIN_CLUMP, new SeasoningEffect(MobEffects.STEADFAST, minutesToTicks(1.5f)),
                new SeasoningEffect(MobEffects.VIGOR, minutesToTicks(1.5f)),
                new SeasoningEffect(MobEffects.HEARTY, minutesToTicks(1.5f), 1),
                new SeasoningEffect(MobEffects.SLUGGISH, minutesToTicks(1.5f)));

        // 'late' game
        quickAdd(Items.NETHER_WART, MobEffects.HARDENED, minutesToTicks(3));
        quickAdd(Items.WARPED_FUNGUS, MobEffects.HEAT_TOLERANCE, minutesToTicks(4)); //TODO: probably want this earlier game?
        quickAdd(Items.MAGMA_CREAM, MobEffects.HEAT_TOLERANCE, minutesToTicks(5), 1);
        quickAdd(Items.CRIMSON_FUNGUS, new SeasoningEffect(MobEffects.MIGHT, minutesToTicks(3.25f)),
                new SeasoningEffect(MobEffects.SLUGGISH, minutesToTicks(1.25f)));
        quickAdd(Items.GHAST_TEAR, new SeasoningEffect(MobEffects.VIGOR, minutesToTicks(6)),
                new SeasoningEffect(MobEffects.HEARTY, minutesToTicks(6)));
        quickAdd(Items.CHORUS_FRUIT, MobEffects.ENDERSTEP_UNSTABLE, minutesToTicks(1));
        quickAdd(Items.ENDER_PEARL, new SeasoningEffect(MobEffects.ENDERSTEP, minutesToTicks(1.5f)),
                new SeasoningEffect(MobEffects.ENDERSTEP_UNSTABLE, secondsToTicks(8))); // unstable only ticks every 10
        quickAdd(Items.POPPED_CHORUS_FRUIT, MobEffects.ENDERSTEP, minutesToTicks(2));

        // just bad... but with iron stomach?
        quickAdd(Items.ROTTEN_FLESH, new SeasoningEffect(MobEffects.AFFLICTION, secondsToTicks(30)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.DARKNESS, secondsToTicks(10)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(30)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.SATURATION, 2));
        quickAdd(Items.DRAGON_BREATH, new SeasoningEffect(MobEffects.SATED, minutesToTicks(8)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.INSTANT_DAMAGE, secondsToTicks(8)),
                new SeasoningEffect(MobEffects.VIGOR, minutesToTicks(8)));
        quickAdd(Items.SPIDER_EYE, new SeasoningEffect(MobEffects.AFFLICTION, secondsToTicks(30)),
                new SeasoningEffect(MobEffects.RECKLESS, minutesToTicks(2)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(10)));
        quickAdd(Items.POISONOUS_POTATO, new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(20)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.SATURATION, 2),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.NAUSEA, secondsToTicks(20)),
                new SeasoningEffect(MobEffects.SATED, secondsToTicks(20)));
        quickAdd(Items.FLINT, new SeasoningEffect(MobEffects.BRITTLE, minutesToTicks(6)),
                new SeasoningEffect(MobEffects.HEAVY, minutesToTicks(6)),
                new SeasoningEffect(MobEffects.SATED, minutesToTicks(6)),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.SATURATION, 1),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.INSTANT_DAMAGE, secondsToTicks(3)));
    }

    private void quickAdd(TagKey<Item> tag, Holder<MobEffect> effect, int duration) {
        quickAdd(tag, effect, duration, 0);
    }

    private void quickAdd(TagKey<Item> tag, Holder<MobEffect> effect, int duration, int amplifier) {
        this.builder(DataMaps.SEASONINGS).add(tag,
                Seasoning.from(new MobEffectInstance(effect, duration, amplifier)), false);
    }

    private void quickAdd(Item item, SeasoningEffect... effects) {
        this.builder(DataMaps.SEASONINGS).add(key(item), new Seasoning(
                Arrays.stream(effects).map(SeasoningEffect::toInstance).toList()), false);
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

    private record SeasoningEffect(Holder<MobEffect> effect, int duration, int amplifier) {
        SeasoningEffect(Holder<MobEffect> effect, int duration) {
            this(effect, duration, 0);
        }

        MobEffectInstance toInstance() {
            return new MobEffectInstance(effect, duration, amplifier);
        }
    }
}