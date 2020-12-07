package arcaios26.astraladditions.objects.blocks;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.init.BlockInit;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockIWFenceGate extends BlockFenceGate implements IHasModel {

    public BlockIWFenceGate (String name, CreativeTabs tab) {
        super(EnumType.DARK_OAK);
        setRegistryName(name);
        setTranslationKey(name);
        setHardness(1.0F);
        setResistance(3.0F);
        setHarvestLevel("axe", 0);
        setCreativeTab(tab);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        AstralAdditions.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}