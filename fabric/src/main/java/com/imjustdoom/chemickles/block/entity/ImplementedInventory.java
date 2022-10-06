//package com.imjustdoom.chemickles.block.entity;
//
//import net.fabricmc.fabric.api.transfer.v1.storage.base.SidedStorageBlockEntity;
//import net.minecraft.core.Direction;
//import net.minecraft.core.NonNullList;
//import net.minecraft.world.ContainerHelper;
//import net.minecraft.world.WorldlyContainer;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import org.checkerframework.checker.nullness.qual.NonNull;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//
///**
//        * A simple {@code SidedInventory} implementation with only default methods + an item list getter.
//        *
//        * <h2>Reading and writing to tags</h2>
//        * Use {@link Inventories#writeNbt(NbtCompound, DefaultedList)} and {@link Inventories#readNbt(NbtCompound, DefaultedList)}
//        * on {@linkplain #getItems() the item list}.
//        *
//        * License: <a href="https://creativecommons.org/publicdomain/zero/1.0/">CC0</a>
//        * @author Juuz
//        */
//@FunctionalInterface
//public interface ImplementedInventory extends WorldlyContainer {
//    /**
//     * Gets the item list of this inventory.
//     * Must return the same instance every time it's called.
//     *
//     * @return the item list
//     */
//    NonNullList<ItemStack> getItems();
//
//    /**
//     * Creates an inventory from the item list.
//     *
//     * @param items the item list
//     * @return a new inventory
//     */
//    static ImplementedInventory of(NonNullList<ItemStack> items) {
//        return () -> items;
//    }
//
//    /**
//     * Creates a new inventory with the size.
//     *
//     * @param size the inventory size
//     * @return a new inventory
//     */
//    static ImplementedInventory ofSize(int size) {
//        return of(NonNullList.withSize(size, ItemStack.EMPTY));
//    }
//
//    // SidedInventory
//
//    /**
//     * Gets the available slots to automation on the side.
//     *
//     * <p>The default implementation returns an array of all slots.
//     *
//     * @param side the side
//     * @return the available slots
//     */
//    @Override
//    default int[] getSlotsForFace(Direction side) {
//        int[] result = new int[getItems().size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = i;
//        }
//
//        return result;
//    }
//
//    /**
//     * Returns true if the stack can be inserted in the slot at the side.
//     *
//     * <p>The default implementation returns true.
//     *
//     * @param slot the slot
//     * @param stack the stack
//     * @param side the side
//     * @return true if the stack can be inserted
//     */
//    @Override
//    default boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
//        return true;
//    }
//
//    /**
//     * Returns true if the stack can be extracted from the slot at the side.
//     *
//     * <p>The default implementation returns true.
//     *
//     * @param slot the slot
//     * @param stack the stack
//     * @param side the side
//     * @return true if the stack can be extracted
//     */
//    @Override
//    default boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
//        return true;
//    }
//
//    // Inventory
//
//    /**
//     * Returns the inventory size.
//     *
//     * <p>The default implementation returns the size of {@link #getItems()}.
//     *
//     * @return the inventory size
//     */
//    @Override
//    default int getContainerSize() {
//        return getItems().size();
//    }
//
//    /**
//     * @return true if this inventory has only empty stacks, false otherwise
//     */
//    @Override
//    default boolean isEmpty() {
//        for (int i = 0; i < getContainerSize(); i++) {
//            ItemStack stack = getItem(i);
//            if (!stack.isEmpty()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    /**
//     * Gets the item in the slot.
//     *
//     * @param slot the slot
//     * @return the item in the slot
//     */
//    @Override
//    default ItemStack getItem(int slot) {
//        return getItems().get(slot);
//    }
//
//    /**
//     * Takes a stack of the size from the slot.
//     *
//     * <p>(default implementation) If there are less items in the slot than what are requested,
//     * takes all items in that slot.
//     *
//     * @param slot the slot
//     * @param count the item count
//     * @return a stack
//     */
//    @Override
//    default ItemStack removeItem(int slot, int count) {
//        ItemStack result = ContainerHelper.splitStack(getItems(), slot, count);
//        if (!result.isEmpty()) {
//            //markDirty();
//        }
//
//        return result;
//    }
//
//    /**
//     * Removes the current stack in the {@code slot} and returns it.
//     *
//     * <p>The default implementation uses {@link Inventories#removeStack(List, int)}
//     *
//     * @param slot the slot
//     * @return the removed stack
//     */
//    @Override
//    default ItemStack removeItemNoUpdate(int slot) {
//        return ContainerHelper.removeItem(getItems(), slot);
//    }
//
//    /**
//     * Replaces the current stack in the {@code slot} with the provided stack.
//     *
//     * <p>If the stack is too big for this inventory ({@link Inventory#getMaxCountPerStack()}),
//     * it gets resized to this inventory's maximum amount.
//     *
//     * @param slot the slot
//     * @param stack the stack
//     */
//    @Override
//    default void setItem(int slot, ItemStack stack) {
//        getItems().set(slot, stack);
//        if (stack.getCount() > getMaxStackSize()) {
//            stack.setCount(getMaxStackSize());
//        }
//    }
//
//    /**
//     * Clears {@linkplain #getItems() the item list}}.
//     */
//    @Override
//    default void clearContent() {
//        getItems().clear();
//    }
//
//    // not sure what this is for
////    @Override
////    default void markDirty() {
////        // Override if you want behavior.
////    }
//
//    @Override
//    default boolean stillValid(Player player) {
//        return true;
//    }
//}