package arcaios26.astraladditions.common.registry;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.CommonProxy;
import arcaios26.astraladditions.common.block.base.template.IBlockItemAA;
import arcaios26.astraladditions.common.item.ring.AstralRingItem;
import arcaios26.astraladditions.common.util.NameUtils;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static arcaios26.astraladditions.common.lib.ItemsAA.ASTRAL_RING;

public class ItemsRegistry {

    private ItemsRegistry() {}

    public static void registerItems() {
        ASTRAL_RING = registerItem(new AstralRingItem());
    }

    public static void registerBlockItems() {
        BlocksRegistry.BLOCK_ITEMS.forEach(ItemsRegistry::registerBlockItem);
    }

    private static void registerBlockItem(IBlockItemAA block) {
        BlockItem blockItem = block.createBlockItem(new Item.Properties().group(CommonProxy.ITEM_GROUP_AA));
        blockItem.setRegistryName(blockItem.getBlock().getRegistryName());
        AstralAdditions.getProxy().getRegistryPrimer().register(blockItem);
    }

    private static <T extends Item> T registerItem(T item) {
        ResourceLocation name = NameUtils.fromClass(item, null, "Item");
        item.setRegistryName(name);
        AstralAdditions.getProxy().getRegistryPrimer().register(item);
        return item;
    }

}
