package com.colonialkreeper.randomjunkmod;

import com.colonialkreeper.randomjunkmod.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class RandomJunkModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelGenerator::new);
	}

    private static class ModelGenerator extends FabricModelProvider {
        public ModelGenerator(FabricDataOutput output) {
            super(output);
        }


        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            // ...
        }


        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.DAY_NIGHT_WAND, Models.HANDHELD_ROD);
            itemModelGenerator.register(ModItems.CLASSITE_SWORD, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_GEM, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_HELMET, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_CHESTPLATE, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_LEGGINGS, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_BOOTS, Models.GENERATED);

        }
    }


}
