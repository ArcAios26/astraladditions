package arcaios26.astraladditions.objects.armor;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {
    public ArmorBase(String name, ArmorMaterial material, int index, EntityEquipmentSlot slot, CreativeTabs tab) {
        super (material, index, slot);
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(tab);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        AstralAdditions.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
