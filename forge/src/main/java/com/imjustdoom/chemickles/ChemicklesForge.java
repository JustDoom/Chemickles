package com.imjustdoom.chemickles;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chemickles.MOD_ID)
public class ChemicklesForge {
    public ChemicklesForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Chemickles.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Chemickles.init();
    }

    public static void setRenderLayer(Block block) {
        RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
    }
}