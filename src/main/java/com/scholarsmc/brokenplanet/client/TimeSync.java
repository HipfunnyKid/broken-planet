package com.scholarsmc.brokenplanet.client;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.CubicSampler;
import net.minecraft.util.Mth;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.WritableLevelData;
import net.minecraft.world.phys.Vec3;

@Environment(value= EnvType.CLIENT)
public class TimeSync extends ClientLevel {
	private int skyFlashTime;
	private final ClientChunkCache chunkSource;
	//Will sync client side irl time with in game skybox/visibility

	Calendar calendar = Calendar.getInstance();

	LocalTime midnight = LocalTime.MIDNIGHT;
	LocalTime currentTime = LocalTime.now();

	long seconds = ChronoUnit.SECONDS.between(midnight, currentTime);

	public long current_time = ((seconds * 24000) / 86400);
	public float current_ingame_time = current_time;

	public final ClientLevel.ClientLevelData clientLevelData;

	public TimeSync(ClientPacketListener connection, ClientLevelData clientLevelData, ResourceKey<Level> dimension, Holder<DimensionType> dimensionType, int viewDistance, int serverSimulationDistance, Supplier<ProfilerFiller> profiler, LevelRenderer levelRenderer, boolean isDebug, long biomeZoomSeed, ClientLevelData clientLevelData1) {
		super(connection, clientLevelData, dimension, dimensionType, viewDistance, serverSimulationDistance, profiler, levelRenderer, isDebug, biomeZoomSeed);
		this.clientLevelData = clientLevelData1;
		chunkSource = new ClientChunkCache(this, viewDistance);
	}
	@Override
	public void setGameTime(long gameTime) {
		this.clientLevelData.setGameTime(current_time);
	}
	/**
	 * Runs a single tick for the world
	 */
	public void tick(BooleanSupplier hasTimeLeft) {
		this.getWorldBorder().tick();
		this.tickTime();
		if (this.skyFlashTime > 0) {
			this.setSkyFlashTime(this.skyFlashTime - 1);
		}
		this.getProfiler().push("blocks");
		this.chunkSource.tick(hasTimeLeft, true);
		this.getProfiler().pop();
	}

	private void tickTime() {
		this.setGameTime(current_time);
		if (this.levelData.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
			this.setDayTime(current_time);
		}

	}
	/**
	 * Sets the client side world time
	 */

	@Override
	public void setDayTime(long time) {
		if (time < 0L) {
			time = -time;
			this.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, null);
		} else {
			this.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, null);
		}
		this.clientLevelData.setDayTime(current_time);
	}
	@Override
	public float getSkyDarken(float partialTick) {
		float f = current_time;
		float g = 1.0f - (Mth.cos(f * ((float)Math.PI * 2)) * 2.0f + 0.2f);
		g = Mth.clamp(g, 0.0f, 1.0f);
		g = 1.0f - g;
		g *= 1.0f - this.getRainLevel(partialTick) * 5.0f / 16.0f;
		return (g *= 1.0f - this.getThunderLevel(partialTick) * 5.0f / 16.0f) * 0.8f + 0.2f;
	}
	@Override
	public Vec3 getSkyColor(Vec3 pos, float partialTick) {
		int o;
		float n;
		float m;
		float l;
		float f = current_time;
		Vec3 vec3 = pos.subtract(2.0, 2.0, 2.0).scale(0.25);
		BiomeManager biomeManager = this.getBiomeManager();
		Vec3 vec32 = CubicSampler.gaussianSampleVec3(vec3, (x, y, z) -> Vec3.fromRGB24(biomeManager.getNoiseBiomeAtQuart(x, y, z).value().getSkyColor()));
		float g = Mth.cos(f * ((float)Math.PI * 2)) * 2.0f + 0.5f;
		g = Mth.clamp(g, 0.0f, 1.0f);
		float h = (float)vec32.x * g;
		float i = (float)vec32.y * g;
		float j = (float)vec32.z * g;
		float k = this.getRainLevel(partialTick);
		if (k > 0.0f) {
			l = (h * 0.3f + i * 0.59f + j * 0.11f) * 0.6f;
			m = 1.0f - k * 0.75f;
			h = h * m + l * (1.0f - m);
			i = i * m + l * (1.0f - m);
			j = j * m + l * (1.0f - m);
		}
		if ((l = this.getThunderLevel(partialTick)) > 0.0f) {
			m = (h * 0.3f + i * 0.59f + j * 0.11f) * 0.2f;
			n = 1.0f - l * 0.75f;
			h = h * n + m * (1.0f - n);
			i = i * n + m * (1.0f - n);
			j = j * n + m * (1.0f - n);
		}
		if ((o = this.getSkyFlashTime()) > 0) {
			n = (float)o - partialTick;
			if (n > 1.0f) {
				n = 1.0f;
			}
			h = h * (1.0f - (n *= 0.45f)) + 0.8f * n;
			i = i * (1.0f - n) + 0.8f * n;
			j = j * (1.0f - n) + 1.0f * n;
		}
		return new Vec3(h, i, j);


	}

	@Environment(value=EnvType.CLIENT)
	public static class ClientLevelData extends ClientLevel.ClientLevelData
			implements WritableLevelData {
		private long gameTime;
		private long dayTime;

		public ClientLevelData(Difficulty difficulty, boolean hardcore, boolean isFlat) {
			super(difficulty, hardcore, isFlat);
		}

		@Override
		public long getGameTime() {
			return this.gameTime;
		}

		@Override
		public long getDayTime() {
			return this.dayTime;
		}

		@Override
		public void setGameTime(long gameTime) {
			this.gameTime = gameTime;
		}

		@Override
		public void setDayTime(long dayTime) {
			this.dayTime = dayTime;
		}
	}
}
