package io.github.sarahellyeah;

import io.github.sarahellyeah.effect.ModEffects;
import io.github.sarahellyeah.item.ModItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnchRei implements ModInitializer {
	public final static String MOD_ID = "ench_rei";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {

		ModItems.registerModItems();

		ModEffects.registerEffects();
	}
}
