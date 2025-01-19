package com.imjustdoom.chemickles.platform;

import net.minecraftforge.registries.RegistryObject;

public class ForgeWrapper<T> implements RegistryWrapper<T> {
    private final RegistryObject<T> object;

    public ForgeWrapper(RegistryObject<T> object) {
        this.object = object;
    }

    @Override
    public T get() {
        return this.object.get();
    }
}
