package com.imjustdoom.chemickles.fabric;

import com.imjustdoom.chemickles.Chemickles;
import net.fabricmc.api.ModInitializer;

public class ChemicklesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Chemickles.init();
    }

//    public static void setRenderLayer(Block block) {
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.class());
//    }
}
