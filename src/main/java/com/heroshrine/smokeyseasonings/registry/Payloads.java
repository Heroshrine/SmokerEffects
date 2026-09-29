package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.network.handling.ActiveSeasoningHandler;
import com.heroshrine.smokeyseasonings.network.protocol.ActiveSeasoningPayload;
import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = SmokeySeasonings.MOD_ID)
public class Payloads {

    private static final String VERSION = "1";

    @SubscribeEvent
    private static void registerPayloads(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(VERSION);

        registrar.playToClient(
                ActiveSeasoningPayload.TYPE,
                ActiveSeasoningPayload.STREAM_CODEC,
                ActiveSeasoningHandler::handleData
        );
    }
}