package com.scholarsmc.voxelrunners;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scholarsmc.voxelrunners.block.BlockResources.VoxelRunnersSpriteShifts;
import com.scholarsmc.voxelrunners.block.VoxelRunnersBlocks;
import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;
import com.scholarsmc.voxelrunners.item.VoxelRunnersItems;
import com.simibubi.create.Create;

import com.simibubi.create.foundation.data.CreateRegistrate;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.server.MinecraftServer;

import net.minecraft.server.TickTask;

import net.minecraft.world.ticks.TickAccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoxelRunners implements ModInitializer {
	public static final String ID = "voxelrunners";
	public static final String NAME = "Voxel Runners";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID);

//	@Deprecated
//	public static final Random RANDOM = new Random();

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting()
			.disableHtmlEscaping()
			.create();

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);
		VoxelRunnersBlocks.register();
		VoxelRunnersItemTab.register();
		VoxelRunnersItems.register();

		REGISTRATE.register();

	}
	public void ServerTickEvent() {
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(VoxelRunners.ID, path);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
