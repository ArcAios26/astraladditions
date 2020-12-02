package arcaios26.astraladditions.network;

import arcaios26.astraladditions.network.packets.PktItemEffectRender;
import arcaios26.astraladditions.network.packets.PktKeyPress;
import arcaios26.astraladditions.util.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    private static final SimpleNetworkWrapper HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void register() {
        int disc = 0;
        HANDLER.registerMessage(PktKeyPress.Handler.class, PktKeyPress.class, disc++, Side.SERVER);
        HANDLER.registerMessage(PktItemEffectRender.Handler.class, PktItemEffectRender.class, disc++, Side.CLIENT);
    }

    public static void sendToServer(IMessage msg) {
        HANDLER.sendToServer(msg);
    }

    public static void sendTo(IMessage msg, EntityPlayerMP player) { HANDLER.sendTo(msg, player);}
}
