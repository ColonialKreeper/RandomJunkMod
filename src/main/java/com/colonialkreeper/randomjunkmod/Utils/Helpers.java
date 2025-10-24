package com.colonialkreeper.randomjunkmod.Utils;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class Helpers {

    public static ItemStack getArmorStack(ServerPlayerEntity player, EquipmentSlot slot) {
        return player.getInventory().getStack(slot.getOffsetEntitySlotId(36));
    }
}
