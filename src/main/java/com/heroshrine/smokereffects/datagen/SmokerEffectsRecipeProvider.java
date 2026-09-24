package com.heroshrine.smokereffects.datagen;

import com.heroshrine.smokereffects.registry.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class SmokerEffectsRecipeProvider extends RecipeProvider {
    protected SmokerEffectsRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, Items.SMOKING_POUCH)
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('X', net.minecraft.world.item.Items.WHEAT)
                .define('#', ItemTags.COALS)
                .unlockedBy("has_wheat", this.has(net.minecraft.world.item.Items.WHEAT))
                .unlockedBy("has_coal", this.has(ItemTags.COALS))
                .save(this.output);
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