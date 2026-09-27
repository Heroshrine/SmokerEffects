package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.network.handling.ActiveSeasoningHandler;
import com.heroshrine.smokereffects.network.protocol.ActiveSeasoningPayload;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = SmokerEffects.MOD_ID)
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