package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.item.component.SeasonedFood;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Components {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, SmokerEffects.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SeasonedFood>> SEASONED_FOOD =
            DATA_COMPONENTS.registerComponentType("seasoned", b -> b
                    .persistent(SeasonedFood.CODEC)
                    .networkSynchronized(SeasonedFood.STREAM_CODEC));
}
