package com.imjustdoom.chemickles;

import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.ItemInit;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.fuel.FuelRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class Chemickles {
    public static final String MOD_ID = "chemickles";

    public static final CreativeTabRegistry.TabSupplier CHEMICKLES_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "chemickles_tab"), () -> new ItemStack(ItemInit.PICKLE.get()));

    public static void init() {
        BlockInit.init();
        ItemInit.init();
    }

    @Environment(EnvType.CLIENT)
    public class ExampleModClient implements ClientModInitializer {
        public void onInitializeClient() {
            setRenderLayer(BlockInit.CUCUMBER_CROP.get());
        }
    }

    @ExpectPlatform
    public static void setRenderLayer(Block block) {
        throw new AssertionError();
    }
}