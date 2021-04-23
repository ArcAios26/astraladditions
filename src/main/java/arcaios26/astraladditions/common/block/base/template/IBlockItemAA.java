package arcaios26.astraladditions.common.block.base.template;

import arcaios26.astraladditions.common.item.block.BlockItemAA;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public interface IBlockItemAA {

    default Class<? extends BlockItem> getBlockItemClass() {
        return BlockItemAA.class;
    }

    default BlockItem createBlockItem(Item.Properties properties) {
        Class<?> blockItemClass = getBlockItemClass();
        try {
            return (BlockItem) blockItemClass.getConstructor(Block.class, Item.Properties.class)
                    .newInstance(this, properties);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot instantiate BlockItem!", e);
        }
    }

}
