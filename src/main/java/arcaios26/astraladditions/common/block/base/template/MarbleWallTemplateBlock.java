package arcaios26.astraladditions.common.block.base.template;

import hellfirepvp.astralsorcery.common.block.properties.PropertiesMarble;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;

public class MarbleWallTemplateBlock extends WallBlock implements IBlockItemAA {

    private final BlockState baseState;

    public MarbleWallTemplateBlock(BlockState baseState, Properties properties) {
        super(properties);
        this.baseState = baseState;
    }

}
