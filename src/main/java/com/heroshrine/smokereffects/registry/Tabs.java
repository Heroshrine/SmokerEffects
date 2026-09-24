package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Tabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SmokerEffects.MOD_ID);

    public static final String TAB_NAME = "creativetab." + SmokerEffects.MOD_ID + ".default";
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEFAULT = CREATIVE_MODE_TABS.register(TAB_NAME, () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.SEASONING_POUCH.get()))
                    .title(Component.translatable(TAB_NAME))
                    .displayItems((parameters, output) ->
                            Items.ITEMS.getEntries().forEach(entry -> output.accept(entry.get())))
                    .build());
}