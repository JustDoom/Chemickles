package com.imjustdoom.chemickles.fabric;

import com.imjustdoom.chemickles.Chemickles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ChemicklesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CreativeModeTab tab = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.COOKED_EGG.get()))
                .title(Component.translatable("category.chemickles.chemickles_tab"))
                .displayItems((context, entries) -> {
                    BuiltInRegistries.ITEM.stream()
                            .filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(Chemickles.MOD_ID))
                            .forEach(entries::accept);
                })
                .build();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Chemickles.MOD_ID, "chemickles_tab"), tab);

        Chemickles.init(tab);
    }

//    public static void setRenderLayer(Block block) {
//        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.class());
//    }
}
