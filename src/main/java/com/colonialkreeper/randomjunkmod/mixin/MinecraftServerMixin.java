package com.colonialkreeper.randomjunkmod.mixin;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.minecraft.network.QueryableServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTask;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.world.ChunkErrorHandler;
import net.minecraft.util.thread.ReentrantThreadExecutor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
abstract class MinecraftServerMixin extends ReentrantThreadExecutor<ServerTask> implements QueryableServer, ChunkErrorHandler, CommandOutput, AutoCloseable {
    public MinecraftServerMixin(String string) {
        super(string);
    }

    @Inject(method = "loadWorld", at = @At(value = "HEAD"))
    private void logOnWorldLoad(CallbackInfo ci) {
        RandomJunkMod.LOGGER.info("MinecraftServer$loadWorld has started!");
    }
}