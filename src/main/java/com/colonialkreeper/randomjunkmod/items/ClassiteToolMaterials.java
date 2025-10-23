package com.colonialkreeper.randomjunkmod.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ClassiteToolMaterials {
    public static final ToolMaterial CLASSITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            5000,
            15.0F,
            8.0F,
            25,
            ClassiteArmorMaterial.REPAIRS_CLASSITE_ARMOR
    );
}
