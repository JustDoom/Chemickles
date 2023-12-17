package com.imjustdoom.chemickles;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.level.block.Block;

public class ChemicklesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Chemickles.init();
    }

//    public static void setRenderLayer(Block block) {
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.class());
//    }
}
