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
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.heroshrine.smokeyseasonings.SmokeySeasonings.secondsToTicks;
import static com.heroshrine.smokeyseasonings.SmokeySeasonings.minutesToTicks;

@NullMarked
public class SmokeySeasoningsDataMapProvider extends DataMapProvider {
    protected SmokeySeasoningsDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    private static final int VERY_BRIEF = secondsToTicks(30);
    private static final int BRIEF = minutesToTicks(2);
    private static final int AVERAGE = minutesToTicks(3);
    private static final int LONG = minutesToTicks(5);
    private static final int VERY_LONG = minutesToTicks(7);

    //TODO: conditional entry API using item IDs
    @Override
    protected void gather(HolderLookup.Provider provider) {
        quickAdd(ItemTags.EGGS, MobEffects.HEARTY, BRIEF); // + 1 heart
        quickAdd(Items.SNIFFER_EGG, MobEffects.HEARTY, LONG, 1); // + 2 hearts

        quickAdd(Items.BEETROOT, MobEffects.MIGHT, BRIEF); // + 1 attack
        quickAdd(Items.NAUTILUS_SHELL, MobEffects.MIGHT, LONG, 1); // + 2 attack

        quickAdd(Items.COCOA_BEANS, MobEffects.FERVOR, BRIEF); // mine speed
        quickAdd(Items.BEETROOT_SEEDS, MobEffects.FERVOR, BRIEF);
        quickAdd(Items.TORCHFLOWER_SEEDS, MobEffects.FERVOR, LONG, 1);

        quickAdd(Items.SUGAR_CANE, MobEffects.BRISK, BRIEF); // run speed
        quickAdd(Items.BREEZE_ROD, MobEffects.BRISK, AVERAGE, 1);

        quickAdd(Items.ARMADILLO_SCUTE, new SeasoningEffect(MobEffects.HARDENED, AVERAGE), // armor + toughness
                new SeasoningEffect(MobEffects.STEADFAST, AVERAGE));
        quickAdd(Items.TURTLE_SCUTE, new SeasoningEffect(MobEffects.HARDENED, AVERAGE),
                new SeasoningEffect(MobEffects.AQUANE, BRIEF));
        quickAdd(Items.SHULKER_SHELL, new SeasoningEffect(MobEffects.HARDENED, VERY_LONG),
                new SeasoningEffect(MobEffects.STEADFAST, LONG, 1));

        quickAdd(Items.KELP, MobEffects.BREATH, AVERAGE); // extra breath bubbles
        quickAdd(Items.PUFFERFISH, new SeasoningEffect(MobEffects.BREATH, LONG, 1),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(8)));

