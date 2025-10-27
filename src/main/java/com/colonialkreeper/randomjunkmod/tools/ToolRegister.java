package com.colonialkreeper.randomjunkmod.tools;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.minecraft.item.Item;

import static com.colonialkreeper.randomjunkmod.items.ItemRegister.register;

public class ToolRegister {

    public static final Item DAY_NIGHT_WAND = register("day_night_wand", DayNightWand::new, new Item.Settings().maxCount(1));

    public static final Item CLASSITE_SWORD = register(
            "classite_sword",
            Item::new,
            new Item.Settings().sword(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 5, 60f)
    );
    public static final Item CLASSITE_PICKAXE = register(
            "classite_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 1, 60f)
    );
    public static final Item CLASSITE_AXE = register(
            "classite_axe",
            Item::new,
            new Item.Settings().axe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9, 60f)
    );
    public static final Item CLASSITE_SHOVEL = register(
            "classite_shovel",
            Item::new,
            new Item.Settings().shovel(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9, 60f)
    );
    public static final Item CLASSITE_HOE = register(
            "classite_hoe",
            Item::new,
            new Item.Settings().hoe(ClassiteToolMaterials.CLASSITE_TOOL_MATERIAL, 9, 60f)
    );

    public static void registerToolItems() {
        RandomJunkMod.LOGGER.info("Registering Tool Items for " + RandomJunkMod.MOD_ID);
    }

}
