package com.heroshrine.smokeyseasonings.mixin;

import com.heroshrine.smokeyseasonings.SmokeySeasonings;
import com.heroshrine.smokeyseasonings.registry.MobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightmapRenderStateExtractor;
import net.minecraft.client.renderer.state.LightmapRenderState;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapRenderStateExtractor.class)
public class LightmapRenderStateExtractorMixin {
    @Unique
    private static final float smokeyseasonings$KEEN_EYES_INTENSITY = 0.35f;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "extract", at = @At("TAIL"))
    private void smokeyseasonings$applyKeenEyes(LightmapRenderState renderState, float partialTicks, CallbackInfo callback) {
        LocalPlayer player = minecraft.player;
        if (!renderState.needsUpdate || minecraft.level == null || player == null)
            return;

        var effect = player.getEffect(MobEffects.KEEN_EYES);
        if (effect == null)
            return;

        var timeLeft = effect.getDuration();
        var multiplier = 1f;
        if (timeLeft <= SmokeySeasonings.secondsToTicks(10))
            multiplier = Mth.cos((Mth.PI * timeLeft) / 10f) / 2f + 0.5f;

        renderState.nightVisionEffectIntensity = Math.max(renderState.nightVisionEffectIntensity,
                smokeyseasonings$KEEN_EYES_INTENSITY * multiplier * player.getEffectBlendFactor(MobEffects.KEEN_EYES, partialTicks));
    }
}