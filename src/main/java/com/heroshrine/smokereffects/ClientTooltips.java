package com.heroshrine.smokereffects;

import com.heroshrine.smokereffects.registry.Items;
import com.heroshrine.smokereffects.registry.Tabs;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID, value = Dist.CLIENT)
public class ClientTooltips {
    @SubscribeEvent
    private static void onItemTooltip(ItemTooltipEvent event) {
        if (!(Minecraft.getInstance().screen instanceof CreativeModeInventoryScreen))
            return;
        if (!event.getItemStack().is(Items.SMOKING_POUCH_SMOKING.get()))
            return;

        var lines = event.getToolTip();
        if (!lines.isEmpty())
            lines.add(1, Tabs.DEFAULT.get().getDisplayName().copy().withStyle(ChatFormatting.BLUE));
    }
}