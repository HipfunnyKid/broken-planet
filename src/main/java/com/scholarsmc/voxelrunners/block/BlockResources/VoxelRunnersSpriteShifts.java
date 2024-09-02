package com.scholarsmc.voxelrunners.block.BlockResources;

import com.scholarsmc.voxelrunners.VoxelRunners;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;
import com.simibubi.create.foundation.utility.Couple;

public class VoxelRunnersSpriteShifts {

	public static final CTSpriteShiftEntry VOXEL_CASING;



	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}

	private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
		return SpriteShifter.get(Create.asResource(originalLocation), Create.asResource(targetLocation));
	}

	private static Couple<CTSpriteShiftEntry> stockpile(String name) {
		final String prefixed = "block/stockpile/stockpile_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, VoxelRunners.asResource(prefixed + "_small"),
						VoxelRunners.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}

	private static Couple<CTSpriteShiftEntry> reservoir(String name) {
		final String prefixed = "block/reservoir/reservoir_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, VoxelRunners.asResource(prefixed + "_small"),
						VoxelRunners.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}
	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, VoxelRunners.asResource("block/" + blockTextureName), VoxelRunners.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}

	static {
		VOXEL_CASING = omni("voxel_casing");
	}

	public static void register(){}
}
