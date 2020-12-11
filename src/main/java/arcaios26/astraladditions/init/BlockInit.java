package arcaios26.astraladditions.init;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.objects.blocks.BlockBase;
import arcaios26.astraladditions.objects.blocks.BlockIWFence;
import arcaios26.astraladditions.objects.blocks.BlockIWFenceGate;
import arcaios26.astraladditions.objects.blocks.BlockMarbleWall;
import hellfirepvp.astralsorcery.common.block.BlockBlackMarble;
import hellfirepvp.astralsorcery.common.block.BlockMarble;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final BlockIWFence BLOCK_IW_FENCE = new BlockIWFence("block_infused_wood_fence", AstralAdditions.AATAB);
    public static final BlockIWFenceGate BLOCK_IW_FENCE_GATE = new BlockIWFenceGate("block_infused_wood_fence_gate", AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_WALL = new BlockMarbleWall("block_marble_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_BRICK_WALL = new BlockMarbleWall("block_marble_brick_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_ARCH_WALL = new BlockMarbleWall("block_marble_arch_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_CHISELED_WALL = new BlockMarbleWall("block_marble_chiseled_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_ENGRAVED_WALL = new BlockMarbleWall("block_marble_engraved_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_MARBLE_RUNED_WALL = new BlockMarbleWall("block_marble_runed_wall", new BlockMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_WALL = new BlockMarbleWall("block_black_marble_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_BRICK_WALL = new BlockMarbleWall("block_black_marble_brick_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_ARCH_WALL = new BlockMarbleWall("block_black_marble_arch_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_CHISELED_WALL = new BlockMarbleWall("block_black_marble_chiseled_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_ENGRAVED_WALL = new BlockMarbleWall("block_black_marble_engraved_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockMarbleWall BLOCK_BLACK_MARBLE_RUNED_WALL = new BlockMarbleWall("block_black_marble_runed_wall", new BlockBlackMarble(), AstralAdditions.AATAB);
    public static final BlockBase BLOCK_STARMETAL = new BlockBase("block_starmetal", Material.IRON, AstralAdditions.AATAB);
}
