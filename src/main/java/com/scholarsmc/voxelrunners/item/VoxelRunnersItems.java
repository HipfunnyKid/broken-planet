package com.scholarsmc.voxelrunners.item;

import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.item.CombustibleItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.RegistryObject;

import static com.scholarsmc.voxelrunners.VoxelRunners.ITEMS;
import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.forgeItemTag;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;

public class VoxelRunnersItems {
    static {
        REGISTRATE.setCreativeTab(VoxelRunnersItemTab.VOXELRUNNERS_CREATIVE_TAB);
    }

    //YIPPEE ITEMS PIPEBOMB YUMMY ac
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(100).saturationMod(100f).build())));
   // public static final ItemEntry<Item>
      //      rubber = ingredient("rubber");

    public static final ItemEntry<CombustibleItem> COAL_PIECE = REGISTRATE.item("coal_piece", CombustibleItem::new)
            .onRegister(i -> i.setBurnTime(200))
            .register();

    private static ItemEntry<Item> ingredient(String name) {
        return REGISTRATE.item(name, Item::new)
                .register();
    }

    private static ItemEntry<SimpleFoiledItem> foilIngredient(String name) {
        return REGISTRATE.item(name, SimpleFoiledItem::new)
                .register();
    }

    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }

    @SafeVarargs
    private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
        return REGISTRATE.item(name, Item::new)
                .tag(tags)
                .register();
    }

    public static void register() {}
}
