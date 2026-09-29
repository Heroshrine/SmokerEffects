package com.heroshrine.smokeyseasonings.datagen;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.registry.Items;
import com.heroshrine.smokeyseasonings.world.item.crafting.FilledSeasoningPouchRecipe;
import com.heroshrine.smokeyseasonings.world.item.crafting.SeasoningIngredient;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NullMarked;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@NullMarked
public class SmokeySeasoningsRecipeProvider extends RecipeProvider {
    protected SmokeySeasoningsRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, Items.SEASONING_POUCH_EMPTY)
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('X', net.minecraft.world.item.Items.WHEAT)
                .define('#', ItemTags.COALS)
                .unlockedBy("has_wheat", this.has(net.minecraft.world.item.Items.WHEAT))
                .unlockedBy("has_coal", this.has(ItemTags.COALS))
                .save(this.output);

        for (int count = 1; count <= 3; count++) {
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < count; i++)
                ingredients.add(SeasoningIngredient.of());

            ResourceKey<Recipe<?>> keyFilled = ResourceKey.create(Registries.RECIPE,
                    Identifier.fromNamespaceAndPath(SmokeySeasonings.MOD_ID, "filled_seasoning_pouch_" + count));
            ResourceKey<Recipe<?>> keyMixed = ResourceKey.create(Registries.RECIPE,
                    Identifier.fromNamespaceAndPath(SmokeySeasonings.MOD_ID, "mixed_seasoning_pouch_" + count));

            RecipeUnlockAdvancementBuilder unlock = new RecipeUnlockAdvancementBuilder();
            unlock.unlockedBy("has_seasoning_pouch", this.has(Items.SEASONING_POUCH_EMPTY));

            var filledList = new ArrayList<>(ingredients);
            filledList.add(Ingredient.of(Items.SEASONING_POUCH_EMPTY.get()));
            var mixedList = new ArrayList<>(ingredients);
            mixedList.add(Ingredient.of(Items.SEASONING_POUCH.get()));

            this.output.accept(keyFilled, new FilledSeasoningPouchRecipe(
                    RecipeBuilder.createCraftingCommonInfo(true),
                    RecipeBuilder.createCraftingBookInfo(RecipeCategory.FOOD, "filled_seasoning_pouch"),
                    new ItemStackTemplate(Items.SEASONING_POUCH.asItem()),
                    filledList
            ), unlock.build(this.output, keyFilled, RecipeCategory.FOOD));

            this.output.accept(keyMixed, new FilledSeasoningPouchRecipe(
                    RecipeBuilder.createCraftingCommonInfo(true),
                    RecipeBuilder.createCraftingBookInfo(RecipeCategory.FOOD, "filled_seasoning_pouch"),
                    new ItemStackTemplate(Items.SEASONING_POUCH.asItem()),
                    mixedList
            ), unlock.build(this.output, keyMixed, RecipeCategory.FOOD));
        }
    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new SmokeySeasoningsRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return SmokeySeasoningsRecipeProvider.class.getSimpleName();
        }
    }
}