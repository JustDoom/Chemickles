package com.imjustdoom.chemickles.item;

import com.imjustdoom.chemickles.Chemickles;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().tab(Chemickles.CHEMICKLES_TAB));
    }
}