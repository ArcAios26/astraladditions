package arcaios26.astraladditions.init;

import arcaios26.astraladditions.items.wearable.AstralRing;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    @GameRegistry.ObjectHolder("astraladditions:astral_ring")
    public static AstralRing astralRing;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        astralRing.initModel();
    }
}
