package com.heroshrine.smokereffects.datagen.languageproviders;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.registry.MobEffects;
import com.heroshrine.smokereffects.registry.Items;
import com.heroshrine.smokereffects.registry.Tabs;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EN_US extends LanguageProvider {
    public EN_US(PackOutput output) {
        super(output, SmokerEffects.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(Items.SEASONING_POUCH, "Seasoning Pouch");
        addItem(Items.SEASONING_POUCH_EMPTY, "Empty Seasoning Pouch");

        add(Tabs.TAB_NAME, "Smoker Effects");

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
        add(MobEffects.IRON_STOMACH.get(), "Iron Stomach");
        add(MobEffects.KEEN_EYES.get(), "Keen Eyes");
        add(MobEffects.VIGOR.get(), "Vigor");
        add(MobEffects.SATED.get(), "Sated");
        add(MobEffects.ENDERSTEP_UNSTABLE.get(), "Unstable Enderstep");
        add(MobEffects.AFFLICTION.get(), "Affliction");
    }
}