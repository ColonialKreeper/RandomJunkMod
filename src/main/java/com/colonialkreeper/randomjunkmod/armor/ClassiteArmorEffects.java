package com.colonialkreeper.randomjunkmod.armor;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

import static com.colonialkreeper.randomjunkmod.Utils.Helpers.getArmorStack;

public class ClassiteArmorEffects {

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

                handleArmorEffects(player);
                handlePlayerFlight(player);
            }
        });
    }

    private static void handleArmorEffects(ServerPlayerEntity player) {
        if (isWearingFullClassiteArmor(player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1, 1, true, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 2, true, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1, 2, true, false));
        }
    }

    private static void handlePlayerFlight(ServerPlayerEntity player) {
        boolean fullSet = isWearingFullClassiteArmor(player);

        // Skip creative and spectator
        if (player.interactionManager.getGameMode().isCreative()
                || player.interactionManager.getGameMode() == GameMode.SPECTATOR) {
            return;
        }

        // Toggle flight only if it changed
        if (player.getAbilities().allowFlying != fullSet) {
            player.getAbilities().allowFlying = fullSet;

            // Turn off flying if removing armor while flying
            if (player.getAbilities().flying && !fullSet) {
                player.getAbilities().flying = false;
            }

            player.sendAbilitiesUpdate();
        }
    }

    private static boolean isWearingFullClassiteArmor(ServerPlayerEntity player) {
        return getArmorStack(player, EquipmentSlot.HEAD).isOf(ArmorRegister.CLASSITE_HELMET)
                && getArmorStack(player, EquipmentSlot.CHEST).isOf(ArmorRegister.CLASSITE_CHESTPLATE)
                && getArmorStack(player, EquipmentSlot.LEGS).isOf(ArmorRegister.CLASSITE_LEGGINGS)
                && getArmorStack(player, EquipmentSlot.FEET).isOf(ArmorRegister.CLASSITE_BOOTS);
    }


}
