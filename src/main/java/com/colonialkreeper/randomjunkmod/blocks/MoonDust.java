package com.colonialkreeper.randomjunkmod.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.sound.AmbientDesertBlockSounds;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MoonDust extends ColoredFallingBlock {
    public static final MapCodec<MoonDust> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(ColorCode.CODEC.fieldOf("falling_dust_color").forGetter(block -> block.color), createSettingsCodec())
                    .apply(instance, MoonDust::new)
    );

    @Override
    public MapCodec<MoonDust> getCodec() {
        return CODEC;
    }

    public MoonDust(ColorCode colorCode, AbstractBlock.Settings settings) {
        super(colorCode, settings);
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        AmbientDesertBlockSounds.tryPlaySandSounds(world, pos, random);
    }

}
