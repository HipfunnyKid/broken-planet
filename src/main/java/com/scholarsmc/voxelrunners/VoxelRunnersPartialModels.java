package com.scholarsmc.voxelrunners;

import com.jozufozu.flywheel.core.PartialModel;

public class VoxelRunnersPartialModels {
	public static final PartialModel

	GAS_MASK = item("gas_mask")

			;
	private static PartialModel block(String path) {
		return new PartialModel(VoxelRunners.asResource("block/" + path));
	}
	private static PartialModel item(String path) {
		return new PartialModel(VoxelRunners.asResource("item/" + path));
	}

	private static PartialModel entity(String path) {
		return new PartialModel(VoxelRunners.asResource("entity/" + path));
	}

	public static void init() {
		// init static fields
	}
}
