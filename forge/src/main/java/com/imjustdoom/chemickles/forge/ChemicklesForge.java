package com.imjustdoom.chemickles.forge;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.block.screen.JarScreen;
import com.imjustdoom.chemickles.block.screen.ModScreenHandlers;
import com.imjustdoom.chemickles.item.ItemInit;
import com.imjustdoom.chemickles.platform.ForgePlatformHelper;
import com.imjustdoom.chemickles.platform.ForgeWrapper;
import com.imjustdoom.chemickles.platform.Services;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(Chemickles.MOD_ID)
public class ChemicklesForge {
    private static final List<ForgeWrapper<Item>> REGISTERED_ITEMS = new ArrayList<>();

    public ChemicklesForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(ChemicklesForge::buildContents);
        modBus.addListener(ChemicklesForge::onClientSetup);

        CreativeModeTab tab = CreativeModeTab.builder()
                .title(Component.translatable("category.chemickles.chemickles_tab"))
                .icon(() -> new ItemStack(ItemInit.CUCUMBER.get()))
                .build();

        Services.PLATFORM.registerTab("villagerinabucket_tab", tab);

        ItemInit.init();
        BlockInit.init();

        ForgePlatformHelper.ITEMS.register(modBus);
        ForgePlatformHelper.BLOCKS.register(modBus);
        ForgePlatformHelper.BLOCK_ENTITIES.register(modBus);
        ForgePlatformHelper.MENUS.register(modBus);
        ForgePlatformHelper.TABS.register(modBus);

        Chemickles.init(tab);
    }

    public static <T extends Item> void registerItem(ForgeWrapper<T> item) {
        REGISTERED_ITEMS.add((ForgeWrapper<Item>) item); // Do this to keep general order for creative tab instead of alphabetical
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(ModScreenHandlers.PICKLE_JAR_MENU.get(), JarScreen::new);
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