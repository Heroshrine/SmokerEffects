package com.heroshrine.smokereffects.client.gui.tooltip;

import com.heroshrine.smokereffects.world.inventory.tooltip.SeasoningTooltip;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NullMarked;

import java.util.List;

import static com.heroshrine.smokereffects.world.item.SeasoningPouch.MAX_SEASONINGS;

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
        extractItems(graphics, items, x, y, 1, false);
    }

    public static void extractItems(GuiGraphicsExtractor graphics, List<ItemStack> items, float x, float y, float scale,
                                    boolean centered) {
        var pose = graphics.pose();
        var step = Math.round(16 * scale) + 2;
        if (centered) {
            float max_width = (MAX_SEASONINGS * step);
            x += (max_width / MAX_SEASONINGS) * (1.5f - 0.5f * items.size());
        }

        for (var i = 0; i < items.size(); i++) {

            pose.pushMatrix();
            pose.translate(x + i * step, y);
            pose.scale(scale, scale);
            graphics.item(items.get(i), 0, 0);
            pose.popMatrix();
        }
    }
}