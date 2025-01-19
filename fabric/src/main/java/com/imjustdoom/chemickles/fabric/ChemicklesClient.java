package com.imjustdoom.chemickles.fabric;

import com.imjustdoom.chemickles.block.screen.JarScreen;
import com.imjustdoom.chemickles.block.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class ChemicklesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModScreenHandlers.PICKLE_JAR_MENU.get(), JarScreen::new);
    }
}
