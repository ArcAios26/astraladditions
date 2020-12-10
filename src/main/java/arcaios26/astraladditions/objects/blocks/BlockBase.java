package arcaios26.astraladditions.objects.blocks;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.init.BlockInit;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material, CreativeTabs tab) {
        super(material);
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(tab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        AstralAdditions.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
