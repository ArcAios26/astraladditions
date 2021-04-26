package arcaios26.astraladditions.common.integrations;

import hellfirepvp.astralsorcery.common.base.Mods;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

public class CuriosIntegration {

    public static void initIMC() {
        InterModComms.sendTo(Mods.CURIOS.getModId(), SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().build());
    }
}
