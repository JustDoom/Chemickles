package com.imjustdoom.chemickles.block.screen;

import com.imjustdoom.chemickles.Chemickles;
import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;

public class ModScreenHandlers {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Chemickles.MOD_ID, Registries.MENU);

    public static final RegistrySupplier<MenuType<JarScreenHandler>> PICKLE_JAR_MENU = MENUS.register("pickle_jar_menu", () -> MenuRegistry.of(JarScreenHandler::new));

    public static void registerAllScreenHandlers() {
        MENUS.register();
    }
}
