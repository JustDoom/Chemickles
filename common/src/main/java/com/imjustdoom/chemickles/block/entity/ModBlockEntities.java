package com.imjustdoom.chemickles.block.entity;

import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.platform.RegistryWrapper;
import com.imjustdoom.chemickles.platform.Services;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import java.util.function.Supplier;

public class ModBlockEntities {
    public static final RegistryWrapper<BlockEntityType<PickleJarBlockEntity>> PICKLE_JAR =
        registerBlockEntity("pickle_jar", () -> BlockEntityType.Builder.of(PickleJarBlockEntity::new, BlockInit.PICKLE_JAR.get()).build(null));

    private static <T extends BlockEntity> RegistryWrapper<T> registerBlockEntity(String name, Supplier<T> block) {
        return Services.PLATFORM.registerBlockEntity(name, block);
    }

    public static void init() {}
}
