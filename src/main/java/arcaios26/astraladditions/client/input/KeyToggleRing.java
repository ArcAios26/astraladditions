package arcaios26.astraladditions.client.input;

import arcaios26.astraladditions.common.network.AANetwork;
import arcaios26.astraladditions.common.network.packets.KeyInputPkt;
import net.minecraft.client.settings.KeyBinding;

import static arcaios26.astraladditions.common.network.packets.KeyInputPkt.AAKey.TOGGLE_RING;

public class KeyToggleRing extends AAKeyBind {

    public KeyToggleRing(KeyBinding keyBind) {
        super(keyBind);
    }

    @Override
    public void onKeyDown() {
        AANetwork.sendToServer(new KeyInputPkt(TOGGLE_RING));
    }

    @Override
    public void onKeyUp() {}
}
