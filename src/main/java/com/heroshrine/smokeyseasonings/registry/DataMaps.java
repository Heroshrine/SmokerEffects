package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.world.food.Seasoning;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;
import org.jspecify.annotations.NullMarked;

@NullMarked
@EventBusSubscriber(modid = SmokeySeasonings.MOD_ID)
public class DataMaps {
    public static final DataMapType<Item, Seasoning> SEASONINGS = DataMapType.builder(
            Identifier.fromNamespaceAndPath(SmokeySeasonings.MOD_ID, "seasonings"),
            Registries.ITEM, Seasoning.CODEC
    ).synced(Seasoning.CODEC, false).build();

    @SubscribeEvent
    private static void registerDataMaps(RegisterDataMapTypesEvent event) {
        event.register(SEASONINGS);
    }
}
