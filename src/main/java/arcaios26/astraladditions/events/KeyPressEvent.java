package arcaios26.astraladditions.events;

import arcaios26.astraladditions.network.PacketHandler;
import arcaios26.astraladditions.network.packets.KeyPressPKT;
import arcaios26.astraladditions.util.ClientKeyHelper;
import arcaios26.astraladditions.util.Reference;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public class KeyPressEvent {
    @SubscribeEvent
    public static void keyPress(InputEvent.KeyInputEvent event) {
        for (KeyBinding k : ClientKeyHelper.fromMc.keySet()) {
            if (k.isPressed())
            {
                PacketHandler.sendToServer(new KeyPressPKT(ClientKeyHelper.fromMc.get(k)));
            }
        }
    }
}
