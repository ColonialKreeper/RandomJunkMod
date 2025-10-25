package com.colonialkreeper.randomjunkmod.armor;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import static com.colonialkreeper.randomjunkmod.items.ItemRegister.register;

public class ArmorRegister {

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

    public static void registerArmorItems() {
        RandomJunkMod.LOGGER.info("Registering Armor Items for " + RandomJunkMod.MOD_ID);
    }
}
