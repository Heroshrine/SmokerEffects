package com.heroshrine.smokeyseasonings.datagen.languageproviders;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.registry.ClientEvents;
import com.heroshrine.smokeyseasonings.registry.MobEffects;
import com.heroshrine.smokeyseasonings.registry.Items;
import com.heroshrine.smokeyseasonings.registry.Tabs;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider {
    public EN_US(PackOutput output) {
        super(output, SmokeySeasonings.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(Items.SEASONING_POUCH, "Seasoning Pouch");
        addItem(Items.SEASONING_POUCH_EMPTY, "Empty Seasoning Pouch");
        add(ClientEvents.SEASONING_TOOLTIP_KEY, "Seasoning");

        add(Tabs.TAB_NAME, "Smokey Seasonings");

        add(MobEffects.BRISK.get(), "Brisk");
        add(MobEffects.HARDENED.get(), "Hardened");
        add(MobEffects.FERVOR.get(), "Fervor");
        add(MobEffects.MIGHT.get(), "Might");
        add(MobEffects.HEARTY.get(), "Hearty");
        add(MobEffects.STEADFAST.get(), "Steadfast");
        add(MobEffects.BREATH.get(), "Breath");
        add(MobEffects.AQUANE.get(), "Aquane");
        add(MobEffects.FEATHERWEIGHT.get(), "Featherweight");
        add(MobEffects.SURE_FOOTED.get(), "Sure Footed");
        add(MobEffects.LONG_REACH.get(), "Long Reach");
        add(MobEffects.HEAVY.get(), "Heavy");
        add(MobEffects.RECKLESS.get(), "Reckless");
        add(MobEffects.SLUGGISH.get(), "Sluggish");
        add(MobEffects.BRITTLE.get(), "Brittle");
        add(MobEffects.HEAT_TOLERANCE.get(), "Heat Tolerance");
        add(MobEffects.ENDERSTEP.get(), "Enderstep");
        add(MobEffects.ENDERSTEP_UNSTABLE.get(), "Unstable Enderstep");
        add(MobEffects.IRON_STOMACH.get(), "Iron Stomach");
        add(MobEffects.KEEN_EYES.get(), "Keen Eyes");
        add(MobEffects.VIGOR.get(), "Vigor");
        add(MobEffects.SATED.get(), "Sated");
        add(MobEffects.AFFLICTION.get(), "Affliction");
    }
}