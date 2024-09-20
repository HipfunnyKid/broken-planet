package com.scholarsmc.brokenplanet;

import com.jozufozu.flywheel.core.PartialModel;

public class BrokenPlanetPartialModels {
	public static final PartialModel

	GAS_MASK = item("gas_mask")

			;
	private static PartialModel block(String path) {
		return new PartialModel(BrokenPlanet.asResource("block/" + path));
	}
	private static PartialModel item(String path) {
		return new PartialModel(BrokenPlanet.asResource("item/" + path));
	}

	private static PartialModel entity(String path) {
		return new PartialModel(BrokenPlanet.asResource("entity/" + path));
	}

	public static void init() {
		// init static fields
	}
}
