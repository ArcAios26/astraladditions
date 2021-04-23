package arcaios26.astraladditions.common.registry;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.CommonProxy;
import arcaios26.astraladditions.common.block.base.template.IBlockItemAA;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemsRegistry {

    private ItemsRegistry() {}

    public static void registerItems() {}

    public static void registerBlockItems() {
        BlocksRegistry.BLOCK_ITEMS.forEach(ItemsRegistry::registerBlockItem);
    }

    private static void registerBlockItem(IBlockItemAA block) {
        BlockItem blockItem = block.createBlockItem(new Item.Properties().group(CommonProxy.ITEM_GROUP_AA));
        blockItem.setRegistryName(blockItem.getBlock().getRegistryName());
        AstralAdditions.getProxy().getRegistryPrimer().register(blockItem);
    }

}
