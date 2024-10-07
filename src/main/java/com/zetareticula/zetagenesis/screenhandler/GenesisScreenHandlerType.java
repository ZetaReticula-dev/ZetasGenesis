package com.zetareticula.zetagenesis.screenhandler;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.block.Block;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;

public class GenesisScreenHandlerType {

    public static final ScreenHandlerType<BasketBlockScreenHandler> BASKET_BLOCK_SCREEN =
            register("basket_block_screen", BasketBlockScreenHandler::new, BlockPosPayload.PACKET_CODEC);

    public static final ScreenHandlerType<CabinetBlockScreenHandler> CABINET_BLOCK_SCREEN =
            register("cabinet_block_screen", CabinetBlockScreenHandler::new, BlockPosPayload.PACKET_CODEC);

    public static final ScreenHandlerType<VariantChestBlockScreenHandler> VARIANT_CHEST_BLOCK_SCREEN =
            register("variant_chest_block_screen", VariantChestBlockScreenHandler::new, BlockPosPayload.PACKET_CODEC);

    public static <T extends ScreenHandler, D extends CustomPayload> ExtendedScreenHandlerType<T, D>
        register(String name, ExtendedScreenHandlerType.ExtendedFactory<T, D> factory,
                 PacketCodec<? super RegistryByteBuf, D> codec) {
        return Registry.register(Registries.SCREEN_HANDLER, ZetaGenesis.id(name), new ExtendedScreenHandlerType<>(factory, codec));
    }

    public static void registerGenesisScreenType() {
        ZetaGenesis.LOGGER.info("Registering Genesis Screen Type for " + ZetaGenesis.MOD_ID);
    }
}
