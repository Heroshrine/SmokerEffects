package com.heroshrine.smokeyseasonings.world.effect;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class SeasoningMobEffect extends MobEffect {
    public SeasoningMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public SeasoningMobEffect withModifier(Holder<Attribute> attribute, String name, double amount,
                                           AttributeModifier.Operation operation) {
        addAttributeModifier(attribute, Identifier.fromNamespaceAndPath(SmokeySeasonings.MOD_ID, "effect." + name),
                amount, operation);
        return this;
    }
}