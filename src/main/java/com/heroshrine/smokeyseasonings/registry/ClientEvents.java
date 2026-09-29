package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.client.gui.tooltip.ClientSeasoningTooltip;
import com.heroshrine.smokeyseasonings.network.handling.ActiveSeasoningHandler;
import com.heroshrine.smokeyseasonings.world.inventory.tooltip.SeasoningTooltip;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.inventory.SmokerScreen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.RegisterTooltipAppendersEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = SmokeySeasonings.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    public static final String SEASONING_TOOLTIP_KEY = "smokeyseasonings";

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

    @SubscribeEvent
    private static void addSeasoningTooltip(ItemTooltipEvent event) {
        var seasoning = event.getItemStack().typeHolder().getData(DataMaps.SEASONINGS);
        if (seasoning == null) return;

        var lines = event.getToolTip();
        lines.add(Component.translatable(SEASONING_TOOLTIP_KEY).withStyle(ChatFormatting.GRAY));
    }
}