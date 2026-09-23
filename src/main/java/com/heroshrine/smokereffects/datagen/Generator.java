package com.heroshrine.smokereffects.datagen;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.datagen.languageproviders.EN_US;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public final class Generator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

        event.createProvider(SmokerEffectsModelProvider::new);
        event.createProvider(EN_US::new);

        event.createProvider(SmokerEffectsRecipeProvider.Runner::new);
    }
}