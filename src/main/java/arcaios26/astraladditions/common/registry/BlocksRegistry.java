package arcaios26.astraladditions.common.registry;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.block.base.template.FenceGateTemplateBlock;
import arcaios26.astraladditions.common.block.base.template.IBlockItemAA;
import arcaios26.astraladditions.common.block.base.template.FenceTemplateBlock;
import arcaios26.astraladditions.common.block.base.template.WallTemplateBlock;
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

        STARMETAL_WALL = makeWall(BlocksAS.STARMETAL.getDefaultState(), "starmetal_wall");

        INFUSED_WOOD_FENCE = makeFence(BlocksAS.INFUSED_WOOD.getDefaultState(), "infused_wood_fence");
        VIBRANT_INFUSED_WOOD_FENCE = makeFence(BlocksAS.INFUSED_WOOD_ENRICHED.getDefaultState(), "vibrant_infused_wood_fence");
        STARMETAL_FENCE = makeFence(BlocksAS.STARMETAL.getDefaultState(), "starmetal_fence");

        INFUSED_WOOD_FENCE_GATE = makeFenceGate(BlocksAS.INFUSED_WOOD.getDefaultState(), "infused_wood_fence_gate");
        VIBRANT_INFUSED_WOOD_FENCE_GATE = makeFenceGate(BlocksAS.INFUSED_WOOD_ENRICHED.getDefaultState(), "vibrant_infused_wood_fence_gate");
        STARMETAL_FENCE_GATE = makeFenceGate(BlocksAS.STARMETAL.getDefaultState(), "starmetal_fence_gate");
    }

    private static WallTemplateBlock makeWall(BlockState base, String name) {
        WallTemplateBlock wall = new WallTemplateBlock(base, Block.Properties.from(base.getBlock()));
        ResourceLocation wallName = new ResourceLocation(AstralAdditions.MODID, name);
        return registerBlock(wall, wallName);
    }

    private static FenceTemplateBlock makeFence(BlockState base, String name) {
        FenceTemplateBlock fence = new FenceTemplateBlock(base, Block.Properties.from(base.getBlock()));
        ResourceLocation fenceName = new ResourceLocation(AstralAdditions.MODID, name);
        return registerBlock(fence, fenceName);
    }

    private static FenceGateTemplateBlock makeFenceGate(BlockState base, String name) {
        FenceGateTemplateBlock fenceGate = new FenceGateTemplateBlock(base, Block.Properties.from(base.getBlock()));
        ResourceLocation fenceGateName = new ResourceLocation(AstralAdditions.MODID, name);
        return registerBlock(fenceGate, fenceGateName);
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
