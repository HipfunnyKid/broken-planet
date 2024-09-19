package com.scholarsmc.voxelrunners;

import com.mojang.authlib.GameProfile;
import com.scholarsmc.voxelrunners.item.VoxelRunnersItems;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.StatsCounter;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class VoxelRunnersPlayer extends Player {

	public void tick(){
		this.gasMaskTick();
	}

	public VoxelRunnersPlayer(Level level, BlockPos pos, float yRot, GameProfile gameProfile) {
		super(level, pos, yRot, gameProfile);
	}

	private void gasMaskTick() {
		ItemStack itemStack = this.getItemBySlot(EquipmentSlot.HEAD);
		if (itemStack.is(VoxelRunnersItems.GAS_MASK.asItem()) && !this.isEyeInFluid(FluidTags.WATER)) {
			this.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false, true));
		}
	}
}
