package com.heroshrine.smokereffects;

import com.heroshrine.smokereffects.registry.IngredientTypes;
import com.heroshrine.smokereffects.registry.Items;
import com.heroshrine.smokereffects.registry.RecipeSerializers;
import com.heroshrine.smokereffects.registry.Tabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(SmokerEffects.MOD_ID)
public class SmokerEffects {
    public static final String MOD_ID = "smokereffects";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SmokerEffects(IEventBus modEventBus, ModContainer modContainer) {
        Items.ITEMS_HIDDEN.register(modEventBus);
        Items.ITEMS.register(modEventBus);
        IngredientTypes.INGREDIENT_TYPES.register(modEventBus);
        RecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        Tabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    public static int secondsToTicks(int seconds) {
        return seconds * 20;
    }
}