package com.scholarsmc.voxelrunners.item;

import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;

import com.scholarsmc.voxelrunners.item.models.GasMaskModel;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import com.simibubi.create.content.equipment.goggles.GogglesModel;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PlayerHeadItem;
import net.minecraft.world.item.Rarity;

import static com.simibubi.create.AllTags.forgeItemTag;
import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.CRUSHED_RAW_MATERIALS;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;

public class VoxelRunnersItems {

	static {
		REGISTRATE.setCreativeTab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key());
	}

	public static final ItemEntry<GogglesItem> GAS_MASK = REGISTRATE.item("gas_mask", GogglesItem::new)
			.properties(p -> p.stacksTo(1))
			.tab(VoxelRunnersItemTab.VOXEL_RUNNERS_TAB.key())
			.onRegister(CreateRegistrate.itemModel(() -> GasMaskModel::new))
			.lang("Gas Mask")
			.register();

//	public static final ItemEntry<Item> HONEYED_APPLE = REGISTRATE.item("honeyed_apple", Item::new)
//			.properties(p -> p.food(new FoodProperties.Builder().nutrition(8)
//					.saturationMod(0.8F)
//					.build()))
//			.register();
	public static void register() {}

}
