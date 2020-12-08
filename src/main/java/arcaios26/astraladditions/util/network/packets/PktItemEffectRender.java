package arcaios26.astraladditions.util.network.packets;

import arcaios26.astraladditions.objects.baubles.ItemAstralRing;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PktItemEffectRender implements IMessage {
    private ItemStack stack;

    public PktItemEffectRender() {}

    public PktItemEffectRender(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeItemStack(buf, stack);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        stack = ByteBufUtils.readItemStack(buf);
    }

    public static class Handler implements IMessageHandler<PktItemEffectRender, IMessage> {
        @Override
        public IMessage onMessage(PktItemEffectRender message, MessageContext ctx) {
            ItemAstralRing ring = (ItemAstralRing)message.stack.getItem();
            Minecraft.getMinecraft().addScheduledTask(ring::playEffect);
            return null;
        }
    }
}
