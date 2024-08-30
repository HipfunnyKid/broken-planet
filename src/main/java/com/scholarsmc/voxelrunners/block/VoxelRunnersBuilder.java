package com.scholarsmc.voxelrunners.block;


import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.HorizontalCTBehaviour;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;


import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Supplier;
import static com.simibubi.create.foundation.data.CreateRegistrate.casingConnectivity;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;

@SuppressWarnings({"removal"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class VoxelRunnersBuilder {

   //public static <B extends HazardBlock> NonNullUnaryOperator<BlockBuilder<B, CreateRegistrate>> hazard(
    //       Supplier<CTSpriteShiftEntry> ct) {
      //  return b -> b.initialProperties(SharedProperties::stone)
        //        .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
          //      .transform(axeOrPickaxe())
            //    .blockstate((c, p) -> p.simpleBlock(c.get()))
              //  .onRegister(connectedTextures(() -> new EncasedCTBehaviour(ct.get())))
                //.onRegister(casingConnectivity((block, cc) -> cc.makeCasing(block, ct.get())))
                //.tag(AllTags.AllBlockTags.CASING.tag)
                //.item()
                //.tag(AllTags.AllItemTags.CASING.tag)
      //          .build();
    //}

    public static <B extends Block> NonNullUnaryOperator<BlockBuilder<B, CreateRegistrate>> block(
            Supplier<CTSpriteShiftEntry> ct) {
        return b -> b.initialProperties(SharedProperties::stone)
                .blockstate((c, p) -> p.simpleBlock(c.get()))
                .onRegister(connectedTextures(() -> new EncasedCTBehaviour(ct.get())))
                .onRegister(casingConnectivity((block, cc) -> cc.makeCasing(block, ct.get())))
                .item()
                .build();
    }

    public static <B extends Block> NonNullUnaryOperator<BlockBuilder<B, CreateRegistrate>> blockv2(
            Supplier<CTSpriteShiftEntry> ct, Supplier<CTSpriteShiftEntry> ct2) {
        return b -> b.initialProperties(SharedProperties::stone)
                .blockstate((c, p) -> p.simpleBlock(c.get(), p.models()
                        .cubeColumn(c.getName(), ct.get()
                                        .getOriginalResourceLocation(),
                                ct2.get()
                                        .getOriginalResourceLocation())))
                .onRegister(connectedTextures(() -> new HorizontalCTBehaviour(ct.get(), ct2.get())))
                .onRegister(casingConnectivity((block, cc) -> cc.makeCasing(block, ct.get())))
                .item()
                .build();
    }

    //public static <B extends YIPPEESlidingDoorBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> slidingDoor(String type) {
    //    return b -> b.initialProperties(() -> Blocks.OAK_DOOR) // for villager AI..
    //            .properties(p -> p.strength(3.0F, 6.0F))
    //           .blockstate((c, p) -> {
    //                ModelFile bottom = AssetLookup.partialBaseModel(c, p, "bottom");
    //                ModelFile top = AssetLookup.partialBaseModel(c, p, "top");
    //                p.doorBlock(c.get(), bottom, bottom, bottom, bottom, top, top, top, top);
    //            })
    //            .addLayer(() -> RenderType::cutoutMipped)
    //            .transform(pickaxeOnly())
    //            .onRegister(interactionBehaviour(new DoorMovingInteraction()))
    //            .onRegister(movementBehaviour(new SlidingDoorMovementBehaviour()))
    //            .tag(BlockTags.DOORS)
    //            .tag(BlockTags.WOODEN_DOORS) // for villager AI
    //            .tag(AllTags.AllBlockTags.NON_DOUBLE_DOOR.tag)
    //            .item()
    //            .tag(ItemTags.DOORS)
    //            .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
    //            .model((c, p) -> p.blockSprite(c, p.modLoc("item/" + type + "_door")))
    //            .build();
    //}

}