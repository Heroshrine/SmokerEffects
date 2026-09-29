package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.world.item.component.SeasonedFood;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Components {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, SmokeySeasonings.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SeasonedFood>> SEASONED_FOOD =
            DATA_COMPONENTS.registerComponentType("seasoned", b -> b
                    .persistent(SeasonedFood.CODEC)
                    .networkSynchronized(SeasonedFood.STREAM_CODEC));
}