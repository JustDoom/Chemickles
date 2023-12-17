package com.imjustdoom.chemickles.item.food;

import com.imjustdoom.chemickles.Chemickles;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Cucumber extends Item {

    public Cucumber() {
        super(new Properties()
                .arch$tab(Chemickles.CHEMICKLES_TAB)
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(5)
                        .build())
        );
    }
}