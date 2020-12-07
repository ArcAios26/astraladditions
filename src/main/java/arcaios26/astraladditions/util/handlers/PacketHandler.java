package arcaios26.astraladditions.util.handlers;

import arcaios26.astraladditions.Reference;
import arcaios26.astraladditions.util.network.packets.PktItemEffectRender;
import arcaios26.astraladditions.util.network.packets.PktKeyPress;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    private static final SimpleNetworkWrapper HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void init() {
        int disc = 0;
        HANDLER.registerMessage(PktKeyPress.Handler.class, PktKeyPress.class, disc++, Side.SERVER);
        HANDLER.registerMessage(PktItemEffectRender.Handler.class, PktItemEffectRender.class, disc++, Side.CLIENT);
    }

    public static void sendToServer(IMessage msg) {
        HANDLER.sendToServer(msg);
    }

    public static void sendTo(IMessage msg, EntityPlayerMP player) { HANDLER.sendTo(msg, player);}
}
