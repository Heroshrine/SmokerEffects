package com.heroshrine.smokereffects.world.inventory.tooltip;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.component.ItemContainerContents;

public record SeasoningTooltip(ItemContainerContents contents) implements TooltipComponent {
}