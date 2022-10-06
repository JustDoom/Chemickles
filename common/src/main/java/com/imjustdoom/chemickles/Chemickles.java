package com.imjustdoom.chemickles;

import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.ItemInit;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.fuel.FuelRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Chemickles {
    public static final String MOD_ID = "chemickles";

    public static final CreativeModeTab CHEMICKLES_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "chemickles_tab"), () -> new ItemStack(ItemInit.PICKLE.get()));

    public static void init() {
        BlockInit.init();
        ItemInit.init();
    }
}
