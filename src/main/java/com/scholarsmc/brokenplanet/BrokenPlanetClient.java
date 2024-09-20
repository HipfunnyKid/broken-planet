package com.scholarsmc.brokenplanet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BrokenPlanetClient implements ClientModInitializer {
	public void onInitializeClient() {
		// To make some parts of the block transparent (like glass, saplings and doors):
		//BlockRenderLayerMap.INSTANCE.putBlock(VoxelRunnersBlocks.SHIP_HOLOGRAM, RenderLayer.getCutout());

		// To make some parts of the block translucent (like ice, stained glass and portal)
		//BlockRenderLayerMap.INSTANCE.putBlock(VoxelRunnersBlocks.SHIP_HOLOGRAM, RenderLayer.getTranslucent());
	}
}
