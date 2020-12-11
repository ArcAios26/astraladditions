package arcaios26.astraladditions.creativetabs;

import arcaios26.astraladditions.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AATab extends CreativeTabs {
    public AATab(String name) {
        super(name);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemInit.RING_ASTRAL);
    }
}
