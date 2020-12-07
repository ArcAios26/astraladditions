package arcaios26.astraladditions.init;

import arcaios26.astraladditions.objects.items.wearable.ItemAstralRing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item RING_ASTRAL = new ItemAstralRing("ring_astral", CreativeTabs.TOOLS);
}
