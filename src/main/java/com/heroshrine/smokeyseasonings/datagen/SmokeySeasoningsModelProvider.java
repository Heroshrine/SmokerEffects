package com.heroshrine.smokeyseasonings.datagen;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.registry.Items;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SmokeySeasoningsModelProvider extends ModelProvider {
    public SmokeySeasoningsModelProvider(PackOutput output) {
        super(output, SmokeySeasonings.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(Items.SEASONING_POUCH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(Items.SEASONING_POUCH_EMPTY.get(), ModelTemplates.FLAT_ITEM);
    }
}