package com.imjustdoom.chemickles.item;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.food.Cucumber;
import com.imjustdoom.chemickles.item.food.Pickle;
import com.imjustdoom.chemickles.platform.RegistryWrapper;
import com.imjustdoom.chemickles.platform.Services;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import java.util.function.Supplier;

public class ItemInit {
    //Food Items
    public static final RegistryWrapper<Pickle> PICKLE = register("pickle", Pickle::new);
    public static final RegistryWrapper<Cucumber> CUCUMBER = register("cucumber", Cucumber::new);
    public static final RegistryWrapper<Item> CUCUMBER_SEEDS = register("cucumber_seeds",
            () -> new ItemNameBlockItem(BlockInit.CUCUMBER_CROP.get(), new Item.Properties()));
    public static final RegistryWrapper<Item> PICKLE_RICK = register("pickle_rick", () -> new Item(new Item.Properties()));

    public static <T extends Item> RegistryWrapper<T> register(String id, Supplier<T> item) {
        return Services.PLATFORM.registerItem(id, item);
    }

    public static void init() {}
}