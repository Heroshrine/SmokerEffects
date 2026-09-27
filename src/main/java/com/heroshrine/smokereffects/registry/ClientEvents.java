package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.client.gui.tooltip.ClientSeasoningTooltip;
import com.heroshrine.smokereffects.network.handling.ActiveSeasoningHandler;
import com.heroshrine.smokereffects.world.inventory.tooltip.SeasoningTooltip;
import com.heroshrine.smokereffects.world.item.component.SeasonedFood;
import net.minecraft.client.gui.screens.inventory.SmokerScreen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.RegisterTooltipAppendersEvent;

import java.util.List;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    private static void registerTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(SeasoningTooltip.class, ClientSeasoningTooltip::new);
    }

    @SubscribeEvent
    private static void registerTooltipAppenders(RegisterTooltipAppendersEvent event) {
        event.registerComponentAppenderAfter(Components.SEASONED_FOOD, DataComponents.POTION_CONTENTS,
                (stack, ctx, display, player, flag, lines) ->
                        stack.addToTooltip(Components.SEASONED_FOOD.get(), ctx, display, lines, flag));
    }

    @SubscribeEvent
    private static void renderSmokerSeasoning(ScreenEvent.Render.Foreground event) {
        if (!(event.getScreen() instanceof SmokerScreen screen)) return;
        var menu = screen.getMenu();
        if (!menu.isLit()) return;
        var contents = ActiveSeasoningHandler.ClientSeasoningCache.current(); // this should be our contents from the payload?
        List<ItemStack> seasonings = contents.nonEmptyItemCopyStream().toList();
        if (seasonings.isEmpty()) return;

        ClientSeasoningTooltip.extractItems(event.getGuiGraphics(), seasonings,
                screen.getLeftPos() + 104f, screen.getTopPos() + 57.5f, 0.75f, true);
    }
}