package com.colonialkreeper.randomjunkmod.tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class DayNightWand extends Item {
    public DayNightWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            if (world.isDay()) {
                serverWorld.setTimeOfDay(13000);
            } else {
                serverWorld.setTimeOfDay(1000);
            }
        }
        user.playSound(SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, 10000.0f, 1.0f);
        return ActionResult.SUCCESS;
    }
}
