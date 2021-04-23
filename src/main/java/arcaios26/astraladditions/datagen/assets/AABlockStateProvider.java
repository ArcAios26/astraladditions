package arcaios26.astraladditions.datagen.assets;

import arcaios26.astraladditions.common.lib.BlocksAA;
import hellfirepvp.astralsorcery.AstralSorcery;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static arcaios26.astraladditions.AstralAdditions.MODID;

public class AABlockStateProvider extends BlockStateProvider {

    public AABlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        wallBlock(BlocksAA.MARBLE_WALL, new ResourceLocation(AstralSorcery.MODID, "block/marble_raw"));
        wallBlock(BlocksAA.MARBLE_WALL_BRICKS, new ResourceLocation(AstralSorcery.MODID, "block/marble_bricks"));
        wallBlock(BlocksAA.MARBLE_WALL_CHISELED, new ResourceLocation(AstralSorcery.MODID, "block/marble_chiseled"));
        wallBlock(BlocksAA.MARBLE_WALL_ENGRAVED, new ResourceLocation(AstralSorcery.MODID, "block/marble_engraved"));
        wallBlock(BlocksAA.MARBLE_WALL_ARCH, new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_arch_post")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_arch_side")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_arch_side_tall")));
        wallBlock(BlocksAA.MARBLE_WALL_RUNED, new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_runed_post")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_runed_side")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/marble_wall_runed_side_tall")));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL, new ResourceLocation(AstralSorcery.MODID, "block/black_marble_raw"));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL_BRICKS, new ResourceLocation(AstralSorcery.MODID, "block/black_marble_bricks"));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL_CHISELED, new ResourceLocation(AstralSorcery.MODID, "block/black_marble_chiseled"));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL_ENGRAVED, new ResourceLocation(AstralSorcery.MODID, "block/black_marble_engraved"));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL_ARCH, new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_arch_post")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_arch_side")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_arch_side_tall")));
        wallBlock(BlocksAA.BLACK_MARBLE_WALL_RUNED, new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_runed_post")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_runed_side")), new ModelFile.UncheckedModelFile(new ResourceLocation(MODID, "block/black_marble_wall_runed_side_tall")));

        fenceBlock(BlocksAA.INFUSED_WOOD_FENCE, new ResourceLocation(AstralSorcery.MODID, "block/wood_raw"));
        fenceBlock(BlocksAA.VIBRANT_INFUSED_WOOD_FENCE, new ResourceLocation(AstralSorcery.MODID, "block/wood_infused"));

        fenceGateBlock(BlocksAA.INFUSED_WOOD_FENCE_GATE, new ResourceLocation(AstralSorcery.MODID, "block/wood_raw"));
        fenceGateBlock(BlocksAA.VIBRANT_INFUSED_WOOD_FENCE_GATE, new ResourceLocation(AstralSorcery.MODID, "block/wood_infused"));
    }
}
