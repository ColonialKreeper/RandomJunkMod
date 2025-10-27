package com.colonialkreeper.randomjunkmod;

import com.colonialkreeper.randomjunkmod.Utils.RandomJunkModLootTableModifiers;
import com.colonialkreeper.randomjunkmod.blocks.BlockRegister;
import com.colonialkreeper.randomjunkmod.items.ModItemGroup;
import com.colonialkreeper.randomjunkmod.armor.ArmorRegister;
import com.colonialkreeper.randomjunkmod.armor.ClassiteArmorEffects;
import com.colonialkreeper.randomjunkmod.items.ItemRegister;
import com.colonialkreeper.randomjunkmod.tools.ToolRegister;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomJunkMod implements ModInitializer {
	public static final String MOD_ID = "randomjunkmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
        //add creative mod tab
        ModItemGroup.registerModGroup();

        // Register normal items
        ItemRegister.registerItems();

        // register tool items
        ToolRegister.registerToolItems();

        // register armor items
        ArmorRegister.registerArmorItems();

        // register blocks
        BlockRegister.registerBlocks();

        // add armor effects
        ClassiteArmorEffects.register();

        //Change Loot Tables
        RandomJunkModLootTableModifiers.modifyLootTables();
    }
}