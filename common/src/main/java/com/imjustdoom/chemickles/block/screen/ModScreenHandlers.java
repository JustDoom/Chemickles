package com.imjustdoom.chemickles.block.screen;

import com.imjustdoom.chemickles.platform.RegistryWrapper;
import com.imjustdoom.chemickles.platform.Services;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModScreenHandlers {

    public static final RegistryWrapper<MenuType<JarScreenHandler>> PICKLE_JAR_MENU = register("pickle_jar_menu", JarScreenHandler::new);

    public static <T extends AbstractContainerMenu> RegistryWrapper<MenuType<T>> register(String id, MenuType.MenuSupplier<T> menu) {
        return Services.PLATFORM.registerMenu(id, menu);
    }

    public static void init() {}
}
