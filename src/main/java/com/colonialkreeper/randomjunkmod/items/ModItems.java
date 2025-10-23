package com.colonialkreeper.randomjunkmod.items;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
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

    public static final Item CLASSITE_HELMET = register(
            "classite_helmet",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.INSTANCE, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );
    public static final Item CLASSITE_CHESTPLATE = register("classite_chestplate",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CLASSITE_LEGGINGS = register(
            "classite_leggings",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
    );

    public static final Item CLASSITE_BOOTS = register(
            "classite_boots",
            Item::new,
            new Item.Settings().armor(ClassiteArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(ClassiteArmorMaterial.BASE_DURABILITY))
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
