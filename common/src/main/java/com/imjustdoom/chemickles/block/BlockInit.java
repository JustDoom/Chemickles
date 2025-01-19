package com.imjustdoom.chemickles.block;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.custom.CucumberCrop;
import com.imjustdoom.chemickles.block.custom.PickleJar;
import com.imjustdoom.chemickles.item.ItemInit;
import com.imjustdoom.chemickles.platform.RegistryWrapper;
import com.imjustdoom.chemickles.platform.Services;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class BlockInit {

    // | --------------------------- |
    // | Blocks                      |
    // | --------------------------- |
    public static final RegistryWrapper<Block> PICKLE_JAR = registerBlock("pickle_jar",
            () -> new PickleJar(Block.Properties.of()
                    .strength(0.4f)
                    .sound(SoundType.GLASS))
    );

    // | --------------------------- |
    // | Crops                       |
    // | --------------------------- |
    public static final RegistryWrapper<CucumberCrop> CUCUMBER_CROP = registerBlock("cucumber_crop", () ->
            new CucumberCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT))
    );

    // Registries

    private static <T extends Block> RegistryWrapper<T> registerBlock(String id, Supplier<T> block) {
        RegistryWrapper<T> registeredBlock = Services.PLATFORM.registerBlock(id, block);
        registerBlockItem(id, registeredBlock);
        return registeredBlock;
    }

    private static <T extends Block> RegistryWrapper<Item> registerBlockItem(String name, RegistryWrapper<T> block) {
        return ItemInit.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init() {}
}
