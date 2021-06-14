package arcaios26.astraladditions.common.network.packets;

import arcaios26.astraladditions.common.lib.ItemsAA;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.function.Supplier;

import static arcaios26.astraladditions.common.util.ItemNBTUtils.ACTIVE_TAG;

public class KeyInputPkt {

    private AAKey key;

    public KeyInputPkt(PacketBuffer buf) {
        key = buf.readEnumValue(AAKey.class);
    }

    public KeyInputPkt(AAKey key) {
        this.key = key;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeEnumValue(key);
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            switch(key) {
                case TOGGLE_RING:
                    ServerPlayerEntity player = ctx.get().getSender();
                    if (CuriosApi.getCuriosHelper().findEquippedCurio(ItemsAA.ASTRAL_RING, ctx.get().getSender()).isPresent()) {
                        ItemStack stack = CuriosApi.getCuriosHelper().findEquippedCurio(ItemsAA.ASTRAL_RING, ctx.get().getSender()).get().right;
                        ItemsAA.ASTRAL_RING.toggleRing(stack);
                    }
                    break;
            }
        });
        return true;
    }

    public static enum AAKey {

        TOGGLE_RING;

    }
}
