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
	public static final Item ENRICHED_DRAGONS_BREATH = registerItem("enriched_dragons_breath", new Item(new Item.Settings()));
	public static final Item ETERNAL_FLAME_POTION = registerItem("eternal_flame_potion", new Item(new Item.Settings()));
	public static final Item MERMAID_POTION = registerItem("mermaid_potion", new Item(new Item.Settings()));
	public static final Item ESSENCE_OF_POWER = registerItem("essence_of_power", new Item(new Item.Settings()));
	public static final Item MANA_CRYSTAL = registerItem("mana_crystal", new Item(new Item.Settings()));
	public static final Item BLESSED_MANA_CRYSTAL = registerItem("blessed_mana_crystal", new Item(new Item.Settings()));
	public static final Item CORRUPTED_MANA_CRYSTAL = registerItem("corrupted_mana_crystal", new Item(new Item.Settings()));
	public static final Item DAMAGED_MANA_CRYSTAL = registerItem("damaged_mana_crystal", new Item(new Item.Settings()));
	public static final Item SCORCH_CRYSTAL = registerItem("scorch_crystal", new Item(new Item.Settings()));
	public static final Item CORRUPTED_SCORCH_CRYSTAL = registerItem("corrupted_scorch_crystal", new Item(new Item.Settings()));
	public static final Item BLESSED_SCORCH_CRYSTAL = registerItem("blessed_scorch_crystal", new Item(new Item.Settings()));
	public static final Item DAMAGED_SCORCH_CRYSTAL = registerItem("damaged_scorch_crystal", new Item(new Item.Settings()));
	public static final Item FROST_CRYSTAL = registerItem("frost_crystal", new Item(new Item.Settings()));
	public static final Item CORRUPTED_FROST_CRYSTAL = registerItem("corrupted_frost_crystal", new Item(new Item.Settings()));
	public static final Item BLESSED_FROST_CRYSTAL = registerItem("blessed_frost_crystal", new Item(new Item.Settings()));
	public static final Item DAMAGED_FROST_CRYSTAL = registerItem("damaged_frost_crystal", new Item(new Item.Settings()));
	public static final Item POWER_CRYSTAL = registerItem("power_crystal", new Item(new Item.Settings()));
	public static final Item CORRUPTED_POWER_CRYSTAL = registerItem("corrupted_power_crystal", new Item(new Item.Settings()));
	public static final Item BLESSED_POWER_CRYSTAL = registerItem("blessed_power_crystal", new Item(new Item.Settings()));
	public static final Item DAMAGED_POWER_CRYSTAL = registerItem("damaged_power_crystal", new Item(new Item.Settings()));
	public static final Item FORTUNE_CRYSTAL = registerItem("fortune_crystal", new Item(new Item.Settings()));
	public static final Item CORRUPTED_FORTUNE_CRYSTAL = registerItem("corrupted_fortune_crystal", new Item(new Item.Settings()));
	public static final Item BLESSED_FORTUNE_CRYSTAL = registerItem("blessed_fortune_crystal", new Item(new Item.Settings()));
	public static final Item DAMAGED_FORTUNE_CRYSTAL = registerItem("damaged_fortune_crystal", new Item(new Item.Settings()));

	public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(EnchRei.MOD_ID, name), item);
	}

	public static void registerModItems() {
		EnchRei.LOGGER.info("Registering Mod Items for " + EnchRei.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.MAGMA_CREAM, ModItems.GLOWING_MAGMA);
			entries.addAfter(ModItems.GLOWING_MAGMA, ModItems.ENRICHED_DRAGONS_BREATH);
			entries.addAfter(ModItems.ENRICHED_DRAGONS_BREATH, ModItems.ETERNAL_FLAME_POTION);
			entries.addAfter(ModItems.ETERNAL_FLAME_POTION, ModItems.MERMAID_POTION);
			entries.addAfter(ModItems.MERMAID_POTION, ModItems.ESSENCE_OF_POWER);
			entries.addAfter(Items.AIR, ModItems.MANA_CRYSTAL);
			entries.addAfter(ModItems.MANA_CRYSTAL, ModItems.BLESSED_MANA_CRYSTAL);
			entries.addAfter(ModItems.BLESSED_MANA_CRYSTAL, ModItems.CORRUPTED_MANA_CRYSTAL);
			entries.addAfter(ModItems.CORRUPTED_MANA_CRYSTAL, ModItems.DAMAGED_MANA_CRYSTAL);
			entries.addAfter(ModItems.DAMAGED_MANA_CRYSTAL, ModItems.SCORCH_CRYSTAL);
			entries.addAfter(ModItems.SCORCH_CRYSTAL, ModItems.BLESSED_SCORCH_CRYSTAL);
			entries.addAfter(ModItems.BLESSED_SCORCH_CRYSTAL, ModItems.CORRUPTED_SCORCH_CRYSTAL);
			entries.addAfter(ModItems.CORRUPTED_SCORCH_CRYSTAL, ModItems.DAMAGED_SCORCH_CRYSTAL);
			entries.addAfter(ModItems.DAMAGED_SCORCH_CRYSTAL, ModItems.FROST_CRYSTAL);
			entries.addAfter(ModItems.FROST_CRYSTAL, ModItems.BLESSED_FROST_CRYSTAL);
			entries.addAfter(ModItems.BLESSED_FROST_CRYSTAL, ModItems.CORRUPTED_FROST_CRYSTAL);
			entries.addAfter(ModItems.CORRUPTED_FROST_CRYSTAL, ModItems.DAMAGED_FROST_CRYSTAL);
			entries.addAfter(ModItems.DAMAGED_FROST_CRYSTAL, ModItems.FORTUNE_CRYSTAL);
			entries.addAfter(ModItems.FORTUNE_CRYSTAL, ModItems.BLESSED_FORTUNE_CRYSTAL);
			entries.addAfter(ModItems.BLESSED_FORTUNE_CRYSTAL, ModItems.CORRUPTED_FORTUNE_CRYSTAL);
			entries.addAfter(ModItems.CORRUPTED_FORTUNE_CRYSTAL, ModItems.DAMAGED_FORTUNE_CRYSTAL);
			entries.addAfter(ModItems.DAMAGED_FORTUNE_CRYSTAL, ModItems.POWER_CRYSTAL);
			entries.addAfter(ModItems.POWER_CRYSTAL, ModItems.BLESSED_POWER_CRYSTAL);
			entries.addAfter(ModItems.BLESSED_POWER_CRYSTAL, ModItems.CORRUPTED_POWER_CRYSTAL);
			entries.addAfter(ModItems.CORRUPTED_POWER_CRYSTAL, ModItems.DAMAGED_POWER_CRYSTAL);
		});
	}

}
