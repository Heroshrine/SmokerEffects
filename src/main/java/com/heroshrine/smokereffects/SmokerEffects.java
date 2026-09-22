package com.heroshrine.smokereffects;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(SmokerEffects.MODID)
public class SmokerEffects {
    public static final String MODID = "smokereffects";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SmokerEffects(IEventBus modEventBus, ModContainer modContainer) {
    }
}