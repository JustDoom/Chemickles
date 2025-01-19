package com.imjustdoom.chemickles.platform;

public class FabricWrapper<T> implements RegistryWrapper<T> {
    private final T object;

    public FabricWrapper(T object) {
        this.object = object;
    }

    @Override
    public T get() {
        return this.object;
    }
}
