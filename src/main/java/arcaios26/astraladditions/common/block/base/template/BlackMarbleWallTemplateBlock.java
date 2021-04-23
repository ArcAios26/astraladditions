package arcaios26.astraladditions.common.block.base.template;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;

public class BlackMarbleWallTemplateBlock extends WallBlock implements IBlockItemAA {

    private final BlockState baseState;

    public BlackMarbleWallTemplateBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.baseState = baseState;
    }

}
