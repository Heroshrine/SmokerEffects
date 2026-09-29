package com.heroshrine.smokeyseasonings;

import com.heroshrine.smokeyseasonings.registry.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(SmokeySeasonings.MOD_ID)
public class SmokeySeasonings {
    public static final String MOD_ID = "smokeyseasonings";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SmokeySeasonings(IEventBus modEventBus, ModContainer modContainer) {
        Items.ITEMS_HIDDEN.register(modEventBus);
        Items.ITEMS.register(modEventBus);
        IngredientTypes.INGREDIENT_TYPES.register(modEventBus);
        RecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        Components.DATA_COMPONENTS.register(modEventBus);
        Attachments.ATTACHMENT_TYPES.register(modEventBus);
        MobEffects.MOB_EFFECT.register(modEventBus);
        Tabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static int secondsToTicks(float seconds) {
        return Math.round(seconds * 20);
    }

    public static int minutesToTicks(float minutes) {
        return Math.round(minutes * 1200);
    }
}