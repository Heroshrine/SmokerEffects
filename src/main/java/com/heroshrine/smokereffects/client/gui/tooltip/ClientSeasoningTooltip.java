package com.heroshrine.smokereffects.client.gui.tooltip;

import com.heroshrine.smokereffects.world.inventory.tooltip.SeasoningTooltip;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class ClientSeasoningTooltip implements ClientTooltipComponent {
    public ClientSeasoningTooltip(SeasoningTooltip tooltip) {
        items = tooltip.contents().nonEmptyItemCopyStream().toList();
    }

    public static final int SPACING = 18;
    public static final int HEIGHT = 18;

    private final List<ItemStack> items;

    @Override
    public int getHeight(Font font) {
        return HEIGHT;
    }

    @Override
    public int getWidth(Font font) {
        return items.size() * SPACING;
    }

    @Override
    public void extractImage(Font font, int x, int y, int w, int h, GuiGraphicsExtractor graphics) {
        extractItems(graphics, items, x, y);
    }

    public static void extractItems(GuiGraphicsExtractor graphics, List<ItemStack> items, int x, int y) {
        for (var i = 0; i < items.size(); i++) {
            graphics.item(items.get(i), x + i * SPACING, y);
        }
    }
}
