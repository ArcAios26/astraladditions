package arcaios26.astraladditions.network.packets;

import arcaios26.astraladditions.items.wearable.AstralRing;
import arcaios26.astraladditions.util.AAKeyBind;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static baubles.api.BaublesApi.getBaublesHandler;
import static baubles.api.BaublesApi.isBaubleEquipped;

public class PktKeyPress implements IMessage {
    private AAKeyBind key;

    public PktKeyPress() {}

    public PktKeyPress(AAKeyBind key) {
        this.key = key;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        key = AAKeyBind.values()[buf.readInt()];
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(key.ordinal());
    }

    public static class Handler implements IMessageHandler<PktKeyPress, IMessage> {
        @Override
        public IMessage onMessage(final PktKeyPress message, final MessageContext ctx) {
            ctx.getServerHandler().player.server.addScheduledTask(() -> {
                EntityPlayerMP player = ctx.getServerHandler().player;

                if (message.key == AAKeyBind.RING_TOGGLE) {
                    if (isBaubleEquipped(player, Item.getByNameOrId("astraladditions:astral_ring")) != -1) {
                        AstralRing.toggleRing(getBaublesHandler(player).getStackInSlot(isBaubleEquipped(player, Item.getByNameOrId("astraladditions:astral_ring"))));
                    }
                }
            });
            return null;
        }
    }
}
