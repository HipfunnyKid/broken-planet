package com.scholarsmc.brokenplanet.item;

import com.scholarsmc.brokenplanet.creative.BrokenPlanetItemTab;

import earth.terrarium.adastra.common.tags.ModItemTags;

import com.scholarsmc.brokenplanet.item.models.GasMaskModel;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import static com.scholarsmc.brokenplanet.BrokenPlanet.REGISTRATE;

public class BrokenPlanetItems {

	static {
		REGISTRATE.setCreativeTab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key());
	}

	public static final ItemEntry<GogglesItem> GAS_MASK = REGISTRATE.item("gas_mask", GogglesItem::new)
			.properties(p -> p.stacksTo(1))
			.properties(p -> {
				if (p instanceof FabricItemSettings fp) {
					fp.equipmentSlot(GogglesItem::getEquipmentSlot);
				}
				return p;
			})
			.tag(ModItemTags.SPACE_SUITS)
			.tab(BrokenPlanetItemTab.BROKEN_PLANET_TAB.key())
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
