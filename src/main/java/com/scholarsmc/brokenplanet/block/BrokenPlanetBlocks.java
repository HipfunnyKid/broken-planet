package com.scholarsmc.brokenplanet.block;

import static com.scholarsmc.brokenplanet.BrokenPlanet.REGISTRATE;

import com.scholarsmc.brokenplanet.block.BlockResources.BrokenPlanetSpriteShifts;
import com.scholarsmc.brokenplanet.creative.BrokenPlanetItemTab;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class BrokenPlanetBlocks {
	public static final BlockEntry<CasingBlock> VOXEL_CASING = REGISTRATE.block("voxel_casing", CasingBlock::new)
		.properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
				.requiresCorrectToolForDrops()
				.sound(SoundType.COPPER))
		.transform(BuilderTransformers.casing(() -> BrokenPlanetSpriteShifts.VOXEL_CASING))
		.item()
		.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
		.build()
		.register();
	public static final BlockEntry<RotatedPillarBlock> CHARRED_LOG = REGISTRATE.block("charred_log", RotatedPillarBlock::new)
			.properties(p -> p.mapColor(MapColor.WOOD)
					.requiresCorrectToolForDrops()
					.sound(SoundType.BASALT))
			.blockstate(BlockStateGen.directionalBlockProvider(true))
			.item()
			.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
			.build()
			.register();

	public static final BlockEntry<Block> SHIP_BLOCK = REGISTRATE.block("ship_block", Block::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
					.noOcclusion())
			.item()
			.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
			.build()
			.register();

	public static final BlockEntry<GlassBlock> SHIP_HOLOGRAM = REGISTRATE.block("ship_hologram", GlassBlock::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
					.noOcclusion()
					.lightLevel(state -> 8))
			.item()
			.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
			.build()
			.register();

	public static final BlockEntry<CasingBlock> SPACESHIP_PADDING = REGISTRATE.block("spaceship_padding", CasingBlock::new)
			.properties(p -> p.mapColor(MapColor.WOOL)
					.requiresCorrectToolForDrops()
					.sound(SoundType.WOOL))
			.transform(BuilderTransformers.casing(() -> BrokenPlanetSpriteShifts.SPACESHIP_PADDING))
			.item()
			.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
			.build()
			.register();
	public static void register() {}
}
