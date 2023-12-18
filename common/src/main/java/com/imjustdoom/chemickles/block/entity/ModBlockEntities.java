package com.imjustdoom.chemickles.block.entity;

import com.imjustdoom.chemickles.Chemickles;
import com.imjustdoom.chemickles.block.BlockInit;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Chemickles.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<PickleJarBlockEntity>> PICKLE_JAR =
        BLOCK_ENTITIES.register("pickle_jar", () -> BlockEntityType.Builder.of(PickleJarBlockEntity::new, BlockInit.PICKLE_JAR.get()).build(null));

    public static void registerBlockEntities() {
        BLOCK_ENTITIES.register();
    }
}
