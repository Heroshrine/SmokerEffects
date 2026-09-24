package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.item.SmokingPouch;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static final DeferredRegister.Items ITEMS_HIDDEN = DeferredRegister.createItems(SmokerEffects.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SmokerEffects.MOD_ID);

    public static final DeferredItem<SmokingPouch> SMOKING_POUCH = ITEMS.registerItem("smoking_pouch",
            SmokingPouch::new,
            props -> props
                    .stacksTo(16));
}