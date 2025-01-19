package com.imjustdoom.chemickles;

import com.imjustdoom.chemickles.block.entity.ModBlockEntities;
import com.imjustdoom.chemickles.block.screen.ModScreenHandlers;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chemickles {
    public static final String MOD_ID = "chemickles";
    public static final String MOD_NAME = "Chemickles";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static CreativeModeTab CHEMICKLES_TAB;
//    CreativeTabRegistry.create(
//            new ResourceLocation(MOD_ID, "chemickles_tab"),
//            builder -> {
//                builder.icon(() -> new ItemStack(ItemInit.PICKLE.get()));
//                builder.displayItems((params, output) -> {
//                    for (Potion potion : BuiltInRegistries.POTION) {
//                        if (potion != Potions.EMPTY && (potion != Potions.TURTLE_MASTER && potion != Potions.LONG_TURTLE_MASTER && potion != Potions.STRONG_TURTLE_MASTER && potion != Potions.LUCK)) {
//                            //nonNullList.add(PotionUtils.setPotion(new ItemStack(this), potion));
//
//                            ItemStack potionItemStack = new ItemStack(ItemInit.PICKLE.get());
//                            PotionUtils.setPotion(potionItemStack, potion);
//
//                            // Get the PotionEffect associated with the potion
//                            List<MobEffectInstance> effects = PotionUtils.getMobEffects(potionItemStack);
//                            if (!effects.isEmpty()) {
//                                MobEffectInstance effect = effects.get(0); // Assuming there's only one effect per potion
//                                int newDuration = 200; // Modify the duration to your desired value
//
//                                // Create a new custom PotionEffect with the modified duration
//                                MobEffectInstance customEffect = new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());
//
//                                // Replace the existing PotionEffect with the custom one
//                                effects.set(0, customEffect);
//                            }
//
//                            output.accept(potionItemStack);
//                        }
//                    }
//                });
//            });

    public static void init(CreativeModeTab tab) {
        CHEMICKLES_TAB = tab;

        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerAllScreenHandlers();
    }
}