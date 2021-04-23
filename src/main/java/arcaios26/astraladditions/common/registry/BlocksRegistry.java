package arcaios26.astraladditions.common.registry;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.block.base.template.IBlockItemAA;
import arcaios26.astraladditions.common.block.base.template.MarbleWallTemplateBlock;
import arcaios26.astraladditions.common.util.NameUtils;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;

import java.util.LinkedList;
import java.util.List;

import static arcaios26.astraladditions.common.lib.BlocksAA.*;

public class BlocksRegistry {

    static final List<IBlockItemAA> BLOCK_ITEMS = new LinkedList<>();

    private BlocksRegistry() {}

    public static void registerBlocks() {
        MARBLE_WALL = makeWall(BlocksAS.MARBLE_RAW.getDefaultState(), "marble_wall");
        MARBLE_WALL_RUNED = makeWall(BlocksAS.MARBLE_RUNED.getDefaultState(), "marble_wall_runed");
        MARBLE_WALL_CHISELED = makeWall(BlocksAS.MARBLE_CHISELED.getDefaultState(), "marble_wall_chiseled");
        MARBLE_WALL_ENGRAVED = makeWall(BlocksAS.MARBLE_ENGRAVED.getDefaultState(), "marble_wall_engraved");
        MARBLE_WALL_BRICKS = makeWall(BlocksAS.MARBLE_BRICKS.getDefaultState(), "marble_wall_bricks");
        MARBLE_WALL_ARCH = makeWall(BlocksAS.MARBLE_ARCH.getDefaultState(), "marble_wall_arch");

        BLACK_MARBLE_WALL = makeWall(BlocksAS.BLACK_MARBLE_RAW.getDefaultState(), "black_marble_wall");
        BLACK_MARBLE_WALL_RUNED = makeWall(BlocksAS.BLACK_MARBLE_RUNED.getDefaultState(), "black_marble_wall_runed");
        BLACK_MARBLE_WALL_CHISELED = makeWall(BlocksAS.BLACK_MARBLE_CHISELED.getDefaultState(), "black_marble_wall_chiseled");
        BLACK_MARBLE_WALL_ENGRAVED = makeWall(BlocksAS.BLACK_MARBLE_ENGRAVED.getDefaultState(), "black_marble_wall_engraved");
        BLACK_MARBLE_WALL_BRICKS = makeWall(BlocksAS.BLACK_MARBLE_BRICKS.getDefaultState(), "black_marble_wall_bricks");
        BLACK_MARBLE_WALL_ARCH = makeWall(BlocksAS.BLACK_MARBLE_ARCH.getDefaultState(), "black_marble_wall_arch");
    }

    private static MarbleWallTemplateBlock makeWall(BlockState base, String name) {
        MarbleWallTemplateBlock wall = new MarbleWallTemplateBlock(base, Block.Properties.from(base.getBlock()));
        ResourceLocation wallName = new ResourceLocation(AstralAdditions.MODID, name);
        return registerBlock(wall, wallName);
    }

    private static <T extends Block> T registerBlock(T block) {
        return registerBlock(block, NameUtils.fromClass(block, null, "Block"));
    }

    private static <T extends Block> T registerBlock(T block, ResourceLocation name) {
        block.setRegistryName(name);
        AstralAdditions.getProxy().getRegistryPrimer().register(block);
        if (block instanceof IBlockItemAA) {
            BLOCK_ITEMS.add((IBlockItemAA) block);
        }
        return block;
    }

}
