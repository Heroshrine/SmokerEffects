package com.heroshrine.smokereffects.registry;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.world.item.crafting.SeasoningIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class IngredientTypes {
    public static final DeferredRegister<IngredientType<?>> INGREDIENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.INGREDIENT_TYPES, SmokerEffects.MOD_ID);

    public static final DeferredHolder<IngredientType<?>, IngredientType<SeasoningIngredient>> SEASONING =
            INGREDIENT_TYPES.register("seasoning", () -> new IngredientType<>(SeasoningIngredient.CODEC));
}