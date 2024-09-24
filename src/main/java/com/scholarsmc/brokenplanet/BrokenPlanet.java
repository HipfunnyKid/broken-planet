package com.scholarsmc.brokenplanet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scholarsmc.brokenplanet.block.BrokenPlanetBlocks;
import com.scholarsmc.brokenplanet.creative.BrokenPlanetItemTab;
import com.scholarsmc.brokenplanet.item.BrokenPlanetItems;
import com.simibubi.create.Create;

import com.simibubi.create.foundation.data.CreateRegistrate;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokenPlanet implements ModInitializer {
	public static final String ID = "brokenplanet";
	public static final String NAME = "Broken Planet";
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
		BrokenPlanetPartialModels.init();
		BrokenPlanetBlocks.register();
		BrokenPlanetItemTab.register();
		BrokenPlanetItems.register();
		REGISTRATE.register();

	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(BrokenPlanet.ID, path);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
