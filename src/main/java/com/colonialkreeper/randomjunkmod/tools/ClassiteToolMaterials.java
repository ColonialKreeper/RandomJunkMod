package com.colonialkreeper.randomjunkmod.tools;

import com.colonialkreeper.randomjunkmod.armor.ClassiteArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ClassiteToolMaterials {
    public static final ToolMaterial CLASSITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            5000,
            12.0F,
            5.0F,
            25,
            ClassiteArmorMaterial.REPAIRS_CLASSITE_ARMOR
    );
}
