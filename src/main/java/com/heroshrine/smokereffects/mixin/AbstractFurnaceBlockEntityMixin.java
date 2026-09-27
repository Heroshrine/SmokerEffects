package com.heroshrine.smokereffects.mixin;

import com.heroshrine.smokereffects.network.protocol.ActiveSeasoningPayload;
import com.heroshrine.smokereffects.registry.Attachments;
import com.heroshrine.smokereffects.registry.Components;
import com.heroshrine.smokereffects.world.item.SeasoningPouch;
import com.heroshrine.smokereffects.world.item.component.SeasonedFood;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "serverTick", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/entity/AbstractFurnaceBlockEntity;consumeFuel(Lnet/minecraft/core/NonNullList;Lnet/minecraft/world/item/ItemStack;)V"))
    private static void smokereffects$captureSeasoning(ServerLevel level, BlockPos pos, BlockState state,
                                                       AbstractFurnaceBlockEntity entity, CallbackInfo callback,
                                                       @Local(name = "fuel") ItemStack fuel) {
        if (!(entity instanceof SmokerBlockEntity be)) return;
        be.setData(Attachments.ACTIVE_SEASONING, fuel.getItem() instanceof SeasoningPouch
                ? fuel.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                : ItemContainerContents.EMPTY);
        ActiveSeasoningPayload.sendToViewers(be);
    }

    @ModifyExpressionValue(method = "serverTick", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/item/crafting/AbstractCookingRecipe;assemble(Lnet/minecraft/world/item/crafting/SingleRecipeInput;)Lnet/minecraft/world/item/ItemStack;"))

    private static ItemStack smokereffects$seasonResult(ItemStack result,
                                                        @Local(argsOnly = true, name = "entity") AbstractFurnaceBlockEntity entity) {
        if (!(entity instanceof SmokerBlockEntity be) || !result.has(DataComponents.CONSUMABLE))
            return result;

        var seasoning = be.getData(Attachments.ACTIVE_SEASONING);
        if (seasoning.equals(ItemContainerContents.EMPTY))
            return result;

        var seasoned = result.copy();
        seasoned.set(Components.SEASONED_FOOD, SeasonedFood.from(seasoning));
        return seasoned;
    }
}