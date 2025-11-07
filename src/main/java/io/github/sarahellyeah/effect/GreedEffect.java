package io.github.sarahellyeah.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class GreedEffect extends StatusEffect {
	public GreedEffect(StatusEffectType type, int color) {
		super(StatusEffectType.HARMFUL, 0xB8860B);
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		return super.applyUpdateEffect(entity, amplifier);
	}


}
