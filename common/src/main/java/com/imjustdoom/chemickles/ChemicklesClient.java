package com.imjustdoom.chemickles;

import com.imjustdoom.chemickles.block.screen.JarScreen;
import com.imjustdoom.chemickles.block.screen.ModScreenHandlers;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.menu.MenuRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.level.block.Block;

public class ChemicklesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MenuRegistry.registerScreenFactory(ModScreenHandlers.JAR_MENU.get(), JarScreen::new);
//        setRenderLayer(BlockInit.CUCUMBER_CROP.get());
    }

    @ExpectPlatform
    public static void setRenderLayer(Block block) {
        throw new AssertionError();
    }
}