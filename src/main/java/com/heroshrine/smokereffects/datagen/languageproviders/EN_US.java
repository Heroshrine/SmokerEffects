package com.heroshrine.smokereffects.datagen.languageproviders;

import com.heroshrine.smokereffects.SmokerEffects;
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
    }
}