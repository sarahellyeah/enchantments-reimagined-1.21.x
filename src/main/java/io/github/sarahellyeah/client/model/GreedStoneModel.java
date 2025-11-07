package io.github.sarahellyeah.client.model;

import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockRenderView;

import java.util.function.Supplier;

/**
 * GreedStoneModel wraps the vanilla stone/deepslate model and
 * sometimes renders it as ore when the player has the Greed effect.
 */
public class GreedStoneModel implements FabricBakedModel {
	private final BakedModel original;
	private final BakedModel oreModel;

	public GreedStoneModel(BakedModel original, BakedModel oreModel) {
		this.original = original;
		this.oreModel = oreModel;
	}

	@Override
	public boolean isVanillaAdapter() {
		return false;
	}

	@Override
	public void emitBlockQuads(BlockRenderView world, BlockState state, BlockPos pos,
							   Supplier<RandomGenerator> randomSupplier, RenderContext context) {
		PlayerEntity player = MinecraftClient.getInstance().player;

		// Quilt-safe check: scan active effects and compare the underlying effect object
		boolean hasGreed = player != null && player.getStatusEffects().stream()
			.anyMatch(inst -> {
				// In Quilt/Mojang mappings, getEffectType() returns a Holder; unwrap via value()
				var holder = inst.getEffectType();
				var effectObj = holder == null ? null : holder.value();
				return effectObj == io.github.sarahellyeah.effect.ModEffects.GREED;
			});

		if (hasGreed && shouldFakeOre(world, pos, state)) {
			((FabricBakedModel) oreModel).emitBlockQuads(world, state, pos, randomSupplier, context);
			return;
		}

		((FabricBakedModel) original).emitBlockQuads(world, state, pos, randomSupplier, context);
	}

	/**
	 * Decide if this stone/deepslate block should render as fake ore.
	 * Rule: Only if exposed to air, and 30% chance when bordering a real ore.
	 */
	private boolean shouldFakeOre(BlockRenderView world, BlockPos pos, BlockState state) {
		if (!isExposed(world, pos)) return false;

		// If any neighbor is an ore (explicit checks), roll 30% chance
		for (Direction dir : Direction.values()) {
			BlockState neighbor = world.getBlockState(pos.offset(dir));
			if (isOre(neighbor)) {
				return RandomGenerator.createLegacy(pos.asLong()).nextFloat() < 0.3f;
			}
		}
		return false;
	}

	private boolean isOre(BlockState state) {
		// Explicit vanilla ore checks (overworld + deepslate + nether)
		return state.isOf(Blocks.COAL_ORE) || state.isOf(Blocks.DEEPSLATE_COAL_ORE)
			|| state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE)
			|| state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.DEEPSLATE_COPPER_ORE)
			|| state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE)
			|| state.isOf(Blocks.REDSTONE_ORE) || state.isOf(Blocks.DEEPSLATE_REDSTONE_ORE)
			|| state.isOf(Blocks.LAPIS_ORE) || state.isOf(Blocks.DEEPSLATE_LAPIS_ORE)
			|| state.isOf(Blocks.EMERALD_ORE) || state.isOf(Blocks.DEEPSLATE_EMERALD_ORE)
			|| state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE)
			|| state.isOf(Blocks.NETHER_GOLD_ORE) || state.isOf(Blocks.NETHER_QUARTZ_ORE);
	}

	/**
	 * Helper: is this block exposed to air?
	 */
	private boolean isExposed(BlockRenderView world, BlockPos pos) {
		for (Direction dir : Direction.values()) {
			if (world.getBlockState(pos.offset(dir)).isAir()) {
				return true;
			}
		}
		return false;
	}
}
