package com.imjustdoom.chemickles.forge;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.ItemInit;
import com.imjustdoom.chemickles.platform.ForgePlatformHelper;
import com.imjustdoom.chemickles.platform.ForgeWrapper;
import com.imjustdoom.chemickles.platform.Services;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(Chemickles.MOD_ID)
public class ChemicklesForge {
    private static final List<ForgeWrapper<Item>> REGISTERED_ITEMS = new ArrayList<>();

    public ChemicklesForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(ChemicklesForge::buildContents);

        CreativeModeTab tab = CreativeModeTab.builder()
                .title(Component.translatable("category.chemickles.chemickles_tab"))
                .icon(() -> new ItemStack(ItemInit.COOKED_EGG.get()))
                .build();

        Services.PLATFORM.registerTab("villagerinabucket_tab", tab);

        ItemInit.init();
        BlockInit.init();

        ForgePlatformHelper.ITEMS.register(modBus);
        ForgePlatformHelper.BLOCKS.register(modBus);
        ForgePlatformHelper.TABS.register(modBus);

        Chemickles.init(tab);
    }

    public static void registerItem(ForgeWrapper<Item> item) {
        REGISTERED_ITEMS.add(item); // Do this to keep general order for creative tab instead of alphabetical
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() != Chemickles.CHEMICKLES_TAB) {
            return;
        }

        for (ForgeWrapper<Item> item : REGISTERED_ITEMS) {
            event.accept(item.get());
        }
    }

//    public static void setRenderLayer(Block block) {
//        RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
//    }
}