        quickAdd(Items.INK_SAC, MobEffects.AQUANE, BRIEF); // water efficiency
        quickAdd(Items.PRISMARINE_CRYSTALS, MobEffects.AQUANE, LONG, 1);
        quickAdd(Items.GLOW_INK_SAC, new SeasoningEffect(MobEffects.AQUANE, BRIEF),
                new SeasoningEffect(MobEffects.KEEN_EYES, BRIEF),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.GLOWING, VERY_BRIEF));

        quickAdd(Items.PINK_PETALS, MobEffects.FEATHERWEIGHT, BRIEF); // less gravity and higher safe fall distance
        quickAdd(Items.PHANTOM_MEMBRANE, MobEffects.FEATHERWEIGHT, AVERAGE, 1);

        quickAdd(Items.TWISTING_VINES, MobEffects.SURE_FOOTED, AVERAGE); // higher step height
        quickAdd(Items.RABBIT_FOOT, new SeasoningEffect(MobEffects.SURE_FOOTED, LONG),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.LUCK, AVERAGE));

        quickAdd(Items.BAMBOO, MobEffects.LONG_REACH, BRIEF); // +1 extended block/entity interaction range
        quickAdd(Items.PITCHER_POD, MobEffects.LONG_REACH, VERY_LONG);

        quickAdd(Items.CACTUS_FLOWER, new SeasoningEffect(MobEffects.HEAT_TOLERANCE, BRIEF),
                new SeasoningEffect(MobEffects.SATED, BRIEF));
        quickAdd(Items.WARPED_FUNGUS, MobEffects.HEAT_TOLERANCE, AVERAGE);
        quickAdd(Items.MAGMA_CREAM, MobEffects.HEAT_TOLERANCE, AVERAGE, 1);

        quickAdd(Items.ENDER_EYE, MobEffects.ENDERSTEP, BRIEF); // enderstep
        quickAdd(Items.POPPED_CHORUS_FRUIT, MobEffects.ENDERSTEP, AVERAGE);

        quickAdd(Items.CHARCOAL, MobEffects.IRON_STOMACH, VERY_BRIEF); //iron stomach
        quickAdd(Items.HONEYCOMB, MobEffects.IRON_STOMACH, BRIEF);

        quickAdd(Items.GLOW_BERRIES, new SeasoningEffect(MobEffects.KEEN_EYES, AVERAGE), // weak night vision
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.GLOWING, VERY_BRIEF));
        quickAdd(Items.GLOWSTONE_DUST, new SeasoningEffect(MobEffects.KEEN_EYES, LONG),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.GLOWING, AVERAGE));
        quickAdd(Items.GOLDEN_CARROT, MobEffects.KEEN_EYES, VERY_LONG);

        quickAdd(Items.SWEET_BERRIES, MobEffects.VIGOR, BRIEF); // weak regeneration
        quickAdd(Items.RESIN_CLUMP, MobEffects.VIGOR, AVERAGE);
        quickAdd(Items.GLISTERING_MELON_SLICE, MobEffects.VIGOR, LONG);
        quickAdd(Items.GHAST_TEAR, MobEffects.VIGOR, AVERAGE, 1);

        quickAdd(Items.BROWN_MUSHROOM, MobEffects.SATED, BRIEF); // slower hunger drain... or technically saturation regeneration but very slow
        quickAdd(Items.GOLDEN_DANDELION, MobEffects.SATED, AVERAGE);

        quickAdd(Items.IRON_NUGGET, MobEffects.HEAVY, BRIEF); // 'heavy'
        quickAdd(Items.COPPER_NUGGET, MobEffects.HEAVY, AVERAGE);
        quickAdd(Items.GOLD_NUGGET, MobEffects.HEAVY, AVERAGE, 1);

        quickAdd(Items.RED_MUSHROOM, MobEffects.RECKLESS, VERY_BRIEF); // +2 atk, -4 def
        quickAdd(Items.CRIMSON_ROOTS, MobEffects.RECKLESS, AVERAGE); // +2 atk, -4 def
        quickAdd(Items.CRIMSON_FUNGUS, MobEffects.RECKLESS, AVERAGE, 1); // +4 atk, -8 def

        quickAdd(Items.ENDER_PEARL, MobEffects.ENDERSTEP_UNSTABLE, BRIEF + 3); // unstable enderstep
        quickAdd(Items.CHORUS_FRUIT, MobEffects.ENDERSTEP_UNSTABLE, AVERAGE);

        // unfocused

        quickAdd(Items.FIREFLY_BUSH, new SeasoningEffect(MobEffects.FEATHERWEIGHT, BRIEF),
                new SeasoningEffect(MobEffects.BREATH, BRIEF));
        quickAdd(Items.OPEN_EYEBLOSSOM, new SeasoningEffect(MobEffects.HEARTY, AVERAGE, 1),
                new SeasoningEffect(MobEffects.MIGHT, AVERAGE),
                new SeasoningEffect(MobEffects.AFFLICTION, LONG));
        quickAdd(Items.CLOSED_EYEBLOSSOM, new SeasoningEffect(MobEffects.HEARTY, BRIEF),
                new SeasoningEffect(MobEffects.MIGHT, BRIEF));

        quickAdd(Items.DRAGON_BREATH, new SeasoningEffect(MobEffects.VIGOR, VERY_LONG, 1),
                new SeasoningEffect(MobEffects.SATED, VERY_LONG),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.INSTANT_DAMAGE, 1));

        quickAdd(Items.ROTTEN_FLESH, new SeasoningEffect(MobEffects.AFFLICTION, AVERAGE),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.SATURATION, 2));
        quickAdd(Items.SPIDER_EYE, new SeasoningEffect(MobEffects.KEEN_EYES, AVERAGE),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(6)));
        quickAdd(Items.POISONOUS_POTATO, new SeasoningEffect(MobEffects.SATED, BRIEF),
                new SeasoningEffect(MobEffects.HEARTY, BRIEF),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.POISON, secondsToTicks(6)));
        quickAdd(Items.FLINT, new SeasoningEffect(MobEffects.BRITTLE, BRIEF),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.INSTANT_DAMAGE, 10),
                new SeasoningEffect(MobEffects.HEARTY, BRIEF),
                new SeasoningEffect(MobEffects.SATED, AVERAGE));

        // bad things

        quickAdd(Items.WITHER_ROSE, net.minecraft.world.effect.MobEffects.WITHER, AVERAGE);
        quickAdd(Items.PALE_OAK_SAPLING, net.minecraft.world.effect.MobEffects.INFESTED, AVERAGE);
        quickAdd(Items.FERMENTED_SPIDER_EYE, new SeasoningEffect(MobEffects.SLUGGISH, VERY_BRIEF),
                new SeasoningEffect(net.minecraft.world.effect.MobEffects.HUNGER, VERY_BRIEF));
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