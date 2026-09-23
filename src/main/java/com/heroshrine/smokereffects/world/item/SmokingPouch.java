package com.heroshrine.smokereffects.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import static com.heroshrine.smokereffects.world.item.SmokingSmokingPouch.BURN_TIME;

@NullMarked
public class SmokingPouch extends Item {
    public SmokingPouch(Properties properties) {
        super(properties);
    }

    public static final int MAX_STACK = 4;

    //TODO: only if has component
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return recipeType == RecipeType.SMOKING ? BURN_TIME : 0;
    }

    //TODO: if no component, default. Else, 1.
    @Override
    public int getMaxStackSize(ItemStack stack) {
        return super.getMaxStackSize(stack);
    }

    //TODO: return separate item that has durability
    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {
        if (!(instance instanceof ItemStack stack))
            return null;

        var used = SmokingSmokingPouch.fromSmokingPouch(stack);
        used.setDamageValue(used.getDamageValue() + 1);
        return used.getDamageValue() >= used.getMaxDamage() ? null : ItemStackTemplate.fromNonEmptyStack(used);
    }
}