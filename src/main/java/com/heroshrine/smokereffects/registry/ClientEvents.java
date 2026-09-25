package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.client.gui.tooltip.ClientSeasoningTooltip;
import com.heroshrine.smokereffects.world.inventory.tooltip.SeasoningTooltip;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    static void registerTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(SeasoningTooltip.class, ClientSeasoningTooltip::new);
    }
}