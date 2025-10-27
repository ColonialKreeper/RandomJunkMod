package com.colonialkreeper.randomjunkmod.Utils;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class RandomJunkModWorldgenModifier {

    public static final RegistryKey<PlacedFeature> CLASSITE_ORE_PLACED_KEY = RegistryKey.of(
            RegistryKeys.PLACED_FEATURE, Identifier.of(RandomJunkMod.MOD_ID, "ore_classite")
    );

    private static void modifyOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, CLASSITE_ORE_PLACED_KEY);

    }

    public static void addWorldgen() {
        modifyOres();
    }

}
