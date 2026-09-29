package com.heroshrine.smokeyseasonings.network.protocol;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.registry.Attachments;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record ActiveSeasoningPayload(ItemContainerContents contents) implements CustomPacketPayload {
    public static final Type<ActiveSeasoningPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(SmokeySeasonings.MOD_ID, "active_seasoning"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ActiveSeasoningPayload> STREAM_CODEC =
            ItemContainerContents.STREAM_CODEC.map(ActiveSeasoningPayload::new, ActiveSeasoningPayload::contents);

    @Override
    public Type<ActiveSeasoningPayload> type() {
        return TYPE;
    }

    public static void sendToViewers(SmokerBlockEntity be) {
        var payload = new ActiveSeasoningPayload(be.getData(Attachments.ACTIVE_SEASONING));
        if (!(be.getLevel() instanceof ServerLevel serverLevel)) return;

        for (var player : serverLevel.players()) {
            if (player.containerMenu instanceof SmokerMenu menu && menu.container == be)
                PacketDistributor.sendToPlayer(player, payload);
        }
    }

    public static void sendToPlayer(SmokerBlockEntity be, ServerPlayer player) {
        var payload = new ActiveSeasoningPayload(be.getData(Attachments.ACTIVE_SEASONING));
        PacketDistributor.sendToPlayer(player, payload);
    }
}