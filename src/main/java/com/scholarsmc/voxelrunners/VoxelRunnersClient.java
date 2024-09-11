package com.scholarsmc.voxelrunners;

import com.scholarsmc.voxelrunners.block.VoxelRunnersBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

@Environment(EnvType.CLIENT)
public class VoxelRunnersClient implements ClientModInitializer {
	public void onInitializeClient() {
		// To make some parts of the block transparent (like glass, saplings and doors):
		//BlockRenderLayerMap.INSTANCE.putBlock(VoxelRunnersBlocks.SHIP_HOLOGRAM, RenderLayer.getCutout());

		// To make some parts of the block translucent (like ice, stained glass and portal)
		//BlockRenderLayerMap.INSTANCE.putBlock(VoxelRunnersBlocks.SHIP_HOLOGRAM, RenderLayer.getTranslucent());
	}
}
