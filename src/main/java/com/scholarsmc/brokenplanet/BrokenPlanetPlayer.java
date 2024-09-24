package com.scholarsmc.brokenplanet;

import com.mojang.authlib.GameProfile;

import com.scholarsmc.brokenplanet.item.BrokenPlanetItems;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BrokenPlanetPlayer extends Player {
	public BrokenPlanetPlayer(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
		super(level, pos, yRot, gameProfile);
	}
	@Override
	public void tick() {
		gasMaskTick();
	}
	public boolean isSpectator() {
		return false;
	}

	public boolean isCreative() {
		return false;
	}

	private void gasMaskTick() {
		ItemStack itemStack = this.getItemBySlot(EquipmentSlot.HEAD);
		if (itemStack.is(BrokenPlanetItems.GAS_MASK.asItem())) {
			this.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
		}
	}
}
