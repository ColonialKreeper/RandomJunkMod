package com.colonialkreeper.randomjunkmod;

import com.colonialkreeper.randomjunkmod.armor.ArmorRegister;
import com.colonialkreeper.randomjunkmod.blocks.BlockRegister;
import com.colonialkreeper.randomjunkmod.items.ItemRegister;
import com.colonialkreeper.randomjunkmod.tools.ToolRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
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
        pack.addProvider(RandomJunkBlockLootTableProvider::new);
        pack.addProvider(RandomJunkBlockTagProvider::new);
        pack.addProvider(RandomJunkEnglishLangProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {

    }

    private static class RandomJunkModelProvider extends FabricModelProvider {
        public RandomJunkModelProvider(FabricDataOutput output) {
            super(output);
        }


        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.CLASSITE_ORE);
            blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.CLASSITE_BLOCK);
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

    private static class RandomJunkBlockTagProvider extends FabricTagProvider.BlockTagProvider {
        private static final TagKey<Block> MINEABLE =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("mineable/pickaxe"));
        private static final TagKey<Block> NEEDS_DIAMOND_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("needs_diamond_tool"));
        private static final TagKey<Block> ORES =
                TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "ores"));
        private static final TagKey<Block> INCORRECT_FOR_WOODEN_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("incorrect_for_wooden_tool"));
        private static final TagKey<Block> INCORRECT_FOR_STONE_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("incorrect_for_stone_tool"));
        private static final TagKey<Block> INCORRECT_FOR_GOLDEN_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("incorrect_for_golden_tool"));
        private static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("incorrect_for_copper_tool"));
        private static final TagKey<Block> INCORRECT_FOR_IRON_TOOL =
                TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla("incorrect_for_iron_tool"));

        public RandomJunkBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            valueLookupBuilder(MINEABLE)
                    .add(BlockRegister.CLASSITE_ORE)
                    .add(BlockRegister.CLASSITE_BLOCK)
            ;

            valueLookupBuilder(NEEDS_DIAMOND_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
            ;
            valueLookupBuilder(INCORRECT_FOR_WOODEN_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
                    .add(BlockRegister.CLASSITE_BLOCK)
            ;
            valueLookupBuilder(INCORRECT_FOR_STONE_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
                    .add(BlockRegister.CLASSITE_BLOCK)
            ;
            valueLookupBuilder(INCORRECT_FOR_GOLDEN_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
                    .add(BlockRegister.CLASSITE_BLOCK)
            ;
            valueLookupBuilder(INCORRECT_FOR_COPPER_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
                    .add(BlockRegister.CLASSITE_BLOCK)
            ;
            valueLookupBuilder(INCORRECT_FOR_IRON_TOOL)
                    .add(BlockRegister.CLASSITE_ORE)
            ;
            valueLookupBuilder(ORES)
                    .add(BlockRegister.CLASSITE_ORE)
            ;
        }
    }

    private static class RandomJunkItemTagProvider extends FabricTagProvider.ItemTagProvider {
        private static final TagKey<Item> SWORDS =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "swords"));
        private static final TagKey<Item> AXES =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "axes"));
        private static final TagKey<Item> PICKAXES =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "pickaxes"));
        private static final TagKey<Item> SHOVELS =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "shovels"));
        private static final TagKey<Item> HOES =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "hoes"));
        private static final TagKey<Item> BOOTS =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "foot_armor"));
        private static final TagKey<Item> LEGGINGS =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "leg_armor"));
        private static final TagKey<Item> CHESTPLATE =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "chest_armor"));
        private static final TagKey<Item> HELMET =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("fabric", "head_armor"));

        public RandomJunkItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

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
                    .add(ArmorRegister.GRAV_BOOTS)
            ;

        }
    }

    private static class RandomJunkRecipeProvider extends FabricRecipeProvider {


        public RandomJunkRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }


        @Override
        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
            return new RecipeGenerator(registryLookup, exporter) {
                @Override
                public void generate() {
                    RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                    // Day Night wand

                    createShaped(RecipeCategory.MISC, ToolRegister.DAY_NIGHT_WAND, 1)
                            .pattern(" lc")
                            .pattern(" ll")
                            .pattern("j  ")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .input('c', Items.CLOCK)
                            .criterion(hasItem(ToolRegister.DAY_NIGHT_WAND), conditionsFromItem(ToolRegister.DAY_NIGHT_WAND))
                            .offerTo(exporter);


                    // Sword
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_SWORD, 1)
                            .pattern("l")
                            .pattern("l")
                            .pattern("j")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_SWORD), conditionsFromItem(ToolRegister.CLASSITE_SWORD))
                            .offerTo(exporter);

                    // Pickaxe
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_PICKAXE, 1)
                            .pattern("lll")
                            .pattern(" j ")
                            .pattern(" j ")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_PICKAXE), conditionsFromItem(ToolRegister.CLASSITE_PICKAXE))
                            .offerTo(exporter);

                    // Axe
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_AXE, 1)
                            .pattern("ll")
                            .pattern("lj")
                            .pattern(" j")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_AXE), conditionsFromItem(ToolRegister.CLASSITE_AXE))
                            .offerTo(exporter);

                    // Shovel
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_SHOVEL, 1)
                            .pattern("l")
                            .pattern("j")
                            .pattern("j")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_SHOVEL), conditionsFromItem(ToolRegister.CLASSITE_SHOVEL))
                            .offerTo(exporter);

                    // Hoe
                    createShaped(RecipeCategory.MISC, ToolRegister.CLASSITE_HOE, 1)
                            .pattern("ll")
                            .pattern(" j")
                            .pattern(" j")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('j', Items.STICK)
                            .criterion(hasItem(ToolRegister.CLASSITE_HOE), conditionsFromItem(ToolRegister.CLASSITE_HOE))
                            .offerTo(exporter);

                    // Helmet
                    createShaped(RecipeCategory.MISC, ArmorRegister.CLASSITE_HELMET, 1)
                            .pattern("blb")
                            .pattern("l l")
                            .input('b', BlockRegister.CLASSITE_BLOCK)
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .criterion(hasItem(ArmorRegister.CLASSITE_HELMET), conditionsFromItem(ArmorRegister.CLASSITE_HELMET))
                            .offerTo(exporter);

                    // Chestplate
                    createShaped(RecipeCategory.MISC, ArmorRegister.CLASSITE_CHESTPLATE, 1)
                            .pattern("b b")
                            .pattern("lel")
                            .pattern("ldl")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('b', BlockRegister.CLASSITE_BLOCK)
                            .input('e', Items.ELYTRA)
                            .input('d', Items.DRAGON_EGG)
                            .criterion(hasItem(ArmorRegister.CLASSITE_CHESTPLATE), conditionsFromItem(ArmorRegister.CLASSITE_CHESTPLATE))
                            .offerTo(exporter);

                    // Leggings
                    createShaped(RecipeCategory.MISC, ArmorRegister.CLASSITE_LEGGINGS, 1)
                            .pattern("blb")
                            .pattern("l l")
                            .pattern("l l")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('b', BlockRegister.CLASSITE_BLOCK)
                            .criterion(hasItem(ArmorRegister.CLASSITE_LEGGINGS), conditionsFromItem(ArmorRegister.CLASSITE_LEGGINGS))
                            .offerTo(exporter);

                    // Boots
                    createShaped(RecipeCategory.MISC, ArmorRegister.CLASSITE_BOOTS, 1)
                            .pattern("b b")
                            .pattern("l l")
                            .input('l', ItemRegister.CLASSITE_GEM)
                            .input('b', BlockRegister.CLASSITE_BLOCK)
                            .criterion(hasItem(ArmorRegister.CLASSITE_BOOTS), conditionsFromItem(ArmorRegister.CLASSITE_BOOTS))
                            .offerTo(exporter);
                }
            };
        }


        @Override
        public String getName() {
            return "RandomJunkRecipeProvider";
        }
    }

    private static class RandomJunkBlockLootTableProvider extends FabricBlockLootTableProvider {
        protected RandomJunkBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            RegistryWrapper.WrapperLookup lookup = registries;
            RegistryWrapper.Impl<Enchantment> enchantmentRegistry = lookup.getOrThrow(RegistryKeys.ENCHANTMENT);

            RegistryEntry<Enchantment> fortune = enchantmentRegistry.getOrThrow(Enchantments.FORTUNE);

            addDrop(BlockRegister.CLASSITE_ORE,
                    block -> dropsWithSilkTouch(
                            block,
                            ItemEntry.builder(ItemRegister.CLASSITE_GEM)
                                    .apply(ApplyBonusLootFunction.oreDrops(fortune))
                                    .apply(ExplosionDecayLootFunction.builder())
                    )
            );
        }
    }

    private static class RandomJunkEnglishLangProvider extends FabricLanguageProvider {
        protected RandomJunkEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            // Specifying en_us is optional, as it's the default language code
            super(dataOutput, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {

            translationBuilder.add("itemGroup.randomjunkmod", "Random Junk Mod");

            translationBuilder.add("block.randomjunkmod.classite_block", "Classite Block");
            translationBuilder.add("block.randomjunkmod.classite_ore", "Classite Ore");

            translationBuilder.add("item.randomjunkmod.day_night_wand", "Time Shifter Wand");
            translationBuilder.add("item.randomjunkmod.day_night_wand.tooltip", "Changes the very position of the sun itself.");

            translationBuilder.add("item.randomjunkmod.classite_gem", "Classite Gem");

            translationBuilder.add("item.randomjunkmod.classite_helmet", "Classite Helmet");
            translationBuilder.add("item.randomjunkmod.classite_chestplate", "Classite Chestplate");
            translationBuilder.add("item.randomjunkmod.classite_leggings", "Classite Leggings");
            translationBuilder.add("item.randomjunkmod.classite_boots", "Classite Boots");

            translationBuilder.add("item.randomjunkmod.classite_sword", "Classite Sword");
            translationBuilder.add("item.randomjunkmod.classite_pickaxe", "Classite Pickaxe");
            translationBuilder.add("item.randomjunkmod.classite_axe", "Classite Axe");
            translationBuilder.add("item.randomjunkmod.classite_shovel", "Classite Shovel");
            translationBuilder.add("item.randomjunkmod.classite_hoe", "Classite Hoe");

            translationBuilder.add("item.randomjunkmod.grav_boots", "Grav Boots");

        }
    }

}


