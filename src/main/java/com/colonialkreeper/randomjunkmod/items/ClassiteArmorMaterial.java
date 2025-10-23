package com.colonialkreeper.randomjunkmod.items;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ClassiteArmorMaterial {
    public static final int BASE_DURABILITY = 50;

    public static final RegistryKey<EquipmentAsset> CLASSITE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(RandomJunkMod.MOD_ID, "classite"));
    public static final TagKey<Item> REPAIRS_CLASSITE_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(RandomJunkMod.MOD_ID, "repairs_classite_armor"));

    public static final ArmorMaterial CLASSITE_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 5,
                    EquipmentType.CHESTPLATE, 10,
                    EquipmentType.LEGGINGS, 8,
                    EquipmentType.BOOTS, 5
            ),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            3.0F,
            0.5F,
            REPAIRS_CLASSITE_ARMOR,
            CLASSITE_ARMOR_MATERIAL_KEY
    );




}
