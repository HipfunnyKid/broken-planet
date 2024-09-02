package com.scholarsmc.voxelrunners.block;

import com.scholarsmc.voxelrunners.block.BlockResources.VoxelRunnersSpriteShifts;
import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;
import static com.simibubi.create.content.redstone.displayLink.AllDisplayBehaviours.assignDataBehaviour;
import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOnly;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

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

	public static void register() {}
}
