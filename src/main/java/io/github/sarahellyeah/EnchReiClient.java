package io.github.sarahellyeah;

import io.github.sarahellyeah.client.model.GreedStoneModel;
import net.fabricmc.api.ClientModInitializer;

public class EnchReiClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EnchRei.LOGGER.info("Client entrypoint initialized for {}", EnchRei.MOD_ID);
	}

}
