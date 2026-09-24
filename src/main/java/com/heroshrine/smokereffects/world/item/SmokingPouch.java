package com.heroshrine.smokereffects.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// Decision was made to remove the 'smoking'/'used' smoking pouch,
// to let smoking pouches with same ingredients stack, and
// to show on the smoker UI what the current effects are.

@NullMarked
public class SmokingPouch extends Item {
    public SmokingPouch(Properties properties) {
        super(properties);
    }

    public static final int MAX_STACK = 4;
    public static final int BURN_TIME = 2000;

    //TODO: only if has component
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return recipeType == RecipeType.SMOKING ? BURN_TIME : 0;
    }

    //TODO: verify this can be removed once components added
    @Override
    public int getMaxStackSize(ItemStack stack) {
        return super.getMaxStackSize(stack);
    }
}