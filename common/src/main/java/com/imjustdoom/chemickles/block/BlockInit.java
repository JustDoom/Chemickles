package com.imjustdoom.chemickles.block;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.custom.CucumberCrop;
import com.imjustdoom.chemickles.block.custom.PickleJar;
import com.imjustdoom.chemickles.item.ItemInit;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Chemickles.MOD_ID, Registry.BLOCK_REGISTRY);

    // | --------------------------- |
    // | Blocks                      |
    // | --------------------------- |
    public static final RegistrySupplier<Block> PICKLE_JAR = registerBlock("pickle_jar",
            () -> new PickleJar(Block.Properties.of(Material.CLAY, MaterialColor.COLOR_PURPLE)
                    .strength(0.4f)
                    .sound(SoundType.GLASS)),
            Chemickles.CHEMICKLES_TAB
    );

    // | --------------------------- |
    // | Crops                       |
    // | --------------------------- |
    public static final RegistrySupplier<CucumberCrop> CUCUMBER_CROP = registerBlockWithoutItem("cucumber_crop", () ->
            new CucumberCrop(Block.Properties.of(Material.PLANT, MaterialColor.GRASS)
                    .instabreak()
                    .noCollission()
                    .randomTicks()
                    .sound(SoundType.CROP))
    );

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistrySupplier<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistrySupplier<Item> registerBlockItem(String name, RegistrySupplier<T> block, CreativeModeTab tab) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void init() {
        BLOCKS.register();
    }
}
