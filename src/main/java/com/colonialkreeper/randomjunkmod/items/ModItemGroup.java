package com.colonialkreeper.randomjunkmod.items;

import com.colonialkreeper.randomjunkmod.RandomJunkMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(RandomJunkMod.MOD_ID, "item_group"));
    public static final net.minecraft.item.ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.DAY_NIGHT_WAND))
            .displayName(Text.translatable("itemGroup.randomjunkmod"))
            .build();

    public static void registerModGroup() {

        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.DAY_NIGHT_WAND);
            itemGroup.add(ModItems.CLASSITE_GEM);
            itemGroup.add(ModItems.CLASSITE_HELMET);
            itemGroup.add(ModItems.CLASSITE_CHESTPLATE);
            itemGroup.add(ModItems.CLASSITE_LEGGINGS);
            itemGroup.add(ModItems.CLASSITE_BOOTS);
        });
    }

}
