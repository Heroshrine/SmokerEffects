package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class Attachments {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, SmokeySeasonings.MOD_ID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<ItemContainerContents>> ACTIVE_SEASONING =
            ATTACHMENT_TYPES.register("active_seasoning", () -> AttachmentType
                    .builder(() -> ItemContainerContents.EMPTY)
                    .serialize(ItemContainerContents.CODEC.fieldOf("contents"), c ->
                            !c.equals(ItemContainerContents.EMPTY))
                    .build());

}