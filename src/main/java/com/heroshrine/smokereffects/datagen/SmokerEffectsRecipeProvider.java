package com.heroshrine.smokereffects.datagen;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.registry.Items;
import com.heroshrine.smokereffects.world.item.crafting.FilledSeasoningPouchRecipe;
import com.heroshrine.smokereffects.world.item.crafting.SeasoningIngredient;
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
public class SmokerEffectsRecipeProvider extends RecipeProvider {
    protected SmokerEffectsRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
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
            ingredients.add(Ingredient.of(Items.SEASONING_POUCH_EMPTY));
            for (int i = 0; i < count; i++)
                ingredients.add(SeasoningIngredient.of());

            ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE,
                    Identifier.fromNamespaceAndPath(SmokerEffects.MOD_ID, "filled_seasoning_pouch_" + count));

            RecipeUnlockAdvancementBuilder unlock = new RecipeUnlockAdvancementBuilder();
            unlock.unlockedBy("has_seasoning_pouch", this.has(Items.SEASONING_POUCH));

            this.output.accept(key, new FilledSeasoningPouchRecipe(
                    RecipeBuilder.createCraftingCommonInfo(true),
                    RecipeBuilder.createCraftingBookInfo(RecipeCategory.FOOD, "filled_seasoning_pouch"),
                    new ItemStackTemplate(Items.SEASONING_POUCH.asItem()),
                    ingredients
            ), unlock.build(this.output, key, RecipeCategory.FOOD));
        }
    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new SmokerEffectsRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return SmokerEffectsRecipeProvider.class.getSimpleName();
        }
    }
}