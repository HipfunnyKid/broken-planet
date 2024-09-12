package com.scholarsmc.voxelrunners.block;

import com.google.common.collect.UnmodifiableIterator;
import com.scholarsmc.voxelrunners.block.BlockResources.VoxelRunnersSpriteShifts;
import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;

import io.github.fabricators_of_create.porting_lib.models.virtual.TranslucentBakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.text.html.BlockView;

import java.util.Iterator;
import java.util.function.ToIntFunction;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;
import static com.simibubi.create.content.redstone.displayLink.AllDisplayBehaviours.assignDataBehaviour;
import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.BlockStateGen.directionalBlockProvider;
import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.CreateRegistrate.blockModel;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOnly;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;
import static net.minecraft.core.Direction.Axis.CODEC;
import static net.minecraft.world.level.block.Block.byItem;
import static net.minecraft.world.level.block.Blocks.WHITE_CONCRETE;
import static net.minecraft.world.level.block.Blocks.log;
import static net.minecraft.world.level.block.DirectionalBlock.FACING;

public class VoxelRunnersBlocks {
	static {
		REGISTRATE.setCreativeTab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key());
	}

//	public static final BlockEntry<CasingBlock> VOXEL_CASING = REGISTRATE.block("voxel_casing", CasingBlock::new)
//			.properties(p -> p.mapColor(MapColor.PODZOL))
//			.transform(BuilderTransformers.casing(() -> VoxelRunnersSpriteShifts.VOXEL_CASING))
//			.register();
	public static final BlockEntry<CasingBlock> VOXEL_CASING = REGISTRATE.block("voxel_casing", CasingBlock::new)
		.properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
				.requiresCorrectToolForDrops()
				.sound(SoundType.COPPER))
		.transform(BuilderTransformers.casing(() -> VoxelRunnersSpriteShifts.VOXEL_CASING))
		.item()
		.tab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key())
		.build()
		.register();

	public static final BlockEntry<RotatedPillarBlock> CHARRED_LOG = REGISTRATE.block("charred_log", RotatedPillarBlock::new)
			.properties(p -> p.mapColor(MapColor.WOOD)
					.requiresCorrectToolForDrops()
					.sound(SoundType.BASALT))
			.blockstate(BlockStateGen.directionalBlockProvider(true))
			.item()
			.tab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key())
			.build()
			.register();

	public static final BlockEntry<Block> SHIP_BLOCK = REGISTRATE.block("ship_block", Block::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
					.noOcclusion())
			.item()
			.tab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key())
			.build()
			.register();

	public static final BlockEntry<GlassBlock> SHIP_HOLOGRAM = REGISTRATE.block("ship_hologram", GlassBlock::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
					.noOcclusion()
					.lightLevel(state -> 8))
			.item()
			.tab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key())
			.build()
			.register();

	public static void register() {}
}
