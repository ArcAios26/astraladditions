package arcaios26.astraladditions.common.block.base.template;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;

public class FenceTemplateBlock extends FenceBlock implements IBlockItemAA {

    private final BlockState baseState;

    public FenceTemplateBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.baseState = baseState;
    }
}
