package arcaios26.astraladditions.objects.blocks;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.init.BlockInit;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockIWFence extends BlockFence implements IHasModel {
    public BlockIWFence(String name, CreativeTabs tab) {
        super(Material.WOOD, MapColor.BROWN);
        setRegistryName(name);
        setTranslationKey(name);
        setHardness(1.0F);
        setHarvestLevel("axe", 0);
        setResistance(3.0F);
        setSoundType(SoundType.WOOD);
        setCreativeTab(tab);

        this.useNeighborBrightness = true;

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        AstralAdditions.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
