package com.scholarsmc.brokenplanet.item;

import static com.scholarsmc.brokenplanet.BrokenPlanet.REGISTRATE;

import com.scholarsmc.brokenplanet.creative.BrokenPlanetItemTab;
import com.scholarsmc.brokenplanet.item.models.GasMaskModel;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

import earth.terrarium.adastra.common.tags.ModItemTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

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

	public static void register() {}

}
