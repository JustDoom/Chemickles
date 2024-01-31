package com.imjustdoom.chemickles.block.entity;

import com.imjustdoom.chemickles.block.screen.JarScreenHandler;
import com.imjustdoom.chemickles.item.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PickleJarBlockEntity extends BlockEntity implements MenuProvider, ImplementedInventory {

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);

    protected final ContainerData propertyDelegate;
    private int progress = 0;
    private int maxProgress = 20;

    public PickleJarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PICKLE_JAR.get(), pos, state);
        this.propertyDelegate = new ContainerData() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> PickleJarBlockEntity.this.progress;
                    case 1 -> PickleJarBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: PickleJarBlockEntity.this.progress = value; break;
                    case 1: PickleJarBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Pickle Jar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
        return new JarScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, inventory);
        nbt.putInt("pickle_jar.progress", progress);
    }

    @Override
    public void load(CompoundTag nbt) {
        ContainerHelper.loadAllItems(nbt, inventory);
        super.load(nbt);
        progress = nbt.getInt("pickle_jar.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(Level world, BlockPos blockPos, BlockState state, PickleJarBlockEntity entity) {
        if(world.isClientSide()) {
            return;
        }

        if(hasRecipe(entity)) {
            entity.progress++;
            setChanged(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            setChanged(world, blockPos, state);
        }
    }

    private static void craftItem(PickleJarBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.getContainerSize());
        for (int i = 0; i < entity.getContainerSize(); i++) {
            inventory.setItem(i, entity.getItem(i));
        }

        if(hasRecipe(entity)) {
            entity.removeItem(1, 1);

            entity.setItem(2, new ItemStack(ItemInit.PICKLE.get(),
                    entity.getItem(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(PickleJarBlockEntity entity) {
        SimpleContainer inventory = new SimpleContainer(entity.getContainerSize());
        for (int i = 0; i < entity.getContainerSize(); i++) {
            inventory.setItem(i, entity.getItem(i));
        }

        boolean hasRawGemInFirstSlot = entity.getItem(1).getItem() == ItemInit.CUCUMBER.get();

        return hasRawGemInFirstSlot && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, ItemInit.PICKLE.get());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, Item output) {
        return inventory.getItem(2).getItem() == output || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
