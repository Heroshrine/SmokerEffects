package com.heroshrine.smokereffects.network.handling;

import com.heroshrine.smokereffects.network.protocol.ActiveSeasoningPayload;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class ActiveSeasoningHandler {

    public static class ClientSeasoningCache {
        private static ItemContainerContents current = ItemContainerContents.EMPTY;

        public static ItemContainerContents current() {
            return current;
        }
    }

    // not sure if it's necessary to assign field on main thread or not, but just in case
    // because threading is scary
    public static void handleData(final ActiveSeasoningPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> ClientSeasoningCache.current = payload.contents());
    }
}