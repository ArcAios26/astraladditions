package arcaios26.astraladditions.common.block.base.template;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;

public class FenceGateTemplateBlock extends FenceGateBlock implements IBlockItemAA {

    private final BlockState baseState;

    public FenceGateTemplateBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.baseState = baseState;
    }
}
