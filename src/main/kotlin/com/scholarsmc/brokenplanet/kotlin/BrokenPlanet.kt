package com.scholarsmc.brokenplanet.kotlin

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory
object BrokenPlanet : ModInitializer {
    private val logger = LoggerFactory.getLogger("brokenplanet")

	override fun onInitialize() {
        logger.info("Initializing Broken Planet Kotlin Classes")
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
	}
}
