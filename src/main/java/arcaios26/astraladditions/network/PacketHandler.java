package arcaios26.astraladditions.network;

import arcaios26.astraladditions.network.packets.KeyPressPKT;
import arcaios26.astraladditions.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    private static final SimpleNetworkWrapper HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void register() {
        int disc = 0;
        HANDLER.registerMessage(KeyPressPKT.Handler.class, KeyPressPKT.class, disc++, Side.SERVER);
    }

    public static void sendToServer(IMessage msg) {
        HANDLER.sendToServer(msg);
    }
}
