package io.github.sarahellyeah;

import net.fabricmc.api.ClientModInitializer;

public class EnchReiClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EnchRei.LOGGER.info("Client entrypoint initialized for {}", EnchRei.MOD_ID);
	}
}
