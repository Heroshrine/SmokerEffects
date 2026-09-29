package com.heroshrine.smokeyseasonings.registry;

import com.heroshrine.smokeyseasonings.world.item.crafting.FilledSeasoningPouchRecipe;
import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, SmokeySeasonings.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FilledSeasoningPouchRecipe>> FILLED_SEASONING_POUCH =
            RECIPE_SERIALIZERS.register("filled_seasoning_pouch", () -> FilledSeasoningPouchRecipe.SERIALIZER);
}