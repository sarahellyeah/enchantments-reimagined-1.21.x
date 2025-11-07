package io.github.sarahellyeah.effect;

import io.github.sarahellyeah.EnchRei;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {

	public static final StatusEffect GREED = registerStatusEffect("greed", new GreedEffect(StatusEffectType.HARMFUL, 0xB8860B));

	private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
		return Registry.register(Registries.STATUS_EFFECT, Identifier.of(EnchRei.MOD_ID, name), statusEffect);
	}

	public static void registerEffects() {
		EnchRei.LOGGER.info("Registering Mod Effects for " + EnchRei.MOD_ID);
	}
}
