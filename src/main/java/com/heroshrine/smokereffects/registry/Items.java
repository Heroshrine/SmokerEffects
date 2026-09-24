package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.item.SeasoningPouch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static final DeferredRegister.Items ITEMS_HIDDEN = DeferredRegister.createItems(SmokerEffects.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SmokerEffects.MOD_ID);

    public static final DeferredItem<SeasoningPouch> SEASONING_POUCH = ITEMS.registerItem("seasoning_pouch",
            SeasoningPouch::new,
            props -> props
                    .stacksTo(16)
                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
}