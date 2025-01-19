package com.imjustdoom.chemickles.platform;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.forge.ChemicklesForge;
import com.imjustdoom.chemickles.platform.services.IPlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgePlatformHelper implements IPlatformHelper {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chemickles.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chemickles.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Chemickles.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Chemickles.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Chemickles.MOD_ID);

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public <T extends Item> RegistryWrapper<T> registerItem(String id, Supplier<T> item) {
        ForgeWrapper<T> wrapper = new ForgeWrapper<>(ITEMS.register(id, item));
        ChemicklesForge.registerItem(wrapper);
        return wrapper;
    }

    @Override
    public <T extends Block> RegistryWrapper<T> registerBlock(String id, Supplier<T> block) {
        return new ForgeWrapper<>(BLOCKS.register(id, block));
    }

    @Override
    public <T extends BlockEntity> RegistryWrapper<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> block) {
        return new ForgeWrapper<>(BLOCK_ENTITIES.register(id, block));
    }

    @Override
    public <T extends AbstractContainerMenu> RegistryWrapper<MenuType<T>> registerMenu(String id, MenuType.MenuSupplier<T> block) {
        return new ForgeWrapper<>(MENUS.register(id, () -> new MenuType<>(block, FeatureFlags.VANILLA_SET)));
    }

    @Override
    public void registerTab(String id, CreativeModeTab tab) {
        TABS.register(id, () -> tab);
    }
}