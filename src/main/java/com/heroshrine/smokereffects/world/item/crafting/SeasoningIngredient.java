package com.heroshrine.smokereffects.world.item.crafting;

import com.heroshrine.smokereffects.registry.DataMaps;
import com.heroshrine.smokereffects.registry.IngredientTypes;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;

import java.util.stream.Stream;

public class SeasoningIngredient implements ICustomIngredient {
    public static final SeasoningIngredient INSTANCE = new SeasoningIngredient();
    public static final MapCodec<SeasoningIngredient> CODEC = MapCodec.unit(INSTANCE);

    private SeasoningIngredient() {
    }

    public static Ingredient of() {
        return INSTANCE.toVanilla();
    }

    @Override
    public boolean test(ItemStack stack) {
        return stack.typeHolder().getData(DataMaps.SEASONINGS) != null;
    }

    @Override
    public Stream<Holder<Item>> items() {
        return BuiltInRegistries.ITEM.listElements()
                .filter(h -> h.getData(DataMaps.SEASONINGS) != null)
                .map(h -> h);
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public IngredientType<?> getType() {
        return IngredientTypes.SEASONING.get();
    }
}
