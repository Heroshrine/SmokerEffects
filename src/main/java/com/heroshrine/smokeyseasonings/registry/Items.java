package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.world.item.SeasoningPouch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static final DeferredRegister.Items ITEMS_HIDDEN = DeferredRegister.createItems(SmokeySeasonings.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SmokeySeasonings.MOD_ID);

    public static final DeferredItem<Item> SEASONING_POUCH_EMPTY = ITEMS.registerItem("seasoning_pouch_empty",
            SeasoningPouch::new,
            props -> props
                    .stacksTo(16));

    public static final DeferredItem<SeasoningPouch> SEASONING_POUCH = ITEMS.registerItem("seasoning_pouch",
            SeasoningPouch::new,
            props -> props
                    .stacksTo(16)
                    .component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                    .component(DataComponents.TOOLTIP_DISPLAY,
                            TooltipDisplay.DEFAULT.withHidden(DataComponents.CONTAINER, true)));
}