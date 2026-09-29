package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.network.protocol.ActiveSeasoningPayload;
import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;

@EventBusSubscriber(modid = SmokeySeasonings.MOD_ID)
public class ContainerInteractionEvent {

    @SubscribeEvent
    private static void onOpenSmoker(PlayerContainerEvent.Open event) {
        if (!(event.getContainer() instanceof SmokerMenu sm)) return;
        if (!(sm.container instanceof SmokerBlockEntity sb)) return;
        if (!(event.getEntity() instanceof ServerPlayer sp)) return;
        ActiveSeasoningPayload.sendToPlayer(sb, sp);
    }
}