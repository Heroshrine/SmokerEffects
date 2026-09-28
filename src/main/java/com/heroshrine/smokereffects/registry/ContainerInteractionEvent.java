package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.network.protocol.ActiveSeasoningPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
public class ContainerInteractionEvent {

    @SubscribeEvent
    private static void onOpenSmoker(PlayerContainerEvent.Open event) {
        if (!(event.getContainer() instanceof SmokerMenu sm)) return;
        if (!(sm.container instanceof SmokerBlockEntity sb)) return;
        if (!(event.getEntity() instanceof ServerPlayer sp)) return;
        ActiveSeasoningPayload.sendToPlayer(sb, sp);
    }
}