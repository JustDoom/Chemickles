package com.imjustdoom.chemickles;

import com.imjustdoom.chemickles.block.BlockInit;
import com.imjustdoom.chemickles.item.ItemInit;
import com.imjustdoom.chemickles.item.Pickles;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.fuel.FuelRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class Chemickles {
    public static final String MOD_ID = "chemickles";

    public static final CreativeTabRegistry.TabSupplier CHEMICKLES_TAB = CreativeTabRegistry.create(
            new ResourceLocation(MOD_ID, "chemickles_tab"),
            builder -> {
                builder.icon(() -> new ItemStack(ItemInit.PICKLE.get()));
                builder.displayItems((params, output) -> {
                    for (Potion potion : BuiltInRegistries.POTION) {
                        if (potion != Potions.EMPTY && (potion != Potions.TURTLE_MASTER && potion != Potions.LONG_TURTLE_MASTER && potion != Potions.STRONG_TURTLE_MASTER && potion != Potions.LUCK)) {
                            //nonNullList.add(PotionUtils.setPotion(new ItemStack(this), potion));

                            ItemStack potionItemStack = new ItemStack(ItemInit.PICKLE.get());
                            PotionUtils.setPotion(potionItemStack, potion);

                            // Get the PotionEffect associated with the potion
                            List<MobEffectInstance> effects = PotionUtils.getMobEffects(potionItemStack);
                            if (!effects.isEmpty()) {
                                MobEffectInstance effect = effects.get(0); // Assuming there's only one effect per potion
                                int newDuration = 200; // Modify the duration to your desired value

                                // Create a new custom PotionEffect with the modified duration
                                MobEffectInstance customEffect = new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());

                                // Replace the existing PotionEffect with the custom one
                                effects.set(0, customEffect);
                            }

                            output.accept(potionItemStack);
                        }
                    }
                });
            });

    public static void init() {
        BlockInit.init();
        ItemInit.init();
    }

    @Environment(EnvType.CLIENT)
    public class ExampleModClient implements ClientModInitializer {
        public void onInitializeClient() {
            setRenderLayer(BlockInit.CUCUMBER_CROP.get());
        }
    }

    @ExpectPlatform
    public static void setRenderLayer(Block block) {
        throw new AssertionError();
    }
}