package com.colonialkreeper.randomjunkmod;

import com.colonialkreeper.randomjunkmod.items.ModItems;
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
import net.minecraft.registry.tag.ItemTags;
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
            // ...
        }


        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            itemModelGenerator.register(ModItems.DAY_NIGHT_WAND, Models.HANDHELD_ROD);
            itemModelGenerator.register(ModItems.CLASSITE_SWORD, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_AXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_PICKAXE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_SHOVEL, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_HOE, Models.HANDHELD);
            itemModelGenerator.register(ModItems.CLASSITE_GEM, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_HELMET, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_CHESTPLATE, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_LEGGINGS, Models.GENERATED);
            itemModelGenerator.register(ModItems.CLASSITE_BOOTS, Models.GENERATED);
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
                    .add(ModItems.CLASSITE_SWORD)
            ;
            valueLookupBuilder(AXES)
                    .add(ModItems.CLASSITE_AXE)
            ;
            valueLookupBuilder(PICKAXES)
                    .add(ModItems.CLASSITE_PICKAXE)
            ;
            valueLookupBuilder(SHOVELS)
                    .add(ModItems.CLASSITE_SHOVEL)
            ;
            valueLookupBuilder(HOES)
                    .add(ModItems.CLASSITE_HOE)
            ;
            valueLookupBuilder(HELMET)
                    .add(ModItems.CLASSITE_HELMET)
            ;
            valueLookupBuilder(CHESTPLATE)
                    .add(ModItems.CLASSITE_CHESTPLATE)
            ;
            valueLookupBuilder(LEGGINGS)
                    .add(ModItems.CLASSITE_LEGGINGS)
            ;
            valueLookupBuilder(BOOTS)
                    .add(ModItems.CLASSITE_BOOTS)
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
                    createShaped(RecipeCategory.MISC, ModItems.CLASSITE_SWORD, 1)
                            .pattern("l")
                            .pattern("l")
                            .pattern("j")
                            .input('l', ModItems.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ModItems.CLASSITE_SWORD), conditionsFromItem(ModItems.CLASSITE_SWORD))
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
