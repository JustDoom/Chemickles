package com.imjustdoom.chemickles.platform;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public RegistryWrapper<Item> registerItem(String id, Supplier<Item> item) {
        return new FabricWrapper<>(Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Chemickles.MOD_ID, id), item.get()));
    }

    @Override
    public <T extends Block> RegistryWrapper<T> registerBlock(String id, Supplier<T> block) {
        return new FabricWrapper<>(Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Chemickles.MOD_ID, id), block.get()));
    }

    @Override
    public void registerTab(String id, CreativeModeTab tab) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Chemickles.MOD_ID, id), tab);
    }
}
