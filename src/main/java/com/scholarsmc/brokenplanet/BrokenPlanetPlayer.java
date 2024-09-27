package com.scholarsmc.brokenplanet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger log = LoggerFactory.getLogger(BrokenPlanetPlayer.class);

	public BrokenPlanetPlayer(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
		super(level, pos, yRot, gameProfile);
	}
	@Override
	public void tick() {

	}
	public boolean isSpectator() {
		return false;
	}

	public boolean isCreative() {
		return false;
	}

	private void turtleHelmetTick() {
		ItemStack itemStack = this.getItemBySlot(EquipmentSlot.HEAD);
		if (itemStack.is(BrokenPlanetItems.GAS_MASK.asItem()) && !this.isEyeInFluid(FluidTags.WATER)) {
			this.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
		}
	}
}
