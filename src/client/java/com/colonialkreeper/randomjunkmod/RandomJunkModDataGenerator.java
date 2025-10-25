package com.colonialkreeper.randomjunkmod;

import com.colonialkreeper.randomjunkmod.blocks.BlockRegister;
import com.colonialkreeper.randomjunkmod.items.ItemRegister;
import com.colonialkreeper.randomjunkmod.armor.ArmorRegister;
import com.colonialkreeper.randomjunkmod.tools.ToolRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class RandomJunkModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(RandomJunkItemTagProvider::new);
        pack.addProvider(RandomJunkModelProvider::new);
        pack.addProvider(RandomJunkRecipeProvider::new);
	}

    private static class RandomJunkModelProvider extends FabricModelProvider {
        public RandomJunkModelProvider(FabricDataOutput output) {
            super(output);
        }


        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.MOON_DUST);
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.MOON_STONE);
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.MOON_COBBLESTONE);
        }


        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ToolRegister.DAY_NIGHT_WAND, Models.HANDHELD_ROD);
            itemModelGenerator.register(ToolRegister.CLASSITE_SWORD, Models.HANDHELD);
            itemModelGenerator.register(ToolRegister.CLASSITE_AXE, Models.HANDHELD);
            itemModelGenerator.register(ToolRegister.CLASSITE_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(ToolRegister.CLASSITE_SHOVEL, Models.HANDHELD);
            itemModelGenerator.register(ToolRegister.CLASSITE_HOE, Models.HANDHELD);
            itemModelGenerator.register(ItemRegister.CLASSITE_GEM, Models.GENERATED);
            itemModelGenerator.register(ArmorRegister.CLASSITE_HELMET, Models.GENERATED);
            itemModelGenerator.register(ArmorRegister.CLASSITE_CHESTPLATE, Models.GENERATED);
            itemModelGenerator.register(ArmorRegister.CLASSITE_LEGGINGS, Models.GENERATED);
            itemModelGenerator.register(ArmorRegister.CLASSITE_BOOTS, Models.GENERATED);
            itemModelGenerator.register(ArmorRegister.GRAV_BOOTS, Models.GENERATED);
        }
    }

    public static class RandomJunkItemTagProvider extends FabricTagProvider.ItemTagProvider {
        public RandomJunkItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }
        private static final TagKey<Item> SWORDS =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("swords"));
        private static final TagKey<Item> AXES =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("axes"));
        private static final TagKey<Item> PICKAXES =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("pickaxes"));
        private static final TagKey<Item> SHOVELS =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("shovels"));
        private static final TagKey<Item> HOES =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("hoes"));
        private static final TagKey<Item> BOOTS =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("foot_armor"));
        private static final TagKey<Item> LEGGINGS =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("leg_armor"));
        private static final TagKey<Item> CHESTPLATE =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("chest_armor"));
        private static final TagKey<Item> HELMET =
                TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("head_armor"));



        @Override
        protected void configure(RegistryWrapper.WrapperLookup lookup) {
            valueLookupBuilder(SWORDS)
                    .add(ToolRegister.CLASSITE_SWORD)
            ;
            valueLookupBuilder(AXES)
                    .add(ToolRegister.CLASSITE_AXE)
            ;
            valueLookupBuilder(PICKAXES)
                    .add(ToolRegister.CLASSITE_PICKAXE)
            ;
            valueLookupBuilder(SHOVELS)
                    .add(ToolRegister.CLASSITE_SHOVEL)
            ;
            valueLookupBuilder(HOES)
                    .add(ToolRegister.CLASSITE_HOE)
            ;
            valueLookupBuilder(HELMET)
                    .add(ArmorRegister.CLASSITE_HELMET)
            ;
            valueLookupBuilder(CHESTPLATE)
                    .add(ArmorRegister.CLASSITE_CHESTPLATE)
            ;
            valueLookupBuilder(LEGGINGS)
                    .add(ArmorRegister.CLASSITE_LEGGINGS)
            ;
            valueLookupBuilder(BOOTS)
                    .add(ArmorRegister.CLASSITE_BOOTS)
            ;

        }
    }

    public static class RandomJunkRecipeProvider extends FabricRecipeProvider {


        public RandomJunkRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
            return new RecipeGenerator(registryLookup, exporter) {
                @Override
                public void generate() {
                    RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_SWORD, 1)
                            .pattern("l")
                            .pattern("l")
                            .pattern("j")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_SWORD), conditionsFromItem(ToolRegister.CLASSITE_SWORD))
                            .offerTo(exporter);

                    createDoorRecipe(Items.OAK_DOOR, Ingredient.ofItems(Items.OAK_BUTTON)) // Using a helper method!
                            .criterion(hasItem(Items.OAK_BUTTON), conditionsFromItem(Items.OAK_BUTTON))
                            .offerTo(exporter);
                }
            };
        }

        @Override
        public String getName() {
            return "RandomJunkRecipeProvider";
        }
    }
}
