package arcaios26.astraladditions.init;

import arcaios26.astraladditions.objects.blocks.BlockIWFence;
import arcaios26.astraladditions.objects.blocks.BlockIWFenceGate;
import arcaios26.astraladditions.objects.blocks.BlockMarbleWall;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final BlockIWFence BLOCK_IW_FENCE = new BlockIWFence("block_infused_wood_fence", Material.WOOD, MapColor.BROWN);
    public static final BlockIWFenceGate BLOCK_IW_FENCE_GATE = new BlockIWFenceGate("block_infused_wood_fence_gate", Material.WOOD, MapColor.BROWN);
    public static final BlockMarbleWall BLOCK_MARBLE_WALL = new BlockMarbleWall("block_marble_wall", Material.ROCK, MapColor.GRAY);
}
