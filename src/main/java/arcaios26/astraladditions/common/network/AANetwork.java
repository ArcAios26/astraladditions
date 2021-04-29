package arcaios26.astraladditions.common.network;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.network.packets.KeyInputPkt;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class AANetwork {

    private static SimpleChannel INSTANCE;
    private static int ID = 0;

    private static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(AstralAdditions.MODID, "astraladditions"),
                () -> "1.0",
                s -> true,
                s -> true);

        INSTANCE.messageBuilder(KeyInputPkt.class, nextID())
                .encoder(KeyInputPkt::toBytes)
                .decoder(KeyInputPkt::new)
                .consumer(KeyInputPkt::handle)
                .add();

    }

    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}
