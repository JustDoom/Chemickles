package com.imjustdoom.chemickles.item;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.food.Cucumber;
import com.imjustdoom.chemickles.item.food.Pickle;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Chemickles.MOD_ID, Registries.ITEM);

    //Food Items
    public static final RegistrySupplier<Pickle> PICKLE = ITEMS.register("pickle", Pickle::new);
    public static final RegistrySupplier<Cucumber> CUCUMBER = ITEMS.register("cucumber", Cucumber::new);
    public static final RegistrySupplier<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(BlockInit.CUCUMBER_CROP.get(),
                    new Item.Properties().arch$tab(Chemickles.CHEMICKLES_TAB)));
    public static final RegistrySupplier<Item> PICKLE_RICK = ITEMS.register("pickle_rick", ItemBase::new);

    public static void init() {
        ITEMS.register();
    }
}