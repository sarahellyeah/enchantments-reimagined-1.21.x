package io.github.sarahellyeah.item;

import io.github.sarahellyeah.EnchRei;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

	public static final Item GLOWING_MAGMA = registerItem("glowing_magma", new Item(new Item.Settings()));

	public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(EnchRei.MOD_ID, name), item);
	}

	public static void registerModItems() {
		EnchRei.LOGGER.info("Registering Mod Items for " + EnchRei.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.MAGMA_CREAM, ModItems.GLOWING_MAGMA);
		});
	}

}
