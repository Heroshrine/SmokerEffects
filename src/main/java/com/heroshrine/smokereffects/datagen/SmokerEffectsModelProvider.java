package com.heroshrine.smokereffects.datagen;

import com.heroshrine.smokereffects.SmokerEffects;
import com.heroshrine.smokereffects.registry.Items;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SmokerEffectsModelProvider extends ModelProvider {
    public SmokerEffectsModelProvider(PackOutput output) {
        super(output, SmokerEffects.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(Items.SEASONING_POUCH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.SEASONING_POUCH_EMPTY.get(), Items.SEASONING_POUCH.get(), ModelTemplates.FLAT_ITEM);
    }
}