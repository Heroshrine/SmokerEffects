package com.heroshrine.smokeyseasonings.world.item.crafting;

import com.heroshrine.smokeyseasonings.registry.DataMaps;
import com.heroshrine.smokeyseasonings.world.item.SeasoningPouch;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.ShapelessCraftingRecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@NullMarked
public class FilledSeasoningPouchRecipe extends NormalCraftingRecipe {
    public FilledSeasoningPouchRecipe(CommonInfo commonInfo, CraftingBookInfo bookInfo, ItemStackTemplate result, List<Ingredient> ingredients) {
        super(commonInfo, bookInfo);
        this.result = result;
        this.ingredients = ingredients;
    }

    public static final MapCodec<FilledSeasoningPouchRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Recipe.CommonInfo.MAP_CODEC.forGetter(o -> o.commonInfo),
            CraftingRecipe.CraftingBookInfo.MAP_CODEC.forGetter(o -> o.bookInfo),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(o -> o.result),
            Ingredient.CODEC.listOf(1, 9).fieldOf("ingredients").forGetter(o -> o.ingredients)
    ).apply(i, FilledSeasoningPouchRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, FilledSeasoningPouchRecipe> STREAM_CODEC = StreamCodec.composite(
            Recipe.CommonInfo.STREAM_CODEC, o -> o.commonInfo,
            CraftingRecipe.CraftingBookInfo.STREAM_CODEC, o -> o.bookInfo,
            ItemStackTemplate.STREAM_CODEC, o -> o.result,
            Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list()), o -> o.ingredients,
            FilledSeasoningPouchRecipe::new);

    public static final RecipeSerializer<FilledSeasoningPouchRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    private final ItemStackTemplate result;
    private final List<Ingredient> ingredients;

    private static boolean isSeasoning(ItemStack stack) {
        return stack.typeHolder().getData(DataMaps.SEASONINGS) != null;
    }

    @Override
    public RecipeSerializer<FilledSeasoningPouchRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        for (ItemStack stack : craftingInput.items()) {
            if (stack.is(com.heroshrine.smokeyseasonings.registry.Items.SEASONING_POUCH.get())
                    && stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                    .allItemsCopyStream().count() + ingredients.size() - 1 > SeasoningPouch.MAX_SEASONINGS)
                return false;
        }

        return craftingInput.ingredientCount() == ingredients.size() &&
                craftingInput.stackedContents().canCraft(this, null);
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput) {
        ItemStack result = this.result.create();
        List<ItemStack> seasonings = new ArrayList<>();
        ItemStack pouch = null;
        for (var stack : craftingInput.items()) {
            if (stack.isEmpty()) continue;
            if (isSeasoning(stack)) seasonings.add(stack.copyWithCount(1));
            else if (stack.is(com.heroshrine.smokeyseasonings.registry.Items.SEASONING_POUCH.get()))
                pouch = stack; // look for a seasoning pouch here to get seasonings from it
        }

        if (pouch != null) {
            var contents = pouch.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
            contents.nonEmptyItemCopyStream().forEach(stack -> seasonings.add(stack.copyWithCount(1)));
        }

        seasonings.sort(Comparator.comparing(s -> s.typeHolder().getRegisteredName()));
        result.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(seasonings));
        return result;
    }

    @Override
    protected PlacementInfo createPlacementInfo() {
        return PlacementInfo.create(ingredients);
    }

    @Override
    public List<RecipeDisplay> display() { // without this, it won't show in the recipe book
        List<SlotDisplay> slots = new ArrayList<>(ingredients.size());
        var offset = 0;

        for (Ingredient ingredient : ingredients) {
            var display = ingredient.display();

            if (display instanceof SlotDisplay.Composite(List<SlotDisplay> contents) && contents.size() > 1) {
                List<SlotDisplay> rotated = new ArrayList<>(contents);
                Collections.rotate(rotated, -offset++);
                display = new SlotDisplay.Composite(rotated);
            }
            slots.add(display);
        }

        return List.of(new ShapelessCraftingRecipeDisplay(
                slots,
                new SlotDisplay.ItemStackSlotDisplay(result),
                new SlotDisplay.ItemSlotDisplay(Items.CRAFTING_TABLE)));
    }
}