package com.imjustdoom.chemickles.block.custom;

import com.imjustdoom.chemickles.item.ItemInit;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class CucumberCrop extends CropBlock {

    public CucumberCrop(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemInit.CUCUMBER_SEEDS.get();
    }
}
