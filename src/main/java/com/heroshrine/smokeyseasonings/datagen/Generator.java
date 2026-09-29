package com.heroshrine.smokeyseasonings.datagen;

import com.heroshrine.smokeyseasonings.datagen.languageproviders.EN_US;
import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = SmokeySeasonings.MOD_ID)
public final class Generator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

        event.createProvider(SmokeySeasoningsModelProvider::new);
        event.createProvider(SmokeySeasoningsRecipeProvider.Runner::new);
        event.createProvider(SmokeySeasoningsDataMapProvider::new);
        event.createProvider(EN_US::new);
    }
}