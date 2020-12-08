package arcaios26.astraladditions.util.network.packets;

import arcaios26.astraladditions.objects.baubles.ItemAstralRing;
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
            ctx.getServerHandler().player.server.addScheduledTask(() -> handle(message, ctx));
            return null;
        }

        private void handle(PktKeyPress message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;

            if (message.key == AAKeyBind.RING_TOGGLE) {
                if (isBaubleEquipped(player, Item.getByNameOrId("astraladditions:ring_astral")) != -1) {
                    ItemAstralRing.toggleRing(getBaublesHandler(player).getStackInSlot(isBaubleEquipped(player, Item.getByNameOrId("astraladditions:ring_astral"))));
                }
            }
        }
    }
}
