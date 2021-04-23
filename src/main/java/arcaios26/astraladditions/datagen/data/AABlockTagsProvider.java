package arcaios26.astraladditions.datagen.data;

import arcaios26.astraladditions.common.lib.BlocksAA;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

import static arcaios26.astraladditions.AstralAdditions.MODID;

public class AABlockTagsProvider extends BlockTagsProvider {
    public AABlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MODID, exFileHelper);
    }

    @Override
    protected void registerTags() {
        tag(BlockTags.WALLS)
                .add(BlocksAA.MARBLE_WALL)
                .add(BlocksAA.MARBLE_WALL_BRICKS)
                .add(BlocksAA.MARBLE_WALL_RUNED)
                .add(BlocksAA.MARBLE_WALL_ENGRAVED)
                .add(BlocksAA.MARBLE_WALL_CHISELED)
                .add(BlocksAA.MARBLE_WALL_ARCH)
                .add(BlocksAA.BLACK_MARBLE_WALL)
                .add(BlocksAA.BLACK_MARBLE_WALL_BRICKS)
                .add(BlocksAA.BLACK_MARBLE_WALL_RUNED)
                .add(BlocksAA.BLACK_MARBLE_WALL_ENGRAVED)
                .add(BlocksAA.BLACK_MARBLE_WALL_CHISELED)
                .add(BlocksAA.BLACK_MARBLE_WALL_ARCH);

        //tag(BlockTags.FENCES)
        //        .add(BlocksAA.INFUSED_WOOD_FENCE)
        //        .add(BlocksAA.ENRICHED_INFUSED_WOOD_FENCE);

        //tag(BlockTags.WOODEN_FENCES)
        //        .add(BlocksAA.INFUSED_WOOD_FENCE)
        //        .add(BlocksAA.ENRICHED_INFUSED_WOOD_FENCE);

        //tag(BlockTags.FENCE_GATES)
        //        .add(BlocksAA.INFUSED_WOOD_FENCE_GATE)
        //        .add(BlocksAA.ENRICHED_INFUSED_WOOD_FENCE_GATE);
    }

    private Builder<Block> tag(ITag.INamedTag<Block> tag) {
        return this.getOrCreateBuilder(tag);
    }
}
