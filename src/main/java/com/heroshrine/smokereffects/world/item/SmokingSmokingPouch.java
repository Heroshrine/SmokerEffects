package com.heroshrine.smokereffects.world.item;

import com.heroshrine.smokereffects.registry.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class SmokingSmokingPouch extends Item {
    public SmokingSmokingPouch(Properties properties) {
        super(properties);
    }

    public static final int MAX_DAMAGE = 4;
    public static final int BURN_TIME = 3200;

    public static ItemStack fromSmokingPouch(ItemStack smokingPouch) throws IllegalArgumentException {
        if (smokingPouch.getItem() != Items.SMOKING_POUCH.get())
            throw new IllegalArgumentException("ItemStack is not a smoking pouch");

        var used = new ItemStack(Items.SMOKING_POUCH_SMOKING.get());
        //TODO: copy components from smoking pouch item stack to used item
        return used;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return recipeType == RecipeType.SMOKING ? BURN_TIME : 0;
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {
        if (!(instance instanceof ItemStack stack))
            return null;

        var pouch = stack.copy();
        pouch.setDamageValue(pouch.getDamageValue() + 1);
        return pouch.getDamageValue() >= pouch.getMaxDamage() ? null : ItemStackTemplate.fromNonEmptyStack(pouch);
    }
}