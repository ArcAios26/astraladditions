package arcaios26.astraladditions.events;

import arcaios26.astraladditions.Reference;
import arcaios26.astraladditions.util.handlers.PacketHandler;
import arcaios26.astraladditions.util.helpers.ClientKeyHelper;
import arcaios26.astraladditions.util.network.packets.PktKeyPress;
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
                PacketHandler.sendToServer(new PktKeyPress(ClientKeyHelper.fromMc.get(k)));
            }
        }
    }
}
