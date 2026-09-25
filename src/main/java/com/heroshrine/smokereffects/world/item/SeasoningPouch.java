package com.heroshrine.smokereffects.world.item;

import com.heroshrine.smokereffects.world.inventory.tooltip.SeasoningTooltip;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

// Decision was made to remove the 'smoking'/'used' smoking pouch (seasoning pouch),
// to let smoking pouches with same ingredients stack, and
// to show on the smoker UI what the current effects are.

@NullMarked
public class SeasoningPouch extends Item {
    public SeasoningPouch(Properties properties) {
        super(properties);
    }

    public static final int BURN_TIME = 2000;

    //TODO: test if this works
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        var container = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        if (container.equals(ItemContainerContents.EMPTY))
            return 0;

        return recipeType == RecipeType.SMOKING ? BURN_TIME : 0;
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        var contents = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        return contents.equals(ItemContainerContents.EMPTY)
                ? Optional.empty()
                : Optional.of(new SeasoningTooltip(contents));
    }
}