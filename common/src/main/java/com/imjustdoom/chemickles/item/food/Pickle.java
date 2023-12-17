package com.imjustdoom.chemickles.item.food;

import com.imjustdoom.chemickles.Chemickles;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

public class Pickle extends Item {

    public Pickle() {
        super(new Item.Properties()
                .arch$tab(Chemickles.CHEMICKLES_TAB)
                .food(new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(5)
                        .build())
        );
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, itemStack);
        }

        if (!level.isClientSide) {
            List<MobEffectInstance> list = PotionUtils.getMobEffects(itemStack);

            for (MobEffectInstance mobEffectInstance : list) {
                if (mobEffectInstance.getEffect().isInstantenous()) {
                    mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                } else {
                    livingEntity.addEffect(new MobEffectInstance(mobEffectInstance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }

        livingEntity.gameEvent(GameEvent.DRINK);
        return itemStack;
    }

//    @Override
//    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
//        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
//        if (player instanceof ServerPlayer) {
//            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, itemStack);
//        }
//
//        if (!level.isClientSide) {
//            List<MobEffectInstance> list = PotionUtils.getMobEffects(itemStack);
//
//            for (MobEffectInstance mobEffectInstance : list) {
//                if (mobEffectInstance.getEffect().isInstantenous()) {
//                    mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1);
//                } else {
//                    livingEntity.addEffect(new MobEffectInstance(mobEffectInstance.getEffect(), mobEffectInstance.getDuration(), mobEffectInstance.getAmplifier(), mobEffectInstance.isAmbient(), mobEffectInstance.isVisible(), mobEffectInstance.showIcon()));
//                }
//            }
//        }
//
//        if (player != null) {
//            player.awardStat(Stats.ITEM_USED.get(this));
//            if (!player.getAbilities().instabuild) {
//                itemStack.shrink(1);
//            }
//        }
//
//        livingEntity.gameEvent(GameEvent.EAT);
//        return itemStack;
//    }

//    @Override
//    public void fillItemCategory(CreativeModeTab creativeModeTab, NonNullList<ItemStack> nonNullList) {
//        if (this.allowedIn(creativeModeTab)) {
//
//            for (Potion potion : Registries.POTION) {
//                if (potion != Potions.EMPTY && (potion != Potions.TURTLE_MASTER && potion != Potions.LONG_TURTLE_MASTER && potion != Potions.STRONG_TURTLE_MASTER && potion != Potions.LUCK)) {
//                    //nonNullList.add(PotionUtils.setPotion(new ItemStack(this), potion));
//
//                    ItemStack potionItemStack = new ItemStack(this);
//                    PotionUtils.setPotion(potionItemStack, potion);
//
//                    // Get the PotionEffect associated with the potion
//                    List<MobEffectInstance> effects = PotionUtils.getMobEffects(potionItemStack);
//                    if (!effects.isEmpty()) {
//                        MobEffectInstance effect = effects.get(0); // Assuming there's only one effect per potion
//                        int newDuration = 200; // Modify the duration to your desired value
//
//                        // Create a new custom PotionEffect with the modified duration
//                        MobEffectInstance customEffect = new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());
//
//                        // Replace the existing PotionEffect with the custom one
//                        effects.set(0, customEffect);
//                    }
//
//                    nonNullList.add(potionItemStack);
//                }
//            }
//        }
//    }

    public String getDescriptionId(ItemStack itemStack) {
        return PotionUtils.getPotion(itemStack).getName(this.getDescriptionId() + ".effect.");
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        PotionUtils.addPotionTooltip(itemStack, list, 1.0F);
    }
}