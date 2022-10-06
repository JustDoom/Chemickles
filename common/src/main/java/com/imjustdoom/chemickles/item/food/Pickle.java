package com.imjustdoom.chemickles.item.food;

import com.imjustdoom.chemickles.Chemickles;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Pickle extends Item {

    public Pickle() {
        super(new Item.Properties()
                .tab(Chemickles.CHEMICKLES_TAB)
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(5)
                        .build())
        );
    }
}