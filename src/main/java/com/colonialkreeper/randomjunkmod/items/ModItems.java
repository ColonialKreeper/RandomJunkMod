package com.colonialkreeper.randomjunkmod.items;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import com.colonialkreeper.randomjunkmod.items.armor.ClassiteArmorMaterial;
import com.colonialkreeper.randomjunkmod.items.armor.GravBoots;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item DAY_NIGHT_WAND = register("day_night_wand", DayNightWand::new, new Item.Settings().maxCount(1));

    public static final Item CLASSITE_GEM = register("classite_gem", Item::new, new Item.Settings());

    public static final Item CLASSITE_SWORD = register(
            "classite_sword",
            Item::new,
            new Item.Settings().sword(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 5,60f)
            );
    public static final Item CLASSITE_PICKAXE = register(
            "classite_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 1,60f)
            );
    public static final Item CLASSITE_AXE = register(
            "classite_axe",
            Item::new,
            new Item.Settings().axe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9,60f)
            );
    public static final Item CLASSITE_SHOVEL= register(
            "classite_shovel",
            Item::new,
            new Item.Settings().shovel(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9,60f)
            );
    public static final Item CLASSITE_HOE = register(
            "classite_hoe",
            Item::new,
            new Item.Settings().hoe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9,60f)
            );

    public static final Item CLASSITE_HELMET = register(
            "classite_helmet",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.CLASSITE_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );
    public static final Item CLASSITE_CHESTPLATE = register("classite_chestplate",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.CLASSITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CLASSITE_LEGGINGS = register(
            "classite_leggings",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.CLASSITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CLASSITE_BOOTS = register(
            "classite_boots",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.CLASSITE_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );

    public static final Item GRAV_BOOTS = register(
            "grav_boots",
            GravBoots::new,
            new Item.Settings().armor(GravBoots.GRAVBOOT_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(GravBoots.BASE_DURABILITY))
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RandomJunkMod.MOD_ID, name));
        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
    public static void registerModItems() {
        RandomJunkMod.LOGGER.info("Registering Mod Items for " + RandomJunkMod.MOD_ID);
        ModItemGroup.registerModGroup();
    }
}
