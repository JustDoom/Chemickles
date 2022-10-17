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
                            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 900), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_INVISIBILITY_PICKLE = ITEMS.register("long_invisibility_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 2400), 1.0F)
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

    public static final RegistrySupplier<Item> FIRE_RESISTANCE_PICKLE = ITEMS.register("fire_resistance_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 900), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_FIRE_RESISTANCE_PICKLE = ITEMS.register("long_fire_resistance_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> SWIFTNESS_PICKLE = ITEMS.register("swiftness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_SWIFTNESS_PICKLE = ITEMS.register("long_swiftness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_SWIFTNESS_PICKLE = ITEMS.register("strong_swiftness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 450, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> SLOWNESS_PICKLE = ITEMS.register("slowness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 450), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_SLOWNESS_PICKLE = ITEMS.register("long_slowness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_SLOWNESS_PICKLE = ITEMS.register("strong_slowness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> TURTLE_MASTER_PICKLE = ITEMS.register("turtle_master_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_TURTLE_MASTER_PICKLE = ITEMS.register("long_turtle_master_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_TURTLE_MASTER_PICKLE = ITEMS.register("strong_turtle_master_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 3), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> WATER_BREATHING_PICKLE = ITEMS.register("water_breathing_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 900), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_WATER_BREATHING_PICKLE = ITEMS.register("long_water_breathing_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2400), 1.0F)
                            .build()))
    );

    //TODO: harming/healing/instadamage/heal things are OP
    public static final RegistrySupplier<Item> HEALING_PICKLE = ITEMS.register("healing_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.HEAL, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_HEALING_PICKLE = ITEMS.register("strong_healing_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.HEAL, 1, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> HARMING_PICKLE = ITEMS.register("harming_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.HARM, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_HARMING_PICKLE = ITEMS.register("strong_harming_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.HARM, 1, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> POISON_PICKLE = ITEMS.register("poison_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.POISON, 225), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_POISON_PICKLE = ITEMS.register("long_poison_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.POISON, 450), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_POISON_PICKLE = ITEMS.register("strong_poison_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.POISON, 108, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> REGENERATION_PICKLE = ITEMS.register("regeneration_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.REGENERATION, 225), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_REGENERATION_PICKLE = ITEMS.register("long_regeneration_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.REGENERATION, 450), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_REGENERATION_PICKLE = ITEMS.register("strong_regeneration_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.REGENERATION, 113, 1), 1.0F) //112.5
                            .build()))
    );

    public static final RegistrySupplier<Item> STRENGTH_PICKLE = ITEMS.register("strength_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_STRENGTH_PICKLE = ITEMS.register("long_strength_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> STRONG_STRENGTH_PICKLE = ITEMS.register("strong_strength_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 450, 1), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> WEAKNESS_PICKLE = ITEMS.register("weakness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 450), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_WEAKNESS_PICKLE = ITEMS.register("long_weakness_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 1200), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LUCK_PICKLE = ITEMS.register("luck_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.LUCK, 1500), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> SLOW_FALLING_PICKLE = ITEMS.register("slow_falling_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 450), 1.0F)
                            .build()))
    );

    public static final RegistrySupplier<Item> LONG_SLOW_FALLING_PICKLE = ITEMS.register("long_slow_falling_pickle", () ->
            new Item(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6F)
                            .effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200), 1.0F)
                            .build()))
    );

    public static void init() {
        ITEMS.register();
    }
}