package com.scholarsmc.voxelrunners.item.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.scholarsmc.voxelrunners.VoxelRunners;
import com.scholarsmc.voxelrunners.VoxelRunnersPartialModels;

import io.github.fabricators_of_create.porting_lib.models.TransformTypeDependentItemBakedModel;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;

public class GasMaskModel extends ForwardingBakedModel implements TransformTypeDependentItemBakedModel {
	protected BakedModel itemModel;

	public GasMaskModel(BakedModel template) {
		this.itemModel = wrapped = template;
	}

	@Override
	public BakedModel applyTransform(ItemDisplayContext cameraItemDisplayContext, PoseStack mat, boolean leftHanded, DefaultTransform defaultTransform) {
		if (cameraItemDisplayContext == ItemDisplayContext.HEAD) {
			BakedModel headGoggles = VoxelRunnersPartialModels.GAS_MASK.get();
			defaultTransform.apply(headGoggles);
			return headGoggles;
		}
		defaultTransform.apply(this);
		return this;
	}
}

