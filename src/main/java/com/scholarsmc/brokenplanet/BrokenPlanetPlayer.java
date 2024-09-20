package com.scholarsmc.brokenplanet;

import com.mojang.authlib.GameProfile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class BrokenPlanetPlayer extends Player {

	public void tick(){
//		this.gasMaskTick();
	}

	public BrokenPlanetPlayer(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
		super(level, pos, yRot, gameProfile);
	}

//	private void gasMaskTick() {
//		ItemStack itemStack = this.getItemBySlot(EquipmentSlot.HEAD);
//		if (itemStack.is(VoxelRunnersItems.GAS_MASK.asItem()) && !this.isEyeInFluid(FluidTags.WATER)) {
//			this.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
//		}
//	}
}
