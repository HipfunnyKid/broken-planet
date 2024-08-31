package com.scholarsmc.voxelrunners.block;

import com.scholarsmc.voxelrunners.VoxelRunners;
import com.scholarsmc.voxelrunners.block.BlockResources.VoxelRunnersBlockSpriteShifts;
import com.scholarsmc.voxelrunners.creative.VoxelRunnersItemTab;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.tterrag.registrate.AbstractRegistrate;

import static com.scholarsmc.voxelrunners.VoxelRunners.MODID;
import static com.scholarsmc.voxelrunners.VoxelRunners.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

@SuppressWarnings({"unused", "removal", "all"})
public class VoxelRunnersBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    static {
        REGISTRATE.setCreativeTab(VoxelRunnersItemTab.VOXELRUNNERS_CREATIVE_TAB);
    }


//    public static final BlockEntry<Block> ponder_stone_generation =
//            REGISTRATE.block("ponder_stone_generation", Block::new)
//                    .simpleItem()
//                    .register();

//    public static final BlockEntry<CasingBlock> VOXEL_CASING;
//    static{
//        VOXEL_CASING = ((BlockBuilder)Create.REGISTRATE.block("voxel_casing", CasingBlock::new).properties((p) -> {
//            return p.mapColor(MapColor.PODZOL);
//        }).transform(BuilderTransformers.casing(() -> {
//            return VoxelRunnersBlockSpriteShifts.VOXEL_CASING;
//        }))).register();
//    }
    public static final BlockEntry<CasingBlock> VOXEL_CASING = REGISTRATE.block("voxel_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(BuilderTransformers.casing(() -> VoxelRunnersBlockSpriteShifts.VOXEL_CASING))
            .item()
            .tab(VoxelRunnersItemTab.VOXELRUNNERS_CREATIVE_TAB.getKey())
            .build()
            .register();


    //public static final BlockEntry<CasingBlock> voxel_casing = REGISTRATE.block("voxel_casing", CasingBlock::new)
      //      .transform(BuilderTransformers.casing(() -> VoxelRunnersBlockSpriteShifts.VOXEL_CASING))
        //    .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
          //  .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            //.lang("Voxel Casing")
            //.simpleItem()
            //.register();


    public static void register() {
    }
}
