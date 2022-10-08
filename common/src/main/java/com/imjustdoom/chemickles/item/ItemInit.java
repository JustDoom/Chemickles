package com.imjustdoom.chemickles.item;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.item.food.Cucumber;
import com.imjustdoom.chemickles.item.food.Pickle;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Chemickles.MOD_ID, Registry.ITEM_REGISTRY);

    //Food Items
    public static final RegistrySupplier<Pickle> PICKLE = ITEMS.register("pickle", Pickle::new);
    public static final RegistrySupplier<Cucumber> CUCUMBER = ITEMS.register("cucumber", Cucumber::new);
    public static final RegistrySupplier<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", ItemBase::new);
    public static final RegistrySupplier<Item> PICKLE_RICK = ITEMS.register("pickle_rick", ItemBase::new);

    // Special Pickles
    public static final RegistrySupplier<Item> NIGHT_VISION_PICKLE = ITEMS.register("night_vision_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 900), 1.0F)
                            .build()))
    );
    public static final RegistrySupplier<Item> LONG_NIGHT_VISION_PICKLE = ITEMS.register("long_night_vision_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> INVISIBILITY_PICKLE = ITEMS.register("invisibility_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 900), 1.0F)
                            .build()))
    );
    public static final RegistrySupplier<Item> LONG_INVISIBILITY_PICKLE = ITEMS.register("long_invisibility_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LEAPING_PICKLE = ITEMS.register("leaping_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.JUMP, 900), 1.0F)
                            .build()))
    );
    public static final RegistrySupplier<Item> LONG_LEAPING_PICKLE = ITEMS.register("long_leaping_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.JUMP, 2400), 1.0F)
                            .build()))
    );
    public static final RegistrySupplier<Item> STRONG_LEAPING_PICKLE = ITEMS.register("strong_leaping_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.JUMP, 450, 1), 1.0F)
                            .build()))
    );

    public static void init() {
        ITEMS.register();
    }
}