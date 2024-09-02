package com.scholarsmc.voxelrunners.item;

import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static com.simibubi.create.AllTags.forgeItemTag;
import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.CRUSHED_RAW_MATERIALS;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;

public class VoxelRunnersItems {

	static {
		REGISTRATE.setCreativeTab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key());
	}

//	public static final ItemEntry<Item> HONEYED_APPLE = REGISTRATE.item("honeyed_apple", Item::new)
//			.properties(p -> p.food(new FoodProperties.Builder().nutrition(8)
//					.saturationMod(0.8F)
//					.build()))
//			.register();

	public static void register() {}

}
