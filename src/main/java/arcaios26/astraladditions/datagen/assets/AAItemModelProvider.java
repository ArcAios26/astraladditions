package arcaios26.astraladditions.datagen.assets;

import hellfirepvp.astralsorcery.AstralSorcery;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static arcaios26.astraladditions.AstralAdditions.MODID;

public class AAItemModelProvider extends ItemModelProvider {

    public AAItemModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        wallInventory("marble_wall", new ResourceLocation(AstralSorcery.MODID, "block/marble_raw"));
        wallInventory("marble_wall_bricks", new ResourceLocation(AstralSorcery.MODID, "block/marble_bricks"));
        wallInventory("marble_wall_chiseled", new ResourceLocation(AstralSorcery.MODID, "block/marble_chiseled"));
        wallInventory("marble_wall_runed", new ResourceLocation(AstralSorcery.MODID, "block/marble_runed"));
        wallInventory("marble_wall_engraved", new ResourceLocation(AstralSorcery.MODID, "block/marble_engraved"));
        wallInventory("marble_wall_arch", new ResourceLocation(AstralSorcery.MODID, "block/marble_arch"));
        wallInventory("black_marble_wall", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_raw"));
        wallInventory("black_marble_wall_bricks", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_bricks"));
        wallInventory("black_marble_wall_chiseled", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_chiseled"));
        wallInventory("black_marble_wall_runed", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_runed"));
        wallInventory("black_marble_wall_engraved", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_engraved"));
        wallInventory("black_marble_wall_arch", new ResourceLocation(AstralSorcery.MODID, "block/black_marble_arch"));

        wallInventory("starmetal_wall", new ResourceLocation(AstralSorcery.MODID, "block/starmetal"));

        fenceInventory("infused_wood_fence", new ResourceLocation(AstralSorcery.MODID, "block/wood_raw"));
        fenceInventory("vibrant_infused_wood_fence", new ResourceLocation(AstralSorcery.MODID, "block/wood_infused"));
        fenceInventory("starmetal_fence", new ResourceLocation(AstralSorcery.MODID, "block/starmetal"));

        fenceGate("infused_wood_fence_gate", new ResourceLocation(AstralSorcery.MODID, "block/wood_raw"));
        fenceGate("vibrant_infused_wood_fence_gate", new ResourceLocation(AstralSorcery.MODID, "block/wood_infused"));
        fenceGate("starmetal_fence_gate", new ResourceLocation(AstralSorcery.MODID, "block/starmetal"));
    }
    
}
