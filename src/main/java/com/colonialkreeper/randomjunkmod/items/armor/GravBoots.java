package com.colonialkreeper.randomjunkmod.items.armor;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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


public class GravBoots extends Item {

    public static final int BASE_DURABILITY = 50;

    public static final RegistryKey<EquipmentAsset> GRAVBOOT_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(RandomJunkMod.MOD_ID, "classite"));
    public static final TagKey<Item> REPAIRS_CLASSITE_ARMOR =
            TagKey.of(Registries.ITEM.getKey(), Identifier.of(RandomJunkMod.MOD_ID, "repairs_classite_armor"));

    public static final ArmorMaterial GRAVBOOT_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 0,
                    EquipmentType.CHESTPLATE, 0,
                    EquipmentType.LEGGINGS, 0,
                    EquipmentType.BOOTS, 3
            ),
            3,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            1.0F,
            0.0F,
            REPAIRS_CLASSITE_ARMOR,
            GRAVBOOT_ARMOR_MATERIAL_KEY
    );

    private static final AttributeModifiersComponent GRAVITY_MODIFIERS = AttributeModifiersComponent.builder()
            .add(EntityAttributes.GRAVITY,
                    new EntityAttributeModifier(
                            Identifier.of(RandomJunkMod.MOD_ID, "grav_boots"),
                            -0.06,
                            EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    AttributeModifierSlot.forEquipmentSlot(EquipmentSlot.FEET))
            .build();

    public GravBoots(Settings settings) {
        super(settings.attributeModifiers(GRAVITY_MODIFIERS)); // ⚡ Use the settings passed in
    }
}